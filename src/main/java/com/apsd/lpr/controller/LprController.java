package com.apsd.lpr.controller;


import com.apsd.lpr.service.LprService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

/**
 * @author Perye
 */
@RestController
@RequestMapping("/upload")
public class LprController {
    @Autowired
    private LprService lprService;

    /**
     * 车牌识别
     */
    @PostMapping("/plateRecognize")
    public String plateRecognize(MultipartFile file){
        String fileName = this.getFileName(file);
        String result = lprService.plateRecognize(fileName);
        return result;
    }

    /**
     * 字符标识
     */
    @PostMapping("/charsIndetify")
    public String charsIndetify(MultipartFile file){
        String fileName = this.getFileName(file);
        String result = lprService.charsIndetify(fileName);
        return result;
    }

    /**
     *字符识别
     */
    @PostMapping("/charsRecognize")
    public String charsRecognize(MultipartFile file){
        String fileName = this.getFileName(file);
        String result = lprService.charsRecognize(fileName);
        return result;
    }

    /**
     *颜色检测
     */
    @PostMapping("/colorDetect")
    public String colorDetect(MultipartFile file){
        String fileName = this.getFileName(file);
        String result = lprService.colorDetect(fileName);
        return result;
    }

    /**
     *车牌检测
     */
    @PostMapping("/plateDetect")
    public void plateDetect(MultipartFile file){
        String fileName = this.getFileName(file);
        lprService.plateDetect(fileName);
    }

    /**
     * 车牌定位
     */
    @PostMapping("/plateLocate")
    public void plateLocate(MultipartFile file){
        String fileName = this.getFileName(file);
        lprService.plateLocate(fileName);
    }

    private String getFileName(MultipartFile file){
        if (!file.isEmpty()) {
            try {
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File("src/main/resources/static/images/" + file.getName()+ ".jpg")));//保存图片到目录下
                out.write(file.getBytes());
                out.flush();
                out.close();
                String filename = "src/main/resources/static/images/" + file.getName()+ ".jpg";
                return filename;
            } catch(Exception e){
                throw new RuntimeException(e);
            }
        }else{
            return "fail!";
        }
    }
}
