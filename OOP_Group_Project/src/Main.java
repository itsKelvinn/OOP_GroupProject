import staff.staff;

public class Main {
    
    staff nodeStaff;
    public void register(String username, String password){
        nodeStaff = new staff(username,password);
    }

    public void login(String username , String passwoString){
        nodeStaff.login(username, passwoString);
    }

    //Display Login and Register
    public void DisplayloginRegister(){
        
    }

    public void displayMenu(){
        System.out.println("");
    }


    
    public static void main(String[] args){

    }
}
