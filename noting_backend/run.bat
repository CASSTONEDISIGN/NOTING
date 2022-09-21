@echo off

:: 0. Preparing...

chcp 65001
COLOR D

echo.

echo "                                          "
echo "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ"
echo "                                          "
echo "   ____             _                  _  "
echo "  |  _ \           | |                | | "
echo "  | |_) | __ _  ___| | _____ _ __   __| | "
echo "  |  _ < / _\` |/ __| |/ / _ \ '_ \ / _\` "
echo "  | |_) | (_| | (__|   <  __/ | | | (_| | "
echo "  |____/ \__,_|\___|_|\_\___|_| |_|\__,_| "
echo "                                          "
echo "                                          "
echo "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ"
echo "                                          "
echo.
echo.

:: 1. Bootstrapping Springboot Server
echo BOOTSTRAPPING SPRINGBOOT SERVER...

echo cd ../src/main/java/com/example/noting_backend
echo start NotingBackendApplication.java

:: 2. Finally
:final

echo.

timeout /t 10 /nobreak

start chrome -incognito http://localhost:19410