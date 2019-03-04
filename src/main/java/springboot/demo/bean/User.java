package springboot.demo.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @description: User
 * @Author: wub
 * @Date: 2019/1/5 17:23
 */
@Data
public class User {
    @Excel(name = "id" ,orderNum = "0")
    private Integer id;

    @Excel(name = "姓名" ,orderNum = "1")
    private String name;

    @Excel(name = "性别" ,orderNum = "2")
    private String sex;

    @Excel(name = "年龄" ,orderNum = "3")
    private Integer age;

}
