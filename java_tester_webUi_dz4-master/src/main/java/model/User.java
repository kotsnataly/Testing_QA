package model;


public class User {

    private Long id;
    private String name;
    private String email;
    private int age;


    public User() {
    }

    public User(String init) {
        String[] userInit = null;
        if(init.contains(",")) {
            userInit = init.split(",");
        } else {
            userInit = init.split(" ");
        }
        this.id = Long.parseLong(userInit[0]);
        this.name = userInit[1];
        this.email = userInit[2];
        this.age = Integer.parseInt(userInit[3]);
    }

    public User(Long id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public User(long id, String name, int age, String email) {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    private int Age;
}
