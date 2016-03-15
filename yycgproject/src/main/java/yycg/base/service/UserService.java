package yycg.base.service;

import java.util.List;

import yycg.base.pojo.po.Sysuser;
import yycg.base.pojo.po.Usergys;
import yycg.base.pojo.po.Userjd;
import yycg.base.pojo.po.Useryy;
import yycg.base.pojo.vo.ActiveUser;
import yycg.base.pojo.vo.SysuserCustom;
import yycg.base.pojo.vo.SysuserQueryVo;

public interface UserService {
	public List<SysuserCustom> findSysuserList(SysuserQueryVo sysuserQueryVo)throws Exception;
	public int findSysuserCount(SysuserQueryVo sysuserQueryVo)throws Exception;
	public void insertSysuser(SysuserCustom sysuserCustom)throws Exception;
	public void updateSysuser(String id,SysuserCustom sysuserCustom)throws Exception;
	
	public Sysuser findSysuserByUserId(String userId)throws Exception;
	public Userjd findUserjdByMc(String mc)throws Exception;
	public Useryy findUseryyByMc(String mc)throws Exception;
	public Usergys findUsergysByMc(String mc)throws Exception;
	//根据用户类型，单位名称必须存在
	public String findSysidBySysmc(String sysmc,String gid)throws Exception;
	public void deleteUser(String id)throws Exception;
	public SysuserCustom findSysuserById(String id)throws Exception;
	String findMcBySysid(String sysid, String gid) throws Exception;
	
	public ActiveUser checkUserInfo(String userId,String pwd)throws Exception;
}
