package com.assettracker.app.config;

import io.vertx.core.json.JsonObject;

public final class AppConfigReader {

    private static final String APP = "app";
    private static final String DB = "db";
    private static final String JOOQ = "jooq";
    private static final String FLYWAY = "flyway";

    private final JsonObject _json;

    public AppConfigReader(JsonObject json) {
        _json = json;
    }

    public int getPort() {
        return _json.getJsonObject(APP).getInteger("port");
    }

    public String getDbName() {
        return _json.getJsonObject(DB).getString("name");
    }

    public String getDbUserName() {
        return _json.getJsonObject(DB).getString("userName");
    }

    public String getDbUserPassword() {
        return _json.getJsonObject(DB).getString("userPassword");
    }

    public String getDbSchema() {
        return _json.getJsonObject(DB).getString("schema");
    }

    public String getDbUrl() {
        return _json.getJsonObject(DB).getString("url");
    }

    public boolean getJooqRunCodeGeneration() {
        return _json.getJsonObject(JOOQ).getBoolean("runCodeGeneration");
    }

    public String getJooqDirectory() {
        return _json.getJsonObject(JOOQ).getString("directory");
    }

    public String getJooqSqlMigrationFilesLocation() {
        return _json.getJsonObject(JOOQ).getString("sqlMigrationFilesLocation");
    }

    public boolean getFlywayRunMigration() {
        return _json.getJsonObject(FLYWAY).getBoolean("runMigration");
    }

    public String getFlywayLocations() {
        return _json.getJsonObject(FLYWAY).getString("locations");
    }
}
