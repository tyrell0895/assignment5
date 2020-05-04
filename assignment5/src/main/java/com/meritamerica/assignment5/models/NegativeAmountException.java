package com.meritamerica.assignment5.models;


public class NegativeAmountException extends Exception{
    /**
     * Static variable that cannot be  changed or call on from outside the class
     */
    private static final long serialVersionUID = 1L;
    /**
     *A constructor for this exception
     * @param errorMessage
     */
    public NegativeAmountException(String errorMessage){
        super(errorMessage);
    }
}
