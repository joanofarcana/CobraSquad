// ---------------------------------------------------------------
// Assignment (include number)
// Question: (include question number)
// Written by: (include you name and student id)
// For COMP249 Section: (Substitute your section letter(s))
// ---------------------------------------------------------------
//import src.*;
import java.io.*;

public class CellHash{

    private static CellList[] hashArr;
    
    public CellHash(){
        hashArr = new CellList[] {new CellList(), new CellList(), new CellList(), new CellList(), new CellList(), new CellList(), new CellList(), new CellList(), new CellList(), new CellList(), new CellList(), new CellList()};
    }


    public static int computerHashValue(long serial){
    return (int)serial%12;
    } 
    
    public static void addToHashTable(){
    

    try (BufferedReader br = new BufferedReader(new FileReader("Cell_Info.txt"))) {
        String line;
        String[] phones;
        int hash;
        while ((line = br.readLine()) != null) {
           phones = line.split(" ");
           hash = computerHashValue(Long.parseLong(phones[0]));
           if(hashArr[hash].contains(Long.parseLong(phones[0]))==false){
                hashArr[hash].insertAtIndex(new CellPhone(Long.parseLong(phones[0]),phones[1],Integer.parseInt(phones[3]),Double.parseDouble(phones[2])), hashArr[hash].getSize());
           }
           
        }
    }catch(Exception e){
    }
}


    public static void displayHashContents(){
        for(int i = 0;i<12;i++){
            hashArr[i].showContents();
        }
    }
    
    public static boolean findCell(long serial){
        int searches=0;
        for(int i =0;i<12;i++){
            if(hashArr[i].contains(serial)){
                System.out.println(""+searches+" searches were conducted");
                return true;
            } else
                searches++;
        }
        System.out.println(""+searches+" searches were conducted");
        return false;
    
    }









}
