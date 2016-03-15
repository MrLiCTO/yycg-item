package yycg.business.service;

import java.util.List;

import yycg.business.pojo.po.Yycgdmx;
import yycg.business.pojo.vo.YycgdCustom;
import yycg.business.pojo.vo.YycgdQueryVo;
import yycg.business.pojo.vo.YycgdmxCustom;
import yycg.business.pojo.vo.YycgdrkCustom;

public interface CgdService {
	public String insertYycgd(String useryyid,String year,YycgdCustom yycgdCustom)throws Exception;
	public void updateYycgd(String id,YycgdCustom yycgdCustom)throws Exception;
	public YycgdCustom findYycgdById(String id)throws Exception;
	
	 public List<YycgdmxCustom> findCgdmxListByYycgdid(String yycgdid,YycgdQueryVo yycgdQueryVo)throws Exception;
	 public int findCgdmxCountByYycgdid(String yycgdid,YycgdQueryVo yycgdQueryVo)throws Exception;
	 
	 public List<YycgdmxCustom> findAddYycgdmxList(String useryyid,String yycgdid,YycgdQueryVo yycgdQueryVo)throws Exception;
	 public int findAddYycgdmxCount(String useryyid,String yycgdid,YycgdQueryVo yycgdQueryVo)throws Exception;


		public void insertYycgdmx(String yycgdid, String ypxxid, String usergysid)
				throws Exception;

		// 根据采购单id和药品id查询采购单明细
		public Yycgdmx findYycgdmxByYycgdidAndYpxxid(String yycgdid, String ypxxid)
				throws Exception;
		
		public void updateYycgdmx(String yycgdid,String ypxxid,Integer cgl)throws Exception;
		
		
	   public List<YycgdCustom> findYycgdList(String year,String useryyid,YycgdQueryVo yycgdQueryVo)throws Exception;
	   public int findYycgdCount(String year,String useryyid,YycgdQueryVo yycgdQueryVo)throws Exception;
	   
	   public void saveYycgdSubmitStatus(String yycgdid)throws Exception;
	   
	   public List<YycgdCustom> findCheckYycgdList(String year,String userjdid,YycgdQueryVo yycgdQueryVo)throws Exception;
	   public int findCheckYycgdCount(String year,String userjdid,YycgdQueryVo yycgdQueryVo)throws Exception;
	   
	   //采购单审核。。。
	   public void saveYycgdCheckStatus(String yycgdid,YycgdCustom yycgdCustom)throws Exception;
	   
	
		public List<YycgdmxCustom> findDisposeYycgdList(String usergysid,String year,YycgdQueryVo yycgdQueryVo) throws Exception;
		public int findDisposeYycgdCount(String usergysid,String year,YycgdQueryVo yycgdQueryVo) throws Exception;


	
		public void saveSendStatus(String yycgdid,String ypxxid)throws Exception;
		

		public List<YycgdmxCustom> findYycgdReceivceList(String useryyid,String year,YycgdQueryVo yycgdQueryVo) throws Exception;
		public int findYycgdReceivceCount(String useryyid,String year,YycgdQueryVo yycgdQueryVo) throws Exception;
		
	
		public void saveYycgdrk(String yycgdid,String ypxxid,YycgdrkCustom yycgdrkCustom) throws Exception;


		public List<YycgdmxCustom> findAddYycgdmxListSum(String yycgdid,YycgdQueryVo yycgdQueryVo)throws Exception;
}
