# MVVM Architecture

A sample MVP project which illustrate MVVM architecture using Android Architecture components such as LiveData,ViewModel.
It fetches data from news API server and displays in Recycler view and on click of news item it shows news details in webview.
All data binds using databinding. Added drawer layout and actionbar menu to perform more action as per user requirements.

# Pre-requisites
    Android SDK 28
    Android Build Tools v28.0.3
    Android Support Repository

# Screenshots
    Screenshots path:  app root-directory/screenshot

# Getting Started
1. This sample uses the Gradle build system. To build this project, use the "gradlew build" command or use "Import Project" in Android Studio.

2. Take clone of android app from Github from given link:
    https://github.com/uhirani/MVVM-Android-Architecture.git

3. Setup android project and SYNC gradle file.

4. Run Android Project. Run > Run 'App'.

# Run local unit tests
To run your local unit tests, follow these steps:

1. Be sure your project is synchronized with Gradle by clicking Sync Project  in the toolbar.
2. Run your test in one of the following ways:
    1. To run a single test, open the Project window, and then right-click a test and click Run .
    2. To test all methods in a class, right-click a class or method in the test file and click Run .
    3. To run all tests in a directory, right-click on the directory and select Run tests .

The Android Plugin for Gradle compiles the local unit test code located in the default directory (src/test/java/),
builds a test app, and executes it locally using the default test runner class. Android Studio then displays the results in the Run window

# Code coverage
Android Studio has a built-in feature that allows you to run tests with code coverage.

Navigate to the src/test/java folder and right click. Then select Run 'Test' with Coverage.

The result will give you a window that displays test coverage by package, class, method, and lines. To view code coverage report, screenshot put in folder at app root-directory/screenshot.


