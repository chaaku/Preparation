package Wallmart;
// Java program to find the highest occurring digit 		
// in prime numbers in a range L to R. 
import java.util.Arrays; 


public class HighestOoccurringDigitInPrimeNumbersInRange {
			
			// Returns maximum occurring digits in primes 
			// from l to r. 
			static int maxDigitInPrimes(int L, int R) { 

				int prime[] = new int [R-L];
				
				int m=0;
				for(int i=L; i<R; i++) {
					if(isPrime(i))
						prime[m++] = i;
				}
				
				// Initialse frequency of all digit to 0. 
				int freq[] = new int[10]; 
			
				// For all number between L to R, check if 
				// prime or not. If prime, incrementing 
				// the frequency of digits present in the 
				// prime number. 
				for (int i = 0; i < prime.length; i++) { 
					int p = prime[i]; // If i is prime 

					while (p > 0) { 
						freq[p % 10]++; 
						p /= 10; 
						} 
					} 
			
				// Finding digit with highest frequency. 
				int max = freq[0], ans = 0; 

				for (int j = 1; j < 10; j++) { 
					if (max <= freq[j]) { 
						max = freq[j]; 
						ans = j; 
					} 
				} 
			
				return ans; 
			} 
			
			private static boolean isPrime(int n) {
				// TODO Auto-generated method stub
				
				boolean flag =true;
				for(int i=2;i<=n/2;i++) {
					if(n/i==0)
						flag = false;					
				}				
				return flag;
			}

			// Driver code 
			public static void main(String[] args) { 
				int L = 1, R = 20; 
				System.out.println(maxDigitInPrimes(L, R)); 
			} 
		} 

		// This code is contributed by Anant Agarwal. 