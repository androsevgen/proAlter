package com.websystique.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
//@RequestMapping("/")
public class AppController {

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        return "home";
    }

    @RequestMapping(value = {"/supervisors"}, method = RequestMethod.GET)
    public String supervisorsPage(ModelMap model) {
        return "supervisors";
    }

    @RequestMapping(value = {"/calculator"}, method = RequestMethod.GET)
    public String calculatorPage(ModelMap model) {
        return "calculator";
    }

    @RequestMapping(value = {"/game"}, method = RequestMethod.GET)
    public String gamePage(ModelMap model) {
        return "game";
    }

    @RequestMapping(value = {"/contactus"}, method = RequestMethod.GET)
    public String contactUsPage(ModelMap model) {
        return "contactus";
    }
}