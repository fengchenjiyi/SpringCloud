package com.yaoln.usercenter.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yaoln.api.entitys.usercenter.AppUser;

import java.util.Random;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/17 23:28
 */
@TableName("tab_two_user")
public class TwoUser extends AppUser{

    public static void main(String[] args) {


        for(int i=0; i<100; i++){
            //创建Random类对象
            Random random = new Random();
            //产生10-99随机数
            int number = random.nextInt(99 - 10 + 1) + 10;
            System.out.println(System.currentTimeMillis()+new Random().nextInt(99999));
        }

    }
}
