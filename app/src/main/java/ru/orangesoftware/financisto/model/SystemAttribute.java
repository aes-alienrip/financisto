package ru.orangesoftware.financisto.model;

import java.util.HashMap;

import ru.orangesoftware.financisto.R;
import ru.orangesoftware.financisto.utils.LocalizableEnum;

public enum SystemAttribute implements LocalizableEnum {
	
	DELETE_AFTER_EXPIRED(-1, R.string.system_attribute_delete_after_expired);
	
	private static final HashMap<Long, SystemAttribute> idToAttribute = new HashMap<Long, SystemAttribute>();

	static {
		for (SystemAttribute a : SystemAttribute.values()) {
			idToAttribute.put(a.id, a);
		}
	}
	
	public final long id;
	public final int titleId;
	
	private SystemAttribute(long id, int titleId) {
		this.id = id;
		this.titleId = titleId;
	}

	@Override
	public int getTitleId() {
		return titleId;
	}

	public static SystemAttribute forId(long attributeId) {
		return idToAttribute.get(attributeId);
	}
	
}
