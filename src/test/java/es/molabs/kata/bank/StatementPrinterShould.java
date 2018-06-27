package es.molabs.kata.bank;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

@RunWith(JUnit4.class)
public class StatementPrinterShould
{
	@Test
	public void print_the_header()
	{
		Console console = Mockito.mock(Console.class);
		
		StatementPrinter printer = new StatementPrinter(console);
		printer.print(new ArrayList<Transaction>());
		
		Mockito
			.verify(console, Mockito.times(1))
			.print("DATE | AMOUNT | BALANCE");
	}
	
	@Test
	public void print_the_transactions()
	{
		Transaction transaction = new Transaction("25/06/2018", 100);	
		Console console = Mockito.mock(Console.class);
		
		StatementPrinter printer = new StatementPrinter(console);
		
		printer.print(Arrays.asList(transaction));
		
		Mockito
			.verify(console, Mockito.times(1))
			.print("DATE | AMOUNT | BALANCE");
		
		Mockito
			.verify(console, Mockito.times(1))
			.print(transaction.getDate() + " | " + transaction.getAmount() + " | " + transaction.getAmount());
	}
}
