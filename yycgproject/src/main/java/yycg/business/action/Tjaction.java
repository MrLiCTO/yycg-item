package yycg.business.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yycg.base.pojo.po.Dictinfo;
import yycg.base.pojo.vo.ActiveUser;
import yycg.base.pojo.vo.PageQuery;
import yycg.base.process.result.DataGridResultInfo;
import yycg.base.service.SystemConfigService;
import yycg.business.pojo.vo.YycgdQueryVo;
import yycg.business.pojo.vo.YycgdmxCustom;
import yycg.business.service.BusinessService;

@RequestMapping("/tj")
@Controller
public class Tjaction {
	@Autowired
	private SystemConfigService systemConfigService;
	@Autowired
	private BusinessService businessService;
	
	@RequestMapping("/businesslist")
	public String businesslist(Model model)throws Exception{
		
		List<Dictinfo> cgztList=systemConfigService.findDictinfoByType("011");
		
		model.addAttribute("cgztlist",cgztList);
		
		model.addAttribute("year","2014");
		
		return "/business/tj/businesslist";
	}
	
	@RequestMapping("/businesslist_result")
	public @ResponseBody DataGridResultInfo businesslist_result(
			String year,
			ActiveUser activeUser,
			YycgdQueryVo yycgdQueryVo,
			int rows,
			int page
			)throws Exception{
		
		String sysid=activeUser.getSysid();
		
		String groupid=activeUser.getGroupid();
		
		int total=businessService.findYybusinessCount(year, sysid, groupid, yycgdQueryVo);
		
		PageQuery pageQuery=new PageQuery();
		
		pageQuery.setPageParams(total,rows, page);
		
		yycgdQueryVo.setPageQuery(pageQuery);
		
		List<YycgdmxCustom> list=businessService.findYybusinessList(year, sysid, groupid, yycgdQueryVo);
		
		DataGridResultInfo dataGridResultInfo=new DataGridResultInfo();
		
		dataGridResultInfo.setRows(list);
		
		dataGridResultInfo.setTotal(total);
		
		return dataGridResultInfo;
	}
	
	@RequestMapping("/groupbyypxx")
	public String groupbyypxx(Model model)throws Exception{
		
		List<Dictinfo> cgztList=systemConfigService.findDictinfoByType("011");
		
		model.addAttribute("cgztlist",cgztList);
		
		model.addAttribute("year","2014");
		
		return "/business/tj/groupbyypxx";
	}
	
	@RequestMapping("/groupbyypxx_result")
	public @ResponseBody DataGridResultInfo groupbyypxx_result(
			String year,
			ActiveUser activeUser,
			YycgdQueryVo yycgdQueryVo,
			int rows,
			int page
			)throws Exception{
		
		String sysid=activeUser.getSysid();
		
		String groupid=activeUser.getGroupid();
		
		int total=businessService.findYybusinessGroupbyYpxxCount(year, sysid, groupid, yycgdQueryVo);
		
		PageQuery pageQuery=new PageQuery();
		
		pageQuery.setPageParams(total,rows, page);
		
		yycgdQueryVo.setPageQuery(pageQuery);
		
		List<YycgdmxCustom> list=businessService.findYybusinessGroupbyYpxxList(year, sysid, groupid, yycgdQueryVo);
		
		DataGridResultInfo dataGridResultInfo=new DataGridResultInfo();
		
		dataGridResultInfo.setRows(list);
		
		dataGridResultInfo.setTotal(total);
		
		return dataGridResultInfo;
	}
	
	
}
