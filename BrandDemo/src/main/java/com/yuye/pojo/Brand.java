package com.yuye.pojo;

/**
 * @Auther: yuye
 * @Date: 2021-12-19 - 12 - 19 - 13:07
 * @Description: com.yuye.pojo ，品牌类
 * @version: 1.0
 */
public class Brand {
//    属性
//    品牌id
    private Integer id;
//    品牌名称
    private String brandName;
//    公司名称
    private String companyName;
//    排序
    private Integer ordered;
//    描述
    private String description;
//    状态
    private Integer status;

//    方法

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", ordered=" + ordered +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }

    //  构造器
    public Brand() {
    }

    public Brand(String brandName, String companyName, Integer ordered, String description, Integer status) {
        this.brandName = brandName;
        this.companyName = companyName;
        this.ordered = ordered;
        this.description = description;
        this.status = status;
    }
}
