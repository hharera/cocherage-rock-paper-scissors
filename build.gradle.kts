plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "com.coacherage"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation("io.mockk:mockk:1.12.0")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("com.coacherage.MainKt")
}