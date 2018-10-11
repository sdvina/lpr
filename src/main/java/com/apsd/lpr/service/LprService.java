package com.apsd.lpr.service;


import java.util.List;

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

    /**
     * 车牌检测
     * @param imgPath
     * @return
     */
    void plateDetect(String imgPath);

    /**
     * 车牌定位
     * @param imgPath
     * @return
     */
    void plateLocate(String imgPath);

    /**
     * 车牌识别
     * @param imgPath
     * @return
     */
    String plateRecognize(String imgPath);

}
