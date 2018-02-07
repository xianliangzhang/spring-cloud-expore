package top.kou.customer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestConfigController {

    @Value("${neo.hello}")
    private String neoHello;

    @RequestMapping("/config/get")
    public String getConfig() {
        return neoHello;
    }
}
