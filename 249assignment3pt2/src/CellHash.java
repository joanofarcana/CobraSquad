// ---------------------------------------------------------------
// Assignment 3 part 2

// Written by: Arielle Evans		27380267
// 				Nina Prentiss		26270611

// For COMP249 Section D
// ---------------------------------------------------------------

import java.io.*;

public class CellHash{

	private CellList[] hashArr;

	public CellHash(){
		hashArr = new CellList[] {new CellList(), new CellList(), new CellList(), new CellList(), new CellList(), new CellList(), new CellList(), new CellList(), new CellList(), new CellList(), new CellList(), new CellList()};
	}


	public int computeHashValue(long serial){
		return (int)serial%12;
	} 

	public void addToHashTable() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Cell_Info.txt"));
		String line;
		String[] phones;
		int hash;
		while ((line = br.readLine()) != null) {
			phones = line.split("[ ]+");
			hash = computeHashValue(Long.parseLong(phones[0]));
			if(hashArr[hash].contains(Long.parseLong(phones[0]))==false) {
				hashArr[hash].addToStart(new CellPhone(Long.parseLong(phones[0]),phones[1],Integer.parseInt(phones[3]),Double.parseDouble(phones[2])));
			}
		}
		br.close();
	}



	public void displayHashContents(){
		for(int i = 0; i < hashArr.length; i++){
			hashArr[i].showContents();
		}
	}

	public void findCell(long serial){
		int i = computeHashValue(serial);
		if(hashArr[i].contains(serial)){
			System.out.println("Serial number found.");
			return;
		}
		System.out.println("Serial number not found.");

	}









}
