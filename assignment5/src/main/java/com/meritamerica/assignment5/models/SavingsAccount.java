package com.meritamerica.assignment5.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SavingsAccount extends BankAccount{
 
    static double interestRate = 0.01;
   
    
    public SavingsAccount(double openingBalance){
        super(openingBalance, interestRate);
    }
  
    public SavingsAccount(Long accountNumber, Double balance,
                          Double interestRate, Date openedOn) {
        super(accountNumber, balance, interestRate, openedOn);
    }
 
    public static SavingsAccount readFromString(String accountData) throws ParseException{
        try {
            String[] holding = accountData.split(",");
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(holding[3]);
            SavingsAccount newAccount =  new SavingsAccount(Long.valueOf(holding[0]), Double.valueOf(holding[1]),Double.valueOf(holding[2]), date);
            return newAccount;
        }
        catch(Exception exception) {
            throw new NumberFormatException();
        }
    }

}
