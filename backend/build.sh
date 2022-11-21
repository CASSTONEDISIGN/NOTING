@echo off
echo FRONTEND BUILDING...
cd ../frontend
npm run build

echo SETTING SYMBOLIC LINK FOR STATIC FRONTEND PAGES...

cd ../backend/src/main/resources
echo.
ln -tfs ../../../../frontend/dist static

echo BOOTSTRAPPING SPRINGBOOT SERVER...
cd ../../../
chmod +x gradlew

./gradlew
./gradlew bootrun




#cd ../java/com/example/backend
#./NotingBackendApplication.java