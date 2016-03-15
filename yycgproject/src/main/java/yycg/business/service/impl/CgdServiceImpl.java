package yycg.business.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import yycg.base.dao.mapper.UserjdMapper;
import yycg.base.dao.mapper.UseryyMapper;
import yycg.base.pojo.po.Dictinfo;
import yycg.base.pojo.po.Userjd;
import yycg.base.pojo.po.Useryy;
import yycg.base.process.context.Config;
import yycg.base.process.result.ResultUtil;
import yycg.base.service.SystemConfigService;
import yycg.business.dao.mapper.YpxxMapper;
import yycg.business.dao.mapper.YybusinessMapper;
import yycg.business.dao.mapper.YycgdMapper;
import yycg.business.dao.mapper.YycgdMapperCustom;
import yycg.business.dao.mapper.YycgdmxMapper;
import yycg.business.dao.mapper.YycgdrkMapper;
import yycg.business.pojo.po.Ypxx;
import yycg.business.pojo.po.Yybusiness;
import yycg.business.pojo.po.Yycgd;
import yycg.business.pojo.po.YycgdExample;
import yycg.business.pojo.po.Yycgdmx;
import yycg.business.pojo.po.YycgdmxExample;
import yycg.business.pojo.po.Yycgdrk;
import yycg.business.pojo.vo.YycgdCustom;
import yycg.business.pojo.vo.YycgdQueryVo;
import yycg.business.pojo.vo.YycgdmxCustom;
import yycg.business.pojo.vo.YycgdrkCustom;
import yycg.business.service.CgdService;
import yycg.util.MyUtil;
import yycg.util.UUIDBuild;

public class CgdServiceImpl implements CgdService{
	@Autowired
	private YycgdMapper yycgdMapper;
	@Autowired
	private YycgdmxMapper yycgdmxMapper;
	@Autowired
	private YycgdrkMapper yycgdrkMapper;
	@Autowired
	private UseryyMapper useryyMapper;
	@Autowired
	private YpxxMapper ypxxMapper;
	@Autowired
	private UserjdMapper userjdMapper;
	@Autowired
	private YybusinessMapper yybusinessMapper;
	@Autowired
	private YycgdMapperCustom yycgdMapperCustom;
	
