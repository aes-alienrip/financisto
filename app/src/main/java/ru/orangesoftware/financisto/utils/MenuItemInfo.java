package ru.orangesoftware.financisto.utils;

public class MenuItemInfo {
	public final int menuId;
	public int titleId;
	public boolean enabled = true;
	
	public MenuItemInfo(int menuId, int titleId) {
		this.menuId = menuId;
		this.titleId = titleId;
	}

}
