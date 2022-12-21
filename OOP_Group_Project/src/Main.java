import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import staff.staff;


public class Main {
    private static Scanner scanf = new Scanner(System.in);
    private static ArrayList<staff> staffArr = new ArrayList<>();
    private static ArrayList<Products> products = new ArrayList<>();
    private static staff staffLogin;

  
    public static int entryDisplayMenu() throws IOException, InterruptedException{
        int op;
        do{
            cls();
            System.out.println("Hello and Wellcome");
            System.out.println("==================");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Display all staff");
            System.out.print("Chose >> ");
            op = scanf.nextInt();
            scanf.nextLine();
        }   
        while(op != 1 && op != 2 && op != 3);
        return op;
    }

    public static int login() throws IOException, InterruptedException{
        String  username,password,command;
        int flag = -1;

        do{
            // cls();
            // System.out.println("Type \"Back\" if you go back to menu");
            // System.out.println("Type \"Conti\" if you Still want Login");
            // System.out.print("Command : ");
            // command = scanf.nextLine();
            
            cls();
            System.out.println("Login");
            System.out.println("======");
            System.out.print("Username : ");
            username = scanf.nextLine();
            System.out.print("Password : ");
            password = scanf.nextLine();
            
            username = username.trim();
            password = password.trim();


            for(staff i : staffArr){
                if(i.getUsername().equals(username)&& i.getPassword().equals(password)){
                    flag = 0;
                    staffLogin = i;
                }
            }

            cls();

            if(flag == -1){
                System.out.println("Sry we cant find your Account :(");
                System.out.println("Press Enter to Back to Entry");
                scanf.nextLine();
                return -1;
            }
            else if(flag == 0){
                System.out.println("Login successfully");
                System.out.println("Press Enter to go to Menu");
                scanf.nextLine();
                cls();
                return 0;
            }
        }
        while(flag == -1 );
        return -1;
    }

    public static int register() throws IOException, InterruptedException{
        String username;
        String password;
        String name;
        String command;
        String gender;

        cls();
        System.out.println("Register");
        System.out.println("=========");
        
        do{
            System.out.print("Username [Length > 4] : ");
            username = scanf.nextLine();
        }
        while(username.length() <= 4);
        
        do{
            System.out.print("Password [Length >= 5] : ");
            password = scanf.nextLine();
        }
        while(password.length() < 5);
        
        do{    
            System.out.print("Name [Lenght >= 5]: ");
            name = scanf.nextLine();
        }
        while(name.length() < 5);
        
        do{
            System.out.print("Gender [Male or Female] : ");
            gender = scanf.nextLine();
        }
        while(gender.equals("Male") == false && gender.equals("Female") == false);

        do{
            System.out.print("Are you sure want to register ? [y/n] : ");
            command = scanf.nextLine();
        }
        while (command.equals("y") == false && command.equals("n") == false);
        
        if(command.equals("n")){
            return -1;
        }


        staff newsStaff = new staff(username,password,name,gender);
        staffArr.add(newsStaff);

        return -1;

    }

    public static int displayAllstaff() throws IOException, InterruptedException{
        cls();
        if(staffArr.isEmpty() == true){
            System.out.println("+========================================================================+");
            System.out.println("|  Staff id  |          Name         |     Gender     |     Username     |");
            System.out.println("+========================================================================+");
            
            for(int i = 0; i < 5 ;i ++){

                if(i == 2){
                    System.out.println("|                      Sorry, There is no Data :(                        |");
                }
                else{
                    System.out.println("|                                                                        |");
                }
            }

            System.out.println("+========================================================================+");
            
            System.out.println("\n\n\nPress enter to back Entry Menu");
            scanf.nextLine();
            
            return -1;
        }
        else{
            System.out.println("+========================================================================+");
            System.out.println("|  Staff id  |          Name         |     Gender     |     Username     |");
            System.out.println("+========================================================================+");
            
            for(staff i : staffArr){
                System.out.printf("|   %-9s|   %-20s|      %-10s|      %-12s|\n",i.getId(),i.getName(),i.getGender(),i.getUsername());
            }

            System.out.println("+========================================================================+");
            
            System.out.println("\n\n\nPress enter to back Entry Menu");
            scanf.nextLine();
            
            return -1;
        }
    }

