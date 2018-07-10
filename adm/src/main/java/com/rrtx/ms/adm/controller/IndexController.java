package com.rrtx.ms.adm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * ClassName: IndexController<br>
 * Description: IndexController <br>
 * Company: rrtx
 *
 * @author xugz
 * @version v1.0.0    2018/7/6 上午10:25  xugz    文件初始创建
 */
@Controller
public class IndexController {
    Pattern p = Pattern.compile("Services(.*)Checks");
    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/registeradr")
    public String registeradr() {
        return "registeradr";
    }

    @GetMapping("/feign")
    public String feign() {
        return "feign";
    }

    @GetMapping("/addPara")
    public String addPara() {
        return "addPara";
    }

    @GetMapping("/refreshSvr")
    public String refreshSvr() {
        return "refreshSvr";
    }
    @GetMapping("/monitor")
    public String monitor() {
        return "monitor";
    }

    @GetMapping("/serviceList")
    public String serviceList() {
        return "serviceList";
    }
@GetMapping("/zipkin")
    public String zipkin() {
        return "zipkin";
    }

    @GetMapping("/serviceListAjax")
    @ResponseBody
    public String serviceListAjax() {
        String s = restTemplate.getForObject("http://127.0.0.1:8500/v1/internal/ui/services?dc=dc1", String.class, new HashMap());
        return s;
    }

    @PostMapping("/mytrace")
    @ResponseBody
    public String mytrace() {
        String s = restTemplate.getForObject("http://127.0.0.1:8888/trace", String.class, new HashMap());
        return s;
    }

    @PostMapping("/myrefresh")
    @ResponseBody
    public String myrefresh(String destination) {
        Map m = new HashMap<String, String>();
        m.put("destination", destination);
        String s = restTemplate.postForObject("http://127.0.0.1:8888/bus/refresh", m, String.class);
        return s;
    }
}
