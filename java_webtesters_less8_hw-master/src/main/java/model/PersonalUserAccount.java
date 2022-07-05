package model;

// кошелек пользователя который привязывается к сущности User.
public class PersonalUserAccount {

    private float totalSum;

    public PersonalUserAccount() {
    }

    public float getTotalSum() {
        return totalSum;
    }

    synchronized public void setTotalSum(float totalSum) {
        this.totalSum += totalSum;
    }
}
