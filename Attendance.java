package CSC211Attendance;


//import packages to handle contents
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;



//Class name
public class Attendance {
    //Main method
    public static void main(String[] args) {

        //Main data structures for project
        //HashMap value is Absent/Present with student name as the key
       Map<String,String> enrolledStudents = new HashMap<String,String>();
       Set<String> studentHashSet = new HashSet<String>();



        System.out.println("CSC211Attendance.Attendance: ");
        //Try catch statement to catch any file reading exceptions
        try {
            //New file object based with path name
            File zoomChat = new File("src/CSC211Attendance/meeting_saved_chat.txt");

            File classRoster = new File("src/CSC211Attendance/csc211Roster.txt");

            //New scanner object to read the lines of the file, passing in file zoomChat into the scanner for input
            Scanner fileReader = new Scanner(zoomChat);

            Scanner rosterReader = new Scanner(classRoster);
            //Collecting the names of those present in class/in the zoom chat
            while(fileReader.hasNextLine()) {

                String line = fileReader.nextLine().trim();

                int fromIndex = line.indexOf("m");
                String name = line.substring(fromIndex + 2);
                //Redefine name to be a substring of itself
                name = name.substring(0,name.indexOf(":") - 1);

                studentHashSet.add(name);
            }


            while(rosterReader.hasNextLine()) {
                String line = rosterReader.nextLine().trim();
                if(!line.isBlank()) { //If the line is NOT blank
                    enrolledStudents.put(line,"ABSENT");
                }


            }
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace(); //Prints the error

        }

        //Adds students to absent student list
        for(String roll : studentHashSet) {
                if(enrolledStudents.containsKey(roll))
                    enrolledStudents.put(roll,"PRESENT");
        }


        Iterator<String> itr = enrolledStudents.keySet().iterator();
        while(itr.hasNext()) {
            String name = itr.next();
            System.out.println(name + " : " + enrolledStudents.get(name));
        }



        System.out.println("\n\nTHE FOLLOWING STUDENTS ARE ABSENT\n");

        Iterator<String> absentItr = enrolledStudents.keySet().iterator();
        while(absentItr.hasNext()) {
            String name = absentItr.next();
            if(enrolledStudents.get(name).equalsIgnoreCase("absent")) {
                System.out.println(name + " : " + enrolledStudents.get(name));
            }

        }



    }
}
