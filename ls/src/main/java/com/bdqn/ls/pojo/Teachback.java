package com.bdqn.ls.pojo;

import javax.persistence.*;

public class Teachback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String school;

    private String zuanye;

    private String startime;

    private String comment;

    private Integer infoid;

    private String xueli;

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
     * @return school
     */
    public String getSchool() {
        return school;
    }

    /**
     * @param school
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * @return zuanye
     */
    public String getZuanye() {
        return zuanye;
    }

    /**
     * @param zuanye
     */
    public void setZuanye(String zuanye) {
        this.zuanye = zuanye;
    }

    /**
     * @return startime
     */
    public String getStartime() {
        return startime;
    }

    /**
     * @param startime
     */
    public void setStartime(String startime) {
        this.startime = startime;
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
     * @return xueli
     */
    public String getXueli() {
        return xueli;
    }

    /**
     * @param xueli
     */
    public void setXueli(String xueli) {
        this.xueli = xueli;
    }
}