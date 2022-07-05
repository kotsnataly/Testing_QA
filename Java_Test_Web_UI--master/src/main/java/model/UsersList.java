package model;

import java.io.Serializable;
import java.util.Collection;


public class UsersList implements Serializable {
    Collection<User> users;

    public Collection<User> getUsers() {
        return users;
    }

    public UsersList setUsers(Collection<User> users) {
        this.users = users;
        return null;
    }

}
