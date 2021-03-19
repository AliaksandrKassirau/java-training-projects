package com.epam.cashier.services;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static com.epam.cashier.core.CashType.*;

import com.epam.cashier.core.CashType;
import com.epam.cashier.payments.BalanceInfo;

public class BalanceAggregationServiceImplTest {

	private static BalanceAggregationServiceImpl underTest;

	private BalanceInfo arg1;
	private BalanceInfo arg2;

	@BeforeAll
	public static void init() {
		underTest = new BalanceAggregationServiceImpl();
	}

	@BeforeEach
	public void initMethod() {
		arg1 = new BalanceInfo(0d, CashType.EUR);
		arg2 = new BalanceInfo(0d, CashType.BYN);
	}

	@Test
	public void aggreate_shouldThrowExceptionOnLessThen2Balances() {
		// Execution
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			underTest.aggregate(arg1);
		});

	}

	@Test
	public void aggreate_shouldThrowExceptionOnDifferentCacheTypes() {
		// Execution
		Assertions.assertThrows(IllegalStateException.class, () -> {
			underTest.aggregate(arg1, arg2);
		});

	}

	@ParameterizedTest
	@MethodSource("balances")
	public void aggreate_shouldValuesCorrectly(BalanceInfo a1, BalanceInfo a2, BalanceInfo result) {

		BalanceInfo aggregate = underTest.aggregate(a1, a2);

		Assertions.assertEquals(result, aggregate);
	}

	public static Stream<Arguments> balances() {
		return Stream.of(Arguments.of(bi(1d, BYN), bi(2d, BYN), bi(3d, BYN)),
				Arguments.of(bi(190d, EUR), bi(210d, EUR), bi(400d, EUR)),
				Arguments.of(bi(10d, USD), bi(20d, USD), bi(30d, USD)));
	}

	private static BalanceInfo bi(double v, CashType t) {
		return new BalanceInfo(v, t);
	}

}
