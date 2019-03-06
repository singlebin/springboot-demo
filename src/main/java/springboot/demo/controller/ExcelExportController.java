package springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import springboot.demo.bean.User;
import springboot.demo.service.UserService;
import springboot.demo.util.ExcelUtiles;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @description:
 * @Author: wub
 * @Date: 2019/1/23 9:58
 */
@RestController
@RequestMapping("/Excel")
public class ExcelExportController {

  @Autowired
  private UserService userService;

  @GetMapping("/export")
    public void export(HttpServletRequest request, HttpServletResponse response){
    List<User> userAll = userService.findUserAll();
    long t1 = System.currentTimeMillis();
    ExcelUtiles.exportExcel(userAll, "用户导出", "用户导出", User.class, "用户导出", response);
    long t2 = System.currentTimeMillis();
    System.out.println("查询出："+userAll.size()+"条记录耗时："+(t2-t1));
}

  @GetMapping("/importExcel")
  public void importExcel(@RequestParam("file")MultipartFile file,  HttpServletRequest request){
    /*String filePath = "D:\\用户导出.xlsx";
    List<User> users = ExcelUtiles.importExcel(filePath, 1, 1, User.class);
    System.out.println("导入数据一共【"+users.size()+"】行");*/

    List<User> users = ExcelUtiles.importExcel(file, 0, 1, User.class);
    System.out.println("导入数据一共【"+users.size()+"】行");

  }

  /**
   *
   * @param response
   */
  @GetMapping("/importTemplate")
  public void importTemplate(HttpServletResponse response){
    String path = getClass().getResource("/static/" + "a.xls").getPath();
    ExcelUtiles.downloadExcelTemplate(response,  path, "a");
  }

}
