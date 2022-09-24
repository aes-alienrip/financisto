package ru.orangesoftware.financisto.graph;

import ru.orangesoftware.financisto.model.Currency;
import ru.orangesoftware.financisto.utils.Utils;


public class Amount implements Comparable<Amount> {
	
	public final Currency currency;
	public final long amount;

	public int amountTextWidth;
	public int amountTextHeight;

	public Amount(Currency currency, long amount) {
		this.currency = currency;
		this.amount = amount;
	}
	
	public String getAmountText() {
		return Utils.amountToString(currency, amount, true);
	}

    @Override
    public int compareTo(Amount that) {
        long thisAmount = Math.abs(this.amount);
        long thatAmount = Math.abs(that.amount);
        return thisAmount == thatAmount ? 0 : (thisAmount > thatAmount ? -1 : 1);
    }

}
