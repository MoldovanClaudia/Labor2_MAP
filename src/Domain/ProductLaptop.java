package Domain;

public class ProductLaptop extends Product{
    private String keyboardType;
    private String trackpad;

    private String OS;

    public ProductLaptop(int id, String name, String description, String category, float price, int supplierId, int quantity,String keyboardType, String trackpad, String OS) {
        this.keyboardType = keyboardType;
        this.trackpad = trackpad;
        this.OS = OS;
        this.setProductId(id);
        this.setName(name);
        this.setDescription(description);
        this.setCategory(category);
        this.setPrice(price);
        this.setSupplierId(supplierId);
        this.setQuantity(quantity);
    }
}
