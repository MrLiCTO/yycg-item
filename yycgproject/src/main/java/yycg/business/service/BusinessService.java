package yycg.business.service;

import java.util.List;

import yycg.business.pojo.vo.YycgdQueryVo;
import yycg.business.pojo.vo.YycgdmxCustom;

public interface BusinessService {

	/**
	 * 
	 * <p>
	 * Title: findYybusinessList
	 * </p>
	 * <p>
	 * Description: 交易明细查询
	 * </p>
	 * 
	 * @param year
	 *            年份
	 * @param sysid
	 *            单位id
	 * @param groupid
	 *            用户类型
	 * @param yycgdQueryVo
	 *            查询条件
	 * @return
	 * @throws Exception
	 */
	public List<YycgdmxCustom> findYybusinessList(String year, String sysid,
			String groupid, YycgdQueryVo yycgdQueryVo) throws Exception;

	public int findYybusinessCount(String year, String sysid, String groupid,
			YycgdQueryVo yycgdQueryVo) throws Exception;
	
	/**
	 * 
	 * <p>Title: findYybusinessGroupbyYpxxList</p>
	 * <p>Description: 按药品统计 </p>
	 * @param year
	 *            年份
	 * @param sysid
	 *            单位id
	 * @param groupid
	 *            用户类型
	 * @param yycgdQueryVo
	 *            查询条件
	 * @return
	 * @throws Exception
	 */
	public List<YycgdmxCustom> findYybusinessGroupbyYpxxList(String year, String sysid,
			String groupid, YycgdQueryVo yycgdQueryVo) throws Exception;
	public int findYybusinessGroupbyYpxxCount(String year, String sysid,
			String groupid, YycgdQueryVo yycgdQueryVo) throws Exception;
}
