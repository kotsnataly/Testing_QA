package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import model.Transaction;
import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


//хранилище всех балансов и активов в котором производится транзакция.
public class Vault implements Xeon {

    float totalVaultAmount = 1_000_000f;

    //история совершения операций
    List<Transaction> transactionList = new ArrayList<>();

    //логика отправки пользователем денег, с проверками на сумму баланса пользователя и сумму самого хранилища.
    public boolean makeTransaction(User userFrom, User userTo, float amount) throws IOException {

        //маппер на будущее для сериализации.
        //Пыталась использовать System.out для вывода в json формате, но программа закрывается при первой транзакции, пытаюсь исправить.
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter objectWriter = mapper.writerFor(Transaction.class);

        Transaction t = new Transaction();
        if (amount > this.totalVaultAmount) {
            //total vault sum is less than amount
            t.setSuccess(false);
            t.setReason("Amount is too large for the vault");
            t.setAmount(amount);
            t.setFromWho(userFrom);
            t.setToWhom(userTo);
            transactionList.add(t);

        } else if (userFrom.getUserAccount().getTotalSum() < amount) {
            //total sum is less than transaction sum
            t.setSuccess(false);
            t.setReason("This amount is inaccessible for the user");
            t.setFromWho(userFrom);
            t.setToWhom(userTo);
            t.setAmount(amount);
            transactionList.add(t);
        } else {
            userFrom.getUserAccount().setTotalSum(-amount);
            userTo.getUserAccount().setTotalSum(amount);

            t.setSuccess(true);
            t.setReason("Transaction done");
            t.setAmount(amount);
            t.setFromWho(userFrom);
            t.setToWhom(userTo);
            transactionList.add(t);
        }
        System.out.println(t);
        return t.isSuccess();
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public String printHistory() {
        System.out.println(transactionList);
        return transactionList.toString();
    }
}
