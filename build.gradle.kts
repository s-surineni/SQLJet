import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("org.springframework.boot") version "2.5.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.5.21"
    kotlin("plugin.spring") version "1.5.21"
    application
    id("com.github.johnrengelman.shadow") version "7.0.0"
}


application {
    mainClass.set("com.greatest.sqljet.SqlJetApplication")
}

group = "com.greatest"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.jar {
    manifest {
        attributes(mapOf("Implementation-Title" to project.name,
                "Implementation-Version" to project.version,
                "Main-Class" to "com.greatest.sqljet.SqlJetApplication"))
    }
}

val shadowJar: ShadowJar by tasks
shadowJar.apply {
    manifest.attributes.apply {
        put("Implementation-Title", project.name)
        put("Implementation-Version", project.version)
        put("Main-Class", "com.greatest.sqljet.SqlJetApplication")
    }

    baseName = project.name + "-all"
}