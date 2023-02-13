package com.example.controlle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//在template目录下的所有页面，只能通过controller来跳转
//这个需要模板引擎的支持 thymeleaf
@Controller
public class IndexController {

    @RequestMapping("/index1")
    public String index1(Model model){
        model.addAttribute("mass","hello!Yunxi");
        model.addAttribute("mass_sty","line-height: 80px;" + "text-align: center;\n" + "background-color: #4158D0;\n" +
                "background-image: linear-gradient(43deg, #4158D0 0%, #C850C0 46%, #FFCC70 100%);\n"
                + "height: 80px;\n" + "width: 200px;\n");
        return "index1";
    }
}
