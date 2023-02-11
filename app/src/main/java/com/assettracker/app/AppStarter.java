package com.assettracker.app;

import com.google.common.flogger.FluentLogger;
import io.vertx.core.Vertx;

public final class AppStarter {
    private static final FluentLogger _logger = FluentLogger.forEnclosingClass();
    public static void main(String[] args) {
        _logger.atInfo().log("Application started");
        Vertx.vertx().deployVerticle(new MainVerticle());
    }
}
