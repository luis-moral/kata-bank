package es.molabs.kata.bank;

import java.text.DecimalFormat;
import java.util.List;

public class StatementPrinter
{
	private final static DecimalFormat FORMAT;
	
	static
	{
		FORMAT = new DecimalFormat("0.##");
	}
	
	private final Console console;
	
	public StatementPrinter(Console console)
	{
		this.console = console;
	}
	
	public void print(List<Transaction> transactionList)
	{
		int currentBalance = 0; 
		
		console.print("DATE | AMOUNT | BALANCE");
		
		for (int i = 0; i < transactionList.size(); i++)
		{
			Transaction transaction = transactionList.get(i);
			
			currentBalance += transaction.getAmount();
			
			console.print(formatLine(transaction, currentBalance));
		}
	}
	
	private String formatLine(Transaction transaction, int currentBalance)
	{
		return
			transaction.getDate() +
			" | " +
			FORMAT.format(transaction.getAmount()) +
			" | " +
			FORMAT.format(currentBalance);
	}
}
