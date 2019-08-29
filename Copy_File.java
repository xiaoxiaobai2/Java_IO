import java.io.*;

public class Copy_File {
    public static void copy_file(String s1,String s2) throws IOException {

        File file1 =new File(s1);
        File file2 =new File(s2);

        InputStream is=new FileInputStream(file1);
        OutputStream os=new FileOutputStream(file2);
        byte[] car=is.readAllBytes();
        os.write(car,0,car.length);
        os.flush();
        is.close();
        os.close();

    }

    public static void main(String[] args) {
        String s1="C:\\Users\\Administrator\\Desktop\\Test\\hello.txt";
        String s2="C:\\Users\\Administrator\\Desktop\\Test\\world.txt";
        try {
            copy_file(s1,s2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
