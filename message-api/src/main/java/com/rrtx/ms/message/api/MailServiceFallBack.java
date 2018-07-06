package com.rrtx.ms.message.api;
/** 
* ClassName: MailServiceFallBack<br> 
* Description: 服务降级 <br>
* Company: rrtx 
* @author xugz 
* @version  v1.0.0    2018/7/6 下午5:45  xugz    文件初始创建 
*  
*/
public class MailServiceFallBack implements MailService{
    @Override
    public String hello(String name, String msg) {
        return "I am in FallBack method";
    }
}
