package com.epam.cashier;

import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomLoggerFactory {

	public static CustomLogger getLogger(Class clazz) {
		return new CustomLogger(LoggerFactory.getLogger(clazz));
	}

	static public class CustomLogger {

		private Logger log;

		public CustomLogger(Logger log) {
			super();
			this.log = log;
		}

		public <T> T logOperation(String message, Callable<T> operation) {
			try {
				T call = operation.call();
				log.info(message);
				return call;
			} catch (Exception e) {
				log.error("Something went wrong", e);
				throw new RuntimeException(e);
			}

		}

	}

}
