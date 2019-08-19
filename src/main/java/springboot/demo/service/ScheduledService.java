package springboot.demo.service;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @description: /**
 *      * second(秒), minute（分）, hour（时）, day of month（日）, month（月）, day of week（周几）.
 *      * 0 * * * * MON-FRI
 *      *  【0 0/5 14,18 * * ?】 每天14点整，和18点整，每隔5分钟执行一次
 *      *  【0 15 10 ? * 1-6】 每个月的周一至周六10:15分执行一次
 *      *  【0 0 2 ? * 6L】每个月的最后一个周六凌晨2点执行一次
 *      *  【0 0 2 LW * ?】每个月的最后一个工作日凌晨2点执行一次
 *      *  【0 0 2-4 ? * 1#1】每个月的第一个周一凌晨2点到4点期间，每个整点都执行一次；
 * @Author: wub
 * @Date: 2019/3/9 13:46
 */
@Service
//@EnableScheduling
public class ScheduledService {
    @Scheduled(cron = "0/4 * * * * MON-SAT")  //每4秒执行一次
    public  void hello(){
        System.out.println("hello ... ");
    }

    //@Scheduled(cron = "0 */5 * * * ?") //每隔5分钟执行一次
    //@Scheduled(cron = "0 0 1 * * ?") //每天凌晨1点执行
//    public void  execute(){
//        LogUtil.info("-------定时任务同步商品信息(价格等)，开始时间：" + DateUtils.formatDateTime(new Date()));
//        productEsFeignclient.productSync();
//        //LogUtil.info("同步商品信息(价格等)结果："+result.getData());
//        LogUtil.info("-------同步商品信息(价格等)，结束时间：" + DateUtils.formatDateTime(new Date()));
//    }
}
