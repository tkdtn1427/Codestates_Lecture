package Section1.Java_Effective;

import java.io.BufferedInputStream;
import java.io.*;



public class File_IO_byte_base {
    public static void main(String[] args) throws Exception {
        try {
            FileOutputStream fileOutput = new FileOutputStream("./Section1/src/Section1.Java_Effective/codestates2.txt");
            String word = "code sss";

            byte b[] = word.getBytes();
            fileOutput.write(b);
            fileOutput.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }

        try{
            FileInputStream fileInput = new FileInputStream("./Section1/src/Section1.Java_Effective/codestates2.txt");
            BufferedInputStream bufferedInput = new BufferedInputStream(fileInput);
            int i=0;
            while((i = fileInput.read()) != -1) {
                System.out.print((char)i);
            }
            fileInput.close();
        }catch(Exception e){
            System.out.print(e);
        }
    }
}