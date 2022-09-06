package com.ziraat.personal.util;

import com.ziraat.personal.model.User;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class ExcelUtils {
//    public static ByteArrayInputStream usersToExcel(List<User> users) throws IOException {
//
//        String[] COLUMNs  =  {"Name","Birth", "Country", "City", "Region", "Address", "PhoneMain", "PhoneHome", "PhoneIP", "Department", "Special", "Position"};
//        try(
//            Workbook workbook = new XSSFWorkbook();
//            ByteArrayOutputStream out = new ByteArrayOutputStream();
//        ) {
//            CreationHelper creationHelper = workbook.getCreationHelper();
//
//            Sheet sheet = workbook.createSheet("Users");
//
//            Font headerFont = workbook.createFont();
//            headerFont.setBold(true);
//            headerFont.setColor(IndexedColors.BLUE.getIndex());
//
//            CellStyle headerCellStyle = workbook.createCellStyle();
//            headerCellStyle.setFont(headerFont);
//
//            //Row for Header
//
//            Row headerRow = sheet.createRow(0);
//
//            //Header
//            for (int col = 0; col < COLUMNs.length; col++) {
//                Cell cell = headerRow.createCell(col);
//                cell.setCellValue(COLUMNs[col]);
//                cell.setCellStyle(headerCellStyle);
//            }
//
//            //CellStyle for Age
//            int rowIdx = 1;
//            for (User user : users) {
//                Row row = sheet.createRow(rowIdx++);
//
//                row.createCell(0).setCellValue(user.getFull_name());
//                row.createCell(1).setCellValue(user.getDate_birth());
//                row.createCell(2).setCellValue(user.getCountry());
//                row.createCell(3).setCellValue(user.getCity());
//                row.createCell(4).setCellValue(user.getRegion());
//                row.createCell(5).setCellValue(user.getAddress());
//                row.createCell(6).setCellValue(user.getPhone_main());
//                row.createCell(7).setCellValue(user.getPhone_home());
//                row.createCell(8).setCellValue(user.getPhone_ext());
//                row.createCell(9).setCellValue(user.getDep_cur());
//                row.createCell(10).setCellValue(user.getSpec_cur());
//                row.createCell(11).setCellValue(user.getPosition_cur());
//            }
//
//            workbook.write(out);
//            return new ByteArrayInputStream(out.toByteArray());
//        }
//    }

        public static List<User> parseExcelFile(InputStream  is){
            try{
                Workbook workbook = new XSSFWorkbook(is);

                Sheet sheets = workbook.getSheetAt(0);
                Iterator<Row> rows = sheets.iterator();

                List<User> lstUsers = new ArrayList<User>();

                int rowNumber = 0;
                while (rows.hasNext()) {
                    Row currentRow = rows.next();

                    // skip header
                    if(rowNumber == 0) {
                        rowNumber++;
                        continue;
                    }

                    Iterator<Cell> cellsInRow = currentRow.iterator();

                    User usr = new User();

                    int cellIndex = 1;
                    while (cellsInRow.hasNext()) {
                        Cell currentCell = cellsInRow.next();

                        if(cellIndex==1) { // Name
                            usr.setFull_name(currentCell.getStringCellValue());
                        } else if(cellIndex==2) { // Name
                            usr.setDate_birth(currentCell.getStringCellValue());
                        } else if(cellIndex==3) { // Age
                            usr.setCountry(currentCell.getStringCellValue());
                        } else if(cellIndex==4) { // Age
                            usr.setCity(currentCell.getStringCellValue());
                        } else if(cellIndex==5) { // Age
                            usr.setRegion(currentCell.getStringCellValue());
                        }else if(cellIndex==6) { // Age
                            usr.setAddress(currentCell.getStringCellValue());
                        }else if(cellIndex==7) { // Age
                            usr.setPhone_main(currentCell.getStringCellValue());
                        }else if(cellIndex==8) { // Age
                            usr.setPhone_home(currentCell.getStringCellValue());
                        }else if(cellIndex==9) { // Age
                            usr.setPhone_ext(currentCell.getStringCellValue());
                        }else if(cellIndex==10) { // Age
                            usr.setDep_cur(currentCell.getStringCellValue());
                        }else if(cellIndex==11) { // Age
                            usr.setSpec_cur(currentCell.getStringCellValue());
                        }else if(cellIndex==12) { // Age
                            usr.setPosition_cur(currentCell.getStringCellValue());
                        }

                        cellIndex++;

                    }
                    lstUsers.add(usr);
        }
     workbook.close();
                     return lstUsers;

    }
            catch (IOException e){
            throw  new RuntimeException(String.format("Fail! -> message = " + e.getMessage() + log));

        }
    }
}
