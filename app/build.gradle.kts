plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-parcelize")

//    id("androidx.navigation.safeargs.kotlin")
    // Uncomment if using Safe Args for Navigation
    // alias(libs.plugins.androidx.navigation.safeargs.kotlin)
}

android {
    namespace = "com.example.kmpay"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.kmpay"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true // Optional (if you want both)

    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.cardview)
    implementation(libs.androidx.viewpager2)
//    implementation(libs.androidx.lifecycle.viewmodel.ktx) // Uncommented and added
    implementation(libs.curvedbottomnavigation)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation (libs.material.v1110)


//    implementation (libs.androidx.cardview)

//    classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3")  // Add this line


}