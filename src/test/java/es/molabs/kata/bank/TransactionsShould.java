package es.molabs.kata.bank;

import java.util.Date;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TransactionsShould
{
	@Test
	public void calculate_final_balance()
	{
		TransactionRepository transactions = new TransactionRepository();
		transactions.addTransaction(new Transaction(new Date().toString(), 100));
		
		Assert.assertThat(transactions.getFinalBalance(), Is.is(100));
	}
}
