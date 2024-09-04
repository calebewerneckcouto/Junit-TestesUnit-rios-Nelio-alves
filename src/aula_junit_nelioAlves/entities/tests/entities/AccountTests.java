package aula_junit_nelioAlves.entities.tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import aula_junit_nelioAlves.entities.Account;
import aula_junit_nelioAlves.entities.tests.factory.AccountFactory;

public class AccountTests {
	@Test
	public void depositShouldIncreaseBalanceWhenPositiveAmount() {

		double amount = 200.00;

		double expectedValue = 196.00;
		Account account = AccountFactory.createEmptyAccount();

		account.deposit(amount);

		Assertions.assertEquals(expectedValue, account.getBalance());

	}

	@Test
	public void depositShouldDoNothingNegativeAmount() {
		double expectedValue = 100.00;
		Account account = AccountFactory.createAccount(expectedValue);
		double amount = -200.00;

		account.deposit(amount);
		Assertions.assertEquals(expectedValue, account.getBalance());
	}
	
	@Test
	public void fullWithdrawShouldClearBalance() {
		
		double expectedValue = 0.0;
		double initialBalance = 800.00;
		Account acc =  AccountFactory.createAccount(initialBalance);
		double result = acc.fullWithdraw();
		
		Assertions.assertTrue(expectedValue == acc.getBalance());
		Assertions.assertTrue(result == initialBalance);
		
	}
	@Test
	public void withDrawShouldDecreaseBalanceWhenSufficientBalance() {
		
		Account acc =  AccountFactory.createAccount(800.00);
		acc.withdraw(500.00);
		
		Assertions.assertEquals(300.00, acc.getBalance());
		
	}
	
	
	@Test
	public void withDrawShouldThrowExceptionWhenInsufficientBalance() {
		
		
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Account acc =  AccountFactory.createAccount(800.00);
			acc.withdraw(802.00);
		});
		
	}


}
