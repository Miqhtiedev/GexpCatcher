package miqhtie.gexpcatcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static String value1(String fileName) throws FileNotFoundException {
        File myObj = new File(fileName);
        Scanner myReader = new Scanner(myObj);

        while (myReader.hasNextLine()){
            String line = myReader.nextLine();
            System.out.println(line);
            if(line.startsWith("Name-Of-GuildMaster")){
                System.out.println("found");
                String [] data = line.split(":");
                return data[1];
            }
        }

        return null;
    }
}
