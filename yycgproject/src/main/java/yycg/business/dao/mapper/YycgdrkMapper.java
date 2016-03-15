package yycg.business.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import yycg.business.pojo.po.Yycgdrk;
import yycg.business.pojo.po.YycgdrkExample;

public interface YycgdrkMapper {
    int countByExample(YycgdrkExample example);

    int deleteByExample(YycgdrkExample example);

    int deleteByPrimaryKey(String id);

    int insert(Yycgdrk record);

    int insertSelective(Yycgdrk record);

    List<Yycgdrk> selectByExample(YycgdrkExample example);

    Yycgdrk selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Yycgdrk record, @Param("example") YycgdrkExample example);

    int updateByExample(@Param("record") Yycgdrk record, @Param("example") YycgdrkExample example);

    int updateByPrimaryKeySelective(Yycgdrk record);

    int updateByPrimaryKey(Yycgdrk record);
}