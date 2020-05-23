import org.gradle.plugins.ide.idea.model.IdeaModel
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "2.2.5.RELEASE"
  id("io.spring.dependency-management") version "1.0.9.RELEASE"
  kotlin("jvm") version "1.3.61"
  kotlin("plugin.spring") version "1.3.61"
  kotlin("plugin.jpa") version "1.3.61"
  kotlin("kapt") version "1.3.61"
  idea
}

group = "com.sample"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

val developmentOnly by configurations.creating
configurations {
  runtimeClasspath {
    extendsFrom(developmentOnly)
  }
}

repositories {
  mavenCentral()
}

/* TODO バージョンなどをプロパティファイルに切り分ける */
dependencies {

  /* kotlin */
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

/* spring */
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect")
  implementation("org.thymeleaf:thymeleaf-spring4:3.0.9.RELEASE")
  developmentOnly("org.springframework.boot:spring-boot-devtools")

/* db */
  runtimeOnly("mysql:mysql-connector-java:8.0.14")
  implementation("org.flywaydb:flyway-core:5.2.3")
  testImplementation("com.h2database:h2:1.4.191")

/* meta model */
  kapt("org.hibernate:hibernate-jpamodelgen")

/* test */
  testImplementation("org.springframework.boot:spring-boot-starter-test") {
    exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
  }
}

/* idea */
apply(plugin = "idea")
configure<IdeaModel> {
  module {
    inheritOutputDirs = false
    outputDir = file("$buildDir/classes/kotlin/main")
  }
}


tasks.withType<Test> {
  useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "1.8"
  }
}
