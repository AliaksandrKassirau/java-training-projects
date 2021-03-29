package com.epam.webapplication.listener;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestCounter implements ServletRequestListener {

	private static final AtomicInteger COUNTER = new AtomicInteger(0);

	public void requestInitialized(ServletRequestEvent sre) {
		int currentCounterValue = COUNTER.incrementAndGet();
		log.info("Current request count:" + currentCounterValue);
	}

}
