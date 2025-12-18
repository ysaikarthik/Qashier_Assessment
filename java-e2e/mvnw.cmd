@REM ----------------------------------------------------------------------------
@REM Licensed to the Apache Software Foundation (ASF) under one
@REM or more contributor license agreements.  See the NOTICE file
@REM distributed with this work for additional information
@REM regarding copyright ownership.  The ASF licenses this file
@REM to you under the Apache License, Version 2.0 (the
@REM "License"); you may not use this file except in compliance
@REM with the License.  You may obtain a copy of the License at
@REM
@REM    http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM Unless required by applicable law or agreed to in writing,
@REM software distributed under the License is distributed on an
@REM "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
@REM KIND, either express or implied.  See the License for the
@REM specific language governing permissions and limitations
@REM under the License.
@REM ----------------------------------------------------------------------------

@echo off
setlocal

set MAVEN_PROJECTBASEDIR=%~dp0
set WRAPPER_DIR=%MAVEN_PROJECTBASEDIR%\.mvn\wrapper
set WRAPPER_JAR=%WRAPPER_DIR%\maven-wrapper.jar
set WRAPPER_PROPERTIES=%WRAPPER_DIR%\maven-wrapper.properties

if not exist "%WRAPPER_PROPERTIES%" (
  echo Missing %WRAPPER_PROPERTIES%
  exit /b 1
)

for /f "usebackq tokens=1,* delims==" %%A in ("%WRAPPER_PROPERTIES%") do (
  if "%%A"=="distributionUrl" set DISTRIBUTION_URL=%%B
  if "%%A"=="wrapperUrl" set WRAPPER_URL=%%B
)

if not exist "%WRAPPER_JAR%" (
  if exist "%WRAPPER_DIR%" (echo.) else (mkdir "%WRAPPER_DIR%")
  powershell -Command "try { (New-Object Net.WebClient).DownloadFile('%WRAPPER_URL%', '%WRAPPER_JAR%') } catch { exit 1 }"
  if %ERRORLEVEL% NEQ 0 (
    echo Failed to download Maven Wrapper jar.
    exit /b 1
  )
)

set MAVEN_JAVA_EXE=java
if not "%JAVA_HOME%"=="" set MAVEN_JAVA_EXE=%JAVA_HOME%\bin\java.exe

%MAVEN_JAVA_EXE% %MAVEN_OPTS% -classpath "%WRAPPER_JAR%" org.apache.maven.wrapper.MavenWrapperMain ^
  -Dmaven.multiModuleProjectDirectory="%MAVEN_PROJECTBASEDIR%" ^
  -DdistributionUrl="%DISTRIBUTION_URL%" ^
  -DwrapperUrl="%WRAPPER_URL%" ^
  %*

endlocal

