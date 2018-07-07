package com.rrtx.ms.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.environment.EnvironmentManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
@RestController
public class MessageApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageApplication.class, args);
	}

	@Autowired
	private EnvironmentManager env;
	@Value("${spring.cloud.consul.discovery.instance-id}")
//	@Value("${local.server.port}")
	private String port;
	@Value("${foo:defaultValue}")
	private String foo;
	@GetMapping("/sendMail")
	public String hello(@RequestParam(value = "name")String name,
						@RequestParam(value = "msg")String msg) {
		System.out.printf("sending mail to %s \n",name);
		String envStr =String.valueOf(env.getProperty(name));
		return String.format("my instance-id:%s, foo = %s ,env = %s send %s -->%s",port,foo,envStr,name,msg);
	}

}
