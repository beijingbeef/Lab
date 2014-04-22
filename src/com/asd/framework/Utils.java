package com.asd.framework;

public final class Utils {

	public static String[] parseCustomerToArray(ICustomer customer) {
		String[] result = new String[8];
		IAccount account = customer.getAccount();
		result[0] = customer.getName();
		result[1] = customer.getStreet();
		result[2] = customer.getCity();
		result[3] = customer.getState();
		result[4] = String.valueOf(customer.getZip());
		result[5] = customer.getType();
		result[6] = account.getType();
		result[7] = String.valueOf(account.getCurrentBalance());
		return result;
	}
}
