package com.gogoo.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created by 290879584 on 2019/6/20.
 */
@AllArgsConstructor        //添加全参构造函数
@NoArgsConstructor         //添加无参构造函数
@Data                      //添加set、get、equls、canEqual、hashCode、toString函数
@Accessors(chain = true)   //添加链式调用
public class Dept implements Serializable {

    private Long 	deptno; // 主键
    private String 	dname; // 部门名称
    private String 	db_source;// 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库

}
