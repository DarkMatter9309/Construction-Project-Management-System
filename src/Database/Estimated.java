package Database;

public class Estimated
{
    private String material;
    private String vendor_name;
    private String type;
    private int price;
    private String location;

    public Estimated(String material, String vendor_name, String type, int price, String location)
    {
        this.material=material;
        this.vendor_name=vendor_name;
        this.type=type;
        this.price=price;
        this.location=location;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getVendor_name() {
        return vendor_name;
    }

    public void setVendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}