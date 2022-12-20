package staff;

import java.util.ArrayList;

public class staff {
    private String username;
    private String password;
    
    public staff(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
