package com.assettracker.app;

import com.assettracker.wallet.WalletHandler;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.pgclient.PgPool;

public final class RoutesHandler {
    public static Router Config(Vertx vertx, PgPool pool){
        var router = Router.router(vertx);
        router.route("/api/*").handler(new WalletHandler(router, pool));
        return router;
    }
}
