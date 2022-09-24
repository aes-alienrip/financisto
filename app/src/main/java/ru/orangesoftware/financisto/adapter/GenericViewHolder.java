package ru.orangesoftware.financisto.adapter;

import ru.orangesoftware.financisto.R;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GenericViewHolder {
	public TextView lineView;
	public TextView labelView;
	public TextView numberView;
	public TextView amountView;
	public ImageView iconView;
	
	public static GenericViewHolder createAndTag(View view) {
		GenericViewHolder views = new GenericViewHolder();
		views.lineView = (TextView)view.findViewById(R.id.line1);
		views.labelView = (TextView)view.findViewById(R.id.label);
		views.numberView = (TextView)view.findViewById(R.id.number);
		views.amountView = (TextView)view.findViewById(R.id.date);
		views.iconView = (ImageView) view.findViewById(R.id.icon);
		view.setTag(views);
		return views;
	}
}
