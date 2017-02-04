/*************************************************************************
*
*  Pace University
*  Fall 2016
*  Algorithms and Theory of Computing
*
*  Course: CS 608 CRN 73103
*  Author: Abhishek S. Kulkarni
*  Collaborators: Karan Thakkar,Nikhilesh Purohit
*  References: Stack Overflow
*
*  Assignment: Assignment 1
*  Problem: Brute Force Improved to find Maximum Subarray.
*  Description:It takes size of array from user and generates random number array and the calculates the maximum subarray.
*  using the brute force method.This program is improved version of the brute force algorithm.
*
*  Input:  -2,1,-3,4,-1,2,1,-5,4  
*  Output: 6
*
*  Visible data fields: int maxsum,int sum int[] input_array,int temp,int initialVal 
*
*  Visible methods: public static int maxSubArray(int [] input_array)
*
*
*   Remarks
*   -------               n=10   n=10^2      n=10^3       n=10^4         n=15000     n=10^5     n=10^6         n=10^7  
*   Brute Force            0ms     3ms       77 ms        64564 ms       242297ms    ------     ------          ------
*   Brute Force Improved   0ms     1 ms        6 ms        51 ms          113ms      4083 ms    410603ms        ------
*   Divide and Conquer     0ms     2 ms        2 ms        5 ms           9ms        20 ms      106 ms          909ms
*
*  Conclusion
*  ---------
*    Brute Force
 *   ----------------
 *    Here in the Brute force the running times observed takes too much time for execution for bigger input because the complexity is O(N3).
 *    The running time of the bigger inputs is growing at a very large rate.The running time observed does not match.
 *
 *   Brute Force Improved
 *   --------------------
 *   The Brute force Improved running time are growing at O(n2) rate.The values for 1000 ,10000,100000 are almost growing at O(n2).We can see that this program is better than the brute force algorithm.
 *   It has less number of loops and that is why it is faster than the brute force algorithm. 
 *   
 *   Divide and Conquer
 *  ---------------------- 
 *   It uses the divide and conquer method and that program is executing as expected.The running times observed are almost in sync with O(n logn).  
 *
 *
 *
 *
*************************************************************************/

import java.util.Scanner;
public class ImprovedMaxSubarray{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the size of the array");
		int n = input.nextInt();// takes input from user
		long startTime = System.currentTimeMillis();
		int[] input_Array = new int[n];//new array created
		int intialVal;
		int temp = 0;
		for (int i = 0; i < n; i++){
			intialVal = (int)(Math.random()*2);
			if (intialVal == 0) {  
				temp = -1; 
			}else{
				temp = 1;
			} 
			input_Array[i] = ((int)(Math.random()*110)) * temp; // This array generates random both negative and positive numbers in array
			//System.out.println(input_Array[i]); 
		}
		maxSubArray(input_Array);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;	
		System.out.println(totalTime + " miliseconds");	//prints the running time
	}
	
	public static int maxSubArray(int [] input_array){
		int maxSum = Integer.MIN_VALUE;
		for (int i = 1; i < input_array.length; i++){
			int sum = 0;
			for (int j = i; j < input_array.length; j++){
				sum = sum + input_array[j];  //adds the number 
				maxSum = Math.max(maxSum, sum); // finds the maximum of the two numbers
			}
		}
		System.out.println("Max sum: "+maxSum);
		return maxSum;
	}
}
