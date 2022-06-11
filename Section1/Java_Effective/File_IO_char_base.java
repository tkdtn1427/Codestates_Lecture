package Section1.Java_Effective;
import java.io.*;

public class File_IO_char_base {
    public static void main(String[] args) {
        try {
            String filename = "./Section1/src/Section1.Java_Effective/test_1.txt";
            FileWriter fileWriter = new FileWriter(filename);
            //BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String str = "how to write\n 안녕하세요 저는욤 ";
//            bufferedWriter.write(str);
//            bufferedWriter.flush();
//            bufferedWriter.close();
            fileWriter.write(str);
            fileWriter.close();
        }catch (Exception e){
            System.out.println(e);
        }

        try {
            FileReader fileReader = new FileReader("./Section1/src/Section1.Java_Effective/test_1.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            int i=0;
//            while((i = bufferedReader.read()) != -1){
//                System.out.print((char)i);
//            }
            String str;
            while((str=bufferedReader.readLine()) != null){
                System.out.println(str);
            }
            fileReader.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
