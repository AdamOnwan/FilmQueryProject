## Film Query Project

### Overview

This program simulates a film database lookup.

### How to run
1. Open the file on Eclipse
2. Click the play button or click anywhere in the code and right click Run as Java Application

#### Installation
1. Download JDK8
2. Download Eclipse
3. Download JDBC
4. Download MAMP
5. Download the zip files
6. Unzip into a working set on Eclipse
7. Get SQL database file from Skills Distillery to communicate with database

#### Using the app
1. Upon startup the user will be prompted 3 choices and if you mistype it will give an invalid input message
2. Choice 1 is to communicate to the SQL database and lookup films by ID
3. Choice 2 is to communicate to the SQL database and lookup films via searching
4. Choice 3 is to exit the program.

### Technologies/topics used
1. Interface - Used to ensure the implementing object executed certain commands/methods
2. Objects (Film and Actor) - Used to simulate the objects in the database and assist with the connection to the RDBMS via preparedStatement and resultSet
3. JDBC and ORM - Used as the database where all the films and actors are stored into
4. ToString - Used to simulate text being inputed into the database
5. MySQL - Used to test commands in the database before making a ToString in the application
6. SQL - commands SELECT, FROM, JOIN, ON, WHERE, LIKE to gather information in and display the it neatly from the database
7. Try/Catch to catch SQL errors on the application, and used Try with resources to force AutoCloseable database connections

### Lessons learned
1. I had this error 'java.sql.SQLException Parameter index out of range (1 > number of parameters, which is 0)', which was because I did not have a "?" in my preparedStatement.
2. Another error encountered was 'SQLException: No value specified for parameter 1',
this occured when I was writing a auto closeable try with resources and my 'stmt.setInt(1,filmId);' line of code is suppose to be between preparedStatement and resultSet, however it had an misplaced construct error so I placed it outside the try block, which is after the resultSet and apparently that gave me this runtime error. So I reviewed the material and when a statement is closed any resultSet is automatically closed, and placing the try block around connection and statement seems to work perfectly fine.
3. Another error 'The resource type String does not implement java.lang.AutoCloseable', this occured because I had a string that gives the SQL commands for the preparedStatement in my try block and since its AutoCloseable I cannot have a string inside of it, so I just moved the string outside of the try block. I dont think AutoCloseable try/catch allows for anything other than things to be closed inside of it's try parameters.
4. Another error 'com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Column 'id' in field list is ambiguous', can't recall how I solved this issue, I think what was happening was I used the id from actor twice thinking I was using an id from actor and an id from film. Also, maybe the issue is that I named a variable after it was used the first time, like film.id, and if I wanted to name a variable I have to do it right away.
5. Encapsulation got me again, I had an issue where the program would remember the previous film and I was troubleshooting the App rather than the Database Object and it wasn't until I looked at the Database object and realized because I was trying to make the films and actors private I was also making it so it would not reset within its scope, so I just moved the fields into a smaller scope and I believe it makes them default, however it solved the issue.
6. Also reading the diagram helped a lot, because I was stuck on language not being registered and that was because I selected language instead of language.name.
