package ku.shop;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BuyStepdefs {

    private ProductCatalog catalog;
    private Order order;

    @Before
    public void setup() {
        catalog = new ProductCatalog();
        order = new Order();
    }

    @Given("a product {string} with price {float} exists")
    public void a_product_with_price_exists(String name, double price) {
        catalog.addProduct(name, price);
    }

    @When("I buy {string} with quantity {int}")
    public void i_buy_with_quantity(String name, int quantity) throws NotEnoughProductException {
        Product prod = catalog.getProduct(name);
        order.addItem(prod, quantity);
    }

    @Then("total should be {float}")
    public void total_should_be(double total) {
        assertEquals(total, order.getTotal());
    }


    @Given("a product {string} with price {float} with quantity {int} exists")
    public void a_product_with_quantity_exists(String name, double price, int quantity) {
        catalog.addProduct(name, price, quantity);
    }

    @When("customer buy {string} with quantity {int}")
    public void customer_buy_with_quantity(String name, int quantity) throws NotEnoughProductException {
        Product prod = catalog.getProduct(name);
        order.addItem(prod, quantity);
    }

    @When("customer over buy {string} with quantity {int}")
    public void customer_over_buy_with_quantity(String name, int quantity) throws NotEnoughProductException {
        Product prod = catalog.getProduct(name);
        assertThrows(NotEnoughProductException.class,
                () -> order.addItem(prod, quantity));
    }

    @Then("total {string} in stock should be {int}")
    public void total_availability_should_be(String name, int total) {
        assertEquals(total, catalog.getProduct(name).getQuantity());
    }
}

