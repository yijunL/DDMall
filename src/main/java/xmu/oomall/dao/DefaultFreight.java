package xmu.oomall.dao;

import java.math.BigDecimal;
import java.util.Date;

public class DefaultFreight {
    private Long id;

    private String destination;

    private BigDecimal firstHeavyPrice;

    private BigDecimal continueHeavyPrice;

    private BigDecimal over10Price;

    private BigDecimal over50Price;

    private BigDecimal over100Price;

    private BigDecimal over300Price;

    private String requireDays;

    private Date gmtCreate;

    private Date gmtModified;

    private Boolean isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination == null ? null : destination.trim();
    }

    public BigDecimal getFirstHeavyPrice() {
        return firstHeavyPrice;
    }

    public void setFirstHeavyPrice(BigDecimal firstHeavyPrice) {
        this.firstHeavyPrice = firstHeavyPrice;
    }

    public BigDecimal getContinueHeavyPrice() {
        return continueHeavyPrice;
    }

    public void setContinueHeavyPrice(BigDecimal continueHeavyPrice) {
        this.continueHeavyPrice = continueHeavyPrice;
    }

    public BigDecimal getOver10Price() {
        return over10Price;
    }

    public void setOver10Price(BigDecimal over10Price) {
        this.over10Price = over10Price;
    }

    public BigDecimal getOver50Price() {
        return over50Price;
    }

    public void setOver50Price(BigDecimal over50Price) {
        this.over50Price = over50Price;
    }

    public BigDecimal getOver100Price() {
        return over100Price;
    }

    public void setOver100Price(BigDecimal over100Price) {
        this.over100Price = over100Price;
    }

    public BigDecimal getOver300Price() {
        return over300Price;
    }

    public void setOver300Price(BigDecimal over300Price) {
        this.over300Price = over300Price;
    }

    public String getRequireDays() {
        return requireDays;
    }

    public void setRequireDays(String requireDays) {
        this.requireDays = requireDays == null ? null : requireDays.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}