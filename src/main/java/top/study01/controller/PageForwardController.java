package top.study01.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.study01.pojo.Filewarehouse;
import top.study01.pojo.Selfuser;
import top.study01.service.FilewarehouseService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PageForwardController {

    @Autowired
    private FilewarehouseService filewarehouseService;

    @Value("${fileServer}")
    private String fileServer;

    @Value("${pictureExt}")
    private String pictureExt;

    @Value("${autofileName}")
    private String autofileName;

    @RequestMapping("/uploadPage")
    public String toUploadPage(){
        return "uploadPage";
    }

    @RequestMapping("home")
    public String toHomepage(){
        return "home";
    }

    @RequestMapping("portfolio")
    public String toPortfolio(){
        return "portfolio";
    }

    @RequestMapping("contact")
    public String toContact(){
        return "contact";
    }


    @RequestMapping("warehouse")
    public String toWarehouse(HttpServletRequest request , Model model){
        putUserWareHouseToModel(model, request);
        return "warehouse";
    }

    @RequestMapping("about")
    public String toAbout(){
        return "about";
    }

    @RequestMapping("/myFiles")
    public String toMyFiles(Model model, HttpServletRequest request){
        putUserWareHouseToModel(model, request);
        return "myFiles";
    }

    /**
     * 将当前用户的仓库内的文件信息封装成集合，放入model中，
     * attribute为files，autofileName是默认非图片文件的显示图标URL
     * @param model
     * @param request
     */
    private void putUserWareHouseToModel(Model model, HttpServletRequest request) {
        Selfuser user = (Selfuser) request.getSession().getAttribute("user");

        List<Filewarehouse> filewarehouseList =filewarehouseService.FindFilesByUid(user.getUid());
        for (Filewarehouse file:
                filewarehouseList) {
            file.setFpath("http://"+fileServer+"/"+file.getFpath());
        }
        model.addAttribute("files",filewarehouseList);
        model.addAttribute("autofileName","http://"+fileServer+"/"+autofileName);
    }
}
