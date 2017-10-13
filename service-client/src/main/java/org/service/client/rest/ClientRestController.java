package org.service.client.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientRestController {


    @Autowired
    public ClientRestController(DiscoveryClient discoveryClient) {

    }

    @RequestMapping("/")
    public String getClientPage(Model model) {
        // Get the gateway service
        model.addAttribute("addressbookservice", "http://localhost:8081");
        return "webpage";
    }
}
