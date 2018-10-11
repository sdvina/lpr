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

}