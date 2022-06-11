package Section1.Java_Effective;
import java.io.File;

public class File_IO_file_class {
    public static void main(String[] args) {
        File parentDir = new File("./Section1/src/Section1.Java_Effective/");
        File[] list = parentDir.listFiles();

        String prefix = "code";

        for(int i =0; i <list.length; i++) {
            String fileName = list[i].getName();

            if(fileName.endsWith("txt") && !fileName.startsWith("code")) {
                list[i].renameTo(new File(parentDir, prefix + fileName));
            }
        }
    }
}
