
public class Device {
    private String productType;
    private String productName;
    private double price;
//Here are the three main parameters.

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }




    public Device() {
        this.productType= productType;
        this.productName = productName;
        this.price =price;

    }

    public String toString() {
        return "Device{" +
                "productType='" + productType + '\'' +
                ", productName=" + productName +
                ", price=" + price +
                '}';
    }



}