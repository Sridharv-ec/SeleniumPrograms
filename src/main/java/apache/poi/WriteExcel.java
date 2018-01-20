package apache.poi;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class WriteExcel {

    public static void main(String[] args) throws IOException {
        File file = new File("E:\\Sridhar\\AutomationFolder\\AutomationBySridhar\\SeleniumProgramms\\src\\main\\resources\\DataFiles\\DataSheet.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        sheet.getRow(0).createCell(2).setCellValue("Pass");
        sheet.getRow(1).createCell(2).setCellValue("Fail");
        sheet.getRow(2).createCell(2).setCellValue("1098");
        FileOutputStream fos = new FileOutputStream(file);
        wb.write(fos);
        wb.close();

    }
}
