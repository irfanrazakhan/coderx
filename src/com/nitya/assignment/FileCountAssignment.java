package com.nitya.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Month;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/** 
 * Here provide the folder path which folder's files count you want know.
 * Output:-
 *Enter the folder path in format 'D:\\myfol' :- D:\\
 FEBRUARY: 1
 APRIL: 1
 JUNE: 1
 JULY: 1
 SEPTEMBER: 1
 OCTOBER: 3
 DECEMBER: 1
 */

public class FileCountAssignment {
	public static void main(String args[]) throws IOException {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the folder path in format 'D:\\\\myfol' :- ");
		String folderPath = in.nextLine();

		// File folder = new File("D:\\myfol");
		
		Map<Integer, Integer> monthFileCount = new HashMap<Integer, Integer>();

		File folder = new File(folderPath);
		File[] listOfFiles = folder.listFiles();
		if (listOfFiles != null) {
			for (File file : listOfFiles) {
				
				// This condition will check for file or folder. if only file then file count logic proceed and if folder then skip the logic.
				if (file.isFile()) {
					@SuppressWarnings("deprecation")
					Integer month = new Date(file.lastModified()).getMonth();
					if (monthFileCount.containsKey(month)) {
						monthFileCount.put(month, monthFileCount.get(month) + new Integer(1));
					} else {
						monthFileCount.put(month, new Integer(1));
					}

				}
			}
		} else {
			System.out.println("Folder is Empty");
		}
		Month[] months = Month.values();

		for (Entry entry : monthFileCount.entrySet()) {
			System.out.println(months[(int) entry.getKey()] + ": " + entry.getValue());
		}
	}
}