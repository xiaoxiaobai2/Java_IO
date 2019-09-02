import java.io.IOException;

/**
  * @author:  Zhang
  * @description:
  *
  * 测试拆分文件 和 合并文件
 **/
public class Test_split_file {
    public static void main(String[] args) throws IOException {
        test01();
        test02();
    }
    public static void test01() throws IOException {
        String path="C:\\Users\\Administrator\\Desktop\\Test\\白夜行.txt";
        String savepath="C:\\Users\\Administrator\\Desktop\\Test\\白夜行章节划分";
        Split_file split_file=new Split_file(path,savepath,10*1024);
        split_file.split();
    }
    public static void test02() throws IOException {
        String savepath="C:\\Users\\Administrator\\Desktop\\Test\\白夜行章节划分";
        String mergePath="C:\\Users\\Administrator\\Desktop\\Test\\白夜行(副本).txt";
        Merge_file merge_file=new Merge_file(savepath,mergePath);
        merge_file.merge();
    }
}
