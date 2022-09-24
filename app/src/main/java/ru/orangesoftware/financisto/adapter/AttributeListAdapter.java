package ru.orangesoftware.financisto.adapter;

import ru.orangesoftware.financisto.R;
import ru.orangesoftware.financisto.db.DatabaseAdapter;
import ru.orangesoftware.financisto.model.Attribute;
import android.content.Context;
import android.database.Cursor;
import android.view.View;

public class AttributeListAdapter extends AbstractGenericListAdapter {
	
	private final String[] attributeTypes;

	public AttributeListAdapter(DatabaseAdapter db, Context context, Cursor c) {
		super(db, context, c);
		attributeTypes = context.getResources().getStringArray(R.array.attribute_types);
	}

	@Override
	protected void bindView(GenericViewHolder v, Context context, Cursor cursor) {
		Attribute a = Attribute.fromCursor(cursor);
		v.lineView.setText(a.title);
		v.numberView.setText(attributeTypes[a.type-1]);
		String defaultValue = a.getDefaultValue();
		if (defaultValue != null) {
			v.amountView.setVisibility(View.VISIBLE);
			v.amountView.setText(defaultValue);
		} else {
			v.amountView.setVisibility(View.GONE);
		}
	}

}
