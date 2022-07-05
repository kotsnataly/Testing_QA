package model;

public class User {
    private int id;
    private String name;
    private String email;

    public User() {
    }

    public User(String init) {
        String[] userInit = init.split(",");
        this.id = Integer.parseInt(userInit[0]);
        this.name = userInit[1];
        this.email = userInit[2];
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
