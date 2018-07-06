package com.rrtx.ms.adm.controller;


import com.rrtx.ms.message.api.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MailController {
    @Autowired
    MailService mailService;

    @ResponseBody
    @RequestMapping("/sendMail2U")
    public String serviceList(@RequestParam("name") String to,@RequestParam("msg") String msg){

        return mailService.hello(to,msg);
    }
}
