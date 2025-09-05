package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {
    private Sheet workSheet;
    private Workbook workBook;
    private String path;

    public ExcelUtil(String path, String sheetName) {
        this.path = path;
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            workBook = new XSSFWorkbook(fileInputStream);
            workSheet = workBook.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCellData(int rowNum, int colNum) {
        return workSheet.getRow(rowNum).getCell(colNum).toString();
    }

    public int rowCount() {
        return workSheet.getPhysicalNumberOfRows();
    }

    public int columnCount() {
        return workSheet.getRow(0).getPhysicalNumberOfCells();
    }

    public List<String> getColumnData(int columnIndex) {
        List<String> data = new ArrayList<>();
        for (int i = 1; i < rowCount(); i++) {
        data.add(getCellData(i, columnIndex));
    }
        return data;
}

}
