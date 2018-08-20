package com.test.visitor;

public abstract class AbstractBill implements Bill{

	 protected double amount;
	    protected String item;
	    public AbstractBill(double amount, String item) {
	        super();
	        this.amount = amount;
	        this.item = item;
	    }
	    public double getAmount() {
	        return amount;
	    }

	    public String getItem() {
	        return item;
	    }


}
