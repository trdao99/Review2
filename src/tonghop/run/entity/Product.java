package tonghop.run.entity;

import java.util.Date;

public class Product {
    private String productid;
    private String productName;
    private float price;
    private String description;
    private Date created;
    private String catalogId;
    private int productStatus;

    public Product() {
    }

    public Product(String productid, String productName, float price, String description, Date created, String catalogId, int productStatus) {
        this.productid = productid;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.created = created;
        this.catalogId = catalogId;
        this.productStatus = productStatus;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public String toString() {
        return String.format("price : %s | create : %s | catalog: %s |\n", this.getPrice(), this.getCreated().toString(), this.getCatalogId(),
                "ID : %s | Name : %s | Description : %s | Status : %s |\n",
                this.getProductid(),
                this.getProductName(),
                this.getDescription(),
                ((this.getProductStatus() == 0) ? "đang bán" :
                        (this.getProductStatus() == 1) ? "hết hàng" :
                                (this.getProductStatus() == 2) ? "không bán" : "không hợp lệ"));
    }
}
