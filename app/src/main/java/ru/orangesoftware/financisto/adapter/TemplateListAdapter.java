package ru.orangesoftware.financisto.adapter;

import ru.orangesoftware.financisto.R;
import android.content.Context;
import android.database.Cursor;
import android.view.View;
import ru.orangesoftware.financisto.db.DatabaseAdapter;

public class TemplateListAdapter extends BlotterListAdapter {

	public TemplateListAdapter(Context context, DatabaseAdapter db, Cursor c) {
		super(context, db, R.layout.blotter_list_item, c);
	}

    @Override
    protected boolean isShowRunningBalance() {
        return false;
    }

    @Override
	public void bindView(View view, Context context, Cursor cursor) {
		super.bindView(view, context, cursor);
	}

}
