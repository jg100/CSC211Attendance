# CSC211Attendance
Attendance recorder to read from zoom chat log and take attendance
The program will run on any JVM equipt with JDK14.

# Goal 
The goal of the program was to read the zoom chat and take attendance based on the usernames. The file is to be downloaded off of the zoom interface and is in a .txt file.

# Collecting the Data
The data is collected by reading each line of the chat lag and using String delimiter and String function split() to to extract the username from the chat log. The content of the sent chat is ignored.


