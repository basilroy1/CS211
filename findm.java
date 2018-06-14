import java.util.Scanner;

public class findm {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		//Read in public key (p, g, gmp)
		long p = scan.nextLong();
		long g = scan.nextLong();
		long gmp= scan.nextLong();
		
		long x = 0;
		// brute force
		for(long i = 0; i < p; i++){
			long t = modPow(g, i, p);
			if(t== gmp){
				x = i;
				break;
			}	
		}
		
		//cipher 
		long c1 = scan.nextLong();
		long c2 = scan.nextLong();
		
		//find M
		long power = p - 1 - x;
		long first = modPow(c1, power, p);
		
		System.out.println(modMult(first, c2, p));
	}
	
	// Philly code
	public static long modPow(long number, long power, long modulus){
		 if(power==0)
			 return 1;
		 else if (power%2==0) {
			 long halfpower=modPow(number, power/2, modulus);
			 return modMult(halfpower,halfpower,modulus);
		 }else{
			 long halfpower=modPow(number, power/2, modulus);
			 long firstbit = modMult(halfpower,halfpower,modulus);
			 return modMult(firstbit,number,modulus);
		 }
	}
	 public static long modMult(long first, long second, long modulus){
		 if(second==0)
			 return 0;
		 else if (second%2==0) {
			 long half=modMult(first, second/2, modulus);
			 return (half+half)%modulus;
		 }else{
			 long half=modMult(first, second/2, modulus);
			 return (half+half+first)%modulus;
		 }
	}
}