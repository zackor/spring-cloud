package com.rrtx.ms.adm.controller;

import com.rrtx.ms.adm.util.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MicroserviceController {

    @GetMapping("/service")
    public String dataSource(){
        return "service";
    }
    @PostMapping("serviceList")
    @ResponseBody
    public R serviceList(){
        return new R();
    }
}
