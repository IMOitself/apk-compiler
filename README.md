# apk-compiler
a fork of [tyron12233/CodeAssist](https://github.com/tyron12233/CodeAssist) for direct APK builds via adb or third-party apps.
<br><br><br>

## usage
- it takes an android project path e.g `storage/emulated/0/example-project` and immediately compile it.
- the project path can either be sent via adb.

example:
```
adb shell am start -n com.tyron.code/.MainActivity -a imo.buildapk.RECEIVE_PROJECT_PATH --es project_path "storage/emulated/0/example-project"
        
```
- or by creating an app that sends an intent action to this project `com.tyron.code`

example:

```java
import android.content.Intent;

String projectPath = "INSERT PATH HERE"

Intent intent = new Intent();
intent.setClassName("com.tyron.code", "com.tyron.code.MainActivity");
intent.setAction(Intent.ACTION_SEND);
intent.putExtra("project_path", projectPath);
startActivity(intent);
```
see [IMOaswell/compiler-trigger](https://github.com/IMOaswell/compiler-trigger) for actual implementation
<br><br><br>

## building this project
the guide below is for **Windows** users
```
git clone https://github.com/IMOitself/build-apk.git
```

run the command below on terminal on the cloned directory:
```cmd
curl.exe -L -o gradle-7.0.2-bin.zip https://services.gradle.org/distributions/gradle-7.0.2-bin.zip
curl.exe -L -o jdk-11.0.29+7.zip https://github.com/adoptium/temurin11-binaries/releases/download/jdk-11.0.29%2B7/OpenJDK11U-jdk_x64_windows_hotspot_11.0.29_7.zip

mkdir temp_build\gradle
mkdir temp_build\jdk

tar -xf gradle-7.0.2-bin.zip -C temp_build\gradle
tar -xf jdk-11.0.29+7.zip -C temp_build\jdk
```
<br>

once you have `temp_build\gradle` and `temp_build\jdk` after doing the code above, run this to compile the project to apk
```powershell
$env:JAVA_HOME="$PWD\temp_build\jdk\jdk-11.0.29+7"
& "$PWD\temp_build\gradle\gradle-7.3.3\bin\gradle.bat" assembleRelease
```
<br><br>
The built APK will be located at the root of this repository:
```
app-release.apk
```
or 
```
app-debug.apk
```

