package com.example06.model;

import java.util.Set;

public class Product {

    private String name;
    private String code;

    private String categoryCode;

    private Double sellingPrice;
    private Double purchasePrice;

    private Long stockAmount;

    private Set<PackagingType> packagingTypes;

    public Product(String name, String code, String categoryCode, Double sellingPrice, Double purchasePrice, Long stockAmount) {
        this.name = name;
        this.code = code;
        this.categoryCode = categoryCode;
        this.sellingPrice = sellingPrice;
        this.purchasePrice = purchasePrice;
        this.stockAmount = stockAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Long getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(Long stockAmount) {
        this.stockAmount = stockAmount;
    }

    public Set<PackagingType> getPackagingTypes() {
        return packagingTypes;
    }

    public void setPackagingTypes(Set<PackagingType> packagingTypes) {
        this.packagingTypes = packagingTypes;
    }
}
