# Alfabank-task [![CircleCI](https://circleci.com/gh/ValeriyMakarshin/alfabank-task/tree/master.svg?style=svg)](https://circleci.com/gh/ValeriyMakarshin/alfabank-task/tree/master)
Test task for the [alfa bank](https://github.com/ValeriyMakarshin/alfabank-task/blob/master/task-description.pdf).

If you have any questions, you can ask them via [Telegram](https://telegram.me/valeriymakarshin).

## Requirement to work with project
* Android Studio 3.0 or later with SDK 27
* Kotlin
* Emulator or real device

Following instruction specific for MacOS. You can figure out how to do it on different platform.
## Setup
0. Clone project `git clone https://github.com/ValeriyMakarshin/StackViewer/android-stat.git`
1. Download latest Android Studio 3.0 from https://developer.android.com/studio/index.html this will be our IDE.
2. Follow Android Studio installation instruction.
3. Create any emulator in Android Studio, for example `Google Pixel`
4. Open Existing Android Project - find folder with project and click “OK”
5. Wait a while. You can get errors and Android Studio will guide you to install missing items.
6. Select in configuration dropdown (on top between green hammer and green play buttons) `app` item.
7. Then press `ctrl + R` and select running emulator.
8. Wait some time and now you have Android STAT application on your emulator.

## Building and Distribution

### Requirement for manual process
In order to build apk manually you need following items installed on your machine: 
* Android SDK (currently version 27, check `app/build.gradle` file `android.compileSdkVersion`)
The easiest way to install it is to install Android Studio and compile project. 
You can do it using setup instruction.

## Tests
Browse from terminal to `projectRoot/app`, execute:
* `./gradlew detektCheck` - to run code checkstyle verification
* `./gradlew testReleaseUnitTest` to run unit tests
* `./gradlew lintRelease` to run android linter

You can run all verifications in single command: `./gradlew detektCheck lintRelease testReleaseUnitTest`
