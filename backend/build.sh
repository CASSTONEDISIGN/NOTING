@echo off
cd ../frontend
npm run build
cd ../backend/src/main/resources

ln -s ../../../../frontend/dist ./static

backend\gradlew.bat spring-boot:run



#cd ../java/com/example/backend
#./NotingBackendApplication.java