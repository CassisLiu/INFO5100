package Assignment07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class Q2 {
/*
 * Write a program that decode a file. Given an encoded file, create its decoded file. The encoding rule is: k[encoded_string], 
 * where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

	Assume that the string from input file is always valid; No extra white spaces, square brackets are well-formed, etc.

	Furthermore, assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

	Examples:
	Input file: "3[a]2[bc]", output file: "aaabcbc".
	Input file: "3[a2[c]]", output file: "accaccacc".
	Input file: "2[abc]3[cd]ef", output file: "abcabccdcdcdef".
 */
	
// 9:47 完成assign07 完成Java core 总结bfs 做array
	public static String decode(String s) {
		if(s == null || s.length() == 0) return s;
		
		Stack<String> stack = new Stack<>();
		Stack<Integer> count = new Stack<>();
		int num = 0;
		StringBuilder sb = new StringBuilder();
		for(char ch : s.toCharArray()) {
			if(ch == '[') {
				count.push(num);
				num = 0;
				stack.push(sb.toString());
				sb = new StringBuilder();
			} else if(ch == ']') {
				num = count.pop();
				StringBuilder tmp = new StringBuilder(sb);
				for(int i = 0; i < num-1; i++) {
					sb.append(tmp);
				}
				num = 0;
				sb.insert(0, stack.pop());
			} else if(Character.isDigit(ch)) {
				num = num *10 + ch - '0';
			} else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	/** 
	 * Read and write file in main function 
	 * Helper function is decode, which 
	 * @param args
	 */
	public static void main(String[] args) {
		File f = new File("/Users/liuxinman/eclipse-workspace/Algorithms/src/Assignment07/stringDecode.txt");
		File out = new File("/Users/liuxinman/eclipse-workspace/Algorithms/src/Assignment07/decodeOut.txt");
		try {
			BufferedReader bf = new BufferedReader(new FileReader(f));
			BufferedWriter bw = new BufferedWriter(new FileWriter(out, true));
			String st;
			while((st = bf.readLine())!=null) {
				bw.append(decode(st)).append("\n");
				System.out.println(decode(st));
			}
			bf.close();
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// FileNotFoundException
