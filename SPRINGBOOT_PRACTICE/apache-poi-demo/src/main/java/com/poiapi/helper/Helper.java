package com.poiapi.helper;


import com.poiapi.model.Product;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Helper {


    //check that file is of excel type or not
    public static boolean checkExcelFormat(MultipartFile file) {
        String contentType = file.getContentType();
        return contentType != null && contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }


    //convert excel to list of products
    public static List<Product> convertExcelToListOfProduct(InputStream is) {
        List<Product> list = new ArrayList<>();

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheet("data");
            int rowNumber = 0;

            for (Row row : sheet) {
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();
                int cid = 0;
                Product p = new Product();

                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    switch (cid) {
                        case 0 -> p.setProductId((int) cell.getNumericCellValue());
                        case 1 -> p.setProductName(cell.getStringCellValue());
                        case 2 -> p.setProductDesc(cell.getStringCellValue());
                        case 3 -> p.setProductPrice(cell.getNumericCellValue());
                        default -> {
                        }
                    }

                    cid++;
                }

                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static ByteArrayInputStream convertDBDataToExcelData(List<Product> pList) throws IOException {

        String[] headers = {"productId", "productName", "productDesc", "productPrice"};
        String sheetName = "product_list";

        // create a workbook

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {


            // create a sheet
            Sheet sheet = workbook.createSheet(sheetName);

            // create row : header row
            Row rowHead = sheet.createRow(0);

            for (int i = 0; i < headers.length; i++) {
                Cell cell = rowHead.createCell(i);
                cell.setCellValue(headers[i]);
            }

            // values row
            int rowIndex = 1;

            for (Product p : pList) {
                Row row = sheet.createRow(rowIndex);
                rowIndex++;
                row.createCell(0).setCellValue(p.getProductId());
                row.createCell(1).setCellValue(p.getProductName());
                row.createCell(2).setCellValue(p.getProductDesc());
                row.createCell(3).setCellValue(p.getProductPrice());
            }
            workbook.write(outputStream);

            return new ByteArrayInputStream(outputStream.toByteArray());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


}
