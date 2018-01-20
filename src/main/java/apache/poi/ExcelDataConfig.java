package apache.poi;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelDataConfig {

    XSSFWorkbook wb;
    XSSFSheet sheet;

    public ExcelDataConfig(String excelPath) throws IOException {
        File file = new File(excelPath);
        FileInputStream fis = new FileInputStream(file);
        wb = new XSSFWorkbook(fis);

    }

    public String getData(int sheetNo, int row, int column){
        sheet = wb.getSheetAt(sheetNo);
        String data = sheet.getRow(row).getCell(column).getStringCellValue();
        return data;
    }

    public int getRowCount(int sheetIndex){
        int row = wb.getSheetAt(sheetIndex).getLastRowNum();
        row = row + 1;
        return row;
    }

    public static void main(String[] args) throws IOException {
        ExcelDataConfig excelDataConfig = new ExcelDataConfig("E:\\Sridhar\\AutomationFolder\\AutomationBySridhar\\SeleniumProgramms\\src\\main\\resources\\DataFiles\\DataSheet.xlsx");
        System.out.println(excelDataConfig.getData(0,0,0));
    }
}
