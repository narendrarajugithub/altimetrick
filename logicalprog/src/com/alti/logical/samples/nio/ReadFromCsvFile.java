package com.alti.logical.samples.nio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromCsvFile {

	public static void main(String[] args) throws IOException {
		
		FileReader reader = new FileReader("addrass.csv");
		BufferedReader br = new BufferedReader(reader);
		String line= "";
		
		while ((line = br.readLine()) !=null) {
			System.out.println(line);
		}
		
		
	}

}
