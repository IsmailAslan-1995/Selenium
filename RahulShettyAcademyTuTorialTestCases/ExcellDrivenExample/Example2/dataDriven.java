package excelExample1;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class dataDriven {
    public static void main(String[] args) throws IOException {

    }
    public ArrayList<String> getData(String testCaseName) throws IOException {
        ArrayList<String> a = new ArrayList<>();
        FileInputStream fis = new FileInputStream("C:\\Users\\Sys\\Desktop\\demodata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        int sheets = workbook.getNumberOfSheets();
        for (int i = 0; i < sheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rows = sheet.iterator();
                Row firstRow = rows.next();
                Iterator<Cell> cell = firstRow.cellIterator();
                cell.next();
                int k = 0;
                int column = 0;
                while (cell.hasNext()) {
                    Cell value = cell.next();
                    if (value.getStringCellValue().equalsIgnoreCase("TESTCASES")) {
                        column = k;
                    }
                    k++;
                }
                System.out.println(column);
                while (rows.hasNext()) {
                    Row r = rows.next();
                    if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
                        Iterator<Cell> cv = r.cellIterator();
                        while (cv.hasNext()) {
                            Cell c=cv.next();
                            if(c.getCellType()== CellType.STRING){
                            a.add(cv.next().getStringCellValue());
                            }else{
                              a.add(NumberToTextConverter.toText(c.getNumericCellValue()));

                            }
                        }
                    }
                }
            }

        }
        return a;
    }
}


