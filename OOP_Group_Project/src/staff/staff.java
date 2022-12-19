package staff;

import java.util.ArrayList;

public class staff {
    private ArrayList<staff> staffList = new ArrayList<>();
    private String username;
    private String password;
    
    public staff(String username, String password){
        this.username = username;
        this.password = password;
        staff newStaff = new staff(this.username, this.password);
        staffList.add(newStaff);
    }

    public boolean login(String username, String password){
        if(staffList.isEmpty() == true){
            return false;
        }
        else{
            for(int i = 0; i < staffList.size(); i++){
                if(username == staffList.get(i).username && password == staffList.get(i).password){
                    return true;
                }
            }
            return false;
        }
    }

}
