package com.rrtx.ms.api.message;

public class MailServiceFallBack implements MailService {

    @Override
    public String sendMail(String var1, String var2) {
        return "hello," + var1 + " I am in fallback method";
    }
}
