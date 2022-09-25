package ru.orangesoftware.orb;

import java.util.Collections;

public class Lte implements Expression {

	private final String field;
	private final Object value;
	
	Lte(String field, Object value) {
		this.field = field;
		this.value = value;
	}
	
	@Override
	public Selection toSelection(EntityDefinition ed) {
		return new Selection("("+ed.getColumnForField(field)+"<=?)", Collections.singletonList(String.valueOf(value)));
	}

}
