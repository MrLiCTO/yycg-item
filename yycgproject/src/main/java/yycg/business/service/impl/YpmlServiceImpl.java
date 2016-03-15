package yycg.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import yycg.base.process.context.Config;
import yycg.base.process.result.ResultUtil;
import yycg.base.service.SystemConfigService;
import yycg.business.dao.mapper.GysypmlControlMapper;
import yycg.business.dao.mapper.GysypmlControlMapperCustom;
import yycg.business.dao.mapper.GysypmlMapper;
import yycg.business.dao.mapper.GysypmlMapperCustom;
import yycg.business.dao.mapper.YpxxMapper;
import yycg.business.pojo.po.Gysypml;
import yycg.business.pojo.po.GysypmlControl;
import yycg.business.pojo.po.GysypmlControlExample;
import yycg.business.pojo.po.GysypmlExample;
import yycg.business.pojo.po.Ypxx;
import yycg.business.pojo.vo.GysypmlCustom;
import yycg.business.pojo.vo.GysypmlQueryVo;
import yycg.business.service.YpmlService;
import yycg.util.UUIDBuild;

public class YpmlServiceImpl implements YpmlService{
	
	@Autowired
	private GysypmlMapperCustom gysypmlMapperCustom;
	@Autowired
	private GysypmlMapper gysypmlMapper;
	@Autowired
	private YpxxMapper ypxxMapper;
	@Autowired
	private GysypmlControlMapper gysypmlControlMapper;
	@Autowired
	private GysypmlControlMapperCustom gysypmlControlMapperCustom;
	
	@Autowired
	private SystemConfigService systemConfigService;

	@Override
	public List<GysypmlCustom> findGysypmlList(String usergysId, GysypmlQueryVo gysypmlQueryVo) throws Exception {
		
		//设置数据范围权限
		gysypmlQueryVo=gysypmlQueryVo!=null?gysypmlQueryVo:new GysypmlQueryVo();
		 
		GysypmlCustom gysypmlCustom = gysypmlQueryVo.getGysypmlCustom();
		
		if(gysypmlCustom==null){
			gysypmlCustom=new GysypmlCustom();
		}
		
		gysypmlCustom.setUsergysid(usergysId);
		
		gysypmlQueryVo.setGysypmlCustom(gysypmlCustom);
		
		return gysypmlMapperCustom.findGysypmlList(gysypmlQueryVo);
	}

	@Override
	public int findGysypmlCount(String usergysId, GysypmlQueryVo gysypmlQueryVo) throws Exception {
				//设置数据范围权限
				gysypmlQueryVo=gysypmlQueryVo!=null?gysypmlQueryVo:new GysypmlQueryVo();
				 
				GysypmlCustom gysypmlCustom = gysypmlQueryVo.getGysypmlCustom();
				
				if(gysypmlCustom==null){
					gysypmlCustom=new GysypmlCustom();
				}
				
				gysypmlCustom.setUsergysid(usergysId);
				
				gysypmlQueryVo.setGysypmlCustom(gysypmlCustom);
				
				return gysypmlMapperCustom.findGysypmlCount(gysypmlQueryVo);
	}

	@Override
	public List<GysypmlCustom> findAddGysypmlList(String usergysId, GysypmlQueryVo gysypmlQueryVo) throws Exception {
		gysypmlQueryVo=gysypmlQueryVo!=null?gysypmlQueryVo:new GysypmlQueryVo();
		 
		GysypmlCustom gysypmlCustom = gysypmlQueryVo.getGysypmlCustom();
		
		if(gysypmlCustom==null){
			gysypmlCustom=new GysypmlCustom();
		}
		
		gysypmlCustom.setUsergysid(usergysId);
		
		gysypmlQueryVo.setGysypmlCustom(gysypmlCustom);
		return gysypmlMapperCustom.findAddGysypmlList(gysypmlQueryVo);
	}

	@Override
	public int findAddGysypmlCount(String usergysId, GysypmlQueryVo gysypmlQueryVo) throws Exception {
		gysypmlQueryVo=gysypmlQueryVo!=null?gysypmlQueryVo:new GysypmlQueryVo();
		 
		GysypmlCustom gysypmlCustom = gysypmlQueryVo.getGysypmlCustom();
		
		if(gysypmlCustom==null){
			gysypmlCustom=new GysypmlCustom();
		}
		
		gysypmlCustom.setUsergysid(usergysId);
		
		gysypmlQueryVo.setGysypmlCustom(gysypmlCustom);
		return gysypmlMapperCustom.findAddGysypmlCount(gysypmlQueryVo);
	}

