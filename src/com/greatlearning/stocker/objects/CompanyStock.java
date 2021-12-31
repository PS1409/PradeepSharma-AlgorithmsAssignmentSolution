package com.greatlearning.stocker.objects;

public class CompanyStock {
    public double stockPrice;
    public boolean isPriceIncreased;
    
    public CompanyStock(double price, boolean isIncreased)
    {
    	stockPrice = price;
    	isPriceIncreased  = isIncreased;
    }
}
