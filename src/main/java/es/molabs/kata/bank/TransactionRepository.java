package es.molabs.kata.bank;

import java.util.LinkedList;
import java.util.List;

public class TransactionRepository
{
	private List<Transaction> transactionList;
	
	public TransactionRepository()
	{
		transactionList = new LinkedList<Transaction>();
	}
	
	public void addTransaction(Transaction transaction)
	{
		transactionList.add(transaction);
	}
	
	public int getFinalBalance()
	{
		int amount = 0;
		
		for (int i=0; i<transactionList.size(); i++)
		{
			amount += transactionList.get(i).getAmount();
		}
		
		return amount;
	}

	public List<Transaction> getTransactionList()
	{
		return transactionList;
	}
}
