package org.example.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/eureka")
public class EurekaTest {
    private final Logger logger = (Logger) LoggerFactory.getLogger(EurekaTest.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/print")
    @ResponseBody
    public String dotest (){
        logger.info(discoveryClient.getServices().toString());
        return "hello";
    }
}
