package com.vvygulyarniy.wowcraft.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class StaticContentController {

    @RequestMapping(value = {"/", "/recipes", "/recipes/*", "/reagents", "/reagents/*"}, method = GET)
    public String indexPage() {
        return "/index.html";
    }
}
