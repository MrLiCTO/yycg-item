package yycg.business.dao.mapper;

import java.util.List;

import yycg.business.pojo.vo.YycgdCustom;
import yycg.business.pojo.vo.YycgdQueryVo;
import yycg.business.pojo.vo.YycgdmxCustom;

public interface YycgdMapperCustom {
   public String getYycgdBm(String year)throws Exception;
   public List<YycgdmxCustom> findCgdmxList(YycgdQueryVo yycgdQueryVo)throws Exception;
   public int findCgdmxCount(YycgdQueryVo yycgdQueryVo)throws Exception;
   
   public List<YycgdmxCustom> findAddYycgdmxList(YycgdQueryVo yycgdQueryVo)throws Exception;
   public int findAddYycgdmxCount(YycgdQueryVo yycgdQueryVo)throws Exception;
   
   
   public List<YycgdCustom> findYycgdList(YycgdQueryVo yycgdQueryVo)throws Exception;
   public int findYycgdCount(YycgdQueryVo yycgdQueryVo)throws Exception;


   public List<YycgdmxCustom> findCgdmxListSum(YycgdQueryVo yycgdQueryVo)throws Exception;

}