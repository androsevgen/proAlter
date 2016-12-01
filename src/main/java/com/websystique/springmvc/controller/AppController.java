package com.websystique.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.proAlter.conect.select_from_bd;
import com.proAlter.conect.csv;

import java.io.File;

@Controller
//@RequestMapping("/")
public class AppController {

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        return "home";
    }

    @RequestMapping(value = {"/supervisors"}, method = RequestMethod.GET)
    public String supervisorsPage(ModelMap model) {
        select_from_bd seli = new select_from_bd();
        seli.rcd();

        csv c = new csv();

        File file = new File("C:\\csv\\");
        file.mkdirs();


        c.commn();
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

    @RequestMapping(value = {"/dani"}, method = RequestMethod.GET)
    public String daniUsPage(ModelMap model) {
        return "dani";
    }

    /*
        @RequestMapping(value = "/getFile", method = RequestMethod.GET)
        public ModelAndView out(HttpServletResponse response) {

            ModelAndView mv = new ModelAndView();


            File file = new File("file.csv");
            try {
                FileInputStream fileIn = new FileInputStream(file);
                response.setHeader("Content-Disposition", "attachment;filename=" + file);
                response.setContentType("text/plain");

                OutputStream os = response.getOutputStream();
                IOUtils.copy(fileIn, os);
                os.flush();
                os.close();
                fileIn.close();
                response.flushBuffer();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return mv;
        }*/

}