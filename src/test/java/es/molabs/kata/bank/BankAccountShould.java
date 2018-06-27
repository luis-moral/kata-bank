package es.molabs.kata.bank;

import java.util.List;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

@RunWith(JUnit4.class)
public class BankAccountShould
{
	@Test
	public void allow_deposits()
	{
		TransactionRepository transactionRepositoy = new TransactionRepository();
		BankAccount bankAccount = new BankAccount(new StatementPrinter(new Console()), transactionRepositoy);
		
		bankAccount.deposit(100);
		
		Assert.assertThat(transactionRepositoy.getFinalBalance(), Is.is(100));
	}
	
	@Test
	public void allow_withdraws()
	{
		TransactionRepository transactionRepository = new TransactionRepository();
		BankAccount bankAccount = new BankAccount(new StatementPrinter(new Console()), transactionRepository);
		
		bankAccount.withdraw(50);
		
		Assert.assertThat(transactionRepository.getFinalBalance(), Is.is(-50));
	}
	
	@Test
	public void print_statement()
	{		
	//	Console console = Mockito.mock(Console.class);
		StatementPrinter statementPrinter = Mockito.mock(StatementPrinter.class);
		TransactionRepository transactionRepository = new TransactionRepository();
		BankAccount bankAccount = new BankAccount(statementPrinter, transactionRepository);
		
		bankAccount.deposit(1000);
		bankAccount.printStatement();
		
		List<Transaction> transactionList = transactionRepository.getTransactionList();
		
		Mockito
			.verify(statementPrinter, Mockito.times(1))
			.print(transactionList);
	}
}
