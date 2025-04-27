import com.google.protobuf.gradle.id
import com.google.protobuf.gradle.proto

group = "ru.otushw"
version = "unspecified"

plugins {
    id("idea")
    id("com.google.protobuf") version "0.9.4"
}

dependencies {
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    implementation("ch.qos.logback:logback-classic")
    implementation("io.grpc:grpc-netty:1.71.0")
    implementation("io.grpc:grpc-protobuf:1.71.0")
    implementation("io.grpc:grpc-stub:1.71.0")
    implementation("com.google.protobuf:protobuf-java")
    implementation("com.google.errorprone:error_prone_annotations:2.37.0")
    implementation("org.apache.tomcat:annotations-api:6.0.53")
}

val protoSrcDir = "$projectDir/build/generated"

idea {
    module {
        sourceDirs = sourceDirs.plus(file(protoSrcDir))
    }
}

sourceSets {
    main {
        proto {
            srcDir(protoSrcDir)
        }
    }
}

protobuf {

    protoc {
        artifact = "com.google.protobuf:protoc:3.19.4"
    }

    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.56.1"
        }
    }

    generateProtoTasks {
        ofSourceSet("main").forEach {
            it.plugins {
                id("grpc")
            }
        }
    }
}

afterEvaluate {
    tasks {
        getByName("generateProto").dependsOn(processResources)
    }
}