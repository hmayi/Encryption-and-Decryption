


import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.*;
import java.io.*;
public class RSAGenKey {

   private final static BigInteger one      = new BigInteger("1");
   private final static SecureRandom random = new SecureRandom();

  
   private BigInteger n;
   private BigInteger e;
   private BigInteger d;
    private BigInteger p;
    private BigInteger q;
    private BigInteger phi;
    private BigInteger phi1;
    private BigInteger d1;
    
    

   // generate an N-bit (roughly) public and private key
   RSAGenKey(int N) throws FileNotFoundException {
       p = BigInteger.probablePrime(N/2, random);
       q = BigInteger.probablePrime(N/2, random);
       phi = (p.subtract(one)).multiply(q.subtract(one));
      
     
       e = BigInteger.ONE;
      do{
    	  e = e.add(BigInteger.ONE);
      } while (!((phi.gcd(e)).equals(BigInteger.ONE)));
      d=e.modInverse(phi);
      java.io.File publictext=new java.io.File("pub_Key.txt");
      java.io.File privatetext=new java.io.File("pri_Key.txt");
     
      if(publictext.exists() && privatetext.exists()){
    	  System.out.println("file already exists");
    	  System.exit(0);
      }
      
    	  //create a file
    	  java.io.PrintWriter  puboutput = new java.io.PrintWriter(publictext);
    	  java.io.PrintWriter  prioutput = new java.io.PrintWriter(privatetext);
    	     
    	   puboutput.println( "krishna" + e);
    	   puboutput.println();
    	   
    	  puboutput.print( "n =" + phi);
    	   puboutput.close();
    	   
    	   prioutput.println("d ="+ d+"\n");
    	   puboutput.println();
    	   prioutput.println("n ="+ phi);
    	   prioutput.close();
   }
   RSAGenKey(BigInteger p1,BigInteger q1, BigInteger e1) throws FileNotFoundException{
	   phi1 = (p1.subtract(one)).multiply(q1.subtract(one));
	   d1=e1.modInverse(phi1);
	   java.io.File publictext=new java.io.File("pub_Key.txt");
	      java.io.File privatetext=new java.io.File("pri_Key.txt");
	     
	      if(publictext.exists() && privatetext.exists()){
	    	  System.out.println("file already exists");
	    	  System.exit(0);
	      }
	      
	    	  //create a file
	    	  java.io.PrintWriter  puboutput = new java.io.PrintWriter(publictext);
	    	  java.io.PrintWriter  prioutput = new java.io.PrintWriter(publictext);
	     
	    	   puboutput.println( "e =" + e1);
	    	 //  puboutput.println("\n");
	    	   puboutput.print( "n =" + phi1);
	    	   puboutput.close();
	    	   
	    	   prioutput.println("d ="+ d1);
	    	   //prioutput.println("\n");
	    	   prioutput.print("n =" + phi1);
   }
	   

   
  // BigInteger encrypt(BigInteger message) {
  //    return message.modPow(publicKey, modulus);
  // }

  // BigInteger decrypt(BigInteger encrypted) {
   //   return encrypted.modPow(privateKey, modulus);
  // }

   public String toString() {
      String s = "";
      s += "p  ="+ p + "\n";
      s += "e  = " + q  + "\n";
      s += "e  = " + phi + "\n";
      s += "e  = " + e  + "\n";
      s += "d = " + d + "\n";
     // s += "modulus = " + modulus;
      return s;
   }
 
   public static void main(String[] args) throws Exception {
      int N = Integer.parseInt(args[0]);
      
      
      RSAGenKey key = new RSAGenKey(N);
      System.out.println(key);
     
   
      // create random message, encrypt and decrypt
   //   BigInteger message = new BigInteger(N-1, random);

      //// create message by converting string to integer
      // String s = "test";
      // byte[] bytes = s.getBytes();
      // BigInteger message = new BigInteger(s);

    //  BigInteger encrypt = key.encrypt(message);
   //   BigInteger decrypt = key.decrypt(encrypt);
   //   System.out.println("message   = " + message);
   //   System.out.println("encrpyted = " + encrypt);
   //   System.out.println("decrypted = " + decrypt);
      System.out.println();
   }
}

