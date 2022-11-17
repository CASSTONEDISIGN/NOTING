@echo off
cd ../frontend
npm run build
cd ../backend/src/main/resources

#ln -s ../../../../frontend/dist static

cd ../../../

pwd
chmod +x gradlew


./gradlew
./gradlew bootrun




#cd ../java/com/example/backend
#./NotingBackendApplication.java