plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.RollCall.attendancemanagementsystem"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.RollCall.attendancemanagementsystem"
        minSdk = 23
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(platform("com.google.firebase:firebase-bom:32.7.2"))
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.cardview:cardview:1.0.0")

    implementation ("pl.droidsonroids.gif:android-gif-drawable:1.2.17")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    //implementation("com.android.support:design:28.0.0")
    implementation("com.android.volley:volley:1.2.1")
    implementation("com.squareup.picasso:picasso:2.8")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    //implementation("androidx.privacysandbox.tools:tools-core:1.0.0-alpha07")
    //Firebase

    implementation("com.google.firebase:firebase-firestore")
    implementation("com.google.firebase:firebase-auth:22.3.1")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

}