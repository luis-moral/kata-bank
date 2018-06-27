package es.molabs.kata.bank;

import java.util.Date;

public class BankAccount
{
	private final StatementPrinter statementPrinter;
	private final TransactionRepository transactionRepository;
	
	public BankAccount(StatementPrinter statementPrinter, TransactionRepository transactionRepository)
	{
		this.statementPrinter = statementPrinter;
		this.transactionRepository = transactionRepository;
	}
	
	public void deposit(int amount)
	{
		transactionRepository.addTransaction(new Transaction(new Date().toString(), amount));
	}
	
	public void withdraw(int amount)
	{
		deposit(-amount);
	}
	
	public void printStatement()
	{		
		statementPrinter.print(transactionRepository.getTransactionList());
	}
}
