package com.rrtx.ms.adm.controller;


import com.rrtx.ms.api.message.MailService;
import com.rrtx.ms.api.message.MailServiceFallBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MailController {
    //引用其他服务
    @Autowired
    MailService mailService;

    @ResponseBody
    @RequestMapping("/sendMail2U")
    public String sendMail(@RequestParam("name") String to, @RequestParam("msg") String msg) {
        //调用其他服务
        return mailService.sendMail(to, msg);
    }

//    /***
//     * 方法描述：自定义降级方法
//     */
//    @Bean
//    public MailServiceFallBack getMailServiceFallBack(){
//        return  new MailServiceFallBack(){
//            @Override
//            public String sendMail(String var1, String var2) {
//                return "my selfDefind fallBack Method";
//            }
//        };
//    }


    /**
     * 方法描述：断路器的应用
     */
    @Bean
    public MailServiceFallBack getMailServiceFallBack() {
        return new MailServiceFallBack();
    }
}
