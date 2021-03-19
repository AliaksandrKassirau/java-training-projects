package com.epam.cashier.services;

import com.epam.cashier.core.CashType;
import com.epam.cashier.payments.BalanceInfo;

public class BalanceAggregationServiceImpl implements BalanceAggregationService {

	@Override
	public BalanceInfo aggregate(BalanceInfo... balanceInfos) {

		if (balanceInfos == null || balanceInfos.length < 2) {
			throw new IllegalArgumentException("Count of balances should 2 or more"); //case 1
		}

		CashType cashType = balanceInfos[0].getCashType();

		for (BalanceInfo balance : balanceInfos) {
			if (!cashType.equals(balance.getCashType())) {
				throw new IllegalStateException("CashType should be same for all aggregating balances"); //case 2 
			}
		}

		BalanceInfo balanceResult = new BalanceInfo(0.0d, cashType);

		for (BalanceInfo balance : balanceInfos) {
			balanceResult.setAmount(balanceResult.getAmount() + balance.getAmount()); //cases 3x
		}

		return balanceResult;
	}
}
