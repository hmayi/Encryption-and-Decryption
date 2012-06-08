import java.io.*;
import java.util.*;
public class RSAEncrypt {
	private static  List<Integer>  array = new ArrayList<Integer>();
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		RSAEncrypt encrypt = new RSAEncrypt();
		//System.out.println("array = "+ array);
	}
	RSAEncrypt() throws IOException{
		read();
	}
	private void read() throws IOException {

		java.io.File file = new java.io.File("test.txt");
		java.io.FileReader read= new java.io.FileReader(file);
		char n;
		int k;


		while(read.ready()){
			k =  read.read();
			if(k>=65 && k<=90 ){
				n=(char)(k);
				n=Character.toLowerCase(n);
				k = (int)n;
			}
			if(k>=97  && k<=122){
				k=k-97;
				array.add(k);
				System.out.println(k);
			}
			else{
			if(k==32){
				k=26;
				array.add(k);	
			}
			}
		}
	}
}
