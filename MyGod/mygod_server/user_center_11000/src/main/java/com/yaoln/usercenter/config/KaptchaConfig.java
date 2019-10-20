package com.yaoln.usercenter.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class KaptchaConfig {
    @Bean
	public DefaultKaptcha defaultKaptcha(){
		DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
		Properties properties = new Properties();
		//图片边框
		properties.setProperty("kaptcha.border", "no");
		//图片宽度
		properties.setProperty("kaptcha.image.width", "130");
		//图片高度
		properties.setProperty("kaptcha.image.height", "45");
		//验证码背景颜色渐变，开始颜色
		properties.setProperty("kaptcha.background.clear.from", "248,248,248");
		//验证码背景颜色渐变，结束颜色
		properties.setProperty("kaptcha.background.clear.to", "248,248,248");
		//文字渲染器
		properties.setProperty("kaptcha.word.impl", "com.yaoln.usercenter.kaptcha.MyWordRenderer");
		//验证码的字符
		properties.setProperty("kaptcha.textproducer.char.string", "23456789ABCDEFGHJKLMNPQRSTUVWXYZ");
		//验证码字体颜色
		properties.setProperty("kaptcha.textproducer.font.color", "0,0,255");
		//验证码的效果，阴影:ShadowGimpy  水纹:WaterRipple
		properties.setProperty("kaptcha.obscurificator.impl", "com.google.code.kaptcha.impl.WaterRipple");
		//验证码字体大小
		properties.setProperty("kaptcha.textproducer.font.size", "32");
		//验证码字数
		properties.setProperty("kaptcha.textproducer.char.length", "4");
		//验证码文字间距
		properties.setProperty("kaptcha.textproducer.char.space", "8");
		//验证码字体
		properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
		//验证码噪点生成对象
		properties.setProperty("kaptcha.noise.impl", "com.yaoln.usercenter.kaptcha.MyNoise");
		Config config = new Config(properties);
		defaultKaptcha.setConfig(config);
		
		return defaultKaptcha;
	}
}
