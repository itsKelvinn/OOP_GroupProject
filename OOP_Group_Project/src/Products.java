import java.util.ArrayList;

public abstract class Products {
    // id Management
    private static int countShoes = 1;    
    private static int countShirt = 1;
    private static int countPants = 1;

    // Datas
    private ArrayList<String> historyMassage = new ArrayList<>();
    private ArrayList<Integer> historyQuatity = new ArrayList<>();
    private String product_name;
    private String product_type;
    private String product_id;
    private int product_stock;

    Products(String product_name ,String product_type ,int product_stock){
        this.product_name = product_name;
        this.product_type = product_type;
        this.product_stock = product_stock;
        this.product_id = generateID();
    }

    public String getProduct_name() {
        return product_name;
    }

    public int getProduct_stock() {
        return product_stock;
    }

    public String getProduct_type() {
        return product_type;
    }

    public String getProduct_id() {
        return product_id;
    }

    private String generateID(){
        String id = "test";
        String numId = "test";

        class numIdGenerate{
            public static String generate(String id){
                
                if(id.length() == 1){
                    id = "00" + id;
                }
                else if(id.length() == 2){
                    id = "0" + id;
                }
                return id;
            }
        }

        if(getProduct_type().equals("Shoes")){
            id = "SH";
            numId = numIdGenerate.generate(Integer.toString(countShoes++));

        }
        else if(getProduct_type().equals("Shirt")){
            id = "ST";  
            numId = numIdGenerate.generate(Integer.toString(countShirt++));
        }
        else if(getProduct_type().equals("Pants")){
            id = "PA";
            numId = numIdGenerate.generate(Integer.toString(countPants++));
        }

        return id + numId;
    }

    public void minProduct_stock(int stock,String massage){
        historyMassage.add(massage);
        historyQuatity.add(-stock);
        this.product_stock = this.product_stock - stock;
    }

    public void plusProduct_stock(int stock, String massage){
        historyMassage.add(massage);
        historyQuatity.add(stock);
        this.product_stock = this.product_stock + stock;
    }
}
