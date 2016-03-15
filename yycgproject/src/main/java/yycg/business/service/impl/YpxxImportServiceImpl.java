package yycg.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import yycg.business.dao.mapper.YpxxMapper;
import yycg.business.pojo.po.Ypxx;
import yycg.util.HxlsOptRowsInterface;
import yycg.util.UUIDBuild;

public class YpxxImportServiceImpl implements HxlsOptRowsInterface {

	@Autowired
	private YpxxMapper ypxxMapper;
	
	
	
	@Override
	public String optRows(int sheetIndex, int curRow, List<String> rowlist) throws Exception {
		try {
			String mc=rowlist.get(0);
			String jx=rowlist.get(1);
			String gg=rowlist.get(2);
			String zhxs=rowlist.get(3);
			String zbjg=rowlist.get(4);
			String scqymc=rowlist.get(5);
			String spmc=rowlist.get(6);
			String jyzt=rowlist.get(7);
			//进行校验
			//校验中标价格合法性
			//校验交易状态的合法性
			if(jyzt==null||(!jyzt.equals("1")&&!jyzt.equals("2"))){
				return "交易状态输入不对，请输入：1或2（1：正常，2：暂停）";
			}
			//添加唯一校验
			//校验通用名、剂型、规格、转换系数、生产企业、商品名
			//思路：根据通用名、剂型、规格、转换系数、生产企业、商品名，查询，如果查询到记录，说明 存在重复记录
			//.....
			Ypxx ypxx=new Ypxx();
			
			ypxx.setId(UUIDBuild.getUUID());
			//ypxx.setBm(bm);通过触发器自动赋值
			ypxx.setMc(mc);
			ypxx.setJx(jx);
			ypxx.setGg(gg);
			ypxx.setZhxs(zhxs);
			ypxx.setSpmc(spmc);
			ypxx.setZbjg(Float.parseFloat(zbjg));
			ypxx.setScqymc(scqymc);
			ypxx.setJyzt(jyzt);
			
			//校验调用mapper
			ypxxMapper.insert(ypxx);
		} catch (Exception e) {
			e.printStackTrace();
			return "插入失败";
		}
		
		return "success";
	}

}
