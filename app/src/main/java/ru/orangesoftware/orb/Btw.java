package ru.orangesoftware.orb;

import java.util.ArrayList;

public class Btw implements Expression {

	private final String field;
	private final Object value1;
	private final Object value2;
	
	Btw(String field, Object value1, Object value2) {
		this.field = field;
		this.value1 = value1;
		this.value2 = value2;
	}
	
	@Override
	public Selection toSelection(EntityDefinition ed) {
		ArrayList<String> args = new ArrayList<String>();
		args.add(String.valueOf(value1));
		args.add(String.valueOf(value2));
		return new Selection("("+ed.getColumnForField(field)+" between ? and ?)", args);
	}

}
