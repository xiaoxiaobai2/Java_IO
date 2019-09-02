import java.io.*;

public class Merge_file {
    private String mergepath;//要合并的文件路径
    private String path;//要合并的源文件路径
    private boolean tag=true;//是否可以进行合并
    private File file;//
    private File[] fileList;//保存所有要保存的文件路径

    //无参构造
    public Merge_file() {
    }

    //带路径构造（被分割文件的路径要保存的路径，无分割大小
    public Merge_file(String path, String mergepath) {
        this.path = path;
        this.mergepath = mergepath;
        init();
    }
    //初始化
    private void init(){
        if(path==null||mergepath==null){
            tag=false;
            System.out.println("源文件路径为空，或要合并的路径为空");
        }else {
            File pathFile=new File(path);
            File mergeFile=new File(mergepath);
            if (!pathFile.exists()||!mergeFile.exists()||pathFile.isFile()||mergeFile.isDirectory()){
                tag=false;
                System.err.println("源文件路径不存在，或源文件路径为文件路径，" +
                        "或要合并的路径不存在，或要合并的路径为文件夹路径");
            }else {
                file=new File(path);
                fileList=file.listFiles();
            }
        }
    }
    //开始合并文件
    public void merge() throws IOException {
        if (tag){
            OutputStream outputStream=new BufferedOutputStream(new FileOutputStream(mergepath,true));
            for (File file2:fileList){
                InputStream inputStream=new BufferedInputStream(new FileInputStream(file2));
                byte[] bytes=inputStream.readAllBytes();
                outputStream.write(bytes);
                outputStream.flush();
                inputStream.close();
            }
            outputStream.close();
            System.out.println("章节合并成功！");
        }
    }
}
