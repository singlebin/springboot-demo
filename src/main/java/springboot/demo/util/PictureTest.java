package springboot.demo.util;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

/**
 * @description:
 * @Author: wub
 * @date 2020/5/20 16:20
 */
public class PictureTest {

    public static void main(String[] args) throws TesseractException {
        //加载待读取图片
        File imageFile = new File("E://a.png");
        //创建tess对象
        ITesseract instance = new Tesseract();
        //设置训练文件目录
        instance.setDatapath("E://jar//Tess4J//tessdata");
        //设置训练语言
        instance.setLanguage("chi_sim");
        //执行转换
        String result = instance.doOCR(imageFile);

        System.out.println(result);
    }
}
