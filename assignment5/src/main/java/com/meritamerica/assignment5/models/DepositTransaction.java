package com.meritamerica.assignment5.models;
import java.util.Date;

public class DepositTransaction extends Transaction{
    /**
     * a Constructor for a deposit transaction
     * @param targetAccount
     * @param amount
     */
    public DepositTransaction(BankAccount targetAccount, double amount){
        account = null;
        this.targetAccount = targetAccount;
        this.amount = amount;
        this.date = new Date();
    }

}
