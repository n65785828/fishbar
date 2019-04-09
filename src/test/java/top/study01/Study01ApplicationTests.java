package top.study01;

import org.csource.fastdfs.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.study01.mapper.DepartmentMapper;
import top.study01.mapper.EmployeeMapper;
import top.study01.pojo.Department;
import top.study01.pojo.Employee;
import top.study01.utils.FastDFSClient1;

import java.net.URL;
import java.util.List;
import java.util.Scanner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Study01ApplicationTests {


    @Test
    public void contextLoads() throws Exception {

     /*   URL resource = getClass().getClassLoader().getResource("fdfs_client.conf");
        FastDFSClient1 fastDFSClient1 = new FastDFSClient1(resource.getFile());
        Integer result = fastDFSClient1.delete_file("group1/M00/00/00/wKgr7VyAvd6ADaP8AAJUF4sIFTo298.jpg");
        System.out.println(result==0?"成功":"失败");*/


/*            String str =".sdafsdfasdf.bmp.jpg";
        String substring = str.substring(str.lastIndexOf('.') + 1);
        String strne = "bmp,jpg,png,tif,gif,pcx,tga,exif,fpx,svg,psd,cdr,pcd,dxf,ufo,eps,ai,raw,WMF,webp";//bmp,jpg,png,tif,gif,pcx,tga,exif,fpx,svg,psd,cdr,pcd,dxf,ufo,eps,ai,raw,WMF,webp
        if(strne.indexOf(substring)!=-1){
            System.out.println("ok");
        }else {
            System.out.println("fail");
        }*/


        // 1、加载配置文件，配置文件中的内容就是tracker服务的地址。
//        URL resource = getClass().getClassLoader().getResource("fdfs_client.conf");
//        System.out.println(resource.getFile());
//
//        ClientGlobal.init(resource.getFile());
//        // 2、创建一个TrackerClient对象。直接new一个。
//        TrackerClient trackerClient = new TrackerClient();
//        // 3、使用TrackerClient对象创建连接，获得一个TrackerServer对象。
//        TrackerServer trackerServer = trackerClient.getConnection();
//        // 4、创建一个StorageServer的引用，值为null
//        StorageServer storageServer = null;
//        // 5、创建一个StorageClient对象，需要两个参数TrackerServer对象、StorageServer的引用
//        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
//        // 6、使用StorageClient对象上传图片。
//        //扩展名不带“.”
//        String[] strings = storageClient.upload_file("C:\\Users\\n6578\\Pictures\\Saved Pictures\\boy.jpg", "jpg", null);
//        // 7、返回数组。包含组名和图片的路径。
//        for (String string : strings) {
//            System.out.println(string);
//        }

    }



}


