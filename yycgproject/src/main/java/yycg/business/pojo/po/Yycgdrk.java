package yycg.business.pojo.po;

import java.util.Date;

public class Yycgdrk extends BusinessBasePo{
    private String id;

    private String yycgdid;

    private String ypxxid;

    private String vchar1;

    private String vchar2;

    private String vchar3;

    private String vchar4;

    private String vchar5;

    private Integer rkl;

    private Float rkje;

    private String rkdh;

    private String ypph;

    private Float ypyxq;

    private Date rktime;

    private String cgzt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getYycgdid() {
        return yycgdid;
    }

    public void setYycgdid(String yycgdid) {
        this.yycgdid = yycgdid == null ? null : yycgdid.trim();
    }

    public String getYpxxid() {
        return ypxxid;
    }

    public void setYpxxid(String ypxxid) {
        this.ypxxid = ypxxid == null ? null : ypxxid.trim();
    }

    public String getVchar1() {
        return vchar1;
    }

    public void setVchar1(String vchar1) {
        this.vchar1 = vchar1 == null ? null : vchar1.trim();
    }

    public String getVchar2() {
        return vchar2;
    }

    public void setVchar2(String vchar2) {
        this.vchar2 = vchar2 == null ? null : vchar2.trim();
    }

    public String getVchar3() {
        return vchar3;
    }

    public void setVchar3(String vchar3) {
        this.vchar3 = vchar3 == null ? null : vchar3.trim();
    }

    public String getVchar4() {
        return vchar4;
    }

    public void setVchar4(String vchar4) {
        this.vchar4 = vchar4 == null ? null : vchar4.trim();
    }

    public String getVchar5() {
        return vchar5;
    }

    public void setVchar5(String vchar5) {
        this.vchar5 = vchar5 == null ? null : vchar5.trim();
    }

    public Integer getRkl() {
        return rkl;
    }

    public void setRkl(Integer rkl) {
        this.rkl = rkl;
    }

    public Float getRkje() {
        return rkje;
    }

    public void setRkje(Float rkje) {
        this.rkje = rkje;
    }

    public String getRkdh() {
        return rkdh;
    }

    public void setRkdh(String rkdh) {
        this.rkdh = rkdh == null ? null : rkdh.trim();
    }

    public String getYpph() {
        return ypph;
    }

    public void setYpph(String ypph) {
        this.ypph = ypph == null ? null : ypph.trim();
    }

    public Float getYpyxq() {
        return ypyxq;
    }

    public void setYpyxq(Float ypyxq) {
        this.ypyxq = ypyxq;
    }

    public Date getRktime() {
        return rktime;
    }

    public void setRktime(Date rktime) {
        this.rktime = rktime;
    }

    public String getCgzt() {
        return cgzt;
    }

    public void setCgzt(String cgzt) {
        this.cgzt = cgzt == null ? null : cgzt.trim();
    }
}