import java.io.File;

public class PrintFileName {
    public static void main(String[] args) {
        String parent_path="C:\\Users\\Administrator\\Desktop";
        String path = "Test";
        File file=new File(parent_path,path);
        print_dicpath(file);
    }

    //输出子孙文件的路径
    public static void print_dicpath(File file){
        if (null==file||file.isFile()){
            return;
        }
        System.out.println(file.getPath());
        if (file.isDirectory()){
            for (File f:file.listFiles()){
                print_dicpath(f);
            }
        }
    }
}
