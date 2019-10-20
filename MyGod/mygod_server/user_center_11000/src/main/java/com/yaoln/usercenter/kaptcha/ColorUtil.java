package com.yaoln.usercenter.kaptcha;

import java.awt.*;
import java.util.Random;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/16 12:18
 */
public class ColorUtil {

    private ColorUtil(){}

    /**
     * 颜色随机生成
     * @return
     */
    public static Color getRandomColor(){
        Random random = new Random();
        int red = random.nextInt(255);
        int green = random.nextInt(255);
        int blue = random.nextInt(255);
        return new Color(red, green, blue);
    }
}
