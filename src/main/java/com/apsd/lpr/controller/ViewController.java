package com.apsd.lpr.controller;

import org.springframework.stereotype.Controller;

/**
 * @author Perye
 */
@Controller
public class ViewController {

    public String getIndex(){
        return "index";
    }

}
