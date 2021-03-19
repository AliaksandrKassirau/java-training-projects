package com.epam.cashier.payments;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import com.epam.cashier.bank.Transaction;
import com.epam.cashier.core.CashType;
import com.epam.cashier.payments.banks.BankService;
import com.epam.cashier.payments.transactions.GetBalanceTransactionPayload;

public class VisaPaymentSystemServiceTest {

	@Test
	public void getBalanceInfo() {

		@SuppressWarnings("unchecked")
		Map<String, BankService> mock = mock(Map.class);
		BankService bankServiceMock = mock(BankService.class);

		when(mock.get("123")).thenReturn(bankServiceMock);
		when(bankServiceMock.getBalanceInfo(new byte[] { 1, 2, 3 })).thenReturn(new BalanceInfo(10d, CashType.BYN));

		VisaPaymentSystemService underTest = new VisaPaymentSystemService(mock);

		BalanceInfo balanceInfo = underTest
				.getBalanceInfo(new GetBalanceTransactionPayload(new byte[] { 1, 2, 3 }, "123", CashType.BYN));

		Assertions.assertEquals(10d, balanceInfo.getAmount());
		verify(mock, times(1)).get("123");
		
		
		
	}

}
