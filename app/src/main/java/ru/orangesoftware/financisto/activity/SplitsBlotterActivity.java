package ru.orangesoftware.financisto.activity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import ru.orangesoftware.financisto.adapter.TransactionsListAdapter;
import ru.orangesoftware.financisto.blotter.BlotterTotalCalculationTask;
import ru.orangesoftware.financisto.blotter.TotalCalculationTask;

public class SplitsBlotterActivity extends BlotterActivity {

	@Override
	protected void internalOnCreate(Bundle savedInstanceState) {
		super.internalOnCreate(savedInstanceState);
		bFilter.setVisibility(View.GONE);
	}
	
	@Override
	protected Cursor createCursor() {
        return db.getBlotterForAccountWithSplits(blotterFilter);
	}

	@Override
	protected ListAdapter createAdapter(Cursor cursor) {
		return new TransactionsListAdapter(this, db, cursor);
	}

    @Override
    protected TotalCalculationTask createTotalCalculationTask() {
        return new BlotterTotalCalculationTask(this, db, blotterFilter, totalText);
    }

}
