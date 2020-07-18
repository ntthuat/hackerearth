import org.gradle.api.tasks.testing.logging.TestExceptionFormat

group = "com.ntthuat.hackerearth"

extra["spring.version"] = "5.1.3.RELEASE"
extra["spring.boot.version"] = "2.1.6.RELEASE"
extra["spring.cloud.version"] = "Greenwich.RC2"

plugins {
    java
    idea
    id("org.springframework.boot") version "2.1.1.RELEASE"
    id("io.spring.dependency-management") version "1.0.6.RELEASE"
    jacoco
    id("org.sonarqube") version "2.6.2"
    id("io.franzbecker.gradle-lombok") version "3.1.0"
}

repositories {
    jcenter()
    maven("https://repo.spring.io/milestone")
    maven("https://dl.bintray.com/americanexpress/maven/")
}

dependencies {
    implementation(enforcedPlatform("org.springframework.cloud:spring-cloud-dependencies:${extra["spring.cloud.version"]}"))

    implementation("org.springframework.cloud:spring-cloud-starter-gateway")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
    /*implementation("org.springframework.cloud:spring-cloud-starter-security")*/

    implementation("org.springframework.cloud:spring-cloud-starter-kubernetes")
    implementation("org.springframework.cloud:spring-cloud-kubernetes-config")
    implementation("org.springframework.cloud:spring-cloud-starter-sleuth")

    implementation("org.apache.commons:commons-collections4:4.4")
    implementation("org.eclipse.collections:eclipse-collections:10.3.0.M1")
    implementation("org.openjdk.jmh:jmh-core:1.23")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
        exclude(group = "junit", module = "junit")
    }

    testImplementation("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("com.github.tomakehurst:wiremock-jre8:2.21.0")
}

tasks {
    
    compileJava {
        options.compilerArgs.addAll(listOf(
                "-Amapstruct.defaultComponentModel=jsr330"
        ))
    }

    test {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
            showExceptions = true
            showCauses = true
            exceptionFormat = TestExceptionFormat.FULL
        }
    }
}
