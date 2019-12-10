# Android Project Kick-Starter

An android project that serves as a starter template to help you quickly get started.

This project is work in progress. Feedback is welcome!

## Description

The project is divided into 2 modules.
`domain` is a library module that is meant to encapsulate domain and data access (network and db) code.
`domain` "exports" a set of `koin modules` that the `app` module can use to inject `domain`'s services
 (usually injected into viewmodels)
 
`app` is the main module. It encapsulates all your activities, views, and viewmodels.

## Getting Started

1. Clone this repo to your local machine https://github.com/karimit/android-project-kickstarter.git
2. Use android studio to rename the application package.
3. Crashlytics integration:
    * Create a new firebase project
    * Add an android application for the -release- build type.
    * Download google-services.json to src/release and remove src/release/google-services-template.json 
    * Add an android application for the -debug- build type (use the .debug package suffix).
    * Download google-services.json to src/debug and remove src/debug/google-services-template.json
4. Create a signing key for signing the release build. Take note of keystore password, password, and alias.
5. Rename keystore-template.properties to keystore and fill out the placeholders with outputs from step 4.
DONE!

### Requirements

- Android Studio 3.5+ (not tested on earlier versions)
- Java 8+

## What's in it
- Kotlin
- [Koin](https://github.com/InsertKoinIO/koin) for dependency injection
- [Androidx](https://developer.android.com/jetpack/androidx)  Android Jetpack libraries (lifecycle, viewmodel, navigation, savedstate and more)
- [Kotlin Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)
- [Ktlint](https://github.com/pinterest/ktlint) - Kotlin Linter
- [LeakCanary](https://rometools.github.io/rome/) - Leak Reporting
- [Material Components](https://github.com/material-components/material-components-android) - Material Design UI components for Android
- [Stetho](https://github.com/facebook/stetho) - Network Traffic Inspector
- [Timber](https://github.com/JakeWharton/timber/) - Logging library
- Crashlytics Integration
-- Crash reporting is disabled in the `debug` build by default. Change `enableCrashReporting` to `"true"` in `app`'s build.gradle in the `debug` build type block to enable crash reporting for the debug build.
-- [ReleaseTree](app/src/main/java/com/example/app/utils/ReleaseTree.kt) timber tree is planted by default. It reports errors and exception to Crashlytics.
- [Retrofit](https://github.com/square/retrofit) HTTP Client. Setup with OkHttp and some useful interceptors.
- [ThreeTenABP](https://github.com/JakeWharton/ThreeTenABP) Java Time backport 

## Authors

* **Karim Almur** - *Initial work* - [PurpleBooth](https://github.com/karimit)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## See something stupid?

- Suggestions & issues are welcome!
