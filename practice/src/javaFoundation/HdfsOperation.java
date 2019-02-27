package javaFoundation;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author ChenXiang
 * @Date 2018/12/11,16:23
 */
public class HdfsOperation {
    String relativePath = System.getProperty("user.dir");
    public String dir = relativePath+ "/test.txt";
    Set<String> pathSet = new HashSet<>();
//    private String string ="ERROR: Region { meta => null, hdfs => hdfs://master:9000/hbase/APMac20180823/eeb30771b5ef0bf761fd9f6266b366db, deployed =>  } on HDFS, but not listed in META or deployed on any region server";
    public void readFile() throws IOException {
        File file = new File(dir);
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String lineContent="";
        while ((lineContent=reader.readLine())!=null){
            pathSet.add(resolvePath(lineContent));
        }
        reader.close();
        inputStreamReader.close();
        fileInputStream.close();
    }

    public String resolvePath(String string){
        String[] path = string.split("9000|,");
        return path[2];
    }

    public void operation(String path) throws IOException {
        Configuration conf = new Configuration();
        conf.set("fs.default.name","hdfs://master:9000");
        Path dst = new Path(path+"/.regioninfo");
        FileSystem fs = dst.getFileSystem(conf);
        byte[] contents = Bytes.toBytes("DATABLK*.");
        FSDataOutputStream outputStream = fs.create(dst);
        outputStream.write(contents);
    }

    public static void main(String[] args) throws IOException {
        HdfsOperation hdfsOperation = new HdfsOperation();
        hdfsOperation.readFile();
        for (String str:hdfsOperation.pathSet){
            hdfsOperation.operation(str);
        }
//        System.out.println(hdfsOperation.relativePath);
//        System.out.println(hdfsOperation.pathSet);
//        System.out.println(hdfsOperation.pathSet.size());
    }
}
