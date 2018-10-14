package com.apsd.lpr.service;

import com.apsd.lpr.core.*;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.springframework.stereotype.Service;

import java.util.Vector;
import static com.apsd.lpr.core.CoreFunc.getPlateType;
import static com.apsd.lpr.core.CoreFunc.showImage;
import static org.bytedeco.javacpp.opencv_highgui.imread;

/**
 * @author Perye
 */
@Service
public class LprServiceImpl implements LprService{


    /**
     * 字符标识
     * @param imgPath
     * @return
     */
    @Override
    public String charsIndetify(String imgPath) {
        Mat src = imread(imgPath);
        CharsIdentify charsIdentify = new CharsIdentify();
        String result = charsIdentify.charsIdentify(src, false, true);
        return result;
    }

    /**
     * 字符识别
     * @param imgPath
     * @return
     */
    @Override
    public String charsRecognize(String imgPath) {
        Mat src = imread(imgPath);
        CharsRecognize charsRecognize = new CharsRecognize();
        charsRecognize.setCRDebug(true);
        String result = charsRecognize.charsRecognize(src);
        return result;
    }

    /**
     * 颜色检测
     * @param imgPath
     * @return
     */
    @Override
    public String colorDetect(String imgPath) {
        Mat src = imread(imgPath);
        CoreFunc.Color color = getPlateType(src, true);
        return color.toString();
    }

    /**
     * 车牌检测
     * @param imgPath
     */
    @Override
    public void plateDetect(String imgPath) {
        Mat src = imread(imgPath);
        PlateDetect plateDetect = new PlateDetect();
        plateDetect.setPDLifemode(true);
        Vector<Mat> matVector = new Vector<Mat>();
        if (plateDetect.plateDetect(src, matVector) == 0) {
            for (int i = 0; i<matVector.size(); ++i) {
                showImage("Plate Detected", matVector.get(i));
            }
        }
    }

    /**
     * 车牌定位
     * @param imgPath
     */
    @Override
    public void plateLocate(String imgPath) {
        Mat src = imread(imgPath);
        PlateLocate plateLocate = new PlateLocate();
        plateLocate.setDebug(true);
        plateLocate.setLifemode(true);
        Vector<Mat> resultVec = plateLocate.plateLocate(src);
        int num = resultVec.size();
        for (int j=0;j<num;j++) {
            showImage("Plate Located" + j, resultVec.get(j));
        }
    }

    /**
     * 车牌识别
     * @param imgPath
     * @return
     */
    @Override
    public String plateRecognize(String imgPath) {
        Mat src = imread(imgPath);
        PlateDetect plateDetect = new PlateDetect();
        plateDetect.setPDLifemode(true);
        Vector<Mat> matVector = new Vector<>();
        String result = "";
        if (plateDetect.plateDetect(src, matVector) == 0) {
            CharsRecognize charsRecognize = new CharsRecognize();
            for (int i=0;i<matVector.size();++i) {
                result = charsRecognize.charsRecognize(matVector.get(i));
            }
        }
        return result;
    }

}
