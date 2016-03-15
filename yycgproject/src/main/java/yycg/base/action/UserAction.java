package yycg.base.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yycg.base.pojo.po.Dictinfo;
import yycg.base.pojo.vo.PageQuery;
import yycg.base.pojo.vo.SysuserCustom;
import yycg.base.pojo.vo.SysuserQueryVo;
import yycg.base.process.context.Config;
import yycg.base.process.result.DataGridResultInfo;
import yycg.base.process.result.ResultUtil;
import yycg.base.process.result.SubmitResultInfo;
import yycg.base.service.SystemConfigService;
import yycg.base.service.UserService;
@Controller
@RequestMapping("/user")
public class UserAction {
	
	@Autowired
	private SystemConfigService systemConfigService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/queryuser")
	public String queryuser(Model model)throws Exception{
		//int i=1/0;
		
		List<Dictinfo> dicts=systemConfigService.findDictinfoByType("s01");
		
		model.addAttribute("groupList",dicts);
		
		return "/base/user/queryuser";
	}
	
	@RequestMapping("/queryuser_result")
	public @ResponseBody DataGridResultInfo queryuser_result(SysuserQueryVo sysuserQueryVo,
															int page,
															int rows
			)throws Exception{
		
		DataGridResultInfo dataGridResultInfo =new DataGridResultInfo();
		//非空校验
		sysuserQueryVo = sysuserQueryVo!=null?sysuserQueryVo:new SysuserQueryVo();
		PageQuery pageQuery=new PageQuery();
		
		int total=userService.findSysuserCount(sysuserQueryVo);
		
		pageQuery.setPageParams(total, rows, page);
		
		sysuserQueryVo.setPageQuery(pageQuery);
		
		List<SysuserCustom> userRows=userService.findSysuserList(sysuserQueryVo);
		
	
		
	
		
		dataGridResultInfo.setRows(userRows);
		
		dataGridResultInfo.setTotal(total);
		
		
		
		return dataGridResultInfo;
	}
	@RequestMapping("/addsysuser")
	public String addsysuser(Model model)throws Exception{
		

		
		return "/base/user/addsysuser";
	}
	
	//@RequestMapping("/addsysusersubmit")
	//public @ResponseBody Map<String,Object> addsysusersubmit(SysuserQueryVo sysuserQueryVo)throws Exception{
	@RequestMapping("/addsysusersubmit")
	public @ResponseBody SubmitResultInfo addsysusersubmit(SysuserQueryVo sysuserQueryVo)throws Exception{

		//提示用户信息
		
//		String message = "操作成功！！";
//		int type=0;//成功
//		//默认为成功
//		ResultInfo resultInfo = new ResultInfo();
//		resultInfo.setType(ResultInfo.TYPE_RESULT_SUCCESS);
//		resultInfo.setMessage("操作成功！");
		
//		try {
//			//调用service执行用户添加
//			userService.insertSysuser(sysuserQueryVo.getSysuserCustom());
//		} catch (Exception e) {
//			//输出异常信息
//			e.printStackTrace();
//			//对应异常信息进行解析
//			//message = e.getMessage();
//			//type=1;//失败
//			//解析系统自定义异常
//			if(e instanceof ExceptionResultInfo){
//				//抛出的是系统自定义异常
//				resultInfo = ((ExceptionResultInfo)e).getResultInfo();
//			}else{
//				//重新构造“未知错误”异常
//				resultInfo = new ResultInfo();
//				resultInfo.setType(ResultInfo.TYPE_RESULT_FAIL);
//				resultInfo.setMessage("未知错误！");
//			}
//		}
		
		//使用全局异常处理器后，在actoin不用进行try/catch捕获
		userService.insertSysuser(sysuserQueryVo.getSysuserCustom());
		
		
		//将执行结果返回页面
		
//		Map<String, Object> result_map = new HashMap<String, Object>();
//		result_map.put("type", type);
//		result_map.put("message", message);
		
//		SubmitResultInfo submitResultInfo = new SubmitResultInfo(resultInfo);
		
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE,906, null));
		//return result_map;
		
	}
	@RequestMapping("/deletesysuser")
	public @ResponseBody SubmitResultInfo deletesysuser(String id)throws Exception{

		userService.deleteUser(id);
		
		

		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE,906, null));
		
		
	}
	
	//修改用户的页面
	@RequestMapping("/editsysuser")
	public String editsysuser(Model model,String id)throws Exception{
		
		SysuserCustom user=userService.findSysuserById(id);
		 model.addAttribute("sysuserCustom",user);
		 
		 
		 return "/base/user/editsysuser";
	}
	
	//修改用户的提交
	
	@RequestMapping("/editsysusersubmit")
	public @ResponseBody SubmitResultInfo editsysusersubmit(String id,SysuserQueryVo sysuserQueryVo)throws Exception{
		
		userService.updateSysuser(id, sysuserQueryVo.getSysuserCustom());
		
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE,906, null));
	}
}
