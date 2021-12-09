import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class RSAEncrypt{
	public static void main(String[] args) throws FileNotFoundException {
        // File should be located in the same folder for the java code to be able to 
        // read the file.
        File file = new File("test.txt");
        File fileout = new File("test.enc");
        File dec = new File("pub_key.txt");
        
        BigInteger ee = new BigInteger("0");
        BigInteger n = new BigInteger("0");
        PrintWriter lic = new PrintWriter(fileout);
        
        
        
        if (args.length == 2) {
        	file = new File(args[0]);
        	dec = new File(args[1]);
        }
        
        try(Scanner sc = new Scanner(dec))
        {
        	String temp = sc.nextLine();
        	String[] arroftemp = temp.split(" ");
        	ee = new BigInteger(arroftemp[arroftemp.length-1]);
        	
        	
        	temp = sc.nextLine();
        	arroftemp = temp.split(" ");
        	n = new BigInteger(arroftemp[arroftemp.length-1]);
        	
        }   catch (IOException e){
            e.printStackTrace();
        }

        
        
        try(FileReader fr = new FileReader(file))
        {
            // Content collects the characters in the file char by char
            // i helps break up the files by 3 bits or 3 characters.
        	String block ="";
        	BigInteger c= new BigInteger("0");;
        	int hold;
            char content;
            int i = 0;
            while((hold = fr.read()) != -1){
            	content = (char)hold;
            	if (codeToText(Character.toString(content)).equals("-1") == false) {
	                if((i % 3) == 0 && (i != 0)){
	                	System.out.println("");
	                	String temp2 = "";
	                	String temp="";
	                	for (int ii = 0 ; ii<block.length(); ii++) {
	                		temp2 = codeToText(Character.toString(block.charAt(ii)).toLowerCase());
	                		temp += temp2;
	                	}
	                	BigInteger p = new BigInteger(temp);
	                	c = p.modPow(ee, n);
	                	System.out.println(temp + ": " + c);
	                	lic.print(c+"\n");
	                	
	                	//System.out.println(block);
	                	block="";
	                }
	
	                    System.out.print(content);
	                    block += content;
	                    i++;
	            }

           }
            
            System.out.println("blocklength" + block.length());
            
            if (block.length() < 3) {
            	System.out.println("leftovers");
            	for (int x = 0; x < 4-block.length(); ++x) {
            		block += " ";
            	}
            }
            
            	String temp2 = "";
            	String temp="";
            	for (int ii = 0 ; ii<block.length(); ii++) {
            		temp2 = codeToText(Character.toString(block.charAt(ii)).toLowerCase());
            		temp += temp2;
            	}
            	System.out.println(temp);
            	BigInteger p = new BigInteger(temp);
            	c = p.modPow(ee, n);
            	lic.print(c);
           
        }   catch (IOException e){
            e.printStackTrace();
        }
        lic.close();
    }

    
    public static String codeToText(String a) {
    	String output = "";
    	switch(a){
    		case "a": case "A":
				output = "00";
				break;
    		case "b": case "B":	
    			output = "01";
    			break;
    		case "c": case "C":
				output = "02";
				break;
    		case "d": case "D":
    			output = "03";
    			break;
    		case "e": case "E":
				output = "04";
				break;
    		case "f": case "F":
    			output = "05";
    			break;
    		case "g": case "G":
				output = "06";
				break;
    		case "h": case "H":
    			output = "07";
    			break;
    		case "i": case "I":
				output = "08";
				break;
    		case "j": case "J":
    			output = "09";
    			break;
    		case "k": case "K":
				output = "10";
				break;
    		case "l": case "L":
    			output = "11";
    			break;
    		case "m": case "M":
				output = "12";
				break;
    		case "n": case "N":
    			output = "13";
    			break;
    		case "o": case "O":
				output = "14";
				break;
    		case "p": case "P":
    			output = "15";
    			break;
    		case "q": case "Q":
				output = "16";
				break;
    		case "r": case "R":
    			output = "17";
    			break;
    		case "s": case "S":
				output = "18";
				break;
    		case "t": case "T":
    			output = "19";
    			break;
    		case "u": case "U":
				output = "20";
				break;
    		case "v": case "V":
    			output = "21";
    			break;
    		case "w": case "W":
				output = "22";
				break;
    		case "x": case "X":
    			output = "23";
    			break;
    		case "y": case "Y":
				output = "24";
				break;
    		case "z": case "Z":
    			output = "25";
    			break;
    		case " ":
				output = "26";
				break;
    		default:
    			output = "-1";
    			break;
    	}
    	
    	
    	return output;
    }
}