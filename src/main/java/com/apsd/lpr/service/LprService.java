package com.apsd.lpr.service;


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

}
