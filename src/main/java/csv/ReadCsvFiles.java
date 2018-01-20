package csv;


import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ReadCsvFiles {

    public static void main(String[] args) throws IOException {
        CSVReader csvReader = new CSVReader(new FileReader("E:\\Sridhar\\AutomationFolder\\AutomationBySridhar\\SeleniumProgramms\\src\\main\\resources\\DataFiles\\DataSheet - Copy.csv"));
        List<String[]> li = csvReader.readAll();
        Iterator<String[]> itr = li.iterator();

        while (itr.hasNext()){
            String[] str = itr.next();
            System.out.println(" Values are ");
            for(int i = 0; i < str.length; i++){
                System.out.println(" "+str[i]);
            }
            System.out.println(" ");
        }
    }
}
