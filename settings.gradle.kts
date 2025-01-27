rootProject.name = "otusJavaHw"
include("HW01-gradle")
include("HW02-generics")
include("HW03-annotations")
include("HW04-gc")
include("HW05-byte-code")
include("HW06-oop")
include("HW07-patterns")

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

