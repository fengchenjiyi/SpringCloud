package com.weather.springcloud.api.model.entities.city;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Auther: F~cjy
 * @Date: 2019/8/31 13:52
 * 城市信息
 */
@AllArgsConstructor        //添加全参构造函数
@NoArgsConstructor         //添加无参构造函数
@Data                      //添加set、get、equls、canEqual、hashCode、toString函数
@Accessors(chain = true)   //添加链式调用
public class City implements Serializable{

	private String cityId;

	private String cityName;

	private String cityCode;

	private String province;

	//@JsonIgnore  生成json 时不生成字段内容
	private String weatherData;
}
