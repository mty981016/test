package com.bdqn.ls.pojo;

import java.util.Date;
import java.util.List;
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
    private Integer isgo;

    /**
     * 职业类型id
     */
    private Integer isrenzhi;

    /**
     * 性格
     */
    private String xingge;

    /**
     * 兴趣爱好
     */
    private String ilike;

    /**
     * 详细描述
     */
    private String comment;

    /**
     * 是否想跳槽
     */
    private Integer levelid;

    /**
     * 是否在职
     */
    private Integer typeid;

    private String photo;

    private Date createtime;

    private String adress;

    private String phone;

    private String email;

    private Date birthday;

    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    private List<Worklisi> worklisiList;

    public List<Worklisi> getWorklisiList() {
        return worklisiList;
    }

    public void setWorklisiList(List<Worklisi> worklisiList) {
        this.worklisiList = worklisiList;
    }

    public Teachback getTeachback() {
        return teachback;
    }

    public void setTeachback(Teachback teachback) {
        this.teachback = teachback;
    }

    private Teachback teachback;

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
     * @return isgo - 等级id
     */
    public Integer getIsgo() {
        return isgo;
    }

    /**
     * 设置等级id
     *
     * @param isgo 等级id
     */
    public void setIsgo(Integer isgo) {
        this.isgo = isgo;
    }

    /**
     * 获取职业类型id
     *
     * @return isrenzhi - 职业类型id
     */
    public Integer getIsrenzhi() {
        return isrenzhi;
    }

    /**
     * 设置职业类型id
     *
     * @param isrenzhi 职业类型id
     */
    public void setIsrenzhi(Integer isrenzhi) {
        this.isrenzhi = isrenzhi;
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
     * @return ilike - 兴趣爱好
     */
    public String getIlike() {
        return ilike;
    }

    /**
     * 设置兴趣爱好
     *
     * @param ilike 兴趣爱好
     */
    public void setIlike(String ilike) {
        this.ilike = ilike;
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
     * @return levelid - 是否想跳槽
     */
    public Integer getLevelid() {
        return levelid;
    }

    /**
     * 设置是否想跳槽
     *
     * @param levelid 是否想跳槽
     */
    public void setLevelid(Integer levelid) {
        this.levelid = levelid;
    }

    /**
     * 获取是否在职
     *
     * @return typeid - 是否在职
     */
    public Integer getTypeid() {
        return typeid;
    }

    /**
     * 设置是否在职
     *
     * @param typeid 是否在职
     */
    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
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