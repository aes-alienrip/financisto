package ru.orangesoftware.financisto.report;

import android.content.Context;
import ru.orangesoftware.financisto.activity.BlotterActivity;
import ru.orangesoftware.financisto.activity.SplitsBlotterActivity;
import ru.orangesoftware.financisto.blotter.BlotterFilter;
import ru.orangesoftware.financisto.filter.WhereFilter;
import ru.orangesoftware.financisto.filter.Criteria;
import ru.orangesoftware.financisto.db.DatabaseAdapter;
import ru.orangesoftware.financisto.model.Category;
import ru.orangesoftware.financisto.model.Currency;

import static ru.orangesoftware.financisto.db.DatabaseHelper.V_REPORT_CATEGORY;

public class CategoryReportAll extends Report {

	public CategoryReportAll(Context context, Currency currency) {
		super(ReportType.BY_CATEGORY, context, currency);
	}

	@Override
	public ReportData getReport(DatabaseAdapter db, WhereFilter filter) {
        cleanupFilter(filter);
		return queryReport(db, V_REPORT_CATEGORY, filter);
	}
	
	@Override
	public Criteria getCriteriaForId(DatabaseAdapter db, long id) {
		Category c = db.getCategoryWithParent(id);
		return Criteria.btw(BlotterFilter.CATEGORY_LEFT, String.valueOf(c.left), String.valueOf(c.right));
	}

    @Override
    public boolean shouldDisplayTotal() {
        return false;
    }

    @Override
    protected Class<? extends BlotterActivity> getBlotterActivityClass() {
        return SplitsBlotterActivity.class;
    }

}
