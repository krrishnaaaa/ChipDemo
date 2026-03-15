plugins {
  alias(libs.plugins.android.application)
}

android {
  namespace = "com.pcsalt.example.chipdemo"
  compileSdk = 36

  defaultConfig {
    applicationId = "com.pcsalt.example.chipdemo"
    minSdk = 34
    targetSdk = 36
    versionCode = 1
    versionName = "1.0"
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }

  buildFeatures {
    viewBinding = true
  }
}

dependencies {
  implementation(libs.core.ktx)
  implementation(libs.appcompat)
  implementation(libs.material)
  implementation(libs.constraintlayout)

}
