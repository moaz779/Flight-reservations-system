package FlightReservation;
import InputOutput.Input;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;
    public User(String username, String password){
        this.username = username;
        this.password = password;
        Input.users.add(this);
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public static void searchUsers(){
        int i = 1;
        System.out.println("~~ Users List ~~");
        for(User user: Input.users){
            System.out.printf("%d)%s\n",i++,user);
        }
    }
}
