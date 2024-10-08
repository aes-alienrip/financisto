package ru.orangesoftware.financisto.activity;

import android.content.Intent;
import ru.orangesoftware.financisto.R;
import ru.orangesoftware.financisto.blotter.*;
import ru.orangesoftware.financisto.filter.WhereFilter;
import ru.orangesoftware.financisto.model.Total;

public class BlotterTotalsDetailsActivity extends AbstractTotalsDetailsActivity  {

    private volatile TotalCalculationTask totalCalculationTask;

    public BlotterTotalsDetailsActivity() {
        super(R.string.blotter_total_in_currency);
    }

    @Override
    protected void internalOnCreate() {
        Intent intent = getIntent();
        if (intent != null) {
            WhereFilter blotterFilter = WhereFilter.fromIntent(intent);
            cleanupFilter(blotterFilter);
            totalCalculationTask = createTotalCalculationTask(blotterFilter);
        }
    }

    private void cleanupFilter(WhereFilter blotterFilter) {
        blotterFilter.remove(BlotterFilter.BUDGET_ID);
    }

    private TotalCalculationTask createTotalCalculationTask(WhereFilter blotterFilter) {
        WhereFilter filter = WhereFilter.copyOf(blotterFilter);
        if (filter.getAccountId() > 0) {
            shouldShowHomeCurrencyTotal = false;
            return new AccountTotalCalculationTask(this, db, filter, null);
        } else {
            return new BlotterTotalCalculationTask(this, db, filter, null);
        }
    }

    protected Total getTotalInHomeCurrency() {
        return totalCalculationTask.getTotalInHomeCurrency();
    }

    protected Total[] getTotals() {
        return totalCalculationTask.getTotals();
    }

}
