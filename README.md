**Problem Statement**

Write a command line application or script which parses a cron string and expands each field
to show the times at which it will run. 

Consider standard cron format with five time fields (minute, hour, day of month, month, and day of week) plus a command, and no need to handle the special
time strings such as "@yearly". The input will be on a single line. The cron string will be passed to your application as a single argument.
~$ your-program ＂*/15 0 1,15 * 1-5 /usr/bin/find＂. The output should be formatted as a table with the field name taking the first 14 columns and
the times as a space-separated list following it.

For example, the following input argument: */15 0 1,15 * 1-5 /usr/bin/find
Should yield the following output:

minute 0 15 30 45<br>
hour 0<br>
day of month 1 15<br>
month 1 2 3 4 5 6 7 8 9 10 11 12<br>
day of week 1 2 3 4 5<br>
command /usr/bin/find<br>


**Solution Domain**

minute : 0 to 59

hour   : 0 to 23

day of month : 1 to 31

month  : 1 to 12

day of week : 0 to 6

`*` means all valid values for a field

`-` means range of values, 1-6 means all values from 1 to 6

`/` means starting from a value on left of `/` and take steps of a value on right till the end, 1/4 means 1,5,9,13,17,21 for field hour

`,` means all comma separated values are applicable, 1,2,3 means all 1 2 and 3


**Solution Design**

Design is based upon the Object Chain of responsibility design pattern. Above we have seen that there are multiple formats cron fields are acceptable.
This solution has one handler for one particular format. If handler can handle the field value then it handles it otherwise it delegates it to the next available handler.

Solution also has validations in place for the provided cron expression. These validations are done by matching with particular regular expression applicable for each of the cron fields.
These regex are placed in properties file.

**Running on Command Line**

As the required solution asked for a command line execution, Main class CronExpressionParser is the driver of this solution.
This main class does the following pieces of work.

* Validates the provided cron expression
* Creates the chain of handlers
* Pass the cron expression and master data map to the handlers 
* Print the output on console

This solution is compatible with java 8 and later versions.

To generate the executable JAR file, **run 'gradle fatJar'**

To run the cron parser run the following command

**java -jar cron-parser-all-1.0-SNAPSHOT.jar "20 13 2-8 1/3 2,3 doSomething"**

You will be seeing thee following output.<br/>
minute        20<br/>
hour          13<br/>
day of month  2 3 4 5 6 7 8<br/>
month         1 4 7 10<br/>
day of week   2 3<br/>
command       doSomething<br/>





# home-assignment
