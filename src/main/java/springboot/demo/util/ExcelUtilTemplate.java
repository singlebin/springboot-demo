/*
package springboot.demo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


*/
/**
 * poi根据模板导出excel
 *//*

public class ExcelUtilTemplate {
	
	private static final Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

	//模板map
    private Map<String,Workbook> tempWorkbook = new HashMap<String, Workbook>();
    //模板输入流map
    private Map<String,FileInputStream> tempStream = new HashMap<String, FileInputStream>();
    
    private String rootPath= ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
    private String tempFilePath;
    
    private HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    
    public ExcelUtilTemplate(HttpServletRequest request,HttpServletResponse response){
    	rootPath=request.getSession().getServletContext().getRealPath("/");
    	logger.info("rootPath:"+rootPath);
    	tempFilePath=rootPath+ File.separator+ "template"+ File.separator+ "crm_month_usrfee_template.xls";//模板默认路径
    	logger.info("tempFilePath:"+tempFilePath);
    }
    
   
    
   */
/**
    * 按模板向Excel中相应地方填充数据
    * @param dataMap  填充的数据集
    * @param sheetNo  sheet位置,从0开始
    * @throws IOException
    *//*

    public void writeData(Map<String,Object> dataMap,int sheetNo) throws IOException{
    	
    	
        Workbook wbModule = getTempWorkbook();//读取模板
        Sheet wsheet = wbModule.getSheetAt(sheetNo);//数据填充的sheet
        Iterator<Entry<String, Object>> it = dataMap.entrySet().iterator();
        while(it.hasNext()){
        	Entry<String, Object> entry = (Entry<String, Object>) it.next();
        	String point = entry.getKey();//位置信息 例如：B1
        	Object data = entry.getValue();//填充的数据
        	TempCell cell = getCell(point, data,wsheet);
        	setCell(cell,wsheet);//指定坐标赋值
        }
        wsheet.setForceFormulaRecalculation(true);//设置生成excel中公式自动计算
    }
    
    */
/**
     * 按模板向Excel中列表填充数据。    只支持列合并
     * @param heads  头文件位置 B1，B2
     * @param datalist
     * @param sheetNo
     * @throws FileNotFoundException
     * @throws IOException
     *//*

    public void writeDateList(String[] heads,List<Map<Integer, Object>> datalist,int sheetNo) throws FileNotFoundException, IOException {
    	
        Workbook wbModule = getTempWorkbook();//读取模板
        Sheet wsheet = wbModule.getSheetAt(sheetNo);//数据填充的sheet
        List<TempCell> tempCells = new ArrayList<TempCell>();//列表数据模板cell
        for(int i=0;i<heads.length;i++){
        	String point = heads[i];
        	TempCell tempCell = getCell(point,null,wsheet);
        	//取得合并单元格位置  -1：表示不是合并单元格
        	int pos = isMergedRegion(wsheet, tempCell.getRow(), tempCell.getColumn());
        	if(pos>-1){
        		CellRangeAddress range = wsheet.getMergedRegion(pos);
        		tempCell.setColumnSize(range.getLastColumn()-range.getFirstColumn());
        	}
        	tempCells.add(tempCell);
        }
        //赋值
        for(int i=0;i<datalist.size();i++){
        	Map<Integer, Object> dataMap = datalist.get(i);
        	for(int j=0;j<tempCells.size();j++){
        		TempCell tempCell = tempCells.get(j);
        		tempCell.setRow(tempCell.getRow()+1);
        		tempCell.setData(dataMap.get(j+1));
        		setCell(tempCell, wsheet);
        	}
        }

		
	}
    
    */
/**
     * 写到输出流并移除资源
     * @param request
     * @param response
     * @param outputFileName
     * @throws FileNotFoundException
     * @throws IOException
     *//*

    public void writeAndClose(HttpServletRequest request,HttpServletResponse response,String outputFileName) throws FileNotFoundException, IOException{
    	prepareExcelExport(response,getEncodedFileName(request,outputFileName));
    	if(getTempWorkbook()!=null){
    		OutputStream os=response.getOutputStream();
            getTempWorkbook().write(os);
            os.flush();
            os.close();
            tempWorkbook.remove(tempFilePath);
        }
        if(getFileInputStream()!=null){
            getFileInputStream().close();
            tempStream.remove(tempFilePath);
        }
    }
    
    
    public void writeAndClose(String outputFileName) throws FileNotFoundException, IOException{
    	File tempFile = new File("\\"+outputFileName);
    	if(getTempWorkbook()!=null){
    		OutputStream os = new FileOutputStream(tempFile);//输出到临时文件
            getTempWorkbook().write(os);
            os.flush();
            os.close();
            tempWorkbook.remove(tempFilePath);
        }
        if(getFileInputStream()!=null){
            getFileInputStream().close();
            tempStream.remove(tempFilePath);
        }
    }
    
    

	*/
/**
	 * 获取输入工作区
	 * @return Workbook
	 * @throws FileNotFoundException
	 * @throws IOException
	 *//*

    private Workbook getTempWorkbook() throws FileNotFoundException, IOException {
        if(!tempWorkbook.containsKey(tempFilePath)){
            if(tempFilePath.endsWith(".xlsx")){
                tempWorkbook.put(tempFilePath, new XSSFWorkbook(getFileInputStream()));
            }else if(tempFilePath.endsWith(".xls")){
                tempWorkbook.put(tempFilePath, new HSSFWorkbook(getFileInputStream()));
            }
        }
        return tempWorkbook.get(tempFilePath);
    }
    
    
    
    
    */
/**
     * 
     * <p class="detail">
     * 功能：获得模板输入流
     * </p>
     * @date 2015年9月26日
     * @author <a href="mailto:1435290472@qq.com">zq</a>
     * @param tempFilePath
     * @return
     * @throws FileNotFoundException
     *//*

    private FileInputStream getFileInputStream() throws FileNotFoundException {
        if(!tempStream.containsKey(tempFilePath)){
            tempStream.put(tempFilePath, new FileInputStream(tempFilePath));
        }
        return tempStream.get(tempFilePath);
    }
    
    */
/**
     * 
     * <p class="detail">
     * 功能：设置单元格数据,样式  (根据坐标：B3)
     * </p>
     * @param point
     * @param data
     * @param sheet
     * @return
     *//*

    private TempCell getCell(String point,Object data,Sheet sheet){
    	TempCell tempCell = new TempCell();

    	//得到列 字母 
    	String lineStr = "";
    	String reg = "[A-Z]+";
    	Pattern p = Pattern.compile(reg);
    	Matcher m = p.matcher(point);    	
    	while(m.find()){
    		lineStr = m.group();
    	}
    	//将列字母转成列号  根据ascii转换
    	char[] ch = lineStr.toCharArray();
    	int column = 0;
    	for(int i=0;i<ch.length;i++){
    		char c = ch[i];
	    	int post = ch.length-i-1;
	    	int r = (int) Math.pow(10, post);
	    	column = column + r*((int)c-65);
    	}
    	tempCell.setColumn(column);
    	
    	//得到行号
    	reg = "[1-9]+";
    	p = Pattern.compile(reg);
    	m = p.matcher(point);    	
    	while(m.find()){
    		tempCell.setRow((Integer.parseInt(m.group())-1));
    	}
    	
    	//获取模板指定单元格样式，设置到tempCell （写列表数据的时候用）
    	Row rowIn = sheet.getRow(tempCell.getRow());
        if(rowIn == null) {
            rowIn = sheet.createRow(tempCell.getRow());
        }
        Cell cellIn = rowIn.getCell(tempCell.getColumn());
        if(cellIn == null) {
            cellIn = rowIn.createCell(tempCell.getColumn());
        }
        tempCell.setCellStyle(cellIn.getCellStyle());
    	
        tempCell.setData(data);
    	return tempCell;
    }

    */
/**
     * 
     * <p class="detail">
     * 功能：给指定坐标赋值
     * </p>
     * @param tempCell
     * @param sheet
     *//*

    private void setCell(TempCell tempCell,Sheet sheet) {
    	if(tempCell.getColumnSize()>-1){
    		CellRangeAddress rangeAddress = mergeRegion(sheet, tempCell.getRow(), tempCell.getRow(), tempCell.getColumn(), tempCell.getColumn()+tempCell.getColumnSize());
    		setRegionStyle(tempCell.getCellStyle(), rangeAddress, sheet);
    	}
    	
    	Row rowIn = sheet.getRow(tempCell.getRow());
        if(rowIn == null) {
            rowIn = sheet.createRow(tempCell.getRow());
        }
        Cell cellIn = rowIn.getCell(tempCell.getColumn());
        if(cellIn == null) {
            cellIn = rowIn.createCell(tempCell.getColumn());
        }
        //根据data类型给cell赋值
        if(tempCell.getData() instanceof String){
        	cellIn.setCellValue((String)tempCell.getData());
        }else if(tempCell.getData() instanceof Integer){
        	cellIn.setCellValue((int)tempCell.getData());
        }else if(tempCell.getData() instanceof Double){
        	cellIn.setCellValue((double)tempCell.getData());
        	CellStyle cellStyle=tempCell.getCellStyle();
        	cellStyle.setAlignment(CellStyle.ALIGN_RIGHT);
        	tempCell.setCellStyle(cellStyle);
        }else if(tempCell.getData() instanceof Long){
        	cellIn.setCellValue((Long)tempCell.getData());
        }else if(tempCell.getData() instanceof BigDecimal){
        	cellIn.setCellValue(((BigDecimal)tempCell.getData()).toEngineeringString());
        }else{
        	cellIn.setCellValue((String)tempCell.getData());
        }
        //样式
        if(tempCell.getCellStyle()!=null && tempCell.getColumnSize()==-1){
            cellIn.setCellStyle(tempCell.getCellStyle());
        }
        
        
	}
    
   
    
    
    
    private String getEncodedFileName(HttpServletRequest request,String outputFileName) {
		if (outputFileName == null) {
			return null;
		}
		String encodedOutputFileName = outputFileName;
		String agent = request.getHeader("user-agent");
		if (logger.isDebugEnabled()) {
			logger.debug("::: user-agent for browser->" + agent);
		}
		try {
			if (agent.indexOf("Firefox") >= 0 || agent.indexOf("Gecko") >= 0) {
				encodedOutputFileName = new String(outputFileName.getBytes("UTF-8"),
						"ISO-8859-1"); // can display Chinese filename in
				// FireFox.
				// Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.8.1.12)
				// Gecko/20080201 Firefox/2.0.0.12
			} else if (agent.indexOf("MSIE") >= 0) {
				// Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)
				encodedOutputFileName = URLEncoder.encode(outputFileName, "UTF-8"); // can
			} else {
				return outputFileName;
			}
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
		}
		return encodedOutputFileName;
	}
	
	
	private void prepareExcelExport(HttpServletResponse response,String outputFileName) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/vnd.ms-excel");
		response.addHeader("Content-disposition", "attachment;filename="+ outputFileName);
	}
    
    
    */
/**
     * 
     * <p class="detail">
     * 功能：判断指定的单元格是否是合并单元格
     * </p>
     * @param sheet
     * @param row
     * @param column
     * @return  0:不是合并单元格，i:合并单元格的位置
     *//*

    private Integer isMergedRegion(Sheet sheet,int row ,int column) {  
    	int sheetMergeCount = sheet.getNumMergedRegions();  
    	for (int i = 0; i < sheetMergeCount; i++) {  
    		CellRangeAddress range = sheet.getMergedRegion(i);  
    		int firstColumn = range.getFirstColumn();  
    		int lastColumn = range.getLastColumn();  
    		int firstRow = range.getFirstRow();  
    		int lastRow = range.getLastRow();  
    		if(row >= firstRow && row <= lastRow){  
	    		if(column >= firstColumn && column <= lastColumn){  
	    			return i;  
	    		}  
    		}  
    	}  
    	return -1;  
	}
    
    */
