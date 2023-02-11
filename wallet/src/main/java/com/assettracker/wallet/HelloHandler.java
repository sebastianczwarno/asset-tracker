package com.assettracker.wallet;

import io.vertx.core.Handler;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public final class HelloHandler implements Handler<RoutingContext> {
    private final Router _router;

    public HelloHandler(Router router) {
        _router = router;
    }

    private void getHello(RoutingContext ctx) {
        ctx.json(new HelloDto("hello  world!!"));
    }

    @Override
    public void handle(RoutingContext context) {
        _router.get("/hello/test").handler(this::getHello);
        _router.handleContext(context);
    }
}