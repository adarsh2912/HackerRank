/**
 * https://www.hackerrank.com/challenges/tower-breakers-revisited-1
 * 
 */

/**
 * @author rakshith
 *
 */
 
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = 1001;
        int[] noOfPrimeFactors = new int[size];
        int[] primesList = new int[168];
        computeNoOfPrimeFactors(noOfPrimeFactors, size, primesList);
        noOfPrimeFactors[1] = 0;
        //System.out.println(Arrays.toString(noOfPrimeFactors));
        int t = input.nextInt();
        for(int i=0; i<t; i++){
            int n = input.nextInt();
            int p = 0;
            for(int j=0; j<n; j++){
                int q = input.nextInt();
                if(q<=1000)
                    p = p^noOfPrimeFactors[q];
                else{
                    p = p^getNoOfPrimeFactors(q, noOfPrimeFactors, primesList);
                    //System.out.println(getNoOfPrimeFactors(q, noOfPrimeFactors, primesList));
                }
                    
            }
            //System.out.println("p = "+p);
            if(p==0){
                System.out.println(2);
            }else{
                System.out.println(1);
            }
        }
    }
    
    public static void computeNoOfPrimeFactors(int[] mem, int n, int[] primes){
        Arrays.fill(mem,1);
        for(int i=4; i<n; i++){
            for(int j=2;j<i;j++){
                if(i%j==0){
                    mem[i] = 1+mem[i/j];
                    break;
                }
            }
        }
        
        int count = 0;
        for(int i=2;i<n;i++){
            if(mem[i]==1){
                primes[count++] = i;
            }
        }
        //System.out.println(count);
        //System.out.println(Arrays.toString(primes));
    }
    
    public static int getNoOfPrimeFactors(int num, int[] mem, int[] primes){
        int count = 0;
        for(int i=0;i<primes.length;i++){
            while(num != 1 && num%primes[i]==0){
                num = num/primes[i];
                count++;
            }
            if(num == 1){
                break;
            }
        }
        if(num>1)count++;
        return count;
    }
}