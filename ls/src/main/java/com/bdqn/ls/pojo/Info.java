package com.bdqn.ls.pojo;

import java.util.Date;
import javax.persistence.*;

public class Info {
    /**
     * 主键标识
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String sex;

    /**
     * 等级id
     */
    private Integer levelid;

    /**
     * 职业类型id
     */
    private Integer typeid;

    /**
     * 性格
     */
    private String xingge;

    /**
     * 兴趣爱好
     */
    private String ilike;

    /**
     * 当前待遇水平
     */
    private String xinzi;

    /**
     * 当前任职职位
     */
    private String renzi;

    /**
     * 所属公司
     */
    private String gongsi;

    /**
     * 详细描述
     */
    private String comment;

    /**
     * 是否想跳槽
     */
    private Integer isgo;

    /**
     * 是否在职
     */
    private Integer isrenzhi;

    private String photo;

    private Date createtime;

    private String adress;

    private String phone;

    private String email;

    private Date birthday;

    public String getIlike() {
        return ilike;
    }

    public void setIlike(String ilike) {
        this.ilike = ilike;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    private String typename;



    /**
     * 获取主键标识
     *
     * @return id - 主键标识
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键标识
     *
     * @param id 主键标识
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取等级id
     *
     * @return levelid - 等级id
     */
    public Integer getLevelid() {
        return levelid;
    }

    /**
     * 设置等级id
     *
     * @param levelid 等级id
     */
    public void setLevelid(Integer levelid) {
        this.levelid = levelid;
    }

    /**
     * 获取职业类型id
     *
     * @return typeid - 职业类型id
     */
    public Integer getTypeid() {
        return typeid;
    }

    /**
     * 设置职业类型id
     *
     * @param typeid 职业类型id
     */
    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    /**
     * 获取性格
     *
     * @return xingge - 性格
     */
    public String getXingge() {
        return xingge;
    }

    /**
     * 设置性格
     *
     * @param xingge 性格
     */
    public void setXingge(String xingge) {
        this.xingge = xingge;
    }

    /**
     * 获取兴趣爱好
     *
     * @return like - 兴趣爱好
     */
    public String getLike() {
        return ilike;
    }

    /**
     * 设置兴趣爱好
     *
     * @param ilike 兴趣爱好
     */
    public void setLike(String ilike) {
        this.ilike = ilike;
    }

    /**
     * 获取当前待遇水平
     *
     * @return xinzi - 当前待遇水平
     */
    public String getXinzi() {
        return xinzi;
    }

    /**
     * 设置当前待遇水平
     *
     * @param xinzi 当前待遇水平
     */
    public void setXinzi(String xinzi) {
        this.xinzi = xinzi;
    }

    /**
     * 获取当前任职职位
     *
     * @return renzi - 当前任职职位
     */
    public String getRenzi() {
        return renzi;
    }

    /**
     * 设置当前任职职位
     *
     * @param renzi 当前任职职位
     */
    public void setRenzi(String renzi) {
        this.renzi = renzi;
    }

    /**
     * 获取所属公司
     *
     * @return gongsi - 所属公司
     */
    public String getGongsi() {
        return gongsi;
    }

    /**
     * 设置所属公司
     *
     * @param gongsi 所属公司
     */
    public void setGongsi(String gongsi) {
        this.gongsi = gongsi;
    }

    /**
     * 获取详细描述
     *
     * @return comment - 详细描述
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置详细描述
     *
     * @param comment 详细描述
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 获取是否想跳槽
     *
     * @return isgo - 是否想跳槽
     */
    public Integer getIsgo() {
        return isgo;
    }

    /**
     * 设置是否想跳槽
     *
     * @param isgo 是否想跳槽
     */
    public void setIsgo(Integer isgo) {
        this.isgo = isgo;
    }

    /**
     * 获取是否在职
     *
     * @return isrenzhi - 是否在职
     */
    public Integer getIsrenzhi() {
        return isrenzhi;
    }

    /**
     * 设置是否在职
     *
     * @param isrenzhi 是否在职
     */
    public void setIsrenzhi(Integer isrenzhi) {
        this.isrenzhi = isrenzhi;
    }

    /**
     * @return photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * @param photo
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * @return createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * @return adress
     */
    public String getAdress() {
        return adress;
    }

    /**
     * @param adress
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}