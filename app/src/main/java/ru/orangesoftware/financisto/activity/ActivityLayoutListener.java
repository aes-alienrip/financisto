package ru.orangesoftware.financisto.activity;

import android.view.View.OnClickListener;
import ru.orangesoftware.financisto.model.MultiChoiceItem;

import java.util.List;

public interface ActivityLayoutListener extends OnClickListener {

	void onSelectedPos(int id, int selectedPos);
	
	void onSelectedId(int id, long selectedId);

	void onSelected(int id, List<? extends MultiChoiceItem> items);
	
}
