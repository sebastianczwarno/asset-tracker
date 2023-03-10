package com.assettracker.app;

import com.assettracker.app.config.AppConfigReader;
import org.flywaydb.core.Flyway;

public class FlywayMigration {
    public static void run(AppConfigReader config) {
        if (!config.getFlywayRunMigration()) return;
        var flyway = Flyway.configure();
        flyway.schemas(config.getDbSchema());
        flyway.dataSource(config.getDbUrl(), config.getDbUserName(), config.getDbUserPassword()).load().migrate();
    }
}
