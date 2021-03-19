package com.epam.cashier.payments;

import com.epam.cashier.core.CashType;

public class BalanceInfo {
	private double amount;
	private CashType cashType;

	public BalanceInfo(double amount, CashType cashType) {
		this.amount = amount;
		this.cashType = cashType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public CashType getCashType() {
		return cashType;
	}

	@Override
	public String toString() {
		return amount + " " + cashType.name();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((cashType == null) ? 0 : cashType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BalanceInfo other = (BalanceInfo) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (cashType != other.cashType)
			return false;
		return true;
	}
	
}
