package setup;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

public class TestComponents{

    /**
     * the method generates random email
     */
    public String generateRandomEmail(int count){
       return generateRandomAlphaNumericString(count) + "@example.com";
    }

    /**
     * the method generates random String
     */
    protected String generateRandomString(int count){

        final String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz";
        StringBuilder stringBuilder = new StringBuilder();

        while(count-- != 0){
            int character = (int)(Math.random()*AlphaNumericString.length());
            stringBuilder.append(AlphaNumericString.charAt(character));
        }
        return stringBuilder.toString();
    }
    /**
     * the method generates random Alphanumeric String
     */
    protected String generateRandomAlphaNumericString(int count){

        final String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789";
        StringBuilder stringBuilder = new StringBuilder();

        while(count-- != 0){
            int character = (int)(Math.random()*AlphaNumericString.length());
            stringBuilder.append(AlphaNumericString.charAt(character));
        }
        return stringBuilder.toString();
    }
    /**
     * the method creates file and writes in it random email and message for 30 different users
     */
    public void createFileWithRandomData() {

        String filename = "Data.xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Demo");


        XSSFRow rowhead = sheet.createRow(0);
        rowhead.createCell(0).setCellValue("Email");
        rowhead.createCell(1).setCellValue("Message");

        for (int i = 1; i < 31; i++) {
            rowhead = sheet.createRow(i);
            rowhead.createCell(0).setCellValue(generateRandomEmail(10));
            rowhead.createCell(1).setCellValue(generateRandomString(30));
        }


        try (FileOutputStream fileOut = new FileOutputStream(filename)) {
            workbook.write(fileOut);
            workbook.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
