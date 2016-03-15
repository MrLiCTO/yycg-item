package yycg.business.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yycg.base.pojo.po.Dictinfo;
import yycg.base.pojo.vo.ActiveUser;
import yycg.base.pojo.vo.PageQuery;
import yycg.base.process.context.Config;
import yycg.base.process.result.DataGridResultInfo;
import yycg.base.process.result.ExceptionResultInfo;
import yycg.base.process.result.ResultInfo;
import yycg.base.process.result.ResultUtil;
import yycg.base.process.result.SubmitResultInfo;
import yycg.base.service.SystemConfigService;
import yycg.business.pojo.po.Ypxx;
import yycg.business.pojo.vo.GysypmlCustom;
import yycg.business.pojo.vo.GysypmlQueryVo;
import yycg.business.pojo.vo.YpxxCustom;
import yycg.business.service.YpmlService;
@RequestMapping("/ypml")
@Controller
public class YpmlAction {
	@Autowired
	private YpmlService ypmlService;
	@Autowired
	private SystemConfigService systemConfigService;
	@RequestMapping("/querygysypml")
	public String querygysypml(Model model)throws Exception{
		List<Dictinfo> yplblist=systemConfigService.findDictinfoByType("001");
		
		model.addAttribute("yplblist",yplblist);
		
		return "/business/ypml/querygysypml";
	}
	@RequestMapping("/querygysypml_result")
	public @ResponseBody DataGridResultInfo querygysypml_result
	(HttpSession session,
	GysypmlQueryVo gysypmlQueryVo,
	int rows,
	int page
	) throws Exception{
		ActiveUser activeUser=(ActiveUser) session.getAttribute(Config.ACTIVEUSER_KEY);
		String usergysId=activeUser.getSysid();
		int total=ypmlService.findGysypmlCount(usergysId, gysypmlQueryVo);
		
		PageQuery pageQuery=new PageQuery();
		
		pageQuery.setPageParams(total, rows, page);
		
		gysypmlQueryVo.setPageQuery(pageQuery);
		
		List<GysypmlCustom> list=ypmlService.findGysypmlList(usergysId, gysypmlQueryVo);

		DataGridResultInfo dataGridResultInfo=new DataGridResultInfo();
		
		dataGridResultInfo.setTotal(total);
		
		dataGridResultInfo.setRows(list);
		
		return dataGridResultInfo;
	}
	
	@RequestMapping("/querygysypmladd")
	public String querygysypmladd(Model model)throws Exception{
		List<Dictinfo> yplblist=systemConfigService.findDictinfoByType("001");
		
		model.addAttribute("yplblist",yplblist);
		
		return "/business/ypml/querygysypmladd";
	}
	@RequestMapping("/querygysypmladd_result")
	public @ResponseBody DataGridResultInfo querygysypmladd_result
	(HttpSession session,
	GysypmlQueryVo gysypmlQueryVo,
	int rows,
	int page
	) throws Exception{
		ActiveUser activeUser=(ActiveUser) session.getAttribute(Config.ACTIVEUSER_KEY);
		String usergysId=activeUser.getSysid();
		int total=ypmlService.findAddGysypmlCount(usergysId, gysypmlQueryVo);
		
		PageQuery pageQuery=new PageQuery();
		
		pageQuery.setPageParams(total, rows, page);
		
		gysypmlQueryVo.setPageQuery(pageQuery);
		
		List<GysypmlCustom> list=ypmlService.findAddGysypmlList(usergysId, gysypmlQueryVo);

		DataGridResultInfo dataGridResultInfo=new DataGridResultInfo();
		
		dataGridResultInfo.setTotal(total);
		
		dataGridResultInfo.setRows(list);
		
		return dataGridResultInfo;
	}
	
	
	
	
	@RequestMapping("/addgysypmlsubmit")
	public @ResponseBody SubmitResultInfo addgysypmlsubmit(
			HttpSession session,
			//String[] indexs,
			int[] indexs,
			GysypmlQueryVo gysypmlQueryVo)throws Exception{
		
		ActiveUser activeUser=(ActiveUser) session.getAttribute(Config.ACTIVEUSER_KEY);
		
		String usergysid=activeUser.getSysid();
		
		
		int count=indexs.length;
		
		List<YpxxCustom> list=gysypmlQueryVo.getYpxxCustoms();
		
		//处理成功的数量
		int count_success = 0;
		//处理失败的数量
		int count_error = 0;

		//处理失败的原因
		List<ResultInfo> msgs_error = new ArrayList<ResultInfo>();
		
		for(int i=0;i<count;i++){
			//String ypxxid=list.get(Integer.parseInt(indexs[i])).getId();
			ResultInfo resultInfo=null;
			Ypxx ypxx=list.get(indexs[i]);
			String ypxxid=ypxx.getId();
			try {
				ypmlService.insertGysypml(usergysid, ypxxid);
//				count_success++;
			} catch (Exception e) {
				e.printStackTrace();
				
				if(e instanceof ExceptionResultInfo){
					resultInfo=((ExceptionResultInfo) e).getResultInfo();
				}else{
					resultInfo=ResultUtil.createFail(Config.MESSAGE,900,null);
				}
				
			
				
			}
			
			if(resultInfo==null){
				count_success++;
			}else{
				
				count_error++;
				
				msgs_error.add(resultInfo);
			}
		}
		
//		for(String str:indexs){
//			System.out.println("=============+"+str+"+========");
//		}
//		
//		for(YpxxCustom ypxx:gysypmlQueryVo.getYpxxCustoms()){
//			System.out.println("=============+"+ypxx.getId()+"+========");
//		}
		
//		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE,907, new Object[]{count_success,count_error}));
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE,907, new Object[]{count_success,count_error}),msgs_error);
	}

	@RequestMapping("/deletegysypmlsubmit")
	public @ResponseBody SubmitResultInfo deletegysypmlsubmit(
			HttpSession session,
			//String[] indexs,
			int[] indexs,
			GysypmlQueryVo gysypmlQueryVo)throws Exception{
		
		ActiveUser activeUser=(ActiveUser) session.getAttribute(Config.ACTIVEUSER_KEY);
		
		String usergysid=activeUser.getSysid();
		
		
		int count=indexs.length;
		
		List<YpxxCustom> list=gysypmlQueryVo.getYpxxCustoms();
		
		//处理成功的数量
		int count_success = 0;
		//处理失败的数量
		int count_error = 0;

		//处理失败的原因
		List<ResultInfo> msgs_error = new ArrayList<ResultInfo>();
		
		for(int i=0;i<count;i++){
			//String ypxxid=list.get(Integer.parseInt(indexs[i])).getId();
			ResultInfo resultInfo=null;
			Ypxx ypxx=list.get(indexs[i]);
			String ypxxid=ypxx.getId();
			try {
				ypmlService.deleteGysypml(usergysid, ypxxid);
				//System.out.println("==="+i+"gkhj===================hjk=======================hk=========hjk=====hj=============");

//				count_success++;
			} catch (Exception e) {
				e.printStackTrace();
				
				if(e instanceof ExceptionResultInfo){
					resultInfo=((ExceptionResultInfo) e).getResultInfo();
				}else{
					resultInfo=ResultUtil.createFail(Config.MESSAGE,900,null);
					//System.out.println("===gk0000000hj===================hjk=======================hk=========hjk=====hj=============");

				}
				
			}
			
			if(resultInfo==null){
				count_success++;
			}else{
				
				count_error++;
				
				msgs_error.add(resultInfo);
			}
		}
		
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE,907, new Object[]{count_success,count_error}),msgs_error);
	}
	
	
	@RequestMapping("/querygysypmlcontrol")
	public String querygysypmlcontrol(Model model)throws Exception{
		List<Dictinfo> controllist=systemConfigService.findDictinfoByType("008");
		
		List<Dictinfo> yplblist=systemConfigService.findDictinfoByType("001");
		
		
		List<Dictinfo> jyztlist=systemConfigService.findDictinfoByType("003");
		
		model.addAttribute("jyztlist",jyztlist);
		
		model.addAttribute("yplblist",yplblist);
		
		//--------------------------
		model.addAttribute("controllist",controllist);
		
		return "/business/ypml/querygysypmlcontrol";
	}
	
	@RequestMapping("/querygysypmlcontrol_result")
	public @ResponseBody DataGridResultInfo querygysypmlcontrol_result
	(HttpSession session,
			GysypmlQueryVo gysypmlQueryVo,
			int rows,
			int page
			) throws Exception{
		int total=ypmlService.findGysypmControlCount(gysypmlQueryVo);
		
		PageQuery pageQuery=new PageQuery();
		
		pageQuery.setPageParams(total, rows, page);
		
		gysypmlQueryVo.setPageQuery(pageQuery);
		
		List<GysypmlCustom> list=ypmlService.findGysypmControlList(gysypmlQueryVo);
		
		DataGridResultInfo dataGridResultInfo=new DataGridResultInfo();
		
		dataGridResultInfo.setTotal(total);
		
		dataGridResultInfo.setRows(list);
		
		return dataGridResultInfo;
	}
	
	
	//-----------------------------
	@RequestMapping("/gysypmlcontrolsubmit")
	public @ResponseBody SubmitResultInfo gysypmlcontrolsubmit(
			HttpSession session,
			//String[] indexs,
			int[] indexs,
			GysypmlQueryVo gysypmlQueryVo)throws Exception{	
		
		int count=indexs.length;
		
		List<GysypmlCustom> list=gysypmlQueryVo.getGysypmlCustoms();
		
		//处理成功的数量
		int count_success = 0;
		//处理失败的数量
		int count_error = 0;

		//处理失败的原因
		List<ResultInfo> msgs_error = new ArrayList<ResultInfo>();
		
		for(int i=0;i<count;i++){
			//String ypxxid=list.get(Integer.parseInt(indexs[i])).getId();
			ResultInfo resultInfo=null;
			GysypmlCustom ypxx=list.get(indexs[i]);
			String ypxxid=ypxx.getId();
			String usergysid=ypxx.getUsergysid();
			try {
				ypmlService.updateGysypmlControl(usergysid,ypxxid,ypxx.getControl(),ypxx.getAdvice());
//				count_success++;
			} catch (Exception e) {
				e.printStackTrace();
				
				if(e instanceof ExceptionResultInfo){
					resultInfo=((ExceptionResultInfo) e).getResultInfo();
				}else{
					resultInfo=ResultUtil.createFail(Config.MESSAGE,900,null);
				}
				
			
				
			}
			
			if(resultInfo==null){
				count_success++;
			}else{
				
				count_error++;
				
				msgs_error.add(resultInfo);
			}
		}
		
//		for(String str:indexs){
//			System.out.println("=============+"+str+"+========");
//		}
//		
//		for(YpxxCustom ypxx:gysypmlQueryVo.getYpxxCustoms()){
//			System.out.println("=============+"+ypxx.getId()+"+========");
//		}
		
//		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE,907, new Object[]{count_success,count_error}));
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE,907, new Object[]{count_success,count_error}),msgs_error);
	}
	
}
