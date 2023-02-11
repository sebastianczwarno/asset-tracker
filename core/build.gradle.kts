plugins {
    `java-library`
    id("com.scz.common-conventions")
}

dependencies {
    implementation(libs.bundles.vertx)
    implementation(libs.bundles.flogger)
    testImplementation(libs.bundles.testing)
}