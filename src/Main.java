import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Assignment 9 P11.10 This program revert text in a file backward
 * @author Sergei Chekhonin
 */
public class Main {

    static PrintWriter out = null;
    /***
     * Main - enter point to the program
     */
    public static void main(String[] args) throws FileNotFoundException{
        //This block initialize Scaner, printWriter and dateFormatter
        /**
         * Store address of the file to read
         */
        String filePath =  "Assignment9_P11.10base.txt";
        /**
         * Stores File object
         */
        File inputFile = null;
        /**
         * Stores Scanner object
         */
        Scanner in = null;
        //Creating object File, PrintWriter
        try {
            inputFile = new File(filePath);
            out = new PrintWriter("Assignment9_P11.10output.txt");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Create new Scaner object
        in = new Scanner(inputFile, "UTF-8");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        out.println(dtf.format(now));

        //use revertIt() method to each line in a file to read, write output to a new file
        while (in.hasNextLine()){
            String line = in.nextLine();
            out.println(revertIt(line));
        }
        out.close();
        System.exit(0);

    }

    /**
     * Method reverse any input string
     * @param string
     * @return
     */
    public static String revertIt(String string) {
        String revertedString="";
        for (int i = string.length()-1; i >=0; i--) {
            revertedString = revertedString+(string.charAt(i));
        }
        return revertedString;
    }


}





