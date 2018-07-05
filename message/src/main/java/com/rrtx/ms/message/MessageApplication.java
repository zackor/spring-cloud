package com.rrtx.ms.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
@RestController
public class MessageApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageApplication.class, args);
	}


	@GetMapping("/sendMail/{to}/{msg}")
	public String hello(@PathVariable("to") String to,@PathVariable("msg") String msg) {
		System.out.printf("sending mail to %s \n",to);
		return String.format("send %s -->%s",to,msg);
	}

}
