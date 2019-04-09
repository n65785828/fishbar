package top.study01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.study01.pojo.Selfuser;
import top.study01.service.SelfuserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogInController {


    @Autowired
    private SelfuserService selfuserService;

    @RequestMapping("/login")
    public String loginCheck(Selfuser user, Model model, HttpServletRequest req){

        Selfuser selfuser =selfuserService.findUser(user);
        if(selfuser!=null){
            req.getSession().setAttribute("user",selfuser);
            return "redirect:/mainPage";
        }
        model.addAttribute("errorMesg","账号或密码不正确");
        return "index";
    }
}
