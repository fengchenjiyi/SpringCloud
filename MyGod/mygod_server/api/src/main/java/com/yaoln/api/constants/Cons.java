package com.yaoln.api.constants;

/**
 * Created by 29087 on 2018/10/30.
 */
public interface Cons {

    /**
     * 常用正则表达式
     */
    interface Regexp{
        /** 用户名规则 */
        String LOGIN_NAME_REG = "^[a-zA-Z][a-zA-Z0-9]{3,17}$";
        /** 纯数字正则 */
        String NUMBER_REG = "^[0-9]{4,18}$";
        /**1-99整数*/
        String AGE_REG = "^([1-9][0-9]{0,1}|100)$";
        /** 非零的正整数 */
        String INTEGER_REG  = "^[1-9]\\d*$";
        /** 大于0最多两位小数点 */
        String FLOAT_RFG = "^(([1-9]+\\.[0-9]{1,2})|([1-9]*[1-9][0-9]*\\.[0-9]{1,2})|([0-9]*[1-9][0-9]*))$";
        /** 手机号码 */
        String PHONE_NUMBER_REG = "^1(?:3\\d|4[4-9]|5[0-35-9]|6[67]|7[013-8]|8\\d|9\\d)\\d{8}$";
        /** 座机号码 */
        String TEL_NUMBER_REG = "^0\\d{2,3}-?\\d{7,8}$";
        /** 视频格式正则 */
        String VIDEO_REG = "\\.(swf|flv|mp4|rmvb|avi|mpeg|ra|ram|mov|wmv)";
        /** 音频格式正则 */
        String AUDIO_REG = "\\.(mp3|wav|wma|ogg|ape|acc)";
        /** 图片格式正则 */
        String IMG_REG = "\\.(gif|jpg|jpeg|bmp|png)";


        /** 简单日期格式 */
        String SIMPLE_DATE_REG = "yyyy-MM-dd";
        /** 标准日期格式 */
        String STANDART_DATE_REG = "yyyy-MM-dd HH:mm:ss";

    }

    /**
     * 加密key
     */
    interface EncryptKey{
        String MOBILE_RSA_PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJ1MvuU6ZUv3N0UYGkKDRFt+Amfj82XSN+UyUK47cRo4wHLJ9qIiREaH55WIc5WWjPTLhnS29MMTjH/ckU30uEGP8R+zx2DEpSYkmQpP7UvpPkr2ItFqwirMIks01zihQD5cAOCCZyd1JbJ5qV/IG3fgTRyIr52e7AATJBuVvquRAgMBAAECgYBqj2wew/GNhdsWXp6jgmOTi4i7sovX5ZJiHTTU44XaWqnc2X7QFWClWzoCbd7Hbqbsyte6R5sGcD7U+6of4nHTPd8hYdrlTTCIX6BZXD9o+I4PhI11XJftDIs9I7bxYtEPXHTFU3UD1kTKChh1qZi7F8UxEgi4LT7LylJ59y+uAQJBAOZwXdlAaKFiqU3n0Yerq3byrZZ0ZSCVlkRZGfmYW4neYKaU2FCI1oVfrPpIH/5I6m6Z4srfQjOM6+bqiWWnb/ECQQCuv33WDRPfWM4hBQV7q+4ptH6zNcLMkAOLImb+zeMDuol2UQHeNgj0wHp56pym5/hFU/DVOE1oadx+e7rx6pWhAkB45XTnONpr6QYoADo2coNHqXQW3kP7/17RxulQwHUt9MRCQQ7n2ZKqcJKg0FwwnXKYyhVpGA50Wzecc2nYMisRAkBWkfEyIKpupF0ByK4NtYA4Uv3NpF2L3/CRdgqWQsMrLrc40SreveAz+EL0sQDIQvUgy1PtHYZjqsYcNwnHHRLhAkEArM6X2BjJb2ShP+f/f4r43GQ7zaTAKVCIXMjj2a6jk6mKjOaXEDzqkXpQqlhyLBG14OeqBf4bdjcsn5umzyaxTA==";
        String MOBILE_RSA_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCdTL7lOmVL9zdFGBpCg0RbfgJn4/Nl0jflMlCuO3EaOMByyfaiIkRGh+eViHOVloz0y4Z0tvTDE4x/3JFN9LhBj/Efs8dgxKUmJJkKT+1L6T5K9iLRasIqzCJLNNc4oUA+XADggmcndSWyealfyBt34E0ciK+dnuwAEyQblb6rkQIDAQAB";
    }
}
