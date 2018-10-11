package com.apsd.lpr.controller;


import com.apsd.lpr.service.LprService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

/**
 * @author Perye
 */
@RestController
public class LprController {
    @Autowired
    private LprService lprService;

//    @PostMapping("/upload")
//    public Object uploadPicture(MultipartFile file){
//
//        if (!file.isEmpty()) {
//            try {
//                BufferedOutputStream out = new BufferedOutputStream(
//                        new FileOutputStream(new File("src/main/resources/static/images/" + file.getName()+ ".jpg")));//保存图片到目录下
//                out.write(file.getBytes());
//                out.flush();
//                out.close();
//                String filename = "src/main/resources/static/images/" + file.getName()+ ".jpg";
//                System.out.println(filename);
//                List<String> resultList = lprService.LprService(filename);
//                return resultList;
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//                return "upload error," + e.getMessage();
//            } catch (IOException e) {
//                e.printStackTrace();
//                return "upload error" + e.getMessage();
//            }
//        }else{
//            return "fail!";
//        }
//    }

    @GetMapping("/ci")
    public String charsIndetify(){
        return lprService.charsIndetify("https://i.imgur.com/5PMBuyP.jpg");
    }


}
