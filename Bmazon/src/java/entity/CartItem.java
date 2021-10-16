package entity;

import java.io.Serializable;

/**
 *
 * @author Lonely
 */

public class CartItem implements Serializable {
    private static final long serialVersionUID = 1;
    int cartID;
    private int productID;
    private String name;
    private String size;
    private String color;
    private String image;
    private double price;
    private int quantity;
    private double totalCost;

    public CartItem(int productID, String name, String size, String color, String image, double price, int quantity, double totalCost) {
        this.productID = productID;
        this.name = name;
        this.size = size;
        this.color = color;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.totalCost = totalCost;
    }

    public CartItem(int cartID, int productID, String name, String size, String color, String image, double price, int quantity, double totalCost) {
        this.cartID = cartID;
        this.productID = productID;
        this.name = name;
        this.size = size;
        this.color = color;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.totalCost = totalCost;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }
    

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

  
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "CartItem{" + "productID=" + productID + ", name=" + name + ", size=" + size + ", color=" + color + ", image=" + image + ", price=" + price + ", quantity=" + quantity + ", totalCost=" + totalCost + '}';
    }

}