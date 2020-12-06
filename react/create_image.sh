#Angular compile project
cd ..

cd ./frontend/phonecatalog

docker run -it --rm --name phonecatalog-react-front -v "$PWD":/usr/src/app -w /usr/src/app node:12.16.1 /bin/bash -c "cd /usr/src/app && npm install > /dev/null && npm install -g create-react-app > /dev/null && npm run-script build --baseHref=/new/"

mv -v "$PWD"/dist/phonecatalog ../../backend/src/main/resources/static/new

cd ../../backend

docker run -it --rm --name phonecatalog-react-back -v "$PWD":/usr/src/app -w /usr/src/app maven:3.6.3-openjdk-15 mvn clean install

cp target/phonecatalog-0.0.1-SNAPSHOT.jar ../docker/app/

cd ../docker

docker build . -t lordkener/phonecatalog-app

docker login

docker push lordkener/phonecatalog-app