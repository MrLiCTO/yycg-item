package yycg.business.dao.mapper;

import java.util.List;

import yycg.business.pojo.vo.YpxxCustom;
import yycg.business.pojo.vo.YpxxQueryVo;

public interface YpxxMapperCustom {
	public List<YpxxCustom> findYpxxList(YpxxQueryVo ypxxQueryVo)throws Exception;
}
