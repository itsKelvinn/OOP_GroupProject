public class shirt extends Products{
    static int counter = 0;

    shirt(String product_name, int product_stock) {
        super(product_name, "Shirt", product_stock);
        counter++;
    }

    @Override
    public int product_count() {
        return counter;
    }
    
}
