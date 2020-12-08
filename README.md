# GSTests ![Active](https://img.shields.io/badge/version-1-green)
GuideSmiths Tests
This is the main project's repository, where i deployed the frontend client and backend server, yoy can find these folders inside "react"'s folder. You can find 
Also you can find out the proyect on my DockerHub: https://hub.docker.com/r/lordkener/phonecatalog-app

* For execute from docker:
> docker pull lordkener/phonecatalog-app 

### Branches
* IMPORTANT
There are two branches: main and heroku. 
- In the main branch i deployed the application that could be executed in the localhost system, using the port 8443.
- In the heroku branch i deployed the application pushing the proyect on the cloud hosted system. You can find it here: https://app-phone-catalog.herokuapp.com/

# The project
### Introduction 
Phonecatalog is the web application where you can view a catalog of phones, and select one of them to see more details.

  #### Desktop web page 
  <p align="center">
   <img src="https://github.com/lordkener/GLTests/Images/desktop_web_page.gif">
  </p> 
  
  #### Mobile web page
  <p align="center">
   <img src="https://github.com/lordkener/GLTests/Images/mobile_web_page.gif">  
  </p>
   
### Funcionalities
Here you can found a list of existing features in this app.
> * Posibility to see a catalog of phones.
> * Possibility to select a given phone and obtain the phone details view displaying a few more info about that phone.

### Entities

* Phone :phone::open_file_folder:

### Run REST API
- To run REST API make sure you are inside the respective folder (react/backend/)
- Then, you need to create a schema on your MySQL server installed in your system named "phonecatalog_db". Make sure that the server is running on port 3306
- You need have installed Spring-Boot in your system, to run the next command.
- Run this command:
> ./mvnw spring-boot:run

It will be running in localhost:8443, to make sure if it works, try to make an api request, f.e.: http:localhost:8443/api/ or http:localhost:8443/api/phones/1
Or directly look the rows created in the database. 

### Run REACT APP
- To run REACT APP make sure you are inside the respective folder (react/frontend/phonecatalog/)
- Then, you should install the dependices from the packaje.json, running this command:
> npm install
- Now, run this command:
> npm run-scripts start

### Easy run mode, with Docker
- To run both REST API and REACT APP easier, just make sure you have Docker installed in your system.
- Go inside "react"'s folder
- Then you only need to edit the "docker-compose.yml" file, modify "lordkener/phonecatalog-app:latest", and call it what ever you want. For example: phonecatalog-app.
- Open a terminal in that path and run this command:
> docker-compose up

This will install the MySQL, REST API and REACT APP images to be executed in a container. To see what is working, navigate to http://localhost:3000/
Only be carefull to not bussy 8443 and 3000 ports.

### Heroku branch
To see the app, you can visit it from Heroku web page: https://app-phone-catalog.herokuapp.com/

And that's all !