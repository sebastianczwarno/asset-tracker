plugins {
    application
    id("com.scz.common-conventions")
    alias(libs.plugins.shadow)
}

val mainVerticleName = "com.assettracker.app.MainVerticle"
val launcherClassName = "io.vertx.core.Launcher"
val watchForChange = "${rootDir}/**/src/**/*"
val doOnChange = "${rootDir}/gradlew assemble --build-cache"

application {
    mainClass.set(launcherClassName)
}

dependencies {
    implementation(platform(libs.vertx.deepchain))
    implementation(project(":wallet"))
    implementation(project(":asset"))
    implementation(project(":core"))
    implementation(libs.vertx.web)
    implementation(libs.vertx.config)
    implementation(libs.vertx.config.yaml)
    implementation(libs.jackson.databind)
    implementation(libs.bundles.flogger)
    implementation(libs.flyway)
    implementation(libs.postgresql)
    implementation(libs.bundles.jooq)
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveClassifier.set("fat")
    manifest {
        attributes(mapOf("Main-Verticle" to mainVerticleName))
    }
    mergeServiceFiles()
}

tasks.withType<JavaExec> {
    args = listOf("run", mainVerticleName, "--redeploy=$watchForChange", "--launcher-class=$launcherClassName", "--on-redeploy=$doOnChange")
}

