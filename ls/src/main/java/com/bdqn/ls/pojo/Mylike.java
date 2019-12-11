package com.bdqn.ls.pojo;

import javax.persistence.*;

public class Mylike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer adminid;

    private Integer infoid;

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
     * @return adminid
     */
    public Integer getAdminid() {
        return adminid;
    }

    /**
     * @param adminid
     */
    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
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
}