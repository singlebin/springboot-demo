package springboot.demo.util;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;
import java.util.function.Function;

/**
 * @description:
 * @Author: wub
 * @Date: 2019/1/23 9:55
 */

public class ExcelUtiles {

    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass,
                                   String fileName, boolean isCreateHeader, HttpServletResponse response) {
        ExportParams exportParams = new ExportParams(title, sheetName);
        exportParams.setCreateHeadRows(isCreateHeader);
        defaultExport(list, pojoClass, fileName, response, exportParams);
    }

    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName,
                                   HttpServletResponse response) {
        defaultExport(list, pojoClass, fileName, response, new ExportParams(title, sheetName));
    }

    public static void exportExcel(List<Map<String, Object>> list, String fileName, HttpServletResponse response) {
        defaultExport(list, fileName, response);
    }

    private static void defaultExport(List<?> list, Class<?> pojoClass, String fileName,
                                      HttpServletResponse response, ExportParams exportParams) {
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, pojoClass, list);
        if (workbook != null) ;
        downLoadExcel(fileName, response, workbook);
    }

    private static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xlsx");
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static void defaultExport(List<Map<String, Object>> list, String fileName, HttpServletResponse response) {
        Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.HSSF);
        if (workbook != null) ;
        downLoadExcel(fileName, response, workbook);
    }

    public static <T> List<T> importExcel(String filePath, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
        if (StringUtils.isBlank(filePath)) {
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(new File(filePath), pojoClass, params);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("模板不能为空");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return list;
    }

    public static <T> List<T> importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
        if (file == null) {
            return null;
        }
        ImportParams params = new ImportParams();
        params.setNeedVerfiy(true);
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("excel文件不能为空");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage());

        }
        return list;
    }

    public static void downloadExcelTemplate(HttpServletResponse response, String path, String fileName) {
        try {
            InputStream inStream = new FileInputStream(path);
            // 设置输出的格式
            response.reset();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("bin");
            response.addHeader("Content-Disposition",
                    "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            // 循环取出流中的数据
            byte[] b = new byte[1000000];
            int len;
            while ((len = inStream.read(b)) > 0) {
                response.getOutputStream().write(b, 0, len);
            }
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取 指定  curCol 列的数据
     * <p>
     * stream 为null返回空集合
     *
     * @param is            stream
     * @param curCol        第几列 数据
     * @param skipFirstLine 是否跳过第一行
     * @return list
     * @throws IOException            e
     * @throws InvalidFormatException e
     */
    public static List<String> getColumnForData(InputStream is, int curCol, boolean skipFirstLine) throws IOException, InvalidFormatException {
        if (is == null) {
            return Collections.emptyList();
        }
        Workbook workbook = WorkbookFactory.create(is);
        List<String> list = new ArrayList<>();
        Iterator<Row> rowIterator = workbook.getSheetAt(curCol).rowIterator();
        // 判断是否跳过
        if (skipFirstLine) {
            rowIterator.next();
        }
        rowIterator.forEachRemaining(s -> {
            Cell cell = s.getCell(0);
            // 判断是否为正常数据
            if (org.springframework.util.StringUtils.hasText(cell.toString())) {
                list.add(cell.toString());
            }
        });
        workbook.close();
        return list;
    }

    /**
     * 将list数据转换成指定的excel
     * 如果生成的数据总条数大于 sheetMaxNum (单个sheet页最大数量) 或者大于一百万行
     * 则自动进行分为多个sheet页进行保存
     * <p>
     * 如果数据总条数为100000条, 分为十个sheet页进行保存, 将进行异步操作(速度会快)
     *
     * @param sheetName   sheetName
     * @param objects     data
     * @param os          os
     * @param sheetMaxNum 每个sheet最大行数 小于等于0/null 则为默认值
     *                    默认值: 一百万行
     * @param sp          sp
     * @param <T>         T
     * @throws IOException e
     */
    public static <T> void createExcel(String sheetName, List<T> objects, OutputStream os, Integer sheetMaxNum, Function<T, List<TitleAndVal>> sp) throws IOException {

        @AllArgsConstructor
        final class Attr {
            private Sheet sheet;
            private List<T> ls;
        }
        // 最大sheet页数量16384
        final int SHEET_MAX = 16384;
        // 每个sheet最大行数 1048756
        int max = 1000000;
        if (sheetMaxNum != null && sheetMaxNum > 0) {
            max = sheetMaxNum;
        }
        Workbook workbook = new SXSSFWorkbook(2500);
        List<List<T>> lists = ListUtil.splitList(objects, max);
        // 构建sheet页
        if (lists.size() > SHEET_MAX)
            throw new RuntimeException("超出最大Sheet页数量");
        String sn = sheetName;
        List<Attr> attrList = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            workbook.createSheet(sn);
            attrList.add(new Attr(workbook.getSheet(sn), lists.get(i)));
            // 当多个sheet时将传进来的 sheetName 加 i
            sn = sheetName + (i + 1);
        }
        // 多个sheet时异步执行
        attrList.parallelStream().forEach(ls -> new ExcelUtiles().cre(ls.sheet, ls.ls, sp));
        // 写出数据
        workbook.write(os);
        workbook.close();
        System.out.println("Excel创建完成");
    }

    /**
     * 下载文件时设置 response 响应头和下载文件名称
     * 适用于 .xlsx 文件
     *
     * @param response response
     * @param fileName fileName
     * @return response
     */
    public static HttpServletResponse downloadSetHead(HttpServletResponse response, String fileName) {
        //强制浏览器下载文件
        response.setContentType("application/force-download");
        //设置为下载类型 并指定下载的文件名称 / 处理下载文件中文名称乱码  new String(fileName.getBytes("gbk"), "iso8859-1")
        String fn = null;
        try {
            fn = new String(fileName.getBytes("gbk"), "iso8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.addHeader("Content-Disposition", "attachment;fileName=" + fn + ".xlsx");

        return response;
    }

    private <T> void cre(Sheet sheet, List<T> ls, Function<T, List<TitleAndVal>> sp) {
        Iterator<T> iterator = ls.iterator();
        int iRow = 0;
        while (iterator.hasNext()) {
            List<TitleAndVal> apply = sp.apply(iterator.next());
            // 初始化表头
            if (iRow == 0) {
                sheet.createRow(iRow);
                // 冻结第一行
                sheet.createFreezePane(1, 1, 1, 1);
                for (int i = 0; i < apply.size(); i++) {
                    sheet.getRow(0).createCell(i).setCellValue(apply.get(i).k);
                }
                iRow++;
            }
            // 填充数据
            Row row = sheet.createRow(iRow);
            for (int i = 0; i < apply.size(); i++) {
                row.createCell(i)
                        //如果对象为null转为空字符
                        .setCellValue(apply.get(i).v == null ? "" : apply.get(i).v + "");
            }
            iRow++;
        }
    }

    @Data
    @AllArgsConstructor
    public final static class TitleAndVal {
        // 表头名称
        private String k;
        // 对应表头的值
        private Object v;
    }

}
