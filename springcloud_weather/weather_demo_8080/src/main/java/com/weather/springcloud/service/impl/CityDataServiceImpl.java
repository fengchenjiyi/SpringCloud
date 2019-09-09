package com.weather.springcloud.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import com.weather.springcloud.api.utils.XmlBuilderUtils;
import com.weather.springcloud.model.bean.City;
import com.weather.springcloud.model.bean.CityList;
import com.weather.springcloud.service.CityDataService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;


/**
 * @Auther: F~cjy
 * @Date: 2019/8/31 14:26
 */
@Service
public class CityDataServiceImpl implements CityDataService {

	@Override
	public List<City> listCity() throws Exception {
		// 读取XML文件
		Resource resource = new ClassPathResource("citylist.xml");
		BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		
		while ((line = br.readLine()) !=null) {
			buffer.append(line);
		}
		
		br.close();
		
		// XML转为Java对象
		CityList cityList = (CityList) XmlBuilderUtils.xmlStrToOject(CityList.class, buffer.toString());
		return cityList.getCityList();
	}

}
