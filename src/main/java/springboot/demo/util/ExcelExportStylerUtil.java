package springboot.demo.util;

import cn.afterturn.easypoi.excel.export.styler.AbstractExcelExportStyler;
import cn.afterturn.easypoi.excel.export.styler.IExcelExportStyler;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @description: easyPoi 样式修改
 * @Author: wub
 * @Date: 2019/1/23 17:54
 */
public class ExcelExportStylerUtil extends AbstractExcelExportStyler implements IExcelExportStyler {

    public ExcelExportStylerUtil(Workbook workbook) {
        super.createStyles(workbook);
    }


    @Override
    public CellStyle getHeaderStyle(short i) {
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER_SELECTION);
        return style;
    }

    @Override
    public CellStyle getTitleStyle(short i) {
        CellStyle titleStyle = this.workbook.createCellStyle();
        titleStyle.setAlignment(HorizontalAlignment.CENTER);
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        titleStyle.setWrapText(false);
        return titleStyle;
    }
}
