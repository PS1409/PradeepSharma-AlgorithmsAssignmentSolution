package com.greatlearning.stocker.service;

import com.greatlearning.stocker.objects.CompanyStock;


public class SearchingStocks {
      
	// Function used for searching the company stock using price 
	public void searchStockByPrice(CompanyStock[] stocks, double searchPrice)
	{
		boolean isStockExists = false;
		 for(int i = 0; i<stocks.length; i++)
		 {
			 if(stocks[i].stockPrice == searchPrice)
			 {
				 isStockExists =true;
				 break;
			 }
		 }
		 if(isStockExists)
		 {
			 System.out.println("Stock of value "+ searchPrice +" is present");
		 }
		 else
		 {
			 System.out.println("Stock of value "+ searchPrice +" is not present");
		 }
	}
	
	// Function that counts total no of companies for which stock prices rose today
	public void totalcompanyStockRise(CompanyStock[] stocks)
	{
		int counts = 0;
		 for(int i = 0; i<stocks.length; i++)
		 {
			 if(stocks[i].isPriceIncreased)
			 {
				 counts++;				
			 }
		 }
		 System.out.println("Total no of companies whose stock price rose today : " + counts);
		 
	}
	
	// Function that counts total no of companies for which stock prices declined today
	public void totalcompanyStockDeclined(CompanyStock[] stocks)
	{
		int counts = 0;
		 for(int i = 0; i<stocks.length; i++)
		 {
			 if(!stocks[i].isPriceIncreased)
			 {
				 counts++;				
			 }
		 }			 
		System.out.println("Total no of companies whose stock price declined today : " + counts);			 
	}
}
