import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import staff.staff;


public class Main {
    private static Scanner scanf = new Scanner(System.in);
    private static ArrayList<staff> staffArr = new ArrayList<>();
  
    public static int entryDisplayMenu() throws IOException, InterruptedException{
        int op;
        do{
            cls();
            System.out.println("Hello and Wellcome");
            System.out.println("==================");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("==================");
            System.out.print("Chose >> ");
            op = scanf.nextInt();
            scanf.nextLine();
        }   
        while(op != 1 && op != 2);
        return op;
    }

    public static int login() throws IOException, InterruptedException{
        String username, password,command;
        int flag = -1;

        do{
            cls();
            System.out.println("Type \"Back\" if you go back to menu");
            System.out.println("Type \"Conti\" if you Still want Login");
            command = scanf.nextLine();
            
            cls();
            System.out.println("Login");
            System.out.println("=================");
            System.out.print("Username : ");
            username = scanf.nextLine();
            System.out.print("Password : ");
            password = scanf.nextLine();
            
            for(staff i : staffArr){
                if(i.getUsername().equals(username)&& i.getPassword().equals(password)){
                    flag = 0;
                }
            }

            cls();

            if(flag == -1){
                System.out.println("Sry we cant find your Account :(");
                System.out.println("Press Enter to Back Login Section");
                scanf.nextLine();
            }
            else if(flag == 0){
                System.out.println("Login successfully");
                System.out.println("Press Enter to go to Menu");
                scanf.nextLine();
                return 0;
            }
        }
        while(flag == -1 || command == "Back");
        return -1;
    }

    public static int register() throws IOException, InterruptedException{
        String username;
        String password;
        String command;

        cls();
        System.out.println("Type \"Back\" if you go back to menu");
        System.out.println("Type \"Conti\" if you Still want Register");
        command = scanf.nextLine();

        if(command == "Back"){
            return -1;
        }

        cls();
        System.out.println("Register");
        System.out.println("=========");
        System.out.print("Username : ");
        username = scanf.nextLine();
        System.out.print("Password : ");
        password = scanf.nextLine();

        staff newsStaff = new staff(username, password);
        staffArr.add(newsStaff);

        return -1;

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
        }
        while(op == -1);
    } 

    public static int menu(){
        int op;
        System.out.println("Menu  ");
        System.out.println("===============");
        System.out.println("1. ");
        System.out.println("2. ");
        System.out.println("3. ");
        System.out.println("4. ");
        System.out.println("5. ");
        System.out.print("Chose >> ");
        op = scanf.nextInt();
        scanf.nextLine();

        return op;
    }

    
    public static void main(String[] args) throws IOException, InterruptedException{
        int op;
        do{
            entry();
            op = menu();
            switch(op){
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
            }
        }
        while(op == 5);
    }    

    public static void cls () throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
