# apk-compiler
the ultimate goal of this repository is to simplify [tyron12233/CodeAssist](https://github.com/tyron12233/CodeAssist)'s code only for compiling apks
<br><br><br><br>

The guide below is for **Windows** users

## Prerequisites
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
<br><br>

## Building the APK
once you have `temp_build\gradle` and `temp_build\jdk` after doing the code above, run this to compile the project to apk
```powershell
$env:JAVA_HOME="$PWD\temp_build\jdk\jdk-11.0.29+7"
& "$PWD\temp_build\gradle\gradle-7.0.2\bin\gradle.bat" assembleDebug
```
<br><br>
### Output
The built APK will be located at the root of this repository:
```
app-release.apk
```
or 
```
app-debug.apk
```

