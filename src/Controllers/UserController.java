package Controllers;

import Models.UserModel;

import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class UserController {

    public HashMap<Integer, UserModel> users;
    public UserController() {
        this.users = new HashMap<>();
    }

    public UserModel createUser(String firstname, String lastname, int age, String cpf) {
        Date createdAt = new Date();
        int id = new Random().nextInt(1000);
        UserModel user = new UserModel(id, firstname, lastname, age, cpf, createdAt);
        this.users.put(id, user);
        return user;
    }

    public UserModel getUser(int id) {
        if(this.users.containsKey(id)) {
            return this.users.get(id);
        }
        return null;
    }

    public UserModel deleteUser(int id) {
        if(this.users.containsKey(id)) {
            return this.users.remove(id);
        }
        return null;
    }
}
