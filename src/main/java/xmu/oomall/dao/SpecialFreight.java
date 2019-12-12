package xmu.oomall.dao;

import java.math.BigDecimal;
import java.util.Date;

public class SpecialFreight {
    private Long id;

    private Short firstNumPiece;

    private BigDecimal firstNumPiecePrice;

    private Short continueNumPiece;

    private BigDecimal continueNumPiecePrice;

    private Date gmtCreate;

    private Date gmtModified;

    private Boolean isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getFirstNumPiece() {
        return firstNumPiece;
    }

    public void setFirstNumPiece(Short firstNumPiece) {
        this.firstNumPiece = firstNumPiece;
    }

    public BigDecimal getFirstNumPiecePrice() {
        return firstNumPiecePrice;
    }

    public void setFirstNumPiecePrice(BigDecimal firstNumPiecePrice) {
        this.firstNumPiecePrice = firstNumPiecePrice;
    }

    public Short getContinueNumPiece() {
        return continueNumPiece;
    }

    public void setContinueNumPiece(Short continueNumPiece) {
        this.continueNumPiece = continueNumPiece;
    }

    public BigDecimal getContinueNumPiecePrice() {
        return continueNumPiecePrice;
    }

    public void setContinueNumPiecePrice(BigDecimal continueNumPiecePrice) {
        this.continueNumPiecePrice = continueNumPiecePrice;
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