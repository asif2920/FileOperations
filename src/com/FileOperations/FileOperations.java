package com.FileOperations;
/**
 * @author asif
 * This program provides a simple example of file input and output 
 * with custom exception handling
 * At first, it gives an example to read from a file
 * where you have to give the file name or directory and it prints file 
 * information if the file exists.
 * 
 * 
 * Secondly, a program of reading two files and merging them to a new 
 * output file where output file's name is asked in the console
 * Without any output file name, it provides the custom exception
 * 
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileOperations {

	public static void main(String[] args) throws IOException {
		//Reading a simple text file while taking the file name as input
		BufferedReader br=null;
		FileReader fr=null;
		System.out.println("Please Enter the file name or with Directory: ");
		Scanner sc=new Scanner(System.in);
		String fName=sc.nextLine();
		fr=new FileReader(fName);
		br=new BufferedReader(fr);
		Scanner sc1=new Scanner(br);
		while(sc1.hasNext()) {
			System.out.println(sc1.nextLine());
		}
		
		/**
		 * Merging two text files into a new file
		 */
		
		BufferedReader f1=null;
		BufferedReader f2=null;
		PrintWriter f3=null;
		try {
		System.out.println("Enter the output file name: ");
		String outputFile=sc.nextLine();
		if(outputFile.isEmpty()) {
			throw new CustomException("Null value is given");
		}else {
		f3= new PrintWriter(outputFile+".txt");
		f1=new BufferedReader(new FileReader(fName));
		String firstFile=f1.readLine();
		f2=new BufferedReader(new FileReader("SecondFile.txt"));
		String secondFile=f2.readLine();
		//reading the first file
		while(firstFile!=null){
			System.out.println(firstFile);
			f3.println(firstFile);
			firstFile=f1.readLine();
		}
		//reading the seconf file
		while(secondFile!=null){
			System.out.println(secondFile);
			f3.println(secondFile);
			secondFile=f2.readLine();
		}
		f3.flush();

	}
		}catch(IOException | CustomException e2) {
		e2.printStackTrace();
	}finally {
		if(f1 !=null) {
			try {
				f1.close();
			}catch(IOException e3) {
				e3.printStackTrace();
			}
		}		
		if(f2 !=null) {
			try {
				f2.close();
			}catch(IOException e3) {
				e3.printStackTrace();
			}
		}
		if(f3 !=null) {
			f3.close();
		}
	}

}
}
