package Assignment07;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *  Write a program that will count the number of lines in each file that is specified on the command line.

	Assume that the files are text files.

	Note that multiple files can be specified, as in "java LineCounts file1.txt file2.txt file3.txt". 
	Write each file name, along with the number of lines in that file, to standard output. If an error occurs 
	while trying to read from one of the files, you should print an error message for that file, 
	but you should still process all the remaining files.

 */
public class Q3 {
	public int lineCounts(File f) {
		BufferedReader bf;
		int count = 0;
		try {
			bf = new BufferedReader(new FileReader(f));
			String st;
			while((st = bf.readLine()) != null) {
				count++;
			}
			bf.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return count;
	}
}
