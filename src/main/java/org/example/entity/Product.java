package org.example.entity;

import java.math.BigDecimal;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/3/24 20:55
 * @description：
 * @modified By：
 * @version: $
 */
public class Product {

    private String fdProductId = " ";		/* 产品类型id*/
    private String fdProductCname = " ";		/* 产品中文名*/
    private String fdProductEname = " ";		/* 产品英文*/
    private String fdProductAttr1 = " ";		/* 产品属性1*/
    private String fdProductAttr2 = " ";		/* 产品属性2*/
    private String fdProductAttr3 = " ";		/* 产品属性3*/

    @Override
    public String toString() {
        return "Product{" +
                "fdProductId='" + fdProductId + '\'' +
                ", fdProductCname='" + fdProductCname + '\'' +
                ", fdProductEname='" + fdProductEname + '\'' +
                ", fdProductAttr1='" + fdProductAttr1 + '\'' +
                ", fdProductAttr2='" + fdProductAttr2 + '\'' +
                ", fdProductAttr3='" + fdProductAttr3 + '\'' +
                '}';
    }

    public String getFdProductId() {
        return fdProductId;
    }

    public void setFdProductId(String fdProductId) {
        this.fdProductId = fdProductId;
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
}
