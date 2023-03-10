package com.assettracker.app;

import com.assettracker.app.config.AppConfigReader;
import io.vertx.core.Vertx;
import io.vertx.pgclient.PgConnectOptions;
import io.vertx.pgclient.PgPool;
import io.vertx.sqlclient.PoolOptions;

public final class PgPoolFactory {
    public static PgPool create(Vertx vertx, AppConfigReader config) {
        var connection = new PgConnectOptions()
                .setPort(config.getDbPort())
                .setHost(config.getDbHost())
                .setDatabase(config.getDbName())
                .setUser(config.getDbUserName())
                .setPassword(config.getDbUserPassword());
        return PgPool.pool(vertx, connection, new PoolOptions().setMaxSize(5));
    }
}
