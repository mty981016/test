package com.bdqn.ls.pojo;

import javax.persistence.*;

public class Worklisi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String timedian;

    private String gongsi;

    private String zhiwei;

    private String xinzhi;

    private Integer infoid;

    private String comment;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return timedian
     */
    public String getTimedian() {
        return timedian;
    }

    /**
     * @param timedian
     */
    public void setTimedian(String timedian) {
        this.timedian = timedian;
    }

    /**
     * @return gongsi
     */
    public String getGongsi() {
        return gongsi;
    }

    /**
     * @param gongsi
     */
    public void setGongsi(String gongsi) {
        this.gongsi = gongsi;
    }

    /**
     * @return zhiwei
     */
    public String getZhiwei() {
        return zhiwei;
    }

    /**
     * @param zhiwei
     */
    public void setZhiwei(String zhiwei) {
        this.zhiwei = zhiwei;
    }

    /**
     * @return xinzhi
     */
    public String getXinzhi() {
        return xinzhi;
    }

    /**
     * @param xinzhi
     */
    public void setXinzhi(String xinzhi) {
        this.xinzhi = xinzhi;
    }

    /**
     * @return infoid
     */
    public Integer getInfoid() {
        return infoid;
    }

    /**
     * @param infoid
     */
    public void setInfoid(Integer infoid) {
        this.infoid = infoid;
    }

    /**
     * @return comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}