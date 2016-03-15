package yycg.business.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import yycg.business.pojo.po.Yycgd;
import yycg.business.pojo.vo.GysypmlCustom;
import yycg.business.pojo.vo.GysypmlQueryVo;
import yycg.business.pojo.vo.YpxxCustom;
import yycg.business.pojo.vo.YycgdCustom;
import yycg.business.pojo.vo.YycgdQueryVo;
import yycg.business.pojo.vo.YycgdmxCustom;
import yycg.business.pojo.vo.YycgdrkCustom;
import yycg.business.service.CgdService;
import yycg.util.MyUtil;
@RequestMapping("/cgd")
@Controller
public class CgdAction {
	
	@Autowired
	private CgdService cgdService;
	@Autowired
	private SystemConfigService systemConfigService;

	// 创建采购单基本信息页面
	@RequestMapping("/addcgd")
	public String addcgd(HttpSession session, Model model) throws Exception {
		
		ActiveUser user=(ActiveUser) session.getAttribute(Config.ACTIVEUSER_KEY);
		
		String yymc=user.getSysmc();
		
		String cgdmc=yymc+MyUtil.getDate()+"采购单";
		
		model.addAttribute("yycgdmc",cgdmc);
		
		//String year=MyUtil.get_YYYY(MyUtil.getDate());
		
		model.addAttribute("year","2014");
		
		

		return "/business/cgd/addcgd";

	}
	
