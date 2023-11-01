package Domain;

public class Product {
    private int productId;
    private String name;
    private String description;
    private String category;
    private float price;
    private int supplierId;
    private int quantity;

    public Product(int id, String name, String description, String category, float price, int supplierId, int quantity) {
        this.productId = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.supplierId = supplierId;
        this.quantity = quantity;
    }

    public int getProductId() { return this.productId; }

    public void setProductId(int productId) { this.productId = productId; }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getSupplierId() {
        return this.supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + productId +
                ", name=" + name + "\'" +
                ", description=" + description +
                ",category=" + category +
                ", price=" + price +
                ", supplierId=" + supplierId +
                ", quantity=" + quantity +
                "}";
    }
}
