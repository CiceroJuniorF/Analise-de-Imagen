package Realce;


import java.io.IOException;

public class Init {
	
	public static void main(String[] args) {
		try {
			int high = 55; 
			int low = 150;
			
			RealceLinear realce = new RealceLinear(high , low , "resultRealceLinear");
			realce.run();
			RealceExponencial a= new RealceExponencial(high , low , "resultRealceExponencial");
			a.run();
			RealceLog b= new RealceLog(high , low , "resultRealceLogaritimico");
			b.run();
			RealceGamma  c= new RealceGamma(high , low , "resultRealceGamma",10000000000000.0);
			c.run();
			
			System.out.println("Salvo em: "+ Realce.PATH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
