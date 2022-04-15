package org.example.entity;

import java.math.BigDecimal;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/3/24 20:48
 * @description：
 * @modified By：
 * @version: $
 */
public class Project {
    private String fdProjectId = " ";		/* 项目id*/
    private String fdProjectName = " ";		/* 项目名称*/
    private String fdProductId = " ";		/* 产品类型id*/
    private String fdProjectManager = " ";		/* 项目经理*/
    private BigDecimal fdProjectAmount = new BigDecimal(0);		/* 金额*/
    private BigDecimal fdProjectRate = new BigDecimal(0);		/* 收益率*/
    private String fdProjectStatus = " ";		/* 项目状态*/
    private String fdProductCname = " ";		/* 产品中文名*/
    private String fdProductEname = " ";		/* 产品英文*/
    private String fdProductAttr1 = " ";		/* 产品属性1*/
    private String fdProductAttr2 = " ";		/* 产品属性2*/
    private String fdProductAttr3 = " ";		/* 产品属性3*/
    private String fdOrgName = " ";

    public String getFdProjectId() {
        return fdProjectId;
    }

    public void setFdProjectId(String fdProjectId) {
        this.fdProjectId = fdProjectId;
    }

    public String getFdProjectName() {
        return fdProjectName;
    }

    public void setFdProjectName(String fdProjectName) {
        this.fdProjectName = fdProjectName;
    }

    public String getFdProductId() {
        return fdProductId;
    }

    public void setFdProductId(String fdProductId) {
        this.fdProductId = fdProductId;
    }

    public String getFdProjectManager() {
        return fdProjectManager;
    }

    public void setFdProjectManager(String fdProjectManager) {
        this.fdProjectManager = fdProjectManager;
    }

    public BigDecimal getFdProjectAmount() {
        return fdProjectAmount;
    }

    public void setFdProjectAmount(BigDecimal fdProjectAmount) {
        this.fdProjectAmount = fdProjectAmount;
    }

    public BigDecimal getFdProjectRate() {
        return fdProjectRate;
    }

    public void setFdProjectRate(BigDecimal fdProjectRate) {
        this.fdProjectRate = fdProjectRate;
    }

    public String getFdProjectStatus() {
        return fdProjectStatus;
    }

    public void setFdProjectStatus(String fdProjectStatus) {
        this.fdProjectStatus = fdProjectStatus;
    }

    public String getFdProductCname() {
        return fdProductCname;
    }

    public void setFdProductCname(String fdProductCname) {
        this.fdProductCname = fdProductCname;
    }

    public String getFdProductEname() {
        return fdProductEname;
    }

    public void setFdProductEname(String fdProductEname) {
        this.fdProductEname = fdProductEname;
    }

    public String getFdProductAttr1() {
        return fdProductAttr1;
    }

    @Override
    public String toString() {
        return "Project{" +
                "fdProjectId='" + fdProjectId + '\'' +
                ", fdProjectName='" + fdProjectName + '\'' +
                ", fdProductId='" + fdProductId + '\'' +
                ", fdProjectManager='" + fdProjectManager + '\'' +
                ", fdProjectAmount=" + fdProjectAmount +
                ", fdProjectRate=" + fdProjectRate +
                ", fdProjectStatus='" + fdProjectStatus + '\'' +
                ", fdProductCname='" + fdProductCname + '\'' +
                ", fdProductEname='" + fdProductEname + '\'' +
                ", fdProductAttr1='" + fdProductAttr1 + '\'' +
                ", fdProductAttr2='" + fdProductAttr2 + '\'' +
                ", fdProductAttr3='" + fdProductAttr3 + '\'' +
                ", fdOrgName='" + fdOrgName + '\'' +
                '}';
    }

    public void setFdProductAttr1(String fdProductAttr1) {
        this.fdProductAttr1 = fdProductAttr1;
    }

    public String getFdProductAttr2() {
        return fdProductAttr2;
    }

    public void setFdProductAttr2(String fdProductAttr2) {
        this.fdProductAttr2 = fdProductAttr2;
    }

    public String getFdProductAttr3() {
        return fdProductAttr3;
    }

    public void setFdProductAttr3(String fdProductAttr3) {
        this.fdProductAttr3 = fdProductAttr3;
    }

    public String getFdOrgName() {
        return fdOrgName;
    }

    public void setFdOrgName(String fdOrgName) {
        this.fdOrgName = fdOrgName;
    }
}
