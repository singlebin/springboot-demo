package springboot.demo.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
//@Data
public class ClSku implements Serializable {
    private Integer id;

    private Long productId;

    private String skuCode;

    private String barcode;

    private String itemnumber;

    private String name;

    private String description;

    private String longDescription;

    private Date startDate;

    private Date endDate;

    private String discountable;

    private String available;

    private Integer taxable;

    private Integer isDeleted;

    private String createdBy;

    private String updatedBy;

    private Integer optCounter;

    private BigDecimal supplierId;

    private Date dateCreated;

    private Date dateUpdated;

    private Integer field1;

    private Integer field2;

    private Date field3;

    private String field4;

    private String field5;

    private String externalCode;

    private String flTransFlag;

    private String r3TransFlag;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode == null ? null : skuCode.trim();
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }

    public String getItemnumber() {
        return itemnumber;
    }

    public void setItemnumber(String itemnumber) {
        this.itemnumber = itemnumber == null ? null : itemnumber.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription == null ? null : longDescription.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDiscountable() {
        return discountable;
    }

    public void setDiscountable(String discountable) {
        this.discountable = discountable == null ? null : discountable.trim();
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available == null ? null : available.trim();
    }

    public Integer getTaxable() {
        return taxable;
    }

    public void setTaxable(Integer taxable) {
        this.taxable = taxable;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    public Integer getOptCounter() {
        return optCounter;
    }

    public void setOptCounter(Integer optCounter) {
        this.optCounter = optCounter;
    }

    public BigDecimal getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(BigDecimal supplierId) {
        this.supplierId = supplierId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Integer getField1() {
        return field1;
    }

    public void setField1(Integer field1) {
        this.field1 = field1;
    }

    public Integer getField2() {
        return field2;
    }

    public void setField2(Integer field2) {
        this.field2 = field2;
    }

    public Date getField3() {
        return field3;
    }

    public void setField3(Date field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4 == null ? null : field4.trim();
    }

    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5 == null ? null : field5.trim();
    }

    public String getExternalCode() {
        return externalCode;
    }

    public void setExternalCode(String externalCode) {
        this.externalCode = externalCode == null ? null : externalCode.trim();
    }

    public String getFlTransFlag() {
        return flTransFlag;
    }

    public void setFlTransFlag(String flTransFlag) {
        this.flTransFlag = flTransFlag == null ? null : flTransFlag.trim();
    }

    public String getR3TransFlag() {
        return r3TransFlag;
    }

    public void setR3TransFlag(String r3TransFlag) {
        this.r3TransFlag = r3TransFlag == null ? null : r3TransFlag.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", skuCode=").append(skuCode);
        sb.append(", barcode=").append(barcode);
        sb.append(", itemnumber=").append(itemnumber);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", longDescription=").append(longDescription);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", discountable=").append(discountable);
        sb.append(", available=").append(available);
        sb.append(", taxable=").append(taxable);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", updatedBy=").append(updatedBy);
        sb.append(", optCounter=").append(optCounter);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", dateCreated=").append(dateCreated);
        sb.append(", dateUpdated=").append(dateUpdated);
        sb.append(", field1=").append(field1);
        sb.append(", field2=").append(field2);
        sb.append(", field3=").append(field3);
        sb.append(", field4=").append(field4);
        sb.append(", field5=").append(field5);
        sb.append(", externalCode=").append(externalCode);
        sb.append(", flTransFlag=").append(flTransFlag);
        sb.append(", r3TransFlag=").append(r3TransFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}