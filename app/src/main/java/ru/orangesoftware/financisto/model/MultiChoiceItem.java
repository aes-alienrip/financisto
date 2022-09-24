package ru.orangesoftware.financisto.model;


public interface MultiChoiceItem {

	public long getId();
	
	public String getTitle();
	
	public boolean isChecked();
	
	public void setChecked(boolean checked);
	
}
