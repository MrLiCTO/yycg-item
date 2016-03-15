package yycg.business.pojo.vo;

import java.util.List;

import yycg.base.pojo.po.Usergys;
import yycg.base.pojo.vo.PageQuery;

public class GysypmlQueryVo {
	
	private List<YpxxCustom> ypxxCustoms; 
	
	private List<GysypmlCustom> gysypmlCustoms; 
	
	private GysypmlCustom gysypmlCustom;
	
	private YpxxCustom ypxxCustom;
	
	private PageQuery pageQuery;
	
	private Usergys usergys;

	public GysypmlCustom getGysypmlCustom() {
		return gysypmlCustom;
	}

	public void setGysypmlCustom(GysypmlCustom gysypmlCustom) {
		this.gysypmlCustom = gysypmlCustom;
	}

	public PageQuery getPageQuery() {
		return pageQuery;
	}

	public void setPageQuery(PageQuery pageQuery) {
		this.pageQuery = pageQuery;
	}

	public YpxxCustom getYpxxCustom() {
		return ypxxCustom;
	}

	public void setYpxxCustom(YpxxCustom ypxxCustom) {
		this.ypxxCustom = ypxxCustom;
	}

	public List<YpxxCustom> getYpxxCustoms() {
		return ypxxCustoms;
	}

	public void setYpxxCustoms(List<YpxxCustom> ypxxCustoms) {
		this.ypxxCustoms = ypxxCustoms;
	}

	public List<GysypmlCustom> getGysypmlCustoms() {
		return gysypmlCustoms;
	}

	public void setGysypmlCustoms(List<GysypmlCustom> gysypmlCustoms) {
		this.gysypmlCustoms = gysypmlCustoms;
	}

	public Usergys getUsergys() {
		return usergys;
	}

	public void setUsergys(Usergys usergys) {
		this.usergys = usergys;
	}
	
	
	
}
