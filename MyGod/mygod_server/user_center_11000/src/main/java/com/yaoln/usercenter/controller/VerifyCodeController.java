package com.yaoln.usercenter.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.yaoln.api.beans.ResponseMsgBody;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.TimeUnit;


/**
 * @Auther: F~cjy
 * @Date: 2019/10/19 00:54
 * 验证码处理控制器
 */
@RestController
@CrossOrigin
@RequestMapping("/usercenter/verify")
public class VerifyCodeController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;
    @Autowired
    private StringRedisTemplate stringRedisTemplate; //操作k-v都是字符串的
    @Value("${verify_code_time_out}")
    protected int verifyCodeTimeOut;

    /**
     * 获取动态验证码
     * @param codeKey
     * @return
     * @throws Exception
     */
    @GetMapping("/img")
    public byte[] getImg(@RequestParam(value="code_key") String codeKey) throws Exception{
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
            ops.set(codeKey, createText, verifyCodeTimeOut, TimeUnit.SECONDS);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            //httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }

        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        return captchaChallengeAsJpeg;
    }

    /**
     * 验证码验证
     * @param codeKey
     * @param code 验证码
     * @return
     */
    @PostMapping("/code")
    public ResponseMsgBody verifyCode(@RequestParam(value="code_key") String codeKey,
                                      @RequestParam(value="code") String code){
        if(stringRedisTemplate.hasKey(codeKey)){
            ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
            if(StringUtils.isNotBlank(code)
                    && code.trim().toUpperCase().equals(ops.get(codeKey).toUpperCase())){
                stringRedisTemplate.delete(codeKey);
                return ResponseMsgBody.success();
            }
        }
        return ResponseMsgBody.fail().addErr("验证码错误");
    }
}