	// 根据供货商id和药品id查询供货商药品目录
		@Override
		public Gysypml findGysypmlByUsergysidAndYpxxid(String usergysId,
				String ypxxId) throws Exception{
			
			GysypmlExample gysypmlExample=new GysypmlExample();
			
			GysypmlExample.Criteria crt=gysypmlExample.createCriteria();
			
			crt.andUsergysidEqualTo(usergysId);
			
			crt.andYpxxidEqualTo(ypxxId);
			
			List<Gysypml> list=gysypmlMapper.selectByExample(gysypmlExample);
			
			if(list!=null&&list.size()==1){
				Gysypml gp=list.get(0);
				return gp;
			}
			
					return null;
		}
		
		
		@Override
		public GysypmlControl findGysypmlControlByUsergysidAndYpxxid(String usergysId,
				String ypxxId) throws Exception{
					
			GysypmlControlExample gysypmlControlExample=new GysypmlControlExample();
					
			GysypmlControlExample.Criteria crt=gysypmlControlExample.createCriteria();
					
			crt.andUsergysidEqualTo(usergysId);
					
			crt.andYpxxidEqualTo(ypxxId);
					
			List<GysypmlControl> list=gysypmlControlMapper.selectByExample(gysypmlControlExample);
					
			if(list!=null&&list.size()==1){
				GysypmlControl gc=list.get(0);
				return gc;
			}
					
					return null;
		}
	
	@Override
	public void insertGysypml(String usergysId, String ypxxId) throws Exception {
		// 只允许添加供货商药品目录中没有的药品
		// 校验方法：先根据供货商id和药品id查询供货商药品目录记录，如果查询到说明已存在
		Gysypml gp=this.findGysypmlByUsergysidAndYpxxid(usergysId, ypxxId);
		if(gp!=null){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,401,null));
		}
		
		// 药品的交易状态为暂停不允许添加
		// 根据药品id查询药品信息
		Ypxx ypxx=ypxxMapper.selectByPrimaryKey(ypxxId);
		
		if(ypxx==null){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,316,null));
		}
		
		if(ypxx.getJyzt().equals("2")){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,403,new Object[]{ypxx.getBm(),ypxx.getMc()}));
		}
		
		// 向供货商药品目录表gysypml插入一条记录
		
		Gysypml gysypml_insert=new Gysypml();
		gysypml_insert.setId(UUIDBuild.getUUID());
		gysypml_insert.setUsergysid(usergysId);
		gysypml_insert.setYpxxid(ypxxId);
		
		gysypmlMapper.insert(gysypml_insert);
		
		
		// 同时向供货商药品目录控制表gysypml_control插入一条记录
		// 如果控制表已存在供货商药品不用插入
		// 根据供货商id和药品id查询
		
		GysypmlControl gc=this.findGysypmlControlByUsergysidAndYpxxid(usergysId, ypxxId);
		
		if(gc==null){
			
			String control =systemConfigService.findBasicinfoById("00101").getValue();
			GysypmlControl gc_insert=new GysypmlControl();
			gc_insert.setId(UUIDBuild.getUUID());
			gc_insert.setUsergysid(usergysId);
			gc_insert.setYpxxid(ypxxId);
			gc_insert.setControl(control);
			gysypmlControlMapper.insert(gc_insert);
		}
		
	}

	@Override
	public void deleteGysypml(String usergysId, String ypxxId) throws Exception {
		//System.out.println("===gkhj===================hjk=======================hk=========hjk=====hj=============");
		Gysypml gp=this.findGysypmlByUsergysidAndYpxxid(usergysId, ypxxId);
		if(gp==null){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,402,null));
		}
		
		gysypmlMapper.deleteByPrimaryKey(gp.getId());
		
	}
	
	//=====================================有问题

	@Override
	public List<GysypmlCustom> findGysypmControlList(GysypmlQueryVo gysypmlQueryVo) throws Exception {
//		gysypmlQueryVo=gysypmlQueryVo!=null?gysypmlQueryVo:new GysypmlQueryVo();
//		 
//		GysypmlCustom gysypmlCustom = gysypmlQueryVo.getGysypmlCustom();
//		
//		if(gysypmlCustom==null){
//			gysypmlCustom=new GysypmlCustom();
//		}
//		
//		gysypmlQueryVo.setGysypmlCustom(gysypmlCustom);
		return gysypmlControlMapperCustom.findGysypmControlList(gysypmlQueryVo);
	}

	@Override
	public int findGysypmControlCount(GysypmlQueryVo gysypmlQueryVo) throws Exception {
//		gysypmlQueryVo=gysypmlQueryVo!=null?gysypmlQueryVo:new GysypmlQueryVo();
//		 
//		GysypmlCustom gysypmlCustom = gysypmlQueryVo.getGysypmlCustom();
//		
//		if(gysypmlCustom==null){
//			gysypmlCustom=new GysypmlCustom();
//		}
//		
//		gysypmlQueryVo.setGysypmlCustom(gysypmlCustom);
		return gysypmlControlMapperCustom.findGysypmControlCount(gysypmlQueryVo);
	}
	//=====================================有问题

	@Override
	public void updateGysypmlControl(String usergysId, String ypxxId,String control,String advice) throws Exception {
		// 只允许添加供货商药品目录中没有的药品
		// 校验方法：先根据供货商id和药品id查询供货商药品目录记录，如果查询到说明已存在
		GysypmlControl gc=this.findGysypmlControlByUsergysidAndYpxxid(usergysId, ypxxId);
		if(gc==null){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,902,null));
		}
		
		
		
		if(control!=null&&!control.equals("")){
			if(control.equals("1")||control.equals("2")){
				gc.setControl(control);
			}else{
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,214,null));
			}
		}
		
		
		
		gc.setAdvice(advice);
		
		gysypmlControlMapper.updateByPrimaryKey(gc);
		
		
		
	}
}
