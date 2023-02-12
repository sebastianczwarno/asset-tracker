package com.assettracker.app;


import org.jooq.codegen.GenerationTool;
import com.assettracker.app.config.AppConfigReader;

import org.jooq.meta.jaxb.*;

public final class JooqCodeGeneration {
    public static void run(AppConfigReader config) {
        if (!config.getJooqRunCodeGeneration()) {
            return;
        }

        var configuration = new Configuration()
                .withGenerator(new Generator()
                        .withDatabase(new Database()
                                .withName("org.jooq.meta.extensions.ddl.DDLDatabase")
                                .withProperties(

                                        // Specify the location of your SQL script.
                                        // You may use ant-style file matching, e.g. /path/**/to/*.sql
                                        //
                                        // Where:
                                        // - ** matches any directory subtree
                                        // - * matches any number of characters in a directory / file name
                                        // - ? matches a single character in a directory / file name
                                        new Property()
                                                .withKey("scripts")
                                                .withValue(config.getJooqSqlMigrationFilesLocation()),

                                        // The sort order of the scripts within a directory, where:
                                        //
                                        // - semantic: sorts versions, e.g. v-3.10.0 is after v-3.9.0 (default)
                                        // - alphanumeric: sorts strings, e.g. v-3.10.0 is before v-3.9.0
                                        // - flyway: sorts files the same way as flyway does
                                        // - none: doesn't sort directory contents after fetching them from the directory
                                        new Property()
                                                .withKey("sort")
                                                .withValue("semantic"),

                                        // The default schema for unqualified objects:
                                        //
                                        // - public: all unqualified objects are located in the PUBLIC (upper case) schema
                                        // - none: all unqualified objects are located in the default schema (default)
                                        //
                                        // This configuration can be overridden with the schema mapping feature
                                        new Property()
                                                .withKey("unqualifiedSchema")
                                                .withValue("none"),

                                        // The default name case for unquoted objects:
                                        //
                                        // - as_is: unquoted object names are kept unquoted
                                        // - upper: unquoted object names are turned into upper case (most databases)
                                        // - lower: unquoted object names are turned into lower case (e.g. PostgreSQL)
                                        new Property()
                                                .withKey("defaultNameCase")
                                                .withValue("lower")
                                )
                        ).withTarget(new Target().withDirectory(config.getJooqDirectory())));

        try {
            GenerationTool.generate(configuration);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
