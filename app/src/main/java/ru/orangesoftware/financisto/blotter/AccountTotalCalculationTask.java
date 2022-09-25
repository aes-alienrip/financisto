package ru.orangesoftware.financisto.blotter;

import android.content.Context;
import android.widget.TextView;
import ru.orangesoftware.financisto.db.DatabaseAdapter;
import ru.orangesoftware.financisto.db.TransactionsTotalCalculator;
import ru.orangesoftware.financisto.filter.WhereFilter;
import ru.orangesoftware.financisto.model.Total;

import static ru.orangesoftware.financisto.db.DatabaseAdapter.enhanceFilterForAccountBlotter;

public class AccountTotalCalculationTask extends TotalCalculationTask {

	private final DatabaseAdapter db;
	private final WhereFilter filter;

	public AccountTotalCalculationTask(Context context, DatabaseAdapter db, WhereFilter filter, TextView totalText) {
        super(context, totalText);
		this.db = db;
		this.filter = enhanceFilterForAccountBlotter(filter);
	}

    @Override
    public Total getTotalInHomeCurrency() {
        TransactionsTotalCalculator calculator = new TransactionsTotalCalculator(db, filter);
        return calculator.getAccountTotal();
    }

    @Override
    public Total[] getTotals() {
        TransactionsTotalCalculator calculator = new TransactionsTotalCalculator(db, filter);
        return calculator.getTransactionsBalance();
    }

}
