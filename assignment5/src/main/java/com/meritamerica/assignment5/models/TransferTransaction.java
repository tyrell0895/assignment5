package com.meritamerica.assignment5.models;

import java.util.Date;

public class TransferTransaction extends Transaction{
    /**
     * Constructor  for the transfer transaction object
     * @param sourceAccount
     * @param targetAccount
     * @param amount
     */
    TransferTransaction(BankAccount sourceAccount, BankAccount targetAccount, double amount){
        account = sourceAccount;
        this.targetAccount = targetAccount;
        this.amount = amount;
        this.date = new Date();
    }

}

