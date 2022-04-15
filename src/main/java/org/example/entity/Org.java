package org.example.entity;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/3/23 13:54
 * @description：
 * @modified By：
 * @version: $
 * 组织机构表 存放部门信息
 */
public class Org {
    private String fdOrgId = " ";		/* 部门id*/
    private String fdOrgName = " ";		/* 部门名称*/
    private String fdOrgDesc = " ";		/* 部门描述及*/
    private String fdParentFdOrgId = " ";		/* 父部门名称*/

    public String getFdOrgId() {
        return fdOrgId;
    }

    public void setFdOrgId(String fdOrgId) {
        this.fdOrgId = fdOrgId;
    }

    public String getFdOrgName() {
        return fdOrgName;
    }

    public void setFdOrgName(String fdOrgName) {
        this.fdOrgName = fdOrgName;
    }

    public String getFdOrgDesc() {
        return fdOrgDesc;
    }

    public void setFdOrgDesc(String fdOrgDesc) {
        this.fdOrgDesc = fdOrgDesc;
    }

    public String getFdParentFdOrgId() {
        return fdParentFdOrgId;
    }

    public void setFdParentFdOrgId(String fdParentFdOrgId) {
        this.fdParentFdOrgId = fdParentFdOrgId;
    }

    @Override
    public String toString() {
        return "Org{" +
                "fdOrgId='" + fdOrgId + '\'' +
                ", fdOrgName='" + fdOrgName + '\'' +
                ", fdOrgDesc='" + fdOrgDesc + '\'' +
                ", fdParentFdOrgId='" + fdParentFdOrgId + '\'' +
                '}';
    }
}
