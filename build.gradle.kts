import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.3"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.4.30"
	kotlin("plugin.spring") version "1.4.30"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

extra["karateVersion"] = "0.9.6"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	// Report
	implementation ("net.masterthought:cucumber-reporting:5.5.2")

	// libraries to use karate
	implementation("com.intuit.karate:karate-apache:${property("karateVersion")}")
	implementation("com.intuit.karate:karate-junit5:${property("karateVersion")}")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = JavaVersion.VERSION_11.toString()
	}
}

tasks.test {
	useJUnitPlatform()
	testLogging {
		events("passed", "skipped", "failed")
	}
	// Always run the tests
	outputs.upToDateWhen { false }
}

sourceSets {
	test {
		resources {
			srcDirs("src/test/kotlin") // resource directory to upload files Karate
		}
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
