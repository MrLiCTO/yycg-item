package yycg.base.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import yycg.base.dao.mapper.SysuserMapper;
import yycg.base.dao.mapper.SysuserMapperCustom;
import yycg.base.dao.mapper.UsergysMapper;
import yycg.base.dao.mapper.UserjdMapper;
import yycg.base.dao.mapper.UseryyMapper;
import yycg.base.pojo.po.Sysuser;
import yycg.base.pojo.po.SysuserExample;
import yycg.base.pojo.po.Usergys;
import yycg.base.pojo.po.UsergysExample;
import yycg.base.pojo.po.Userjd;
import yycg.base.pojo.po.UserjdExample;
import yycg.base.pojo.po.Useryy;
import yycg.base.pojo.po.UseryyExample;
import yycg.base.pojo.vo.ActiveUser;
import yycg.base.pojo.vo.SysuserCustom;
import yycg.base.pojo.vo.SysuserQueryVo;
import yycg.base.process.context.Config;
import yycg.base.process.result.ExceptionResultInfo;
import yycg.base.process.result.ResultInfo;
import yycg.base.process.result.ResultUtil;
import yycg.base.service.UserService;
import yycg.util.MD5;
import yycg.util.ResourcesUtil;
import yycg.util.UUIDBuild;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private SysuserMapperCustom sysuserMapperCustom;
	@Autowired
	private SysuserMapper sysuserMapper;
	@Autowired
	private UserjdMapper userjdMapper;
	@Autowired
	private UseryyMapper useryyMapper;
	@Autowired
	private UsergysMapper usergysMapper;

	@Override
	public List<SysuserCustom> findSysuserList(SysuserQueryVo sysuserQueryVo) throws Exception {
		return sysuserMapperCustom.findSysuserList(sysuserQueryVo);
	}

	@Override
	public int findSysuserCount(SysuserQueryVo sysuserQueryVo) throws Exception {
		return sysuserMapperCustom.findSysuserCount(sysuserQueryVo);
	}
	@Override
	public Sysuser findSysuserByUserId(String userId)throws Exception{
		SysuserExample se=new SysuserExample();
		
		SysuserExample.Criteria sec=se.createCriteria();
		
		sec.andUseridEqualTo(userId);
		
		List<Sysuser> users=sysuserMapper.selectByExample(se);
		
		if(users!=null&&users.size()==1){
			return users.get(0);
		}
		
		return null;
	}
	
	@Override
	public Userjd findUserjdByMc(String mc)throws Exception{
		
		UserjdExample ue=new UserjdExample();
		
		UserjdExample.Criteria uec=ue.createCriteria();
		
		uec.andMcEqualTo(mc);
		
		List<Userjd> userjds=userjdMapper.selectByExample(ue);
		
		
		if(userjds!=null&&userjds.size()==1){
			return userjds.get(0);
		}
		
		
		return null;
		
	}
	@Override
	public Useryy findUseryyByMc(String mc)throws Exception{
		
		UseryyExample ue=new UseryyExample();
		
		UseryyExample.Criteria uec=ue.createCriteria();
		
		uec.andMcEqualTo(mc);
		
		List<Useryy> useryys=useryyMapper.selectByExample(ue);
		
		
		if(useryys!=null&&useryys.size()==1){
			return useryys.get(0);
		}
		
		
		return null;
		
	}
	@Override
	public Usergys findUsergysByMc(String mc)throws Exception{
		
		UsergysExample ue=new UsergysExample();
		
		UsergysExample.Criteria uec=ue.createCriteria();
		
		uec.andMcEqualTo(mc);
		
		List<Usergys> usergyss=usergysMapper.selectByExample(ue);
		
		
		if(usergyss!=null&&usergyss.size()==1){
			return usergyss.get(0);
		}
		
		
		return null;
		
	}
	
	@Override
	public void insertSysuser(SysuserCustom sysuserCustom) throws Exception {
		//参数的合法性教研
		//非空，长度，等
		
		//业务合法性校验
		//账号是否唯一
		Sysuser user=findSysuserByUserId(sysuserCustom.getUserid());
		
		if(user!=null){
			//使用系统自定义异常类
//			ResultInfo resultInfo = new ResultInfo();
//			resultInfo.setType(ResultInfo.TYPE_RESULT_FAIL);
//			//resultInfo.setMessage("账号重复");
//			resultInfo.setMessage(ResourcesUtil.getValue("resources.messages","208")); 
			//throw new ExceptionResultInfo(resultInfo);
//			ResultInfo resultInfo = ResultUtil.createFail("resources.messages",208,null);
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,208,null));
		}
		
		//根据用户类型，单位名称必须存在
		
		String gid=sysuserCustom.getGroupid();
		String sysmc=sysuserCustom.getSysmc();
		String sysid=this.findSysidBySysmc(sysmc, gid);