	// 创建采购单基本信息保存方法
		@RequestMapping("/addcgdsubmit")
		public @ResponseBody SubmitResultInfo addcgdsubmit(HttpSession session//, String year,
				,YycgdQueryVo yycgdQueryVo) throws Exception {
			
			ActiveUser user=(ActiveUser) session.getAttribute(Config.ACTIVEUSER_KEY);
			
			String useryyid=user.getSysid();
			
			String yycgdid=cgdService.insertYycgd(useryyid, "2014", yycgdQueryVo.getYycgdCustom());
			
			ResultInfo resultInfo=ResultUtil.createSuccess(Config.MESSAGE,906, null);
			
			resultInfo.getSysdata().put("yycgdid",yycgdid);
			
			return ResultUtil.createSubmitResult(resultInfo);
		}
		
		
		// 采购单修改页面方法
		@RequestMapping("/editcgd")
		public String editcgd(Model model, String id) throws Exception {
			
			List<Dictinfo> cgztlist=systemConfigService.findDictinfoByType("011");
			List<Dictinfo> jyztlist=systemConfigService.findDictinfoByType("003");
			
			YycgdCustom yycgdCustom=cgdService.findYycgdById(id);
			
			model.addAttribute("cgztlist", cgztlist);
			model.addAttribute("jyztlist", jyztlist);
			
			model.addAttribute("yycgd", yycgdCustom);
			
			return "/business/cgd/editcgd";
		}
		// 采购单修改页面方法
		@RequestMapping("/editcgdsubmit")
		public @ResponseBody SubmitResultInfo editcgdsubmit(String id,YycgdQueryVo yycgdQueryVo) throws Exception {
			
			cgdService.updateYycgd(id,yycgdQueryVo.getYycgdCustom());
			
			return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE,906, null));
		}
		
		@RequestMapping("/queryYycgdmx_result")
		public @ResponseBody DataGridResultInfo queryYycgdmx_result(
				String id,
				YycgdQueryVo yycgdQueryVo,
				int page,
				int rows
				) throws Exception {
			DataGridResultInfo dataGridResultInfo=new DataGridResultInfo();
			 
			int total=cgdService.findCgdmxCountByYycgdid(id, yycgdQueryVo);

			PageQuery pageQuery=new PageQuery();
			
			pageQuery.setPageParams(total, rows, page);
			
			yycgdQueryVo.setPageQuery(pageQuery);
			
			List<YycgdmxCustom> list=cgdService.findCgdmxListByYycgdid(id, yycgdQueryVo);
			
			dataGridResultInfo.setRows(list);
			
			dataGridResultInfo.setTotal(total);
			
			if(total>0){
				List<YycgdmxCustom> listsum = cgdService.findAddYycgdmxListSum(id, yycgdQueryVo);
				
				
				dataGridResultInfo.setFooter(listsum);
			}
			
					
			return dataGridResultInfo;
		}
		
		
		@RequestMapping("/queryaddyycgdmx")
		public String queryaddyycgdmx(Model model,String yycgdid)throws Exception{
			List<Dictinfo> yplblist=systemConfigService.findDictinfoByType("001");
			
			model.addAttribute("yplblist",yplblist);
			
			model.addAttribute("yycgdid", yycgdid);
			
			return "/business/cgd/queryaddyycgdmx";
		}
		@RequestMapping("/queryaddyycgdmx_result")
		public @ResponseBody DataGridResultInfo queryaddyycgdmx_result
		(//HttpSession session,
		ActiveUser activeUser,
		YycgdQueryVo yycgdQueryVo,
		String yycgdid,
		int rows,
		int page
		) throws Exception{
//			ActiveUser activeUser=(ActiveUser) session.getAttribute(Config.ACTIVEUSER_KEY);
			String useryyid=activeUser.getSysid();
			int total=cgdService.findAddYycgdmxCount(useryyid, yycgdid, yycgdQueryVo);
			
			PageQuery pageQuery=new PageQuery();
			
			pageQuery.setPageParams(total, rows, page);
			
			yycgdQueryVo.setPageQuery(pageQuery);
			
			List<YycgdmxCustom> list=cgdService.findAddYycgdmxList(useryyid, yycgdid, yycgdQueryVo);

			DataGridResultInfo dataGridResultInfo=new DataGridResultInfo();
			
			dataGridResultInfo.setTotal(total);
			
			dataGridResultInfo.setRows(list);
			
			return dataGridResultInfo;
		}
		
		// 采购单药品添加提交
		@RequestMapping("/addyycgdmxsubmit")
		public @ResponseBody SubmitResultInfo addyycgdmxsubmit(
				String yycgdid,//采购单id
				YycgdQueryVo yycgdQueryVo,
				int[] indexs // 页面选择序号
				) throws Exception {
			
			
			int count=indexs.length;
			
			List<YycgdmxCustom> list=yycgdQueryVo.getYycgdmxCustoms();
			
			//处理成功的数量
			int count_success = 0;
			//处理失败的数量
			int count_error = 0;

			//处理失败的原因
			List<ResultInfo> msgs_error = new ArrayList<ResultInfo>();
			
			for(int i=0;i<count;i++){
				//String ypxxid=list.get(Integer.parseInt(indexs[i])).getId();
				ResultInfo resultInfo=null;
				YycgdmxCustom yycgdmxCustom=list.get(indexs[i]);
				String ypxxid=yycgdmxCustom.getYpxxid();
				String usergysid=yycgdmxCustom.getUsergysid();
				try {
					cgdService.insertYycgdmx(yycgdid, ypxxid, usergysid);
					//System.out.println("==="+i+"gkhj===================hjk=======================hk=========hjk=====hj=============");

//					count_success++;
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
		
	// 采购单药品采购量保存
	@RequestMapping("/savecgl")
	public @ResponseBody SubmitResultInfo savecgl(
			String id,//采购单id
			YycgdQueryVo yycgdQueryVo,
			int[] indexs // 页面选择序号
			) throws Exception {
		
		
		int count=indexs.length;
		
		List<YycgdmxCustom> list=yycgdQueryVo.getYycgdmxCustoms();
		
		//处理成功的数量
		int count_success = 0;
		//处理失败的数量
		int count_error = 0;

		//处理失败的原因
		List<ResultInfo> msgs_error = new ArrayList<ResultInfo>();
		
		for(int i=0;i<count;i++){
			//String ypxxid=list.get(Integer.parseInt(indexs[i])).getId();
			ResultInfo resultInfo=null;
			YycgdmxCustom yycgdmxCustom=list.get(indexs[i]);
			String ypxxid=yycgdmxCustom.getYpxxid();
			Integer cgl=yycgdmxCustom.getCgl();
			try {
				cgdService.updateYycgdmx(id, ypxxid, cgl);
				//System.out.println("==="+i+"gkhj===================hjk=======================hk=========hjk=====hj=============");

//							count_success++;
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
	
	@RequestMapping("/yycgdlist")
	public String yycgdlist(Model model)throws Exception{
		List<Dictinfo> cgdztlist=systemConfigService.findDictinfoByType("010");
		List<Dictinfo> jyztlist=systemConfigService.findDictinfoByType("003");
		
		model.addAttribute("jyztlist", jyztlist);
//		
		model.addAttribute("cgdztlist",cgdztlist);
		
		model.addAttribute("year",MyUtil.get_YYYY(MyUtil.getDate()));
		
		return "/business/cgd/yycgdlist";
	}
	
	@RequestMapping("/yycgdlist_result")
	public @ResponseBody DataGridResultInfo yycgdlist_result(
			String year,
			HttpSession session,
			YycgdQueryVo yycgdQueryVo,
			int page,
			int rows
			) throws Exception {
		
		ActiveUser user=(ActiveUser) session.getAttribute(Config.ACTIVEUSER_KEY);
		
		String useryyid=user.getSysid();
		
		DataGridResultInfo dataGridResultInfo=new DataGridResultInfo();
		 
		//int total=cgdService.findYycgdCount(year, useryyid, yycgdQueryVo);
		int total=cgdService.findYycgdCount("2014", useryyid, yycgdQueryVo);

		PageQuery pageQuery=new PageQuery();
		
		pageQuery.setPageParams(total, rows, page);
		
		yycgdQueryVo.setPageQuery(pageQuery);
		
		List<YycgdCustom> list=cgdService.findYycgdList("2014", useryyid, yycgdQueryVo);
		
		dataGridResultInfo.setRows(list);
		
		dataGridResultInfo.setTotal(total);
		
		//dataGridResultInfo.setFooter(footer);
				
		return dataGridResultInfo;
	}
	@RequestMapping("/submitYycgd")
	public @ResponseBody SubmitResultInfo submitYycgd(String id)throws Exception{
		cgdService.saveYycgdSubmitStatus(id);
		
		return ResultUtil.createSubmitResult(ResultUtil.createInfo(Config.MESSAGE,906, null));
	}
	
	@RequestMapping("/checkyycgdlist")
	public String checkyycgdlist(Model model)throws Exception{
		List<Dictinfo> cgdztlist=systemConfigService.findDictinfoByType("010");
		List<Dictinfo> jyztlist=systemConfigService.findDictinfoByType("003");
		
		model.addAttribute("jyztlist", jyztlist);
//		
		model.addAttribute("cgdztlist",cgdztlist);
		
		model.addAttribute("year",MyUtil.get_YYYY(MyUtil.getDate()));
		
		return "/business/cgd/checkyycgdlist";
	}
	
	@RequestMapping("/checkyycgdlist_result")
	public @ResponseBody DataGridResultInfo checkyycgdlist_result(
			String year,
			HttpSession session,
			YycgdQueryVo yycgdQueryVo,
			int page,
			int rows
			) throws Exception {
		
		ActiveUser user=(ActiveUser) session.getAttribute(Config.ACTIVEUSER_KEY);
		
		String userjdid=user.getSysid();
		
		DataGridResultInfo dataGridResultInfo=new DataGridResultInfo();
		 
		//int total=cgdService.findYycgdCount(year, useryyid, yycgdQueryVo);
		int total=cgdService.findCheckYycgdCount("2014", userjdid, yycgdQueryVo);

		PageQuery pageQuery=new PageQuery();
		
		pageQuery.setPageParams(total, rows, page);
		
		yycgdQueryVo.setPageQuery(pageQuery);
		
		List<YycgdCustom> list=cgdService.findCheckYycgdList("2014", userjdid, yycgdQueryVo);
		
		dataGridResultInfo.setRows(list);
		
		dataGridResultInfo.setTotal(total);
		
		//dataGridResultInfo.setFooter(footer);
				
		return dataGridResultInfo;
	}
	
	// 采购单药品添加提交
	@RequestMapping("/checkyycgdsubmit")
	public @ResponseBody SubmitResultInfo checkyycgdsubmit(
			
			YycgdQueryVo yycgdQueryVo,
			int[] indexs // 页面选择序号
			) throws Exception {
		
		
		int count=indexs.length;
		
		List<YycgdCustom> list=yycgdQueryVo.getYycgdCustoms();
		
		//处理成功的数量
		int count_success = 0;
		//处理失败的数量
		int count_error = 0;

		//处理失败的原因
		List<ResultInfo> msgs_error = new ArrayList<ResultInfo>();
		
		for(int i=0;i<count;i++){
			//String ypxxid=list.get(Integer.parseInt(indexs[i])).getId();
			ResultInfo resultInfo=null;
			YycgdCustom yycgdCustom=list.get(indexs[i]);
			String yycgdid=yycgdCustom.getId();
			String shyj=yycgdCustom.getShyj();
			String zt=yycgdCustom.getZt();
			
			try {
				cgdService.saveYycgdCheckStatus(yycgdid, yycgdCustom);
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
	
	
	@RequestMapping("/disposeyycgd")
	public String disposeyycgd(Model model)throws Exception{
//		List<Dictinfo> cgdztlist=systemConfigService.findDictinfoByType("010");
//		List<Dictinfo> jyztlist=systemConfigService.findDictinfoByType("003");
//		
//		model.addAttribute("jyztlist", jyztlist);
////		
//		model.addAttribute("cgdztlist",cgdztlist);
		
		model.addAttribute("year","2014");
		
		return "/business/cgd/disposeyycgd";
	}
	
	@RequestMapping("/disposeyycgd_result")
	public @ResponseBody DataGridResultInfo disposeyycgd_result(
			String year,
			HttpSession session,
			YycgdQueryVo yycgdQueryVo,
			int page,
			int rows
			) throws Exception {
		
		ActiveUser user=(ActiveUser) session.getAttribute(Config.ACTIVEUSER_KEY);
		
		String usergysid=user.getSysid();
		
		DataGridResultInfo dataGridResultInfo=new DataGridResultInfo();
		 
		//int total=cgdService.findYycgdCount(year, useryyid, yycgdQueryVo);
		int total=cgdService.findDisposeYycgdCount( usergysid,year, yycgdQueryVo);

		PageQuery pageQuery=new PageQuery();
		
		pageQuery.setPageParams(total, rows, page);
		
		yycgdQueryVo.setPageQuery(pageQuery);
		
		List<YycgdmxCustom> list=cgdService.findDisposeYycgdList( usergysid, "2014",yycgdQueryVo);
		
		dataGridResultInfo.setRows(list);
		
		dataGridResultInfo.setTotal(total);
		
		//dataGridResultInfo.setFooter(footer);
				
		return dataGridResultInfo;
	}
	
	// 采购单药品添加提交
		@RequestMapping("/disposeyycgdsubmit")
		public @ResponseBody SubmitResultInfo disposeyycgdsubmit(
				
				YycgdQueryVo yycgdQueryVo,
				int[] indexs // 页面选择序号
				) throws Exception {
			
			
			int count=indexs.length;
			
			List<YycgdmxCustom> list=yycgdQueryVo.getYycgdmxCustoms();
			
			//处理成功的数量
			int count_success = 0;
			//处理失败的数量
			int count_error = 0;

			//处理失败的原因
			List<ResultInfo> msgs_error = new ArrayList<ResultInfo>();
			
			for(int i=0;i<count;i++){
				//String ypxxid=list.get(Integer.parseInt(indexs[i])).getId();
				ResultInfo resultInfo=null;
				YycgdmxCustom yycgdmxCustom=list.get(indexs[i]);
				String yycgdid=yycgdmxCustom.getYycgdid();
				String ypxxid=yycgdmxCustom.getYpxxid();
				
				
				try {
					cgdService.saveSendStatus(yycgdid, ypxxid);
					//System.out.println("==="+i+"gkhj===================hjk=======================hk=========hjk=====hj=============");

//					count_success++;
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
	
		
		@RequestMapping("/receiveyycgd")
		public String receiveyycgd(Model model)throws Exception{
//			List<Dictinfo> cgdztlist=systemConfigService.findDictinfoByType("010");
//			List<Dictinfo> jyztlist=systemConfigService.findDictinfoByType("003");
//			
//			model.addAttribute("jyztlist", jyztlist);
////			
//			model.addAttribute("cgdztlist",cgdztlist);
			
			model.addAttribute("year","2014");
			
			return "/business/cgd/receiveyycgd";
		}
		
		@RequestMapping("/receiveyycgd_result")
		public @ResponseBody DataGridResultInfo receiveyycgd_result(
				String year,
				HttpSession session,
				YycgdQueryVo yycgdQueryVo,
				int page,
				int rows
				) throws Exception {
			
			ActiveUser user=(ActiveUser) session.getAttribute(Config.ACTIVEUSER_KEY);
			
			String useryyid=user.getSysid();
			
			DataGridResultInfo dataGridResultInfo=new DataGridResultInfo();
			 
			//int total=cgdService.findYycgdCount(year, useryyid, yycgdQueryVo);
			int total=cgdService.findYycgdReceivceCount(useryyid, year, yycgdQueryVo);

			PageQuery pageQuery=new PageQuery();
			
			pageQuery.setPageParams(total, rows, page);
			
			yycgdQueryVo.setPageQuery(pageQuery);
			
			List<YycgdmxCustom> list=cgdService.findYycgdReceivceList(useryyid, year, yycgdQueryVo);
			
			dataGridResultInfo.setRows(list);
			
			dataGridResultInfo.setTotal(total);
			
			//dataGridResultInfo.setFooter(footer);
					
			return dataGridResultInfo;
		}
		// 采购单药品添加提交
				@RequestMapping("/receiveyycgdsubmit")
				public @ResponseBody SubmitResultInfo receiveyycgdsubmit(
						
						YycgdQueryVo yycgdQueryVo,
						int[] indexs // 页面选择序号
						) throws Exception {
					
					
					int count=indexs.length;
					
					List<YycgdrkCustom> list=yycgdQueryVo.getYycgdrkCustoms();
					
					//处理成功的数量
					int count_success = 0;
					//处理失败的数量
					int count_error = 0;

					//处理失败的原因
					List<ResultInfo> msgs_error = new ArrayList<ResultInfo>();
					
					for(int i=0;i<count;i++){
						//String ypxxid=list.get(Integer.parseInt(indexs[i])).getId();
						ResultInfo resultInfo=null;
						YycgdrkCustom yycgdrkCustom=list.get(indexs[i]);
						String yycgdid=yycgdrkCustom.getYycgdid();
						String ypxxid=yycgdrkCustom.getYpxxid();
						
						
						try {
							cgdService.saveYycgdrk(yycgdid, ypxxid, yycgdrkCustom);
							//System.out.println("==="+i+"gkhj===================hjk=======================hk=========hjk=====hj=============");

//							count_success++;
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
}
