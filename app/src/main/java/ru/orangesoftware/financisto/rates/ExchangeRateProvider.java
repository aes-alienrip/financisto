package ru.orangesoftware.financisto.rates;

import ru.orangesoftware.financisto.model.Currency;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: denis.solonenko
 * Date: 1/30/12 7:46 PM
 */
public interface ExchangeRateProvider {

    ExchangeRate getRate(Currency fromCurrency, Currency toCurrency);

    ExchangeRate getRate(Currency fromCurrency, Currency toCurrency, long atTime);

    List<ExchangeRate> getRates(List<Currency> currencies);

}
