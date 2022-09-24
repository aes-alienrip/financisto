package ru.orangesoftware.financisto.activity;

import android.content.Intent;
import ru.orangesoftware.financisto.R;
import ru.orangesoftware.financisto.filter.WhereFilter;
import ru.orangesoftware.financisto.db.BudgetsTotalCalculator;
import ru.orangesoftware.financisto.model.Budget;
import ru.orangesoftware.financisto.model.Total;

import java.util.List;

public class BudgetListTotalsDetailsActivity extends AbstractTotalsDetailsActivity  {

    private WhereFilter filter = WhereFilter.empty();
    private BudgetsTotalCalculator calculator;
    
    public BudgetListTotalsDetailsActivity() {
        super(R.string.budget_total_in_currency);
    }

    @Override
    protected void internalOnCreate() {
        Intent intent = getIntent();
        if (intent != null) {
            filter = WhereFilter.fromIntent(intent);
        }
    }

    @Override
    protected void prepareInBackground() {
        List<Budget> budgets = db.getAllBudgets(filter);
        calculator = new BudgetsTotalCalculator(db, budgets);
        calculator.updateBudgets(null);
    }

    protected Total getTotalInHomeCurrency() {
        return calculator.calculateTotalInHomeCurrency();
    }

    protected Total[] getTotals() {
        return calculator.calculateTotals();
    }

}
