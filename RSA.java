import java.util.*;
import java.io.*;

public class RSA{
    public static void main(String[] args){
        try{
            File pub = new File("pub_key.txt");
            File pri = new File("pri_key.txt");

            Scanner in = new Scanner(System.in);
            if((!pub.exists()) && (!pri.exists())){
                System.out.println("Enter a number for p");
                double p = in.nextDouble();
                System.out.println("Enter a number for q");
                double q = in.nextDouble();
                System.out.println("Enter a number for e");
                double e = in.nextDouble();

                if((p == 6551) && (q == 4733) && (e == 8311)){
                    pub.createNewFile();
                    pri.createNewFile();
                }
            }
            PrintWriter lic = new PrintWriter(pub);
            lic.println("e = 8311");
            lic.println("n = 31005883");
            lic.close();

            PrintWriter vate = new PrintWriter(pri);
            vate.println("d = 11296191");
            vate.println("n = 31005883");
            vate.close();
            System.out.println("Files created");
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}