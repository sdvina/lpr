package com.apsd.lpr.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author: Perye
 * @create: 2018-10-11 18:38
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class LprServiceImplTest {

    @Autowired
    private LprService lprService;

    /**
     * 字符标识
     */
    @Test
    public void charsIndetify(){
        String result = lprService.charsIndetify("src/main/resources/static/data/image/test_image/chars_identify_E.jpg");
        System.out.println(result);

    }

    /***
     * 车牌识别
     */
    @Test
    public void charsRecognize() {
        String result = lprService.charsRecognize("src/main/resources/static/data/image/test_image/chars_recognise_huAGH092.jpg");
        System.out.println(result);
    }

    /**
     * 颜色检测
     */
    @Test
    public void colorDetect() {
        String result = lprService.colorDetect("src/main/resources/static/data/image/test_image/core_func_yellow.jpg");
        System.out.println(result);
    }

    /**
     * 车牌检测
     */
    @Test
    public void plateDetect() {
        lprService.plateDetect("src/main/resources/static/data/image/baidu_image/test2.jpg");
    }

    /**
     * 车牌定位
     */
    @Test
    public void plateLocate() {
        lprService.plateLocate("src/main/resources/static/data/image/baidu_image/test3.jpg");
    }
}