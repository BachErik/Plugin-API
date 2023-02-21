@echo off

set OUTPUT_DIR=plugins

if not exist %OUTPUT_DIR% mkdir %OUTPUT_DIR%

for /d %%i in (*) do (
    if exist "%%i\pom.xml" (
        echo Building Maven project in directory %%i
        pushd "%%i" && mvn clean package && popd
        copy "%%i\target\*.jar" "%OUTPUT_DIR%\"
    )
)
