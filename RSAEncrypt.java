import java.io.*;
import java.util.*;

public class RSAEncrypt{
    public static void main(String[] args) throws FileNotFoundException {
        // File should be located in the same folder for the java code to be able to 
        // read the file.
        File file = new File("test.txt");
        try(FileReader fr = new FileReader(file))
        {
            // Content collects the characters in the file char by char
            // i helps break up the files by 3 bits or 3 characters.
            int content;
            int i = 1;
            while((content = fr.read()) != -1){
                if((i % 3) == 0){
                    // adding (char) next to content helps the variable be read as a character
                    //System.out.print((char)content);
                    System.out.print(content);
                    System.out.println(" ");
                }
                else
                    // adding (char) next to content helps the variable be read as a character
                    //System.out.print((char)content);
                    System.out.print(content);
                    i++;
            }
        }   catch (IOException e){
            e.printStackTrace();
        }
    }
}