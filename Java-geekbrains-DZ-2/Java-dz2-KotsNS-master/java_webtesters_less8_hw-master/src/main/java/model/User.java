package model;

public class User {

    private PersonalUserAccount userAccount;
    private String userName;
    private Long userId;

    public User(Long userId, String userName, PersonalUserAccount userAccount) {
        this.userAccount = userAccount;
        this.userName = userName;
        this.userId = userId;
    }


    public PersonalUserAccount getUserAccount() {
        return userAccount;
    }

    @Override
    public String toString() {
        return "User{" +
                "userAccount=" + userAccount +
                ", userName='" + userName + '\'' +
                ", userId=" + userId +
                '}';
    }
}
