package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// объект сохраняющий данные о времени , сумме и адресате транзакции.
public class Transaction {

    private boolean success = false;
    private String reason;
    private float amount;
    private User toWhom;
    private User fromWho;


    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
    private String dt = LocalDateTime.now().format(formatter);

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setToWhom(User toWhom) {
        this.toWhom = toWhom;
    }

    public void setFromWho(User fromWho) {
        this.fromWho = fromWho;
    }
    @Override
    public String toString() {
        return "Transaction{" +
                "success=" + success +
                ", reason='" + reason + '\'' +
                ", amount=" + amount +
                ", toWhom=" + toWhom +
                ", fromWho=" + fromWho +
                ", formatter=" + formatter +
                ", dt='" + dt + '\'' +
                '}';
    }

 }
