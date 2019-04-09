package top.study01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.study01.pojo.Department;
import top.study01.pojo.Employee;
import top.study01.pojo.Filewarehouse;
import top.study01.pojo.Selfuser;
import top.study01.service.DeparmentService;
import top.study01.service.EmployeeService;
import top.study01.service.FilewarehouseService;
import top.study01.utils.FastDFSClient;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class mainController {

    @Value("${fileServer}")
    private String fileServer;

    @Autowired
    private DeparmentService deparmentService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private FilewarehouseService filewarehouseService;

    @Value("${pictureExt}")
    private String pictureExt;


//    此处使用spring  注入单利 运行则会报错,手动new对象则不会遇到该问题 未解决
    @Autowired
    private FastDFSClient fastDFSClient;

    @RequestMapping("upload")
    @ResponseBody
    public Map upload(MultipartFile file01, String fdesc, HttpServletRequest request)throws Exception{
        Map<String,String> resultMap = new HashMap<>();
        if(file01==null){
            System.out.println("失败，没有文件");
            resultMap.put("result","n");//n 代表失败
            return resultMap;
        }
        System.out.println(fdesc);
        //创建上传文件工具对象
       // FastDFSClient fastDFSClient=new FastDFSClient();//此处无法用单利解决
        //获取上传文件全名称
        String originalFilename = file01.getOriginalFilename();
        //截取扩展名
        String extName = originalFilename.substring(originalFilename.lastIndexOf('.') + 1);
        //上传到图片服务器，返回图片地址
        String filePath = fastDFSClient.uploadFile(file01.getBytes(), extName, null);
        //将上传的文件信息封装
        Filewarehouse filewarehouse = new Filewarehouse();
        filewarehouse.setFdate(new Date());
        filewarehouse.setFname(originalFilename);
        filewarehouse.setFdesc(fdesc);
        filewarehouse.setFid(UUID.randomUUID().toString().replace("-",""));
        Selfuser selfuser = (Selfuser) request.getSession().getAttribute("user");
        filewarehouse.setUid(selfuser.getUid());
        filewarehouse.setFpath(filePath);
        //将上传文件信息对象存入数据库
        filewarehouse.setIspicture(pictureExt.indexOf(extName)!=-1);
        Integer result = filewarehouseService.save(filewarehouse);
        resultMap.put("result",result==1?"y":"n");
        return  resultMap;
    }

    @RequestMapping("/list")
    public String listLogInPage(Model model){
        Collection<Employee> allEmoloyee = employeeService.getAllEmployee();
        model.addAttribute("allEmoloyee",allEmoloyee);
        return "list";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        int result =employeeService.deleteEmployee(id);
        return "redirect:/list";
    }

    @GetMapping("/emp")
    public String findEmployee(Integer id ,Model model){
        Employee employee=null;
        if(id!=null){
            employee = employeeService.getEmpById(id);
        }
        model.addAttribute("emp",employee);
        Collection<Department> departments = deparmentService.getAllDepartments();
        model.addAttribute("deps",departments);
        return "add&modify";
    }
    @RequestMapping("/mainPage")
    public String toMainPage(){
        return "dashboard";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
            employeeService.addEmployee(employee);
        return "redirect:/list";
    }

    @PutMapping("/emp")
    public String modifyEmp(Employee employee){
        int reuslt =employeeService.updateEmployeeById(employee);
        return "redirect:/list";
    }
}
