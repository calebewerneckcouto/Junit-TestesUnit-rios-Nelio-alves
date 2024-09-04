package aula_junit_nelioAlves.entities;

public class Account {

	public static double DEPOSIT_FF_PERCENTAGE = 0.02;
	private long id;
	private Double balance;

	public Account() {

	}

	public Account(long id, Double balance) {
		super();
		this.id = id;
		this.balance = balance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getBalance() {
		return balance;
	}

	public void deposit(double amount) {

		if (amount > 0) {
			amount -= amount * DEPOSIT_FF_PERCENTAGE;
			balance += amount;
		}

	}
	
	public void withdraw(double amount) {
		if ( amount > balance) {
		throw new IllegalArgumentException();
		}
		balance -= amount;
	}
	
	public double fullWithdraw() {
		double aux = balance;
		balance = 0.0;
		return aux;
				
	}

}
