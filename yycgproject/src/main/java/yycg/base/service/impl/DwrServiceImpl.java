package yycg.base.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import yycg.base.pojo.po.Dictinfo;
import yycg.base.service.DwrService;
import yycg.base.service.SystemConfigService;
import yycg.util.MyUtil;


public class DwrServiceImpl implements DwrService {
	
	@Autowired
	SystemConfigService systemConfigService;
	
	/**
	 * 测试方法
	 * @return
	 * @throws Exception
	 */
	public String testdwr() throws Exception{
		return "helloworld";
	}
	
	public String testdwr2(String name) throws Exception{
		return "helloworld "+name;
	}
	
	/**
	 * 获取年度，获取近6年
	 */
	public List<Map<String, String>> businessyear() throws Exception{
		//当前年
		int year = Integer.parseInt(MyUtil.get_YYYY(MyUtil.getDate()));
		//定义了一个list对象，list里边是map
		List<Map<String, String>> result  = new ArrayList<Map<String,String>>();
		//将近5年放入list
		for(int i=year;i>=year-5;i--){
			 Map<String, String> index = new HashMap<String, String>();
			 index.put("info", i+"");
	      	 index.put("value", i+"");
	      	 result.add(index);
		}
		//将list返回
		return result;
	}
	
	/**
	 * 根据typecode获取数据字典id信息
	 */
	@Override
	public List<Map<String, String>> getDictinfoIdlist(String typecode) throws Exception {
        List<Dictinfo> list = systemConfigService.findDictinfoByType(typecode);
        
        List<Map<String, String>> result  = new ArrayList<Map<String,String>>();
        for(Dictinfo dictinfo:list){
        	Map<String, String> index = new HashMap<String, String>();
        	index.put("info", dictinfo.getInfo());
        	index.put("value", dictinfo.getId());//将数据字典表中的id放入，用于在页面中将id作为select下拉框的value值
        	result.add(index);
        }
		return result;
	}
	/**
	 * 根据typecode获取数据字典dictcode信息
	 */
	@Override
	public List<Map<String, String>> getDictinfoCodelist(String typecode) throws Exception {
        List<Dictinfo> list = systemConfigService.findDictinfoByType(typecode);
        
        List<Map<String, String>> result  = new ArrayList<Map<String,String>>();
        for(Dictinfo dictinfo:list){
        	Map<String, String> index = new HashMap<String, String>();
        	index.put("info", dictinfo.getInfo());
        	index.put("value", dictinfo.getDictcode());//将数据字典的dictcode值放入，用于在页面中将dictcode值作为select下拉框的value值
        	result.add(index);
        }
		return result;
	}
	

}
