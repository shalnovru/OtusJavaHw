rootProject.name = "otusJavaHw"
include("HW01-gradle")
include("HW02-generics")
include("HW03-annotations")
include("HW04-gc")
include("HW05-byte-code")
include("HW06-oop")
include("HW07-patterns")
include("HW08-io")
include("HW09-jdbc")
include("HW10-jpql")
include("HW11-cache")
include("HW12-web-server")
include("HW13-di")
include("HW14-spring-jdbc")
include("HW15-executors")
include("HW16-queues")
include("HW17-gRPC")

pluginManagement {
    val dependencyManagement: String by settings
    val springframeworkBoot: String by settings
    val johnrengelmanShadow: String by settings

    plugins {
        id("io.spring.dependency-management") version dependencyManagement
        id("org.springframework.boot") version springframeworkBoot
        id("com.github.johnrengelman.shadow") version johnrengelmanShadow
    }
}

