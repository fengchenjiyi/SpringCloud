package com.yaoln.usercenter.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yaoln.api.beans.PageInfo;
import com.yaoln.api.utils.JacksonUtils;
import com.yaoln.api.entitys.usercenter.AppType;
import com.yaoln.usercenter.service.impl.AppTypeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/17 15:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Autowired
    private AppTypeServiceImpl appTypeService;

    @Test
    public void saveTest() throws Exception{
        AppType appType = new AppType();
        appType.setAppName("碰碰");
        appType.setTabIndex(1);
        appType.setDescription("一款交友应用");
        appTypeService.saveAppType(appType);
    }

    @Test
    public void selectPageList() throws Exception{
        PageInfo<AppType> appTypePageInfo = appTypeService.selectPageList(1, 200);
        System.out.println(appTypePageInfo);
    }

    @Test
    public void createJson() throws JsonProcessingException {
        AppType appType = new AppType();
        appType.setAppName("碰碰");
        appType.setTabIndex(1);
        appType.setDescription("一款交友应用");
        System.out.println(JacksonUtils.getJackson().writeValueAsString(appType));
    }
}
