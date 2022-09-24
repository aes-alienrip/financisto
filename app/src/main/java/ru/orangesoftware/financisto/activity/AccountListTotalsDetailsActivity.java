package ru.orangesoftware.financisto.activity;

import ru.orangesoftware.financisto.R;
import ru.orangesoftware.financisto.model.Total;

/**
 * Created by IntelliJ IDEA.
 * User: denis.solonenko
 * Date: 3/15/12 16:40 PM
 */
public class AccountListTotalsDetailsActivity extends AbstractTotalsDetailsActivity  {

    public AccountListTotalsDetailsActivity() {
        super(R.string.account_total_in_currency);
    }

    protected Total getTotalInHomeCurrency() {
        return db.getAccountsTotalInHomeCurrency();
    }

    protected Total[] getTotals() {
        return db.getAccountsTotal();
    }

}
