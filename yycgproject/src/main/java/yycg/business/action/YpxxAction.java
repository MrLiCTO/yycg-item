package yycg.business.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import yycg.base.pojo.po.Dictinfo;
import yycg.base.process.context.Config;
import yycg.base.process.result.ResultInfo;
import yycg.base.process.result.ResultUtil;
import yycg.base.process.result.SubmitResultInfo;
import yycg.base.service.SystemConfigService;
import yycg.business.pojo.vo.YpxxCustom;
import yycg.business.pojo.vo.YpxxQueryVo;
import yycg.business.service.YpxxService;
import yycg.business.service.impl.YpxxImportServiceImpl;
import yycg.util.ExcelExportSXXSSF;
import yycg.util.HxlsOptRowsInterface;
import yycg.util.HxlsOptRowsInterfaceImpl;
import yycg.util.HxlsRead;
import yycg.util.UUIDBuild;
import yycg.util.Ypxx;

@RequestMapping("/ypml")
@Controller
public class YpxxAction {
	@Autowired
	private YpxxService ypxxService;
	@Autowired
	private SystemConfigService systemConfigService;
	@Autowired
	private HxlsOptRowsInterface ypxxImportService;
	
	//导出页面展示
	@RequestMapping("/exportYpxx")
	public String exportYpxx(Model model) throws Exception{
		
		//药品类别
		List<Dictinfo> yplblist=systemConfigService.findDictinfoByType("001");
		//交易状态
		List<Dictinfo> jyztlist=systemConfigService.findDictinfoByType("003");
		
		model.addAttribute("yplblist", yplblist);
		model.addAttribute("jyztlist", jyztlist);
		
		
		return "/business/ypml/exportYpxx";
	}
	//到处提交
	
