package ru.orangesoftware.orb;

import java.util.Collections;

class Neq implements Expression {

	private final String field;
	private final Object value;
	
	Neq(String field, Object value) {
		this.field = field;
		this.value = value;
	}
	
	@Override
	public Selection toSelection(EntityDefinition ed) {
		return new Selection("("+ed.getColumnForField(field)+"!=?)", Collections.singletonList(String.valueOf(value)));
	}

}
