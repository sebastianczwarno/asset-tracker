plugins {
    `java-library`
    id("com.scz.common-conventions")
    alias(libs.plugins.errorprone)
}

dependencies {
    implementation(libs.bundles.vertx)
    implementation(libs.bundles.flogger)
    testImplementation(libs.bundles.testing)
    errorprone(libs.errorprone)
}