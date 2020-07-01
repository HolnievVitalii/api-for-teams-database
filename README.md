# api-for-teams-database

# _The structure of the database_
![Database structure](/DBstructure.png)

# Application deployment:
* import the dump file **(api-for-teams-database/TeamsDbApi/TeamsDbApi/DB/TeamDB.sql)** with the finished database to your MySql server
  * make sure the server is up and running online, then go to the database server through your MySql Workbench
* before assembling the application, go to the file **(TeamsDbApi/TeamsDbApi/src/main/resources/application.properties)** and fill in the fields port, user name, and password from your database
* Further, all we need to do is create an executable jar file using Maven and run it like a normal standalone application:
  * Enter maven command line mode, go to the folder with pom.xml and enter the __mvn clean package__ command ![Instruct](/instruct.png)
  * Maven generates an executable jar file called **TeamsDbApi-0.0.1-SNAPSHOT.jar**
  * Go to the **target** folder
  * Then run the jar file: **TeamsDbApi-0.0.1-SNAPSHOT.jar**
  * Go to the browser [http://localhost:8080/teams](http://localhost:8080/teams)
  * **Our REST API is running and ready to serve requests through port 8080 (by default)!**
  * you will see a list of teams in __JSON__ format ![HTTPGET](/httpget.png), 
  then you can use HTTP requests to view, add, change and delete teams from your database
