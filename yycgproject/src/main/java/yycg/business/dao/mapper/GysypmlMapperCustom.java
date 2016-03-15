package yycg.business.dao.mapper;

import java.util.List;

import yycg.business.pojo.vo.GysypmlCustom;
import yycg.business.pojo.vo.GysypmlQueryVo;

public interface GysypmlMapperCustom {
	public List<GysypmlCustom> findGysypmlList(GysypmlQueryVo gysypmlQueryVo)throws Exception;
	public int findGysypmlCount(GysypmlQueryVo gysypmlQueryVo)throws Exception;
	
	public List<GysypmlCustom> findAddGysypmlList(GysypmlQueryVo gysypmlQueryVo)throws Exception;
	public int findAddGysypmlCount(GysypmlQueryVo gysypmlQueryVo)throws Exception;
}
