package yycg.base.dao.mapper;

import java.util.List;

import yycg.base.pojo.vo.SysuserCustom;
import yycg.base.pojo.vo.SysuserQueryVo;

public interface SysuserMapperCustom {
	public List<SysuserCustom> findSysuserList(SysuserQueryVo sysuserQueryVo)throws Exception;
	public int findSysuserCount(SysuserQueryVo sysuserQueryVo)throws Exception;
}