//		
//		if(gid.equals("1")||gid.equals("2")){
//			Userjd userjd=this.findUserjdByMc(sysmc);
//			if(userjd==null){
//				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,217,null));
//			}
//			sysid=userjd.getId();
//		}else if(gid.equals("3")){
//			Useryy useryy=this.findUseryyByMc(sysmc);
//			if(useryy==null){
//				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,217,null));
//			}
//			sysid=useryy.getId();
//		}else if(gid.equals("4")){
//			Usergys usergys=this.findUsergysByMc(sysmc);
//			if(usergys==null){
//				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,217,null));
//			}
//			sysid=usergys.getId();
//		}
		
		sysuserCustom.setId(UUIDBuild.getUUID());
		sysuserCustom.setSysid(sysid);
		sysuserCustom.setPwd(new MD5().getMD5ofStr(sysuserCustom.getPwd()));
		sysuserMapper.insert(sysuserCustom);
		
	
	}

	@Override
	public void deleteUser(String id) throws Exception {
		
		//校验用户是否存在
		if(this.sysuserMapper.selectByPrimaryKey(id)==null){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,212,null)); 
		}
		
		
		this.sysuserMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void updateSysuser(String id, SysuserCustom sysuserCustom) throws Exception {
		//校验
		
		//非空校验
		
		
		//修改用户账号不允许暂用别人的账号
		//页面提交的账号可能是用户修改的账号
		String userid_page=sysuserCustom.getUserid();
		
		
		Sysuser sysuser=sysuserMapper.selectByPrimaryKey(id);
		
		if(sysuser==null){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,215,null)); 
		}
		//数据库中的原有账号
		String userid=sysuser.getUserid();
		
		if(!userid.equals(userid_page)){
			Sysuser sysuser_1=this.findSysuserByUserId(userid_page);
			
			if(sysuser_1!=null){
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,213,null));
			}
		}
				
				//根据用户类型，单位名称必须存在
