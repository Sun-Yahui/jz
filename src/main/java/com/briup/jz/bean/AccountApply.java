package com.briup.jz.bean;

import java.io.Serializable;

public class AccountApply implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jz_account_apply.id
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jz_account_apply.money
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    private Double money;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jz_account_apply.apply_type
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    private String applyType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jz_account_apply.apply_time
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    private Long applyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jz_account_apply.status
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jz_account_apply.user_id
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jz_account_apply.reason
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    private String reason;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table jz_account_apply
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jz_account_apply.id
     *
     * @return the value of jz_account_apply.id
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jz_account_apply.id
     *
     * @param id the value for jz_account_apply.id
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jz_account_apply.money
     *
     * @return the value of jz_account_apply.money
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    public Double getMoney() {
        return money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jz_account_apply.money
     *
     * @param money the value for jz_account_apply.money
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    public void setMoney(Double money) {
        this.money = money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jz_account_apply.apply_type
     *
     * @return the value of jz_account_apply.apply_type
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    public String getApplyType() {
        return applyType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jz_account_apply.apply_type
     *
     * @param applyType the value for jz_account_apply.apply_type
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    public void setApplyType(String applyType) {
        this.applyType = applyType == null ? null : applyType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jz_account_apply.apply_time
     *
     * @return the value of jz_account_apply.apply_time
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    public Long getApplyTime() {
        return applyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jz_account_apply.apply_time
     *
     * @param applyTime the value for jz_account_apply.apply_time
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    public void setApplyTime(Long applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jz_account_apply.status
     *
     * @return the value of jz_account_apply.status
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jz_account_apply.status
     *
     * @param status the value for jz_account_apply.status
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jz_account_apply.user_id
     *
     * @return the value of jz_account_apply.user_id
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jz_account_apply.user_id
     *
     * @param userId the value for jz_account_apply.user_id
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jz_account_apply.reason
     *
     * @return the value of jz_account_apply.reason
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    public String getReason() {
        return reason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jz_account_apply.reason
     *
     * @param reason the value for jz_account_apply.reason
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }
}