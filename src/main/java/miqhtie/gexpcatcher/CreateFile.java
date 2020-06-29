package miqhtie.gexpcatcher;

import java.io.File;
import java.io.FileWriter;

public class CreateFile {
    public static void createFile(String fileNameDotTxt){
        try{
            File myObj = new File(fileNameDotTxt);
            File myObj2 = new File("input.txt");

            if(!myObj2.exists()){
                myObj2.createNewFile();
                FileWriter writer = new FileWriter("input.txt");
                writer.write("INPUTS. PLEASE DO NOT PUT ANY SPACES BETWEEN THE : AND THE VALUE \n");
                writer.write("Name-Of-GuildMaster:{VALUE}");
                writer.close();
            }
            if(myObj.createNewFile()){
                System.out.println("File created");
            } else {
                myObj.delete();
                myObj.createNewFile();
                System.out.println("File created");
            }
//            Process p = Runtime.getRuntime().exec("shutdown /l");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
