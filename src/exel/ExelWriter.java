/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exel;

import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author RT
 */
public class ExelWriter {

    private static ExelType exelType = ExelType.XLS;
    private static Workbook workbook;
    /*private static Sheet sheet;
     private static Row row;
     private static Cell cell;
     */
    private static Font font;
    private static CellStyle cellstyle;

    private static String path = "./words.xlsx";

    public static void write(List<String> list, String path) {

    }

    private static Workbook getWorkbook() {
        if (workbook == null) {
            switch (exelType) {
                case XLS:
                    workbook = new HSSFWorkbook();
                    break;
                case XLSX:
                    workbook = new XSSFWorkbook();
                    break;
            }

        }
        return workbook;
    }

    private static Sheet getSheet(String name) {

        Sheet sheet = getWorkbook().createSheet(name);
        // Set the width (in units of 1/256th of a character width)
        sheet.setColumnWidth(1, 5000);
        sheet.autoSizeColumn(0);
        sheet.addMergedRegion(new CellRangeAddress(0, 4, 4, 8));

        return sheet;
    }

    private static Row getRow(int rowN, float height, String name) {
        Row row = getSheet(name).createRow(rowN);
        row.setHeightInPoints(height);

        return row;
    }

    private static CellStyle getCellStyle(Font font) {
        if (cellstyle == null) {
            cellstyle = getWorkbook().createCellStyle();
            cellstyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
            cellstyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
            cellstyle.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
            cellstyle.setAlignment(CellStyle.ALIGN_CENTER);
            cellstyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
            cellstyle.setBorderBottom(CellStyle.BORDER_DASH_DOT_DOT);
            cellstyle.setBottomBorderColor(IndexedColors.GREEN.getIndex());
            if (font != null) {
                cellstyle.setFont(font);
            }
        }
        return cellstyle;
    }

    private static Font getFont() {
        if (font == null) {
            font = getWorkbook().createFont();
            font.setFontName("Word");
            font.setFontHeightInPoints((short) 25);
            font.setBold(true);
            font.setStrikeout(true);
            font.setUnderline(Font.U_SINGLE);
            font.setColor(IndexedColors.RED.getIndex());
        }
        return font;
    }

}
