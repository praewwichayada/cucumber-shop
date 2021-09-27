package ku.shop;

public class OrderItem {
    private int quantity;
    private Product prod;

    public OrderItem(Product prod, int quantity) {
        if (quantity <= 0)
            throw new IllegalArgumentException("Quantity must be positive");

        this.prod = prod;
        this.quantity = quantity;

        setProductAvailability();
    }

    public double getSubtotal() {
        return prod.getPrice() * quantity;
    }
    public void setProductAvailability() {
        int q = prod.getQuantity() - quantity;
        this.prod.setQuantity(q);
    }

}