/**
     * 
     * <p class="detail">
     * 功能：合并单元格
     * </p>
     * @param sheet
     * @param firstRow
     * @param lastRow
     * @param firstCol
     * @param lastCol
     *//*

    private CellRangeAddress mergeRegion(Sheet sheet, int firstRow, int lastRow, int firstCol, int lastCol) {
    	CellRangeAddress rang = new CellRangeAddress(firstRow, lastRow, firstCol, lastCol);
    	sheet.addMergedRegion(rang); 
    	return rang;
	}
    
    */
/**
     * 
     * <p class="detail">
     * 功能：设置合并单元格样式
     * </p>
     * @param cs
     * @param region
     * @param sheet
     *//*

    private static void setRegionStyle(CellStyle cs, CellRangeAddress region, Sheet sheet){  
    	for(int i=region.getFirstRow();i<=region.getLastRow();i++){  
    		Row row=sheet.getRow(i);  
    		if(row==null) row=sheet.createRow(i);  
    		for(int j=region.getFirstColumn();j<=region.getLastColumn();j++){  
    			Cell cell=row.getCell(j);  
    			if(cell==null){  
    				cell=row.createCell(j);  
    				cell.setCellValue("");  
    			}  
    			cell.setCellStyle(cs);  
    		}  
    	}  
    } 

    */
/**
     * 临时单元格数据
     * @author guiui
     *
     *//*

    class TempCell{
    	private int row;
    	private int column;
    	private CellStyle cellStyle;
    	private Object data;
    	//用于列表合并，表示几列合并
    	private int columnSize = -1;

    	public int getColumn() {
    		return column;
    	}
    	public void setColumn(int column) {
    		this.column = column;
    	}
    	public int getRow() {
    		return row;
    	}
    	public void setRow(int row) {
    		this.row = row;
    	}
    	public CellStyle getCellStyle() {
    		return cellStyle;
    	}
    	public void setCellStyle(CellStyle cellStyle) {
    		this.cellStyle = cellStyle;
    	}
    	public Object getData() {
    		return data;
    	}
    	public void setData(Object data) {
    		this.data = data;
    	}
    	public int getColumnSize() {
    		return columnSize;
    	}
    	public void setColumnSize(int columnSize) {
    		this.columnSize = columnSize;
    	}
    }

    
    public static void main(String[] args) throws FileNotFoundException, IOException {
//    	String tempFilePath = ExcelUtil.class.getResource("demo.xlsx").getPath();
//    	String tempFilePath = "c:/a.xls";
//    	File file = new File("c:/data_1.xlsx");
//        OutputStream os = new FileOutputStream(file);
//        
//        ExcelUtil excel = new ExcelUtil();
//        Map<String, Object> dataMap = new HashMap<String, Object>();
//        dataMap.put("B1", "dddd");
//        dataMap.put("B2", 55);
//        dataMap.put("B3", 55);
//        excel.writeData(tempFilePath, dataMap, 0);
//        
//        List<Map<Integer, Object>> datalist = new ArrayList<Map<Integer,Object>>();
//        Map<Integer, Object> data = new HashMap<Integer,Object>();
//        data.put(1, "dfe");
//        data.put(2, "男");
//        data.put(3, 45);
//        datalist.add(data);
//        data = new HashMap<Integer,Object>();
//        data.put(1, "dfeddddd");
//        data.put(2, "男");
//        data.put(3, 45);
//        datalist.add(data);
//        String[] heads = new String[]{"A5","C5","E5"};   //必须为列表头部所有位置集合，   输出 数据单元格样式和头部单元格样式保持一致
//        excel.writeDateList(tempFilePath,heads,datalist,0);
//        
//        //写到输出流并移除资源
//        excel.writeAndClose(tempFilePath, os);
//         
//        os.flush();
//        os.close();
	}
	
    
}


*/
