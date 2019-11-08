package Assignment07;

import java.util.Random;

/**
 * 
 *  Write a program that calculate the sum value in an array of ints using 4 threads. 
 *  You should construct an 4,000,000 long array of random numbers and return the sum of the array. 
 *  Please finish those two method: generateRandomArray and sum.
*/
    
public class q4 {
	 	
		/*generate array of random numbers*/
		static void generateRandomArray(int[] arr){
			Random rand = new Random();
			for(int i = 0; i <arr.length; i++) {
				arr[i] = rand.nextInt();
			}
	    }

	    /*get sum of an array using 4 threads*/
	    static long sum(int[] arr){
	    	
	    	long sum = 0;
	    	ComputingThread[] th = new ComputingThread[4];
	    	for(int i = 0; i < 4; i++) {
	    		th[i] = new ComputingThread(arr, i * 1000000, (i + 1) * 1000000);
	    		th[i].start(); 
	    		try {
					th[i].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	    	}
	    	sum += th[0].getSum() + th[1].getSum() + th[2].getSum() + th[3].getSum();
	        return sum;
	    }

	    public static void main(String[] args){
	        int[] arr = new int[4000000];
	        generateRandomArray(arr);
	        long sum = sum(arr);
	        System.out.println("Sum: " + sum);
	    }
	    
	   
	    
	    static class ComputingThread extends Thread {
	    	private int[] arr;
	    	private int start;
	    	private int end;
	    	private long sum = 0;

			public ComputingThread(int[] arr, int start, int end) {
				super();
				this.arr = arr;
				this.start = start;
				this.end = end;
			}

			public void run() {
				for(int i = start; i < end; i++) {
					sum += arr[i];
				}
			}

			public long getSum() {
				return sum;
			}			
		}

}
