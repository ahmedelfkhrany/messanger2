/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messenger.DatabaseLayer;

import java.util.ArrayList;
import messenger.ModelLayer.User;

/**
 *
 * @author AL MASRIA 4 COMP
 */
public class UserArraylistRepository extends UserRepository{

    ArrayList<User> users = new ArrayList<User>();

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);

    }

    public void addUser(String id, String name) {
        users.add(new User(id, name));
    }

    public String toString() {
        String fullString = "";
        
        for (User user : users) {
            fullString += user + "\n";
        }
        return fullString;
    }

    @Override
    public void deleteUser(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getUserById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getAllUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
