package yycg.business.service;

import java.util.List;

import yycg.business.pojo.po.Gysypml;
import yycg.business.pojo.po.GysypmlControl;
import yycg.business.pojo.vo.GysypmlCustom;
import yycg.business.pojo.vo.GysypmlQueryVo;

public interface YpmlService {
	public List<GysypmlCustom> findGysypmlList(String usergysId,GysypmlQueryVo gysypmlQueryVo)throws Exception;
	public int findGysypmlCount(String usergysId,GysypmlQueryVo gysypmlQueryVo)throws Exception;
	
	public List<GysypmlCustom> findAddGysypmlList(String usergysId, GysypmlQueryVo gysypmlQueryVo)throws Exception;
	public int findAddGysypmlCount(String usergysId, GysypmlQueryVo gysypmlQueryVo)throws Exception;
	
	public List<GysypmlCustom> findGysypmControlList(GysypmlQueryVo gysypmlQueryVo)throws Exception;
	public int findGysypmControlCount(GysypmlQueryVo gysypmlQueryVo)throws Exception;
	
	public void insertGysypml(String usergysId,String ypxxId)throws Exception;
	public void updateGysypmlControl(String usergysId,String ypxxId,String control,String advice)throws Exception;
	public void deleteGysypml(String usergysId,String ypxxId)throws Exception;
	
	// 根据供货商id和药品id查询供货商药品目录控制表记录
	public GysypmlControl findGysypmlControlByUsergysidAndYpxxid(String usergysId,String ypxxId) throws Exception;
	// 根据供货商id和药品id查询供货商药品目录控制表记录
	public Gysypml findGysypmlByUsergysidAndYpxxid(String usergysId,String ypxxId) throws Exception;
}