//				
//				String gid=sysuserCustom.getGroupid();
//				String sysid=null;
//				String sysmc=sysuserCustom.getSysmc();
//				
//				if(gid.equals("1")||gid.equals("2")){
//					Userjd userjd=this.findUserjdByMc(sysmc);
//					if(userjd==null){
//						ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,217,null));
//					}
//					sysid=userjd.getId();
//				}else if(gid.equals("3")){
//					Useryy useryy=this.findUseryyByMc(sysmc);
//					if(useryy==null){
//						ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,217,null));
//					}
//					sysid=useryy.getId();
//				}else if(gid.equals("4")){
//					Usergys usergys=this.findUsergysByMc(sysmc);
//					if(usergys==null){
//						ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,217,null));
//					}
//					sysid=usergys.getId();
//				}
				
		
				String gid=sysuserCustom.getGroupid();
				String sysmc=sysuserCustom.getSysmc();
				String sysid=this.findSysidBySysmc(sysmc, gid);
		
		
		
				String pwd=sysuserCustom.getPwd();
				String pwd_md5=null;
				if(pwd!=null&&pwd!=""){
					pwd_md5=new MD5().getMD5ofStr(pwd);
					
				}
				
				Sysuser sysuser_update=sysuserMapper.selectByPrimaryKey(id);
				
				sysuser_update.setUserid(sysuserCustom.getUserid());
				sysuser_update.setUsername(sysuserCustom.getUsername());
				sysuser_update.setUserstate(sysuserCustom.getUserstate());
				sysuser_update.setGroupid(sysuserCustom.getGroupid());
				sysuser_update.setSysid(sysid);
				if(pwd_md5!=null){
					sysuser_update.setPwd(pwd_md5);
				}
				
				
				sysuserMapper.updateByPrimaryKey(sysuser_update);
				
	}

	@Override
	public SysuserCustom findSysuserById(String id) throws Exception {
		
		Sysuser user=sysuserMapper.selectByPrimaryKey(id);
		
		String gid=user.getGroupid();
		String sysid=user.getSysid();
		String sysmc=this.findMcBySysid(sysid, gid);
		
		SysuserCustom sysuserCustom=new SysuserCustom();
		
		sysuserCustom.setSysmc(sysmc);
		
		BeanUtils.copyProperties(user, sysuserCustom);
		
		return sysuserCustom;
	}

	//根据用户类型，单位名称必须存在
	@Override
	public String findSysidBySysmc(String sysmc,String gid) throws Exception{
		
		String sysid=null;
		
		
		if(gid.equals("1")||gid.equals("2")){
			Userjd userjd=this.findUserjdByMc(sysmc);
			if(userjd==null){
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,217,null));
			}
			sysid=userjd.getId();
		}else if(gid.equals("3")){
			Useryy useryy=this.findUseryyByMc(sysmc);
			if(useryy==null){
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,217,null));
			}
			sysid=useryy.getId();
		}else if(gid.equals("4")){
			Usergys usergys=this.findUsergysByMc(sysmc);
			if(usergys==null){
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,217,null));
			}
			sysid=usergys.getId();
		}
		return sysid;
	}
	
	
	//根据用户类型，单位sysid查询名称
		@Override
		public String findMcBySysid(String sysid,String gid) throws Exception{
			
			String sysmc=null;
			
			
			if(gid.equals("1")||gid.equals("2")){
				Userjd userjd=userjdMapper.selectByPrimaryKey(sysid);
				if(userjd==null){
					ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,217,null));
				}
				sysmc=userjd.getMc();
			}else if(gid.equals("3")){
				Useryy useryy=useryyMapper.selectByPrimaryKey(sysid);
				if(useryy==null){
					ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,217,null));
				}
				sysmc=useryy.getMc();
			}else if(gid.equals("4")){
				Usergys usergys=usergysMapper.selectByPrimaryKey(sysid);
				if(usergys==null){
					ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,217,null));
				}
				sysmc=usergys.getMc();
			}
			return sysmc;
		}

		@Override
		public ActiveUser checkUserInfo(String userId, String pwd) throws Exception {
			
			Sysuser user=this.findSysuserByUserId(userId);
			
			if(user==null){
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,101,null));
			}
			
			String pwd_md5=user.getPwd();
			
			String pwd_page=new MD5().getMD5ofStr(pwd);
			
			if(!pwd_md5.equalsIgnoreCase(pwd_page)){
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,114,null));
			}
			
			ActiveUser activeUser=new ActiveUser();
			
			activeUser.setGroupid(user.getGroupid());
			activeUser.setSysid(user.getSysid());
			activeUser.setSysmc(this.findMcBySysid(user.getSysid(),user.getGroupid()));
			activeUser.setUserid(user.getUserid());
			activeUser.setUsername(user.getUsername());
			
			
			return activeUser;
		}
	
}
