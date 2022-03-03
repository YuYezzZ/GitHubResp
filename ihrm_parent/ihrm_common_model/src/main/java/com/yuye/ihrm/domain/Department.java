package com.yuye.ihrm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.Serializable;
import java.util.Date;

/**
 * (Department)实体类
 */
//解决跨域
@CrossOrigin
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Department implements Serializable {
    private static final long serialVersionUID = -9084332495284489553L;
    //ID
    private String id;
    /**
     * 父级ID
     */
    private String parentId;
    /**
     * 企业ID
     */
    private String companyId;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 部门编码，同级部门不可重复
     */
    private String code;
    /**
     * 部门类别
     */
    private String category;
    /**
     * 负责人ID
     */
    private String managerId;
    /**
	*  负责人名称
	*/
    private String manager;

    /**
     * 介绍
     */
    private String introduce;
    /**
     * 创建时间
     */
    private Date createTime;
}
