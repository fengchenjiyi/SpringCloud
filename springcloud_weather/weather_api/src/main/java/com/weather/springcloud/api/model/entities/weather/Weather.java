package com.weather.springcloud.api.model.entities.weather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 天气信息.
 */
@AllArgsConstructor        //添加全参构造函数
@NoArgsConstructor         //添加无参构造函数
@Data                      //添加set、get、equls、canEqual、hashCode、toString函数
@Accessors(chain = true)   //添加链式调用
public class Weather implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String city;
	private String aqi;
	private String ganmao;
	private String wendu;
	private Yeaterday yesterday;
	private List<Forecast> forecast;

}
