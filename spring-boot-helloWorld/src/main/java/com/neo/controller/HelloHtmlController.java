package com.neo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloHtmlController {

    @RequestMapping("/getHtml")
    public ModelAndView getHtml(HttpServletRequest request, HttpServletResponse response ){
        return new ModelAndView("test");
    }
}
