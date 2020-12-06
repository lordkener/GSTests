::React compile project
cd ..

cd ./frontend/phonecatalog

docker run -it --rm --name phonecatalog-react-front -v %cd%:/usr/src/app -w /usr/src/app node:12.16.1 /bin/bash -c "cd /usr/src/app && npm install > /dev/null && npm i -g create-react-app > /dev/null && npm run-script build --baseHref=/new/"

cd ..
cd ..

move %cd%\frontend\phonecatalog\build %cd%\backend\src\main\resources\static\new

cd ./backend

docker run -it --rm --name phonecatalog-react-back -v "%cd%":/usr/src/app -w /usr/src/app maven:3.6.3-openjdk-15 mvn clean install

mkdir ..\docker\app\

move target\phonecatalog-0.0.1-SNAPSHOT.jar ..\docker\app\

mkdir ..\docker\app\static\

xcopy /s src\main\resources\static ..\docker\app\

cd ../docker

docker build . -t phonecatalog-app

cd ..

::docker login

::docker push phonecatalog-app
::docker push phonecatalog-client