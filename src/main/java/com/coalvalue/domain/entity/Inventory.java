package com.coalvalue.domain.entity;

import com.coalvalue.domain.BaseDomain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity

@Table(name = "inventory")

public class Inventory extends BaseDomain {



    @Column(name = "no")
    private String no;



    @Column(name = "granularity")
    private String granularity;
    @Column(name = "coalType")
    private String coalType;
    private BigDecimal quote;
    @Column(name = "synchronized_status")
    private String synchronizedStatus;

    public String getSynchronizedStatus() {
        return synchronizedStatus;
    }

    public void setSynchronizedStatus(String synchronizedStatus) {
        this.synchronizedStatus = synchronizedStatus;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getGranularity() {
        return granularity;
    }

    public void setGranularity(String granularity) {
        this.granularity = granularity;
    }

    public String getCoalType() {
        return coalType;
    }

    public void setCoalType(String coalType) {
        this.coalType = coalType;
    }

    @Column(name = "storage_id")
    private Integer storageId;

    @Column(name = "item_id")
    private Integer itemId;


    @Column(name = "company_Id")
    private Integer companyId;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Column(name = "item_type")
    private String itemType;

    @Column(name = "quantity_on_hand")
    private BigDecimal quantityOnHand;

    @Column(name = "status")
    private String status;

    public Inventory() {
    }



    public Integer getStorageId() {
        return storageId;
    }

    public void setStorageId(Integer storageId) {
        this.storageId = storageId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public BigDecimal getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(BigDecimal quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public BigDecimal getQuote() {
        return quote;
    }

    public void setQuote(BigDecimal quote) {
        this.quote = quote;
    }


    ;
}
