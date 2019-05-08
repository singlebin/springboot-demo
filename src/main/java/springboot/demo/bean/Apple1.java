package springboot.demo.bean;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @description:
 * @Author: wub
 * @Date: 2019/4/25 14:58
 */
@Data
@Builder
public class Apple1 {

    private Integer id;
    private String name;
    private BigDecimal money;
    private Integer num;

    public Apple1(Integer id, String name, BigDecimal money, Integer num) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.num = num;
    }

    public Apple1() {
    }
}
