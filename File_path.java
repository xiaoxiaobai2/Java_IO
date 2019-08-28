import java.io.File;

public class File_path {
    /**
      * @author:  Zhang
      * @description:
      *
      * file path 的几种组合方法
     **/
    public static void main(String[] args) {
        System.out.println("*************   两个分隔符   **************");
        System.out.println("File.separator --> \\");
        System.out.println(File.separator);

        System.out.println("File.separator --> ;");
        System.out.println(File.pathSeparator);

        //path 的几种表示方式
        String path = "E:/abc/cdf";
        //适合动态生成
        path = "E:" + File.separator +"abc" + File.separator + "cdf";

        System.out.println("\n\n************绝对路径和相对路径测试*******************");
        String parents_path = "D:\\abc";
        //父＋子
        File file = new File(parents_path,"def");
        System.out.println(file.getName());
        file = new File("def");
        System.out.println("相对路径:"+file.getPath());
        System.out.println("绝对路径:"+file.getAbsolutePath());
    }
}
