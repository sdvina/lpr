package com.apsd.lpr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Perye
 */
@Controller
public class ViewController {

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    //字符标识
    @GetMapping("/charsIndetify")
    public String charsIndetify(){
        return "charsIndetify";
    }

    //字符识别
    @GetMapping("/charsRecognize")
    public String charsRecognize(){
        return "charsRecognize";
    }

    //颜色检测
    @GetMapping("/colorDetect")
    public String colorDetect(){
        return "colorDetect";
    }

    //车牌检测
    @GetMapping("/plateDetect")
    public String plateDetect(){
        return "plateDetect";
    }

    //车牌定位
    @GetMapping("/plateLocate")
    public String plateLocate(){
        return "plateLocate";
    }

}
