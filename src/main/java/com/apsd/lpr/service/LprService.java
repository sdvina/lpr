package com.apsd.lpr.service;


import com.apsd.lpr.core.CoreFunc;

/**
 * @author Perye
 */
public interface LprService {

    /**
     *字符标识
     * @param imgPath
     * @return
     */
    String charsIndetify(String imgPath);

    /**
     * 字符识别
     * @param imgPath
     * @return
     */
    String charsRecognize(String imgPath);

    /**
     * 颜色检测
     * @param imgPath
     * @return
     */
    String colorDetect(String imgPath);


}
