package com.assettracker.app;

import com.google.common.flogger.FluentLogger;
import com.assettracker.app.config.AppConfigReader;
import com.assettracker.app.config.AppConfigFileLoader;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class MainVerticle extends AbstractVerticle {
    private static final FluentLogger _logger = FluentLogger.forEnclosingClass();

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        AppConfigFileLoader.getConfigRetriever(vertx).getConfig().onSuccess(jsonObject -> {
            var config = new AppConfigReader(jsonObject);
            var appPort = config.getPort();

            FlywayMigration.run(config);
            JooqCodeGeneration.run(config);

            var pgPool = PgPoolFactory.create(vertx, config);
            var router = RoutesHandler.Config(vertx, pgPool);

            vertx.createHttpServer().requestHandler(router).listen(appPort).onSuccess(http -> {
                startPromise.complete();
                _logger.atInfo().log("Started on port %d", appPort);
            }).onFailure(startPromise::fail);
        }).onFailure(failure -> {
            _logger.atSevere().withCause(failure).log();
        });
    }
}