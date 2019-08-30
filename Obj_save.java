import java.io.*;
/**
  * @author:  Zhang
  * @description:
  *
  *   Object 序列化和反序列化，即和数据一样的存储读取， 不是所有的对象都可以序列化（需要实现Serializable接口----空接口）
 *      可序列化的对象的某些属性可以隐藏（加修饰符 transient），不被序列化。
 **/
public class Obj_save {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path="C:\\Users\\Administrator\\Desktop\\Test\\employee.txt";
        obj_save(path);
        obj_read(path);
    }

    /**
      * @author:  Zhang
      * @description:
      *
      * 序列化，把对象存储在文件里
     **/
    public static void obj_save(String path) throws IOException {
//        File file=new File(path);
        Employee employee =new Employee("张浩",100000);
        ObjectOutputStream oos=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
        oos.writeObject(employee);
        oos.flush();
        oos.close();
    }
/**
  * @author:  Zhang
  * @description:
  *
  * 反序列化，读取对象
 **/
    public static void obj_read(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new BufferedInputStream(new FileInputStream(path)));
        Object obj = ois.readObject();
        if(obj instanceof Employee){
            Employee employee=(Employee)obj;
            System.out.println(employee.getName());
            System.out.println(employee.getSalary());
        }
    }
}
