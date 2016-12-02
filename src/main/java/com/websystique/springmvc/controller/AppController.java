package com.websystique.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.proAlter.conect.select_from_bd;
import com.proAlter.conect.csv;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

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

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download(HttpServletResponse response) throws IOException {

        File file = new File("C:\\csv\\rcd.csv");
        InputStream is = new FileInputStream(file);

        // MIME type of the file
        response.setContentType("application/octet-stream");
        // Response header
        response.setHeader("Content-Disposition", "attachment; filename=\""
                + file.getName() + "\"");
        // Read from the file and write into the response
        OutputStream os = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        os.flush();
        os.close();
        os.close();
    }
}