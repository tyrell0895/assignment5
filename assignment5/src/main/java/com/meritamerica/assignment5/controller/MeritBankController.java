package com.meritamerica.assignment5.controller;
import com.meritamerica.assignment5.models.*;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeritBankController {
	 List<String> strings = new ArrayList<String>();

	  

	    @RequestMapping(value = "/", method = RequestMethod.GET)
	    public String test() {
	        return "This is a Test ";
	    }



	    @GetMapping(value = "/AccountHolders")
	    @ResponseStatus(HttpStatus.OK)
	    public com.meritamerica.assignment5.models.AccountHolder[] getAccoungHolder(){
	        return MeritBank.getAccountHolders();
	    }

	    @PostMapping(value = "/AccountHolders")
	    @ResponseStatus(HttpStatus.CREATED)
	    public AccountHolder addAccountHolder(@RequestBody @Valid AccountHolder accountHolder) {
	        MeritBank.addAccountHolder(accountHolder);
	        return accountHolder;
	    }

	    

	    @GetMapping(value = "/AccountHolders/{id}")
	    public AccountHolder getACById(@PathVariable (name = "id" )long id)  throws NotFoundException {
	    
	        return MeritBank.getAccountHolder(id);
	    }

	    @PostMapping(value ="/AccountHolders/{id}/CheckingAccounts")
	    @ResponseStatus(HttpStatus.CREATED)
	    public CheckingAccount addCheckingAccount(@RequestBody @Valid CheckingAccount checkingAccount, @PathVariable
	            (name = "id") long id) throws ExceedsCombinedBalanceLimitException, NotFoundException, NegativeAmountException, ExceedsFraudSuspicionLimitException{
	        AccountHolder acctH = MeritBank.getAccountHolder(id);
	        acctH.addCheckingAccount(checkingAccount);
	        return checkingAccount;
	    }

	    @GetMapping(value = "/AccountHolders/{id}/CheckingAccounts")
	    @ResponseStatus(HttpStatus.OK)
	    public CheckingAccount[] getCheckingAccount(@PathVariable (name = "id") long id) throws NotFoundException {
	        AccountHolder acctH = MeritBank.getAccountHolder(id);
	        return acctH.getCheckingAccounts();
	    }
	    @PostMapping(value ="/AccountHolders/{id}/SavingsAccounts")
	    @ResponseStatus(HttpStatus.CREATED)
	    public SavingsAccount addSavingsAccount(@RequestBody @Valid SavingsAccount savingsAccount, @PathVariable
	            (name = "id") long id) throws ExceedsCombinedBalanceLimitException, NotFoundException, ExceedsFraudSuspicionLimitException, NegativeAmountException{
	        AccountHolder acctH = MeritBank.getAccountHolder(id);
	        acctH.addSavingsAccount(savingsAccount);
	        return savingsAccount;
	    }

	    @GetMapping(value = "/AccountHolders/{id}/SavingsAccounts")
	    @ResponseStatus(HttpStatus.OK)
	    public SavingsAccount[] getSavingsAccount(@PathVariable (name = "id") long id) throws NotFoundException {
	        AccountHolder acctH = MeritBank.getAccountHolder(id);
	        return acctH.getSavingsAccounts();
	    }

	    @PostMapping(value ="/AccountHolders/{id}/CDAccounts")
	    @ResponseStatus(HttpStatus.CREATED)
	    public CDAccount addCDAccount(@RequestBody @Valid CDAccount cdAccount, @PathVariable
	            (name = "id") long id) throws ExceedsCombinedBalanceLimitException, NotFoundException, NegativeAmountException, ExceedsFraudSuspicionLimitException{
	        AccountHolder acctH = MeritBank.getAccountHolder(id);
	        acctH.addCDAccount(cdAccount);
	        return cdAccount;
	    }

	    @GetMapping(value = "/AccountHolders/{id}/CDAccounts")
	    @ResponseStatus(HttpStatus.OK)
	    public CDAccount[] getCDAccount(@PathVariable (name = "id") long id) throws NotFoundException {
	        AccountHolder acctH = MeritBank.getAccountHolder(id);
	        return acctH.getCDAccounts();
	    }

	    @PostMapping(value ="/CDOffering")
	    @ResponseStatus(HttpStatus.CREATED)
	    public CDOffering addCDOffering(@RequestBody @Valid CDOffering cdOffering, @PathVariable
	            (name = "id") long id) {
	        MeritBank.addCDOffering(cdOffering);
	        return cdOffering;
	    }

	    @GetMapping(value = "/CDOffering")
	    @ResponseStatus(HttpStatus.OK)
	    public CDOffering[] getCDOffering() throws NotFoundException {
	        return MeritBank.getCDOfferings();
	    }



	}


