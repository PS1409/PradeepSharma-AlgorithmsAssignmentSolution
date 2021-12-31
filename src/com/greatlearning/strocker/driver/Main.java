package com.greatlearning.strocker.driver;

import java.util.Scanner;
import java.util.InputMismatchException;
import com.greatlearning.stocker.objects.CompanyStock;
import com.greatlearning.stocker.service.*;

public class Main {

   private static Scanner scanner =  new Scanner(System.in);	
	public static void main(String[] args) {
		
		// getting the total no of companies from user
		int totalCompanies = 0;
		while(totalCompanies < 1)
		{
			 System.out.println("Enter the no of companies");
			 totalCompanies = scanner.nextInt();
			 if(totalCompanies < 1)
			 {
				 System.out.println("Please enter atleast one company to proceed");
			 }
		}
		
		try
		{
			
			// insert stock values to the stock array
			CompanyStock[] stocks = new CompanyStock[totalCompanies];
			double price;
			boolean priceChanges;
			for(int i = 0; i < totalCompanies; i++)
			{
				System.out.println("Enter current stock price of the company " + (i+1));
				price = scanner.nextDouble();
				System.out.println("Whether company's stock price rose today compare to yesterday?");
				priceChanges = scanner.nextBoolean();
				stocks[i]= new CompanyStock(price, priceChanges); 
			}
			
			//performing operations 
			performOperations(stocks);
		}
		catch(InputMismatchException ex)
		{
			System.out.println("Invalid input provided. please check the input and try again");
			System.out.println("Exception details are as follows : " + ex.getMessage());
		}
	}
    
	private static void performOperations(CompanyStock[] stocks)
	{
		boolean stop = false;
		SortingStocks sorting = new SortingStocks();
		SearchingStocks searching = new SearchingStocks();
		while(!stop)
		{
			 System.out.println("----------------------------------------------------");
			 System.out.println("Enter the operation that you want to perform");
			 System.out.println("1. Display the companies stock prices in ascending order");
			 System.out.println("2. Display the companies stock prices in descending order");
			 System.out.println("3. Display the total no of companies for which stock prices rose today");
			 System.out.println("4. Display the total no of companies for which stock prices declined today");
			 System.out.println("5. Search a specific stock price");
			 System.out.println("6. press 0 to exit");
			 System.out.println("----------------------------------------------------");
			 int choice = scanner.nextInt();
			 switch(choice)
			 {
				 case 0:
					 System.out.println("Exited successfully");
					 stop = true;
					 break;
				 case 1:
					 System.out.println("Stock prices in ascending order are :");
					 sorting.sortAscending(stocks, 0, stocks.length-1);
					 DisplayStockPrice(stocks);
					 break;
				 case 2:
					 System.out.println("Stock prices in descending order are :");
					 sorting.sortDescending(stocks, 0, stocks.length-1);
					 DisplayStockPrice(stocks);
					 break;
				 case 3:
					 searching.totalcompanyStockRise(stocks);
					 break;
				 case 4:
					 searching.totalcompanyStockDeclined(stocks);
					 break;
				 case 5:
					 System.out.println("enter the key value");
					 double searchPrice = scanner.nextDouble();
					 searching.searchStockByPrice(stocks, searchPrice);
					 break;				 
				 default:
					 System.out.println("Invalid choice!");
					 break;
			 }
		}
	}
	
	private static void DisplayStockPrice(CompanyStock[] stocks)
	{
		 for (int i = 0; i < stocks.length; i++) {
				System.out.print(stocks[i].stockPrice + " ");
			}
		 System.out.println("");
	}
}
