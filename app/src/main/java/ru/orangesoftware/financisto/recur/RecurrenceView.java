package ru.orangesoftware.financisto.recur;

import android.widget.LinearLayout;

public interface RecurrenceView {

	void createNodes(LinearLayout layout);
	
	String stateToString();
	
	void stateFromString(String state);

	boolean validateState();

}
