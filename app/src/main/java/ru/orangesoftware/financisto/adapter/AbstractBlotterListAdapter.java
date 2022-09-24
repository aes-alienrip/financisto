package ru.orangesoftware.financisto.adapter;

import ru.orangesoftware.financisto.R;
import ru.orangesoftware.financisto.db.DatabaseAdapter;
import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;

public abstract class AbstractBlotterListAdapter extends AbstractGenericListAdapter {

	protected final int transferColor;
	protected final int futureColor;
	protected final Drawable icBlotterIncome;
	protected final Drawable icBlotterExpense;
	protected final Drawable icBlotterTransfer;	
	
	public AbstractBlotterListAdapter(DatabaseAdapter db, Context context, Cursor c) {
		super(db, context, c);
		transferColor = context.getResources().getColor(R.color.transfer_color);
		futureColor = context.getResources().getColor(R.color.future_color);
		icBlotterIncome = context.getResources().getDrawable(R.drawable.ic_blotter_income);
		icBlotterExpense = context.getResources().getDrawable(R.drawable.ic_blotter_expense);
		icBlotterTransfer = context.getResources().getDrawable(R.drawable.ic_blotter_transfer);
	}
	
	protected abstract void bindView(GenericViewHolder v, Context context, Cursor cursor);
	
	protected void setIcon(GenericViewHolder v, long amount, boolean transfer) {
		// do nothing
	}

}
