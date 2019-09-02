import java.io.*;

public class Split_file {
    int size;//将文件分成多少块
    private int blocksize=1024;//每块文件的大小，默认大小为1024，可根据需要修改
    private String path;//要分割的文件路径
    private String savepath;//要保存的文件路径
    private File file;
    private boolean tag=true;//是否可以拆分

    //无参构造
    public Split_file() {
    }

    //带路径构造（被分割文件的路径要保存的路径，无分割大小
    public Split_file(String path, String savepath) {
        this(path,savepath,1024);
    }
    //自定义大小

    public Split_file(String path, String savepath,int blocksize) {
        this.blocksize = blocksize;
        this.path = path;
        this.savepath = savepath;
        init();
    }
    //初始化
    private void init(){
        if (path==null||!(new File(path).exists())||(new File(path).isDirectory())){
            System.err.println("文件不存在、或路径为空、或为文件夹!");
            tag=false;
        }else if(savepath==null||(new File(savepath).isFile())){
            System.err.println("要保存的路径为空、或为文件路径!");
            tag=false;
        } else {
            this.file=new File(path);
            //创建将要保存的文件路径
            File file1=new File(savepath);
            file1.mkdirs();
            this.size=(int)Math.ceil(file.length()*1.0/blocksize);
        }
    }
    //开始划分文件
    public void split() throws IOException {
        if (tag){
            InputStream inputStream=new BufferedInputStream(new FileInputStream(file));
            //小车
            byte[] flush=new byte[blocksize];
            //实际长度
            int len=0;
            for(int i=0;i<size;i++){
                File file1=new File(savepath,"split_" + i+".txt");
                OutputStream outputStream=new BufferedOutputStream(new FileOutputStream(file1));
                len=inputStream.read(flush,0,blocksize);
                outputStream.write(flush,0,len);
                outputStream.flush();
                outputStream.close();
            }
            inputStream.close();
            System.out.println("章节划分成功！");
        }
    }
}
