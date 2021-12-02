import java.util.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;

public class RSA{
    public static void main(String[] args){
        try{
            File pub = new File("pub_key.txt");
            File pri = new File("pri_key.txt");

            Scanner in = new Scanner(System.in);
            BigInteger p =  new BigInteger("2");
            BigInteger q = new BigInteger("2");
            BigInteger e = new BigInteger("2");
            
            Random rng = new Random();
            
            int bits = 0;
            
            if((!pub.exists()) && (!pri.exists())){
            	
            	if (args.length == 1)  { //using args to hit bits
            		bits = Integer.parseInt(args[0]);
            		boolean pprime = false;
            		boolean qprime = false;
            		while (pprime == false) {
            			p = new BigInteger(bits,1,rng);
            			if (p.isProbablePrime(1) == true) {
            				pprime = true;
            			}
            		}
            		
            		while (qprime == false) {
            			q = new BigInteger(bits,1,rng);
            			if (q.isProbablePrime(1) == true) {
            				qprime = true;
            			}
            		}
            		boolean ecap =false;
            		
            		while (ecap == false) {
            			e = new BigInteger(bits,1,rng);
            			if (e.bitLength() >= bits-1) {
            				ecap = true;
            			}
            			
            		}
            		
            		
            		
            	} else if (args.length == 3){  //using args to fill in
            		p = new BigInteger(args[0]);
            		q = new BigInteger(args[1]);
            		e = new BigInteger(args[2]);
            		
            	} else { //using console
            		System.out.println("Enter a number for p");
	                p = new BigInteger(""+in.nextInt());
	                System.out.println("Enter a number for q");
	                q = new BigInteger(""+in.nextInt());
	                System.out.println("Enter a number for e");
	                e = new BigInteger(""+in.nextInt());
            	}
                
                BigInteger n = p.multiply(q);
                
                //double d = modinv(e,(p-1)*(q-1));
                
                BigInteger ex =p.add(new BigInteger("-1")).multiply(q.add(new BigInteger("-1")));
                
                BigInteger d = e.modInverse(ex);
                
                
                

               // if((p == 6551) && (q == 4733) && (e == 8311)){
                    pub.createNewFile();
                    pri.createNewFile();
               // }
                
                PrintWriter lic = new PrintWriter(pub);
                lic.println("e = "+e.toString());
                lic.println("n = "+n.toString());
                lic.close();

                PrintWriter vate = new PrintWriter(pri);
                vate.println("d = "+d.toString());
                vate.println("n = "+n.toString());
                vate.close();
                System.out.println("Files created");
                
                //d = 11296191
                //n = 31005883
                
                //e = 8311
                //n = 31005883

                		

            }
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
   
    
}