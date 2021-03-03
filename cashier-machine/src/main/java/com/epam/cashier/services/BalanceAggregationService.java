package com.epam.cashier.services;

import com.epam.cashier.payments.BalanceInfo;

public interface BalanceAggregationService {

	BalanceInfo aggregate(BalanceInfo... balanceInfos);

}
