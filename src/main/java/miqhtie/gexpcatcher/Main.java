package miqhtie.gexpcatcher;

import zone.nora.slothpixel.Slothpixel;
import zone.nora.slothpixel.guild.Guild;
import zone.nora.slothpixel.guild.member.GuildMember;

import java.io.FileWriter;
import java.io.IOException;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) throws IOException {

        Slothpixel pixel = new Slothpixel();
        CreateFile.createFile("output.txt");
        FileWriter writer = new FileWriter("output.txt");

        if(ReadFile.value1("input.txt") == null || ReadFile.value1("input.txt").equalsIgnoreCase("{value}")){
            writer.write("Error: Invalid input.txt \n");
            writer.write("To regenerate input.txt please delete input.txt and re run the program");
            writer.close();
            return;
        }

        try{
            pixel.getGuild(ReadFile.value1("input.txt"));
        } catch (Exception e){
            writer.write("Error: Invalid player in input.txt");
            writer.close();
            return;
        }


        writer.write("GEXP FOR ALL MEMBERS IN THE PAST 7 DAYS\n");
        writer.write("\n Powered by Miqhtie \n https://github.com/Miqhtiedev \n \n");

        Guild guild = pixel.getGuild(ReadFile.value1("input.txt"));
        for(GuildMember member : guild.getMembers()){
            int weeklyXP = 0;
            for(String v : member.getExpHistory().values()){
                weeklyXP += Integer.parseInt(v);
            }
            writer.write(member.getProfile().getUsername() + ": " + weeklyXP + "\n");
        }

        writer.close();

    }
}
