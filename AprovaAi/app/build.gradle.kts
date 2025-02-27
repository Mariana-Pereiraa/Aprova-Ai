plugins {
    alias(libs.plugins.android.application)
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    id("org.jetbrains.compose")
//    id("kotlin-kapt")
//    id ("dagger.hilt.android.plugin") version "2.50"
    id("com.google.devtools.ksp") version "1.9.20-1.0.14"
}

android {
    namespace = "com.example.aprovaai"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.aprovaai"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

}
    dependencies {
//        retrofit
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.squareup.okhttp3:okhttp:4.10.0")
        implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
        implementation("com.squareup.retrofit2:converter-gson:2.9.0")
        implementation("com.google.code.gson:gson:2.10.1")
        // Room
        implementation("androidx.room:room-runtime:2.6.1")
        ksp("androidx.room:room-compiler:2.6.1") // KSP para Room
        implementation("androidx.room:room-ktx:2.6.1")

        // Hilt (Injeção de Dependência)
//        implementation("com.google.dagger:hilt-android:2.50")
//        ksp("com.google.dagger:hilt-compiler:2.50") // KSP para Hilt
//        implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
        // Firebase
        implementation(platform("com.google.firebase:firebase-bom:33.7.0"))
        implementation("com.google.firebase:firebase-analytics")
        implementation("com.google.firebase:firebase-firestore")
        implementation("com.google.firebase:firebase-database-ktx")
        implementation("com.google.firebase:firebase-auth-ktx:22.1.1")
        implementation("com.google.firebase:firebase-messaging")

        implementation ("androidx.appcompat:appcompat:1.6.1")

        // Room Database
//    implementation("androidx.room:room-runtime:2.6.1")
//    kapt("androidx.room:room-compiler:2.6.1")
//    implementation("androidx.room:room-ktx:2.6.1")

        //  Hilt (Injeção de Dependência)
//    implementation("com.google.dagger:hilt-android:2.50")
//    kapt("com.google.dagger:hilt-compiler:2.50")
//    implementation("androidx.hilt:hilt-navigation-compose:1.2.0") // Corrigido

        //  Coroutines
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

        //  Google Sign-In
        implementation("com.google.android.gms:play-services-auth:20.7.0")

        //  OkHttp
        implementation("com.squareup.okhttp3:okhttp:4.10.0")

        // Jetpack Compose
        implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.2")
        implementation(platform("androidx.compose:compose-bom:2024.04.01"))
        implementation("androidx.core:core-ktx:1.12.0")
        implementation("androidx.compose.ui:ui")
        implementation("androidx.compose.material3:material3")
        implementation("androidx.compose.ui:ui-tooling-preview")
        implementation("androidx.navigation:navigation-compose:2.7.3")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
        implementation("androidx.activity:activity-compose:1.7.2")
        implementation("androidx.compose.runtime:runtime-livedata")
        implementation("androidx.core:core-splashscreen:1.0.1")
        implementation ("androidx.compose.material:material-icons-extended:<version>")


        //  Accompanist
        implementation("com.google.accompanist:accompanist-navigation-animation:0.32.0")

        // ️ DataStore
        implementation("androidx.datastore:datastore-preferences:1.0.0")

        //  Testes
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)
        androidTestImplementation(platform(libs.androidx.compose.bom))
        androidTestImplementation(libs.androidx.ui.test.junit4)
        debugImplementation(libs.androidx.ui.tooling)
        debugImplementation(libs.androidx.ui.test.manifest)
    }