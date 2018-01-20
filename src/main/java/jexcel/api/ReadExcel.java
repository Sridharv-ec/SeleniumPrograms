package jexcel.api;

import jxl.Workbook;

import java.io.File;


public class ReadExcel {

    public static void main(String[] args) throws Exception {
        File file = new File("E:\\Sridhar\\AutomationFolder\\AutomationBySridhar\\SeleniumProgramms\\src\\main\\resources\\DataFiles\\DataSheet.xlsx");
        //FileInputStream fis = new FileInputStream(file);
        Workbook wb = Workbook.getWorkbook(file);
        String data = wb.getSheet(0).getCell(0,0).getContents();
        System.out.println("data is "+data);

    }
}
