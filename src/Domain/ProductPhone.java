package Domain;

public class ProductPhone extends Product {
    private String touchType;
    private String camera;

    private String OS;

    public ProductPhone(int id, String name, String description, String category, float price, int supplierId, int quantity,String touchType, String camera, String OS) {
        this.touchType = touchType;
        this.camera = camera;
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
