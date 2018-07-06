package com.rrtx.ms.adm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
* ClassName: IndexController<br>
* Description: IndexController <br>
* Company: rrtx
* @author xugz
* @version  v1.0.0    2018/7/6 上午10:25  xugz    文件初始创建
*
*/
@Controller
public class IndexController {
    @GetMapping("/")
    public String home(){
        return "index";
    }
}
