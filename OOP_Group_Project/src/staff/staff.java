package staff;
public class staff {
    static int idCount = 1;

    private String username;
    private String password;

    private String id;
    private String name;
    private String gender;
    
    
    public staff(String username, String password,String name, String gender){
        this.username = username;
        this.password = password;
        this.id = idGenerate();
        this.name = name;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    private String idGenerate(){
        String id;
        String idNum = Integer.toString(idCount++);

        if(idNum.length() == 1){
            idNum = "00" + idNum;
        }
        else if(idNum.length() == 2){
            idNum = "0" + idNum;
        }

        id = "ST" + idNum;
        return id;        
    }
}
