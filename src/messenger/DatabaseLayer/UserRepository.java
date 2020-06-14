/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messenger.DatabaseLayer;

import messenger.ModelLayer.User;

public abstract class UserRepository {

    public abstract void addUser(User user);

    public abstract void addUser(String id, String name);
    
    public abstract void deleteUser(String id);
    
    public abstract void getUserById(String id);
    
    public abstract void getAllUsers();

}