	@RequestMapping("/exportYpxxSubmit")
	public @ResponseBody SubmitResultInfo exportYpxxSubmit(Model model,YpxxQueryVo ypxxQueryVo) throws Exception{
		//--------------------------
		
		
		//导出文件存放的路径，并且是虚拟目录指向的路径
		//String filePath = "e:/upload/linshi/";
		String filePath =systemConfigService.findBasicinfoById("00301").getValue();
		//导出文件的前缀
		String filePrefix="ypxx";
		//-1表示关闭自动刷新，手动控制写磁盘的时机，其它数据表示多少数据在内存保存，超过的则写入磁盘
		int flushRows=100;
		
		//指导导出数据的title
		List<String> fieldNames=new ArrayList<String>();
		fieldNames.add("流水号");
		fieldNames.add("通用名");
		fieldNames.add("剂型");
		fieldNames.add("规格");
		fieldNames.add("转换系数");
		fieldNames.add("生产企业");
		fieldNames.add("商品名称");
		fieldNames.add("中标价格");
		fieldNames.add("交易状态");
		
		//告诉导出类数据list中对象的属性，让ExcelExportSXXSSF通过反射获取对象的值
		List<String> fieldCodes=new ArrayList<String>();
		fieldCodes.add("bm");//药品流水号
		fieldCodes.add("mc");//通用名
		fieldCodes.add("jx");//价格
		fieldCodes.add("gg");//价格
		fieldCodes.add("zhxs");//价格
		fieldCodes.add("scqymc");//价格
		fieldCodes.add("spmc");//价格
		fieldCodes.add("zbjg");//价格
		fieldCodes.add("jyzt");//价格
		
		
		
		//注意：fieldCodes和fieldNames个数必须相同且属性和title顺序一一对应，这样title和内容才一一对应
		
		
		//开始导出，执行一些workbook及sheet等对象的初始创建
		ExcelExportSXXSSF excelExportSXXSSF = ExcelExportSXXSSF.start(filePath, "/upload/", filePrefix, fieldNames, fieldCodes, flushRows);
		
		//准备导出的数据，将数据存入list，且list中对象的字段名称必须是刚才传入ExcelExportSXXSSF的名称
		List<YpxxCustom> list = ypxxService.findYpxxList(ypxxQueryVo);
		
		
		//执行导出
		excelExportSXXSSF.writeDatasByObject(list);
		//输出文件，返回下载文件的http地址
		String webpath = excelExportSXXSSF.exportFile();
		
		System.out.println(webpath);
		
		
		//--------------------------
		
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE,313, new Object[]{list.size(),webpath}));
	}
	
		//导入页面展示
		@RequestMapping("/importypxx")
		public String importypxx(Model model) throws Exception{
			
			
			
			
			return "/business/ypml/importypxx";
		}
		
		//到入提交
		@RequestMapping("/importypxxsubmit")
		public @ResponseBody SubmitResultInfo importspxxyubmit(MultipartFile ypxximportfile) throws Exception{
			String originalFilename=ypxximportfile.getOriginalFilename();
			
			File file=new File("E:/upload/linshi/"+UUIDBuild.getUUID()+originalFilename.substring(originalFilename.lastIndexOf(".")));
			
			if(!file.exists()){
				file.mkdirs();
			}
			
			ypxximportfile.transferTo(file);
			
			String  absolutePath= file.getAbsolutePath();
			
			HxlsRead xls2csv=null;
			try {
				//第一个参数就是导入的文件
				//第二个参数就是导入文件中哪个sheet
				//第三个参数导入接口的实现类对象
				xls2csv = new HxlsRead(absolutePath,1,ypxxImportService);//数据在sheet1
				xls2csv.process();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			long sum=xls2csv.getOptRows_sum();
			long success_num=xls2csv.getOptRows_success();
			long fail_num=xls2csv.getOptRows_failure();
			
			//获取失败记录
			
			List<List<String>> fail_list=xls2csv.getFailrows();
			List<String> title_list=xls2csv.getRowtitle();
			List<String> msgs_list=xls2csv.getFailmsgs();
			
			title_list.add("失败原因");
			
			for(int i=0;i<fail_list.size();i++){
				fail_list.get(i).add(msgs_list.get(i));
			}
			
			//-------------------
			
			//导出文件存放的路径，并且是虚拟目录指向的路径
			//String filePath = "e:/upload/linshi/";
			String filePath =systemConfigService.findBasicinfoById("00301").getValue();
			//导出文件的前缀
			String filePrefix="ypxx";
			//-1表示关闭自动刷新，手动控制写磁盘的时机，其它数据表示多少数据在内存保存，超过的则写入磁盘
			int flushRows=100;
			
			//指导导出数据的title
			List<String> fieldNames=title_list;
			
			//告诉导出类数据list中对象的属性，让ExcelExportSXXSSF通过反射获取对象的值
			List<String> fieldCodes=new ArrayList<String>();
		
			fieldCodes.add("mc");//通用名
			fieldCodes.add("jx");//价格
			fieldCodes.add("gg");//价格
			fieldCodes.add("zhxs");//价格
			
			
			fieldCodes.add("zbjg");//价格
			fieldCodes.add("scqymc");//价格
			
			fieldCodes.add("spmc");//价格
			fieldCodes.add("jyzt");//价格
			fieldCodes.add("sbyy_msg");//价格
			
			
			//注意：fieldCodes和fieldNames个数必须相同且属性和title顺序一一对应，这样title和内容才一一对应
			
			
			//开始导出，执行一些workbook及sheet等对象的初始创建
			ExcelExportSXXSSF excelExportSXXSSF = ExcelExportSXXSSF.start(filePath, "/upload/", filePrefix, fieldNames, fieldCodes, flushRows);
			
			//准备导出的数据，将数据存入list，且list中对象的字段名称必须是刚才传入ExcelExportSXXSSF的名称
			List<YpxxCustom> list = new ArrayList<YpxxCustom>();
			YpxxCustom yc=null;
			for(int i=0;i<fail_list.size();i++){
				List<String> pro_list= fail_list.get(i);
				yc=new YpxxCustom();
				yc.setMc(pro_list.get(0));
				yc.setJx(pro_list.get(1));
				yc.setGg(pro_list.get(2));
				yc.setZhxs(pro_list.get(3));
				yc.setZbjg(Float.parseFloat(pro_list.get(4)));
				yc.setScqymc(pro_list.get(5));
				yc.setSpmc(pro_list.get(6));
				yc.setJyzt(pro_list.get(7));
				yc.setSbyy_msg(pro_list.get(8));
					
				list.add(yc);
			}
			
			//执行导出
			excelExportSXXSSF.writeDatasByObject(list);
			//输出文件，返回下载文件的http地址
			String webpath = excelExportSXXSSF.exportFile();
			
			System.out.println(webpath);
			
			
			
			
			//--------------------------
			
			return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE,315,new Object[]{success_num,fail_num,webpath}));
		}
}
