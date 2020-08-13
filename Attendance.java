package CSC211Attendance;


//import packages to handle contents
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


//Class name
public class Attendance {
    //Main method
    public static void main(String[] args) {

        System.out.println("CSC211Attendance.Attendance: ");

        try {
            //New file object based with path name
            File zoomChat = new File("meeting_saved_chat.txt");
            //New scanner object to read the lines of the file, passing in fiule zoomChat into the scanner for input
            Scanner fileReader = new Scanner(zoomChat);
            while(fileReader.hasNextLine()) {

                String line = fileReader.nextLine();

                int fromIndex = line.indexOf("m");
                String name = line.substring(fromIndex + 2);
                //Redefine name to be a substring of itself
                name = name.substring(0,name.indexOf(":") - 1);

                System.out.println( name );
            }


        } catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace(); //Prints the error

        }








    }
}
