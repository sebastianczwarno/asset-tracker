package com.assettracker.app;

import com.assettracker.wallet.HelloHandler;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public final class RoutesHandler {
    public static Router Config(Vertx vertx){
        var router = Router.router(vertx);
        router.route("/api/*").handler(new HelloHandler(router));
        return router;
    }
}
