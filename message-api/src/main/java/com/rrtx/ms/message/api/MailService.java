package com.rrtx.ms.message.api;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "message",fallback = MailServiceFallBack.class)
public interface MailService {

    @RequestMapping("/sendMail")
    String hello(@RequestParam(value = "name")String name,
                 @RequestParam(value = "msg")String msg);
}
