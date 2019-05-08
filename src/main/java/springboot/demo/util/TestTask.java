package springboot.demo.util;

import springboot.demo.bean.ResultBean;
import springboot.demo.service.ITask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @Author: wub
 * @Date: 2019/3/11 9:31
 */
public class TestTask implements ITask<ResultBean<String>, Integer> {
    @Override
    public ResultBean<String> execute(Integer e, Map<String, Object> params) {
        /**
         * 具体业务逻辑：将list中的元素加上辅助参数中的数据返回
         */
        int addNum = Integer.valueOf(String.valueOf(params.get("addNum")));
        e = e + addNum;
        ResultBean<String> resultBean = ResultBean.newInstance();
        resultBean.setData(e.toString());
        return resultBean;
    }
    public static void main(String[] args) {
        // 需要多线程处理的大量数据list
        List<Integer> data = new ArrayList<>(10000);
        for(int i = 0; i < 10000; i ++){
            data.add(i + 1);
        }

        // 创建多线程处理任务
        MultiThreadUtils<Integer> threadUtils = MultiThreadUtils.newInstance(5);
        ITask<ResultBean<String>, Integer> task = new TestTask();
        // 辅助参数  加数
        Map<String, Object> params = new HashMap<>();
        params.put("addNum", 4);
        // 执行多线程处理，并返回处理结果
        ResultBean<List<ResultBean<String>>> resultBean = threadUtils.execute(data, params, task);
    }

}
