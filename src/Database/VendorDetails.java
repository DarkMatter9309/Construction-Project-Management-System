package Database;

public class VendorDetails {

    private String vendor_Name;
    private String material_Type;
    private String material;
    private int price;
    private String contact;
    private String location;

    public VendorDetails(String vendor_Name, String material_Type, String material, int price, String contact, String location){
        this.vendor_Name = vendor_Name;
        this.material_Type = material_Type;
        this.material = material;
        this.price = price;
        this.contact = contact;
        this.location = location;
    }

    public String getVendor_Name() {
        return vendor_Name;
    }

    public void setVendor_Name(String vendor_Name) {
        this.vendor_Name = vendor_Name;
    }

    public String getMaterial_Type() {
        return material_Type;
    }

    public void setMaterial_Type(String material_Type) {
        this.material_Type = material_Type;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
