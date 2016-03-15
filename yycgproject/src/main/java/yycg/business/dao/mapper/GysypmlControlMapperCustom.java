package yycg.business.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import yycg.business.pojo.po.GysypmlControl;
import yycg.business.pojo.po.GysypmlControlExample;
import yycg.business.pojo.vo.GysypmlCustom;
import yycg.business.pojo.vo.GysypmlQueryVo;

public interface GysypmlControlMapperCustom {
	public List<GysypmlCustom> findGysypmControlList(GysypmlQueryVo gysypmlQueryVo)throws Exception;
	public int findGysypmControlCount(GysypmlQueryVo gysypmlQueryVo)throws Exception;
}