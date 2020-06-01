package springboot.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @description:
 * @Author: wub
 * @date 2019/12/31 16:13
 */
@Data
@AllArgsConstructor
@Builder
public class StoreInfo {
    /**
     * 分公司编码
     */
    private String companyCode;
    /**
     * 门店编码
     */
    private String storeCode;
    /**
     * 市区编码
     */
//    private String regionCode;

}
