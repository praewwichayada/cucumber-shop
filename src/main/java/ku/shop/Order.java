package ku.shop;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private List<OrderItem> items;
    private LocalDateTime date;

    public Order(int id) {
        this.id = id;
        this.items = new ArrayList<>();
        this.date = LocalDateTime.now();
    }

    public Order() {
        this.id = 0;
        this.items = new ArrayList<>();
        this.date = LocalDateTime.now();
    }

    public void addItem(Product prod, int quantity) throws NotEnoughProductException {
        if (quantity > prod.getQuantity())
            throw new NotEnoughProductException("Order quantity is more than product availability");
        items.add(new OrderItem(prod, quantity));
    }

    public double getTotal() {
        double total = 0;
        for (OrderItem item : items)
            total += item.getSubtotal();
        return total;
    }

}
