package encapsulation.assigment_problems;

public class Cart {
    private final String cartId;
    private final double[] itemPrices;
    private int itemCount;

    public Cart(String cartId, int maximumItems) {
        if (maximumItems < 0) {
            throw new IllegalArgumentException("Maximum items cannot be negative");
        }
        this.cartId = cartId;
        this.itemPrices = new double[maximumItems];
    }

    public String getCartId() {
        return cartId;
    }

    public boolean addItem(double price) {
        if (price < 0 || itemCount == itemPrices.length) {
            return false;
        }
        itemPrices[itemCount++] = price;
        return true;
    }

    public double getTotal() {
        double total = 0;
        for (int index = 0; index < itemCount; index++) {
            total += itemPrices[index];
        }
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);
        System.out.println("Total: " + (int) cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}