package yycg.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import yycg.base.dao.mapper.UsergysMapper;
import yycg.base.dao.mapper.UserjdMapper;
import yycg.base.dao.mapper.UseryyMapper;
import yycg.base.pojo.po.Usergys;
import yycg.base.pojo.po.Userjd;
import yycg.base.pojo.po.Useryy;
import yycg.business.dao.mapper.YybusinessMapper;
import yycg.business.dao.mapper.YybusinessMapperCustom;
import yycg.business.pojo.vo.YycgdQueryVo;
import yycg.business.pojo.vo.YycgdmxCustom;
import yycg.business.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {
	
	@Autowired
	private UserjdMapper userjdMapper;
	@Autowired
	private UseryyMapper useryyMapper;
	@Autowired
	private UsergysMapper usergysMapper;
	@Autowired
	private YybusinessMapperCustom yybusinessMapperCuostom;
	
	

	@Override
	public List<YycgdmxCustom> findYybusinessList(String year, String sysid, String groupid, YycgdQueryVo yycgdQueryVo)
			throws Exception {
		
		yycgdQueryVo=yycgdQueryVo!=null?yycgdQueryVo:new YycgdQueryVo();
		
		
		
		if(groupid.equals("1")||groupid.equals("2")){
			
			Userjd userjd=userjdMapper.selectByPrimaryKey(sysid);
			
			String dq=userjd.getDq();
			
			Useryy useryy=yycgdQueryVo.getUseryy();
			
			useryy=useryy!=null?useryy:new Useryy();
			
			useryy.setDq(dq);
			
			yycgdQueryVo.setUseryy(useryy);
			
		}else if(groupid.equals("3")){
			
			//Useryy useryy=useryyMapper.selectByPrimaryKey(sysid);
			
			Useryy useryy=yycgdQueryVo.getUseryy();
			
			useryy=useryy!=null?useryy:new Useryy();
			
			useryy.setId(sysid);
			
			yycgdQueryVo.setUseryy(useryy);
			
		}else if(groupid.equals("4")){
		
		//Useryy useryy=useryyMapper.selectByPrimaryKey(sysid);
		
		Usergys usergys=yycgdQueryVo.getUsergys();
		
		usergys=usergys!=null?usergys:new Usergys();
		
		usergys.setId(sysid);
		
		
		
	}
		yycgdQueryVo.setBusinessyear(year);
		
		return yybusinessMapperCuostom.findYybusinessList(yycgdQueryVo);
	}

	@Override
	public int findYybusinessCount(String year, String sysid, String groupid, YycgdQueryVo yycgdQueryVo)
			throws Exception {
	yycgdQueryVo=yycgdQueryVo!=null?yycgdQueryVo:new YycgdQueryVo();
		
		
		
		if(groupid.equals("1")||groupid.equals("2")){
			
			Userjd userjd=userjdMapper.selectByPrimaryKey(sysid);
			
			String dq=userjd.getDq();
			
			Useryy useryy=yycgdQueryVo.getUseryy();
			
			useryy=useryy!=null?useryy:new Useryy();
			
			useryy.setDq(dq);
			
			yycgdQueryVo.setUseryy(useryy);
			
		}else if(groupid.equals("3")){
			
			//Useryy useryy=useryyMapper.selectByPrimaryKey(sysid);
			
			Useryy useryy=yycgdQueryVo.getUseryy();
			
			useryy=useryy!=null?useryy:new Useryy();
			
			useryy.setId(sysid);
			
			yycgdQueryVo.setUseryy(useryy);
			
		}else if(groupid.equals("4")){
		
		//Useryy useryy=useryyMapper.selectByPrimaryKey(sysid);
		
		Usergys usergys=yycgdQueryVo.getUsergys();
		
		usergys=usergys!=null?usergys:new Usergys();
		
		usergys.setId(sysid);
		
		
		
	}
		yycgdQueryVo.setBusinessyear(year);
		return yybusinessMapperCuostom.findYybusinessCount(yycgdQueryVo);
	}

	@Override
	public List<YycgdmxCustom> findYybusinessGroupbyYpxxList(String year, String sysid, String groupid,
			YycgdQueryVo yycgdQueryVo) throws Exception {
yycgdQueryVo=yycgdQueryVo!=null?yycgdQueryVo:new YycgdQueryVo();
		
		
		
		if(groupid.equals("1")||groupid.equals("2")){
			
			Userjd userjd=userjdMapper.selectByPrimaryKey(sysid);
			
			String dq=userjd.getDq();
			
			Useryy useryy=yycgdQueryVo.getUseryy();
			
			useryy=useryy!=null?useryy:new Useryy();
			
			useryy.setDq(dq);
			
			yycgdQueryVo.setUseryy(useryy);
			
		}else if(groupid.equals("3")){
			
			//Useryy useryy=useryyMapper.selectByPrimaryKey(sysid);
			
			Useryy useryy=yycgdQueryVo.getUseryy();
			
			useryy=useryy!=null?useryy:new Useryy();
			
			useryy.setId(sysid);
			
			yycgdQueryVo.setUseryy(useryy);
			
		}else if(groupid.equals("4")){
		
		//Useryy useryy=useryyMapper.selectByPrimaryKey(sysid);
		
		Usergys usergys=yycgdQueryVo.getUsergys();
		
		usergys=usergys!=null?usergys:new Usergys();
		
		usergys.setId(sysid);
		
		
		
	}
		yycgdQueryVo.setBusinessyear(year);	
		return yybusinessMapperCuostom.findYybusinessGroupbyYpxxList(yycgdQueryVo);
	}

	@Override
	public int findYybusinessGroupbyYpxxCount(String year, String sysid, String groupid, YycgdQueryVo yycgdQueryVo)
			throws Exception {
yycgdQueryVo=yycgdQueryVo!=null?yycgdQueryVo:new YycgdQueryVo();
		
		
		
		if(groupid.equals("1")||groupid.equals("2")){
			
			Userjd userjd=userjdMapper.selectByPrimaryKey(sysid);
			
			String dq=userjd.getDq();
			
			Useryy useryy=yycgdQueryVo.getUseryy();
			
			useryy=useryy!=null?useryy:new Useryy();
			
			useryy.setDq(dq);
			
			yycgdQueryVo.setUseryy(useryy);
			
		}else if(groupid.equals("3")){
			
			//Useryy useryy=useryyMapper.selectByPrimaryKey(sysid);
			
			Useryy useryy=yycgdQueryVo.getUseryy();
			
			useryy=useryy!=null?useryy:new Useryy();
			
			useryy.setId(sysid);
			
			yycgdQueryVo.setUseryy(useryy);
			
		}else if(groupid.equals("4")){
		
		//Useryy useryy=useryyMapper.selectByPrimaryKey(sysid);
		
		Usergys usergys=yycgdQueryVo.getUsergys();
		
		usergys=usergys!=null?usergys:new Usergys();
		
		usergys.setId(sysid);
		
		
		
	}
		yycgdQueryVo.setBusinessyear(year);
		return yybusinessMapperCuostom.findYybusinessGroupbyYpxxCount(yycgdQueryVo);
	}

}