	@Autowired
	private SystemConfigService systemConfigService;
	@Override
	public String insertYycgd(String useryyid, String year, YycgdCustom yycgdCustom) throws Exception {
		String bm=yycgdMapperCustom.getYycgdBm(year);
		
		yycgdCustom.setId(bm);
		
		
		yycgdCustom.setBm(bm);
				
		yycgdCustom.setUseryyid(useryyid);
		
		yycgdCustom.setCjtime(new Date());
		
		yycgdCustom.setZt("1");
		
		yycgdCustom.setBusinessyear(year);
		
		yycgdMapper.insert(yycgdCustom);
		
		return bm;
	}
	@Override
	public YycgdCustom findYycgdById(String id) throws Exception {
		YycgdExample yycgdExample=new YycgdExample();
		
		String year=id.substring(0,4);
		
		yycgdExample.setBusinessyear(year);
		
		YycgdExample.Criteria ct=yycgdExample.createCriteria();
		
		ct.andIdEqualTo(id);
		
		List<Yycgd> list=yycgdMapper.selectByExample(yycgdExample);
		
		Yycgd yycgd=null;
		YycgdCustom yycgdCustom=new YycgdCustom();
		if(list!=null&&list.size()==1){
			yycgd=list.get(0);

			BeanUtils.copyProperties(yycgd, yycgdCustom);
		}else{
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,501,null));
		}
		
		String zt=yycgd.getZt();
		
		Dictinfo dictinfo=systemConfigService.findDictinfoByDictcode("010",zt);
		
		yycgdCustom.setYycgdztmc(dictinfo.getInfo());
		
		return yycgdCustom;
	}
	@Override
	public void updateYycgd(String id,YycgdCustom yycgdCustom) throws Exception {
		YycgdCustom yycgdCus=this.findYycgdById(id);
		
		String year=id.substring(0,4);
		
		yycgdCus.setLxr(yycgdCustom.getLxr());
		
		yycgdCus.setLxdh(yycgdCustom.getLxdh());
		
		yycgdCus.setBz(yycgdCustom.getBz());
		
		yycgdCus.setBusinessyear(year);
		
		yycgdMapper.updateByPrimaryKey(yycgdCus);
	}
	@Override
	public List<YycgdmxCustom> findCgdmxListByYycgdid(String yycgdid, YycgdQueryVo yycgdQueryVo) throws Exception {
		yycgdQueryVo=yycgdQueryVo!=null?yycgdQueryVo:new YycgdQueryVo();
		YycgdmxCustom yycgdmxCustom=yycgdQueryVo.getYycgdmxCustom();
		String year=yycgdid.substring(0,4);
		if(yycgdmxCustom==null){
			yycgdmxCustom=new YycgdmxCustom();
		}
		
		yycgdmxCustom.setYycgdid(yycgdid);
		
		yycgdQueryVo.setBusinessyear(year);
		
		yycgdQueryVo.setYycgdmxCustom(yycgdmxCustom);
		
		return yycgdMapperCustom.findCgdmxList(yycgdQueryVo);
	}
	@Override
	public int findCgdmxCountByYycgdid(String yycgdid, YycgdQueryVo yycgdQueryVo) throws Exception {
		YycgdmxCustom yycgdmxCustom=(yycgdQueryVo!=null?yycgdQueryVo:new YycgdQueryVo()).getYycgdmxCustom();
		String year=yycgdid.substring(0,4);
		if(yycgdmxCustom==null){
			yycgdmxCustom=new YycgdmxCustom();
		}

		yycgdmxCustom.setYycgdid(yycgdid);

		yycgdQueryVo.setBusinessyear(year);
		
		yycgdQueryVo.setYycgdmxCustom(yycgdmxCustom);
		
		return yycgdMapperCustom.findCgdmxCount(yycgdQueryVo);
	}
	@Override
	public List<YycgdmxCustom> findAddYycgdmxList(String useryyid, String yycgdid, YycgdQueryVo yycgdQueryVo)
			throws Exception {
		Useryy useryy=useryyMapper.selectByPrimaryKey(useryyid);
		
		String dq=useryy.getDq();
		
		yycgdQueryVo=yycgdQueryVo!=null?yycgdQueryVo:new YycgdQueryVo();
		
		Useryy useryy_l=yycgdQueryVo.getUseryy();
		
		if(useryy_l==null){
			useryy_l=new Useryy();
		}
		
		useryy_l.setDq(dq);
		YycgdCustom yycgdCustom=yycgdQueryVo.getYycgdCustom();
		
		if(yycgdCustom==null){
			yycgdCustom=new YycgdCustom();
		}
		
		String year=yycgdid.substring(0,4);
		
		yycgdCustom.setId(yycgdid);
		
		yycgdCustom.setBusinessyear(year);
		
		yycgdQueryVo.setUseryy(useryy_l);
		
		yycgdQueryVo.setYycgdCustom(yycgdCustom);
		
		yycgdQueryVo.setBusinessyear(year);
		
		return yycgdMapperCustom.findAddYycgdmxList(yycgdQueryVo);
	}
	@Override
	public int findAddYycgdmxCount(String useryyid, String yycgdid, YycgdQueryVo yycgdQueryVo) throws Exception {
		
		Useryy useryy=useryyMapper.selectByPrimaryKey(useryyid);
		
		String dq=useryy.getDq();
		
		yycgdQueryVo=yycgdQueryVo!=null?yycgdQueryVo:new YycgdQueryVo();
		
		Useryy useryy_l=yycgdQueryVo.getUseryy();
		
		if(useryy_l==null){
			useryy_l=new Useryy();
		}
		
		useryy_l.setDq(dq);
		YycgdCustom yycgdCustom=yycgdQueryVo.getYycgdCustom();
		
		if(yycgdCustom==null){
			yycgdCustom=new YycgdCustom();
		}
		
		String year=yycgdid.substring(0,4);
		
		yycgdCustom.setId(yycgdid);
		
		yycgdQueryVo.setUseryy(useryy_l);
		
		yycgdQueryVo.setYycgdCustom(yycgdCustom);
		
		yycgdQueryVo.setBusinessyear(year);
		
		return yycgdMapperCustom.findAddYycgdmxCount(yycgdQueryVo);
	}
	@Override
	public void insertYycgdmx(String yycgdid, String ypxxid, String usergysid) throws Exception {
		
		Ypxx ypxx=ypxxMapper.selectByPrimaryKey(ypxxid);
		
		if(ypxx==null){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,316,null));
		}
		
		Yycgdmx yycgdmx_l=this.findYycgdmxByYycgdidAndYpxxid(yycgdid, ypxxid);
		
		if(yycgdmx_l!=null){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,508,null));
		}
		
		Yycgdmx yycgdmx=new Yycgdmx();
		String year=yycgdid.substring(0,4);
		yycgdmx.setBusinessyear(year);
		
		yycgdmx.setId(UUIDBuild.getUUID());
		yycgdmx.setYpxxid(ypxxid);
		yycgdmx.setYycgdid(yycgdid);
		yycgdmx.setUsergysid(usergysid);
		yycgdmx.setZbjg(ypxx.getZbjg());
		yycgdmx.setJyjg(ypxx.getZbjg());
		yycgdmx.setCgzt("1");
		yycgdmxMapper.insert(yycgdmx);
	}
	@Override
	public Yycgdmx findYycgdmxByYycgdidAndYpxxid(String yycgdid, String ypxxid) throws Exception {
		
		YycgdmxExample yycgdmxExample=new YycgdmxExample();
		
		YycgdmxExample.Criteria ct=yycgdmxExample.createCriteria();
		
		ct.andYycgdidEqualTo(yycgdid);
		
		ct.andYpxxidEqualTo(ypxxid);
		
		String year=yycgdid.substring(0,4);
		
		yycgdmxExample.setBusinessyear(year);
		
		List<Yycgdmx> list=yycgdmxMapper.selectByExample(yycgdmxExample);
		
		if(list!=null&&list.size()==1){
			return list.get(0);
		}
		
		return null;
	}
	@Override
	public void updateYycgdmx(String yycgdid, String ypxxid, Integer cgl) throws Exception {
		Yycgdmx yycgdmx=findYycgdmxByYycgdidAndYpxxid(yycgdid, ypxxid);
		String year=yycgdid.substring(0, 4);
		if(yycgdmx==null){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,509,null));
		}
		
		if(cgl<=0){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,903,null));
		}
		yycgdmx.setCgl(cgl);
		yycgdmx.setCgje(yycgdmx.getJyjg()*cgl);
		yycgdmx.setBusinessyear(year);
		yycgdmxMapper.updateByPrimaryKey(yycgdmx);
	}
	@Override
	public List<YycgdCustom> findYycgdList(String year,String useryyid, YycgdQueryVo yycgdQueryVo) throws Exception {
		
		yycgdQueryVo=yycgdQueryVo!=null?yycgdQueryVo:new YycgdQueryVo();
		
		Useryy useryy=yycgdQueryVo.getUseryy();
		
		if(useryy==null){
			useryy=new Useryy();
		}
		
		useryy.setId(useryyid);
		
		yycgdQueryVo.setUseryy(useryy);
		
		yycgdQueryVo.setBusinessyear(year);
		
		return yycgdMapperCustom.findYycgdList(yycgdQueryVo);
	}
	@Override
	public int findYycgdCount(String year, String useryyid,YycgdQueryVo yycgdQueryVo) throws Exception {
		//yycgdQueryVo=yycgdQueryVo!=null?yycgdQueryVo:new YycgdQueryVo();
		yycgdQueryVo = yycgdQueryVo != null ? yycgdQueryVo : new YycgdQueryVo();
		Useryy useryy=yycgdQueryVo.getUseryy();
		
		if(useryy==null){
			useryy=new Useryy();
		}
		
		useryy.setId(useryyid);
		
		yycgdQueryVo.setUseryy(useryy);
		
		yycgdQueryVo.setBusinessyear(year);
		
		return yycgdMapperCustom.findYycgdCount(yycgdQueryVo);
	}
	@Override
	public void saveYycgdSubmitStatus(String yycgdid) throws Exception {
		Yycgd yycgd=this.findYycgdById(yycgdid);
		
		if(yycgd==null){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,501,null));
		}
		
		String status=yycgd.getZt();
		
		if(!status.equals("1")&&!status.equals("4")){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,502,null));
		}
		
		List<YycgdmxCustom> yycgdList= this.findCgdmxListByYycgdid(yycgdid,null);
		
		if(yycgdList==null||yycgdList.size()==0){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,504,null));
		}
		
		for(YycgdmxCustom yycgdmx:yycgdList){
			Integer cgl = yycgdmx.getCgl();
			Float cgje = yycgdmx.getCgje();
			if(cgl==null||cgje==null){
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,505,null));
			}
			
		}
		
		Yycgd yycgd_update=new Yycgd();
		
		yycgd_update.setId(yycgdid);
		
		yycgd_update.setZt("2");
		
		yycgd_update.setBusinessyear(yycgdid.substring(0,4)); 
		
		yycgd_update.setTjtime(MyUtil.getNowDate());
		
		yycgdMapper.updateByPrimaryKeySelective(yycgd_update);
	}
	@Override
	public List<YycgdCustom> findCheckYycgdList(String year, String userjdid,YycgdQueryVo yycgdQueryVo) throws Exception {
		yycgdQueryVo=yycgdQueryVo!=null?yycgdQueryVo:new YycgdQueryVo();
		
		String zt="2";
		
		yycgdQueryVo.setBusinessyear(year);
		
		YycgdCustom yycgdCustom=yycgdQueryVo.getYycgdCustom();
		
		if(yycgdCustom==null){
			yycgdCustom=new YycgdCustom();
		}
		
		yycgdCustom.setZt(zt);
		
		yycgdQueryVo.setYycgdCustom(yycgdCustom);
		
		Userjd userjd=userjdMapper.selectByPrimaryKey(userjdid);
		
		if(userjd==null){
			
		}
		
		String dq=userjd.getDq();
		
		Useryy useryy=yycgdQueryVo.getUseryy();
		
		
		if(useryy==null){
			useryy=new Useryy();
		}
		
		useryy.setDq(dq);
		
		yycgdQueryVo.setUseryy(useryy);
		
		return yycgdMapperCustom.findYycgdList(yycgdQueryVo);
	}
	@Override
	public int findCheckYycgdCount(String year, String userjdid, YycgdQueryVo yycgdQueryVo)
			throws Exception {
	yycgdQueryVo=yycgdQueryVo!=null?yycgdQueryVo:new YycgdQueryVo();
		
		String zt="2";
		
		yycgdQueryVo.setBusinessyear(year);
		
		YycgdCustom yycgdCustom=yycgdQueryVo.getYycgdCustom();
		
		if(yycgdCustom==null){
			yycgdCustom=new YycgdCustom();
		}
		
		yycgdCustom.setZt(zt);
		
		yycgdQueryVo.setYycgdCustom(yycgdCustom);
		
		Userjd userjd=userjdMapper.selectByPrimaryKey(userjdid);
		
		if(userjd==null){
			//有疑问
		}
		
		String dq=userjd.getDq();
		
		Useryy useryy=yycgdQueryVo.getUseryy();
		
		
		if(useryy==null){
			useryy=new Useryy();
		}
		
		useryy.setDq(dq);
		
		yycgdQueryVo.setUseryy(useryy);
		
		return yycgdMapperCustom.findYycgdCount(yycgdQueryVo);
	}
	@Override
	public void saveYycgdCheckStatus(String yycgdid, YycgdCustom yycgdCustom) throws Exception {
		
		Yycgd yycgd=this.findYycgdById(yycgdid);
		
		if(yycgd==null){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,501,null));
		}
		
		String zt=yycgd.getZt();
		
		if(!"2".equals(zt)){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,514,null));
		}
		
		if(yycgdCustom==null||yycgdCustom.getZt()==null||(yycgdCustom.getZt()!=null&&!yycgdCustom.getZt().equals("3")&&!yycgdCustom.getZt().equals("4"))){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,513,null));
			
		}
		
		Yycgd yycgd_update=new Yycgd();
		
		yycgd_update.setBusinessyear(yycgdid.substring(0, 4));
		
		yycgd_update.setId(yycgdid);
		
		yycgd_update.setZt(yycgdCustom.getZt());
		
		yycgd_update.setXgtime(new Date());
		
		String shyj=yycgdCustom.getShyj();
		
		yycgd_update.setShyj(shyj);
		
		yycgdMapper.updateByPrimaryKeySelective(yycgd_update);
		
		if(yycgdCustom.getZt().equals("3")){
			List<YycgdmxCustom> yycgdmxList=this.findCgdmxListByYycgdid(yycgdid, null);
			
			for(YycgdmxCustom yd:yycgdmxList){
				Yybusiness yybusiness=new Yybusiness();
				
				yybusiness.setId(UUIDBuild.getUUID());
				
				yybusiness.setYycgdid(yycgdid);
				
				
				yybusiness.setUseryyid(yd.getUseryyid());
				
				yybusiness.setYpxxid(yd.getId());
				
				yybusiness.setZbjg(yd.getZbjg());//中标价格
				yybusiness.setJyjg(yd.getJyjg());//交易价格
				yybusiness.setCgl(yd.getCgl());//采购量
				yybusiness.setCgje(yd.getCgje());//采购金额
				yybusiness.setCgzt(yd.getCgzt());//采购状态
				yybusiness.setUsergysid(yd.getUsergysid());//供货商
				
				yybusiness.setBusinessyear(yycgdid.substring(0, 4));
				
				yybusinessMapper.insert(yybusiness);
				
			}
			
		}
		
	}
	@Override
	public List<YycgdmxCustom> findDisposeYycgdList(String usergysid, String year, YycgdQueryVo yycgdQueryVo)
			throws Exception {
		
		yycgdQueryVo=yycgdQueryVo!=null?yycgdQueryVo:new YycgdQueryVo();
		
		YycgdmxCustom yycgdmxCustom = yycgdQueryVo.getYycgdmxCustom();
		
		yycgdmxCustom=yycgdmxCustom!=null?yycgdmxCustom:new YycgdmxCustom();
		
		yycgdmxCustom.setUsergysid(usergysid);
		
		String cgzt="1";
		
		yycgdmxCustom.setCgzt(cgzt);
		
		yycgdQueryVo.setYycgdmxCustom(yycgdmxCustom);
		
	
		
		String zt="3";
		
		YycgdCustom yycgdCustom=yycgdQueryVo.getYycgdCustom();
		
		yycgdCustom=yycgdCustom!=null?yycgdCustom:new YycgdCustom();
		
		yycgdCustom.setZt(zt);
		
		yycgdQueryVo.setYycgdCustom(yycgdCustom);
		
		
		yycgdQueryVo.setBusinessyear(year);
		
		return yycgdMapperCustom.findCgdmxList(yycgdQueryVo);
	}
	@Override
	public int findDisposeYycgdCount(String usergysid, String year, YycgdQueryVo yycgdQueryVo) throws Exception {
		yycgdQueryVo=yycgdQueryVo!=null?yycgdQueryVo:new YycgdQueryVo();
		
		YycgdmxCustom yycgdmxCustom = yycgdQueryVo.getYycgdmxCustom();
		
		yycgdmxCustom=yycgdmxCustom!=null?yycgdmxCustom:new YycgdmxCustom();
		
		yycgdmxCustom.setUsergysid(usergysid);
		
		String cgzt="1";
		
		yycgdmxCustom.setCgzt(cgzt);
		
		yycgdQueryVo.setYycgdmxCustom(yycgdmxCustom);
		
	
		
		String zt="3";
		
		YycgdCustom yycgdCustom=yycgdQueryVo.getYycgdCustom();
		
		yycgdCustom=yycgdCustom!=null?yycgdCustom:new YycgdCustom();
		
		yycgdCustom.setZt(zt);
		
		yycgdQueryVo.setYycgdCustom(yycgdCustom);
		
		
		yycgdQueryVo.setBusinessyear(year);
		return yycgdMapperCustom.findCgdmxCount(yycgdQueryVo);
	}
	@Override
	public void saveSendStatus(String yycgdid, String ypxxid) throws Exception {
		Yycgdmx yycgdmx=this.findYycgdmxByYycgdidAndYpxxid(yycgdid, ypxxid);
		
		if(yycgdmx==null){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,501,null));
		}
		
		String cgzt=yycgdmx.getCgzt();
		
		if(!"1".equals(cgzt)){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,527,null));
		}
		
		yycgdmx.setCgzt("2");
		
		
		yycgdmx.setBusinessyear(yycgdid.substring(0, 4));
		
		
		yycgdmxMapper.updateByPrimaryKey(yycgdmx);
		
	}
	@Override
	public List<YycgdmxCustom> findYycgdReceivceList(String useryyid, String year, YycgdQueryVo yycgdQueryVo)
			throws Exception {
		yycgdQueryVo=yycgdQueryVo!=null?yycgdQueryVo:new YycgdQueryVo();
		
		YycgdCustom yycgdCustom = yycgdQueryVo.getYycgdCustom();
		
		yycgdCustom=yycgdCustom!=null?yycgdCustom:new YycgdCustom();
		
		yycgdCustom.setUseryyid(useryyid);
		
		yycgdQueryVo.setYycgdCustom(yycgdCustom);
		
		YycgdmxCustom yycgdmxCustom = yycgdQueryVo.getYycgdmxCustom();
		
		yycgdmxCustom=yycgdmxCustom!=null?yycgdmxCustom:new YycgdmxCustom();
		
		yycgdmxCustom.setCgzt("2");
		
		yycgdQueryVo.setYycgdmxCustom(yycgdmxCustom);
		
		yycgdQueryVo.setBusinessyear("2014");
		
		return yycgdMapperCustom.findCgdmxList(yycgdQueryVo);
	}
	@Override
	public int findYycgdReceivceCount(String useryyid, String year, YycgdQueryVo yycgdQueryVo) throws Exception {
	yycgdQueryVo=yycgdQueryVo!=null?yycgdQueryVo:new YycgdQueryVo();
		
		YycgdCustom yycgdCustom = yycgdQueryVo.getYycgdCustom();
		
		yycgdCustom=yycgdCustom!=null?yycgdCustom:new YycgdCustom();
		
		yycgdCustom.setUseryyid(useryyid);
		
		yycgdQueryVo.setYycgdCustom(yycgdCustom);
		
		YycgdmxCustom yycgdmxCustom = yycgdQueryVo.getYycgdmxCustom();
		
		yycgdmxCustom=yycgdmxCustom!=null?yycgdmxCustom:new YycgdmxCustom();
		
		yycgdmxCustom.setCgzt("2");
		
		yycgdQueryVo.setYycgdmxCustom(yycgdmxCustom);
		
		yycgdQueryVo.setBusinessyear(year);
		
		return yycgdMapperCustom.findCgdmxCount(yycgdQueryVo);
	}
	@Override
	public void saveYycgdrk(String yycgdid, String ypxxid, YycgdrkCustom yycgdrkCustom) throws Exception {
		Yycgdmx yycgdmx=this.findYycgdmxByYycgdidAndYpxxid(yycgdid, ypxxid);
		
		if(yycgdmx==null){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,402,null));
		}
		
		String cgzt=yycgdmx.getCgzt();
		
		if(!"2".equals(cgzt)){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,520,null));
		}
		
		int cgl=yycgdmx.getCgl();
		
		int rkl=yycgdrkCustom.getRkl();
		
		if(rkl>cgl){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,519,null));
		}
		
		yycgdmx.setCgzt("3");
		
		yycgdmx.setBusinessyear(yycgdid.substring(0, 4));
		
		yycgdmxMapper.updateByPrimaryKey(yycgdmx);
		
		Yycgdrk yycgdrk=new Yycgdrk();
		
		BeanUtils.copyProperties(yycgdrkCustom, yycgdrk); 
		
		yycgdrk.setId(UUIDBuild.getUUID());
		
		yycgdrk.setYycgdid(yycgdid);
		
		yycgdrk.setYpxxid(ypxxid);
		
		yycgdrk.setRktime(MyUtil.getNowDate());
		
		yycgdrk.setBusinessyear(yycgdid.substring(0, 4));
		
		yycgdrk.setCgzt("3");
		
		yycgdrk.setRkje(rkl*yycgdmx.getJyjg());
		
		yycgdrkMapper.insert(yycgdrk);
	}
	@Override
	public List<YycgdmxCustom> findAddYycgdmxListSum(String yycgdid, YycgdQueryVo yycgdQueryVo) throws Exception {
		
		yycgdQueryVo=yycgdQueryVo!=null?yycgdQueryVo:new YycgdQueryVo();
		
		YycgdmxCustom yycgdmxCustom=yycgdQueryVo.getYycgdmxCustom();
		
		yycgdmxCustom=yycgdmxCustom!=null?yycgdmxCustom:new YycgdmxCustom();
		
		yycgdmxCustom.setYycgdid(yycgdid);
		
		yycgdQueryVo.setBusinessyear(yycgdid.substring(0, 4));
		
		yycgdQueryVo.setYycgdmxCustom(yycgdmxCustom);
		
		return yycgdMapperCustom.findCgdmxListSum(yycgdQueryVo);
	}


	
	
}
