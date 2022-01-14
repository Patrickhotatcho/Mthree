package com.softra.bankingapp;


public interface CurrencyConvertor {
	final double USDTOAUDRATE = 1.4;
	final double AUDTOUSDRATE = 0.71;
	final double USDTOSGDRATE = 1.37;
	final double SGDTOUSDRATE = 0.73;
	
	double convertUSDToAUD(double USD);
	double convertAUDToUSD(double AUD);
	double convertUSDToSGD(double USD);
	double convertSGDToUSD(double SGD);
}
