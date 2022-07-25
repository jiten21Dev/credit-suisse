### log-event-tracker
### Run the project
    In order to run this project, clone the repository or download as zip file on your machine.
    Unzip the file, there are two folders, one log-event-tracker and other is hsqldb.
### check DB.
    Go the location …\hsqldb-2.4.1\hsqldb\data and check below files are present in that folder
      •	testdb
      •	testdb.properties
      •	testdb.script
    if the files are not present in this folder, remove all the files from the “data” folder and run below command.
      java -cp ../lib/hsqldb.jar org.hsqldb.server.Server --database.0 file:testdb --dbname.0 testdb
### Run the project
    Go the location  …\log-event-tracker
      Run the command “mvn clean install”
    Now run below command to test the functionality.
      java -jar target\log-event-tracker-0.0.1-SNAPSHOT.jar logfile.txt
