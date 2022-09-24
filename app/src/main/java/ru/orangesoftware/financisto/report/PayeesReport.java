package ru.orangesoftware.financisto.report;

import android.content.Context;
import ru.orangesoftware.financisto.blotter.BlotterFilter;
import ru.orangesoftware.financisto.filter.WhereFilter;
import ru.orangesoftware.financisto.filter.Criteria;
import ru.orangesoftware.financisto.db.DatabaseAdapter;
import ru.orangesoftware.financisto.model.Currency;

import static ru.orangesoftware.financisto.db.DatabaseHelper.V_REPORT_PAYEES;

public class PayeesReport extends Report {

	public PayeesReport(Context context, Currency currency) {
		super(ReportType.BY_PAYEE, context, currency);
	}

	@Override
	public ReportData getReport(DatabaseAdapter db, WhereFilter filter) {
        cleanupFilter(filter);
		return queryReport(db, V_REPORT_PAYEES, filter);
	}

	@Override
	public Criteria getCriteriaForId(DatabaseAdapter db, long id) {
		return Criteria.eq(BlotterFilter.PAYEE_ID, String.valueOf(id));
	}		
	
}
