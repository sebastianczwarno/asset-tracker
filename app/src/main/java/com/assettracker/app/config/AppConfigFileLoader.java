package com.assettracker.app.config;

import io.vertx.config.ConfigRetriever;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

public final class AppConfigFileLoader {
    public static ConfigRetriever getConfigRetriever(Vertx vertx) {
        var configStoreOption = new ConfigStoreOptions()
                .setType("file")
                .setFormat("yaml")
                .setConfig(new JsonObject()
                        .put("path", "app-config.yaml"));

        return ConfigRetriever
                .create(vertx, new ConfigRetrieverOptions().addStore(configStoreOption));
    }
}
