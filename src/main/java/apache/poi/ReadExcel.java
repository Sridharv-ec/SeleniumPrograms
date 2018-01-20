package apache.poi;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcel {

    public static void main(String[] args) throws IOException {
        File src = new File("E:\\Sridhar\\AutomationFolder\\AutomationBySridhar\\SeleniumProgramms\\src\\main\\resources\\DataFiles\\DataSheet.xlsx");
        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);

        int rowCount = sheet.getLastRowNum();

        System.out.println("Total rows is "+rowCount);

        for(int i = 0 ;i < rowCount; i++){
            String data0 = sheet.getRow(i).getCell(0).getStringCellValue();
            System.out.println("Data from row "+i+" "+data0);
        }
        wb.close();
        fis.close();

    }
}
