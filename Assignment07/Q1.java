package Assignment07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Q1 {
	/**
	 * Write a program that read sentences from a file and reverse sentences word by word. After reverse, create a new file to save sentences. (Extreme corner case is not mandatory.)

	 *	Example:
	 *	Input file: the sky is blue.
	 *	Output file: blue is sky the.
	 * @param st 
	 *
	 */
	public static String reverse(String st) {
		String[] parts = st.split("[^a-zA-Z]");
		int start = 0, end = parts.length-1;
		while(start < end) {
			String tmp = parts[start];
			parts[start++] = parts[end];
			parts[end--] = tmp;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < parts.length; i++) {
			sb.append(parts[i]).append(" ");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append(".");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		File f = new File("/Users/liuxinman/eclipse-workspace/Algorithms/src/Assignment07/textToReversed.txt");
		File out = new File("/Users/liuxinman/eclipse-workspace/Algorithms/src/Assignment07/writtenFile.txt");
		BufferedReader bf;
		BufferedWriter bw;
		try {
			bf = new BufferedReader(new FileReader(f));	
			bw = new BufferedWriter(new FileWriter(out,true));
			String st;
			while((st = bf.readLine())!=null) {
				st = reverse(st);
				bw.append(st);
				System.out.println(st);
			}
			bw.close();
			bf.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
