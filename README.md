## Film Query Project

### Overview

This program simulates a film database lookup.

### How to run

#### Installation

#### Using the app


### Technologies/topics used
In this program I took advantage of
1. Interface
2. Objects (Film and Actor)
3. API (JDBC)
4. ToString - Used to simulate text being inputed into the SQL database
5. MySQL
6.
7.

### Lessons learned
1. I had this error 'java.sql.SQLException Parameter index out of range (1 > number of parameters, which is 0)', which was because I did not have a "?" in my preparedStatement.
2. Another error encountered was 'SQLException: No value specified for parameter 1',
this occured when I was writing a auto closeable try with resources and my 'stmt.setInt(1,filmId);' line of code is suppose to be between preparedStatement and resultSet, however it had an misplaced construct error so I placed it outside the try block, which is after the resultSet and apparently that gave me this runtime error. So I reviewed the material and when a statement is closed any resultSet is automatically closed, and placing the try block around connection and statement seems to work perfectly fine.
3. Another error 'The resource type String does not implement java.lang.AutoCloseable', this occured because I had a string that gives the SQL commands for the preparedStatement in my try block and since its AutoCloseable I cannot have a string inside of it, so I just moved the string outside of the try block. I dont think AutoCloseable try/catch allows for anything other than things to be closed inside of it's try parameters.
4. Another error 'com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Column 'id' in field list is ambiguous'
5.
6.
7.
