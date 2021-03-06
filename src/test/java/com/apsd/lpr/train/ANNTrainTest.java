package com.apsd.lpr.train;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author: Perye
 * @create: 2018-10-11 21:45
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class ANNTrainTest {

    @Autowired
    private ANNTrain annTrain;

    @Test
    public void annTrain() {
        annTrain.annMain();
    }

}