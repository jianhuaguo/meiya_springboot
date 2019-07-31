package com.mei.demo.Domain;



import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class Order implements Serializable {
    private Long id;

    private Integer store_id;

    private Integer user_id;

    private Integer shippingId;

    //付款金额
    private BigDecimal payment;

    private Integer paymentType;

    private Integer postage;

    private Integer status;

    //付款时间
    private Date payment_time;

    private Date sendTime;

    private Date endTime;

    private Date closeTime;

    private Date createTime;

    private Date updateTime;

//    public Order(Long id, Long orderNo, Integer userId, Integer shippingId, BigDecimal payment, Integer paymentType, Integer postage, Integer status, Date paymentTime, Date sendTime, Date endTime, Date closeTime, Date createTime, Date updateTime) {
//        this.id = id;
//        this.orderNo = orderNo;
//        this.userId = userId;
//        this.shippingId = shippingId;
//        this.payment = payment;
//        this.paymentType = paymentType;
//        this.postage = postage;
//        this.status = status;
//        this.paymentTime = paymentTime;
//        this.sendTime = sendTime;
//        this.endTime = endTime;
//        this.closeTime = closeTime;
//        this.createTime = createTime;
//        this.updateTime = updateTime;
//    }


    public Integer getStore_id() {
        return store_id;
    }

    public void setStore_id(Integer store_id) {
        this.store_id = store_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Date getPayment_time() {
        return payment_time;
    }

    public void setPayment_time(Date payment_time) {
        this.payment_time = payment_time;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Integer getShippingId() {
        return shippingId;
    }

    public void setShippingId(Integer shippingId) {
        this.shippingId = shippingId;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getPostage() {
        return postage;
    }

    public void setPostage(Integer postage) {
        this.postage = postage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }



    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
