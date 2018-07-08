package com.rrtx.ms.api.message;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "message", fallback = MailServiceFallBack.class)
public interface MailService {
    @RequestMapping({"/sendMail"})
    String sendMail(@RequestParam("name") String var1, @RequestParam("msg") String var2);
}
