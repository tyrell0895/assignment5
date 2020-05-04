package com.meritamerica.assignment5.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckingAccount extends BankAccount{
   
    static double interestRate = 0.0001;

    public CheckingAccount(double openingBalance){
        super(openingBalance, interestRate);
    }

    
    public CheckingAccount(Long accountNumber, Double balance,
                           Double interestRate, Date openedOn) {
        super(accountNumber, balance, interestRate, openedOn);
    }

    public static CheckingAccount readFromString(String accountData) throws ParseException{
        try {
            String[] temp = accountData.split(",");
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(temp[3]);
            CheckingAccount newAccount =  new CheckingAccount(Long.valueOf(temp[0]), Double.valueOf(temp[1]),Double.valueOf(temp[2]), date);
            return newAccount;
        }
        catch(Exception exception) {
            throw new NumberFormatException();
        }
    }
}