    public static void entry() throws IOException, InterruptedException{
        int op;
        do{
            op = entryDisplayMenu();
            if(op == 1){
                op = login();
            }
            else if (op == 2){
                op = register();
            }
            else if (op == 3){
                op = displayAllstaff();
            }
        }
        while(op == -1);
    } 

    public static void viewProducts(int n){
        String[] id = {"SH","ST","PA"};
        if(products.isEmpty() == true){
            System.out.println("+==================================================================+");
            System.out.println("|  Product Id  |  Product Type  |  Product Name  |  Product Stock  |");
            System.out.println("+==================================================================+");
            for(int i = 0; i < 5 ; i++){
                if(i == 2){
                    System.out.println("|                        There is no data :(                       |"); 
                }
                else{
                    System.out.println("|                                                                  |");
                }
            }
            System.out.println("+==================================================================+");
            System.out.println("\n\n\nPress enter to back Entry Menu");
            scanf.nextLine();
        }
        else{
            System.out.println("+============================================================================+");
            System.out.println("|  Product Id  |  Product Type  |       Product Name       |  Product Stock  |");
            System.out.println("+============================================================================+");
            
            for(int i = 0 ; i < id.length ; i++ ){
                for(Products j : products){
                    if(j.getProduct_id().contains(id[i])){
                        System.out.printf("|    %-9s |     %-10s |          %-16s|       %-9d |\n",j.getProduct_id(),j.getProduct_type(),j.getProduct_name(),j.getProduct_stock());
                    }
                }
            }

            System.out.println("+============================================================================+");

            if(n == 1){
                System.out.println("\n\n\nPress enter to back Entry Menu");
                scanf.nextLine();
            }
        }
    }

    public static void addProducts() throws IOException, InterruptedException{
        String productName;
        String productType;
        int productStock;

        do{
            System.out.print("Product Name [ Length > 3 ] : ");
            productName = scanf.nextLine();
        }
        while(productName.length() < 3);

        do{
            System.out.print("Product Type [Shoes | Shirts | Pants] : ");
            productType = scanf.nextLine();
        }
        while(productType.equals("Shoes") == false && productType.equals("Shirts") == false && productType.equals("Pants") == false);

        do{
            System.out.print("Product Stock [ > 40 ] : ");
            productStock = scanf.nextInt();
            scanf.nextLine();
        }
        while(productStock < 40);


        if(productType.equals("Shoes")){
            Products shoes = new shoes(productName, productStock);
            products.add(shoes);
        }
        else if(productType.equals("Shirt")){
            Products shirt = new shirt(productName, productStock);
            products.add(shirt);
        }
        else if(productType.equals("Pants")){
            Products pants = new pants(productName, productStock);
            products.add(pants);
        }
        else{
            cls();
            System.out.println("Error in Add");
            System.out.println("\n\n\nPress enter to back to Menu");
            scanf.nextLine();
        }
    }

    public static void deleteProduct(){
        String productId;
        System.out.print("Product Id : ");
        productId = scanf.nextLine();
        
        for(int i = 0 ; i < products.size(); i++){
            if(products.get(i).getProduct_id().equals(productId)){
                products.remove(i);
            }
        }
    }
    
    public static int menu(){
        int op;
        System.out.println("Menu " + staffLogin.getName());
        System.out.println("===============");
        System.out.println("1. View Products and Stock");
        System.out.println("2. Add Product");
        System.out.println("3. Delete Product");
        System.out.println("4. Add Product Stock");
        System.out.println("4. Drop Product Stock");
        System.out.println("5. View History");
        System.out.println("6. Log out");
        System.out.print("Chose >> ");
        op = scanf.nextInt();
        scanf.nextLine();

        return op;
    }
    
    public static void main(String[] args) throws IOException, InterruptedException{
        int op;
        staff newStaff = new staff("Kelvin", "Kelvin123123", "Kelvin Giovanno", "Male");
        staffArr.add(newStaff);

        do{
            entry();
            do{ 
                op = menu();
                cls();
                switch(op){
                    case 1:
                        viewProducts(1);
                        break;
                    case 2:
                        addProducts();
                        break;
                    case 3:
                        viewProducts(0);
                        deleteProduct();
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                }
                cls();
            }
            while(op != 6);
        }
        while(true);
    }    

    // clear console
    public static void cls () throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
