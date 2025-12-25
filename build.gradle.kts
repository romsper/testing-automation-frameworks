plugins {
    kotlin("jvm") version "2.3.0"
    kotlin("plugin.serialization") version "2.3.0"
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

// Define configuration for AspectJ agent
val agent: Configuration by configurations.creating {
    isCanBeConsumed = true
    isCanBeResolved = true
}

dependencies {
    agent("org.aspectj:aspectjweaver:1.9.22")

    // JUnit
    val junitVersion = "6.0.1"
    implementation("org.junit.jupiter:junit-jupiter:$junitVersion")
    implementation("org.junit.platform:junit-platform-launcher:$junitVersion")

    // Assert
    val kotestVersion = "6.0.7"
    implementation("io.kotest:kotest-assertions-core-jvm:$kotestVersion")

    // Frontend
    val selenideVersion = "7.10.0"
    implementation("com.codeborne:selenide:$selenideVersion")

    // Backend
    val feignVersion = "13.6"
    implementation("io.github.openfeign:feign-core:$feignVersion")
    implementation("io.github.openfeign:feign-okhttp:$feignVersion")
    implementation("io.github.openfeign:feign-jackson:$feignVersion")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.20.1")

    // Database
    val exposedVersion = "1.0.0-rc-4"
    implementation("org.postgresql:postgresql:42.7.7")
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")

    // Report
    val allureVersion = "2.32.0"
    implementation("io.qameta.allure:allure-okhttp3:$allureVersion")
    implementation("io.qameta.allure:allure-junit5:$allureVersion")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1")
}

tasks.test {
    jvmArgs = listOf("-javaagent:${agent.singleFile}")

    val tags = providers.systemProperty("TAGS")
    useJUnitPlatform {
        if (tags.isPresent) {
            includeTags(tags.get())
        }
    }

    testLogging {
        events("passed", "skipped", "failed")
    }

    val properties = System.getProperties().entries.associate { it.key.toString() to it.value }
    systemProperties(properties)
}
