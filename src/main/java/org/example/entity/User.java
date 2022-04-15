package org.example.entity;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/3/23 12:52
 * @description：
 * @modified By：
 * @version: $
 * 用户表
 */

public class User {
    private String userId = " ";		/* 用户ID*/
    private String loginName = " ";
    private String password = " ";
    private String status = " ";
    private String userName = " ";
    private String gender = "1";
    private String mobile = " ";
    private String email = " ";
    private String oriId = " ";
    private String userType = " ";
    private String accountExpireDate = " ";
    private String pwdExpireDate = " ";
    private String isLocked = " ";
    private String orgId = " ";
    private Integer sortIndex = new Integer(0);		/* 排序*/
    private String pwdRevisor = " ";		/* 密码修改人*/
    private String archiveFlag = " ";		/* 归档标记*/
    private String userGroupEname = " ";		/* 用户组*/

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOriId() {
        return oriId;
    }

    public void setOriId(String oriId) {
        this.oriId = oriId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getAccountExpireDate() {
        return accountExpireDate;
    }

    public void setAccountExpireDate(String accountExpireDate) {
        this.accountExpireDate = accountExpireDate;
    }

    public String getPwdExpireDate() {
        return pwdExpireDate;
    }

    public void setPwdExpireDate(String pwdExpireDate) {
        this.pwdExpireDate = pwdExpireDate;
    }

    public String getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(String isLocked) {
        this.isLocked = isLocked;
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    public String getPwdRevisor() {
        return pwdRevisor;
    }

    public void setPwdRevisor(String pwdRevisor) {
        this.pwdRevisor = pwdRevisor;
    }

    public String getArchiveFlag() {
        return archiveFlag;
    }

    public void setArchiveFlag(String archiveFlag) {
        this.archiveFlag = archiveFlag;
    }

    public String getUserGroupEname() {
        return userGroupEname;
    }

    public void setUserGroupEname(String userGroupEname) {
        this.userGroupEname = userGroupEname;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", oriId='" + oriId + '\'' +
                ", userType='" + userType + '\'' +
                ", accountExpireDate='" + accountExpireDate + '\'' +
                ", pwdExpireDate='" + pwdExpireDate + '\'' +
                ", isLocked='" + isLocked + '\'' +
                ", orgId='" + orgId + '\'' +
                ", sortIndex=" + sortIndex +
                ", pwdRevisor='" + pwdRevisor + '\'' +
                ", archiveFlag='" + archiveFlag + '\'' +
                ", userGroupEname='" + userGroupEname + '\'' +
                '}';
    }
}
