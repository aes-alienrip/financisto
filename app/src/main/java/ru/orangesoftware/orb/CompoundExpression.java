package ru.orangesoftware.orb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

class CompoundExpression implements Expression {

	private final String op;
	private final LinkedList<Expression> expressions = new LinkedList<Expression>();

	CompoundExpression(String op, Expression e) {
		this.op = op;
		this.expressions.add(e);
	}

	CompoundExpression(String op, Expression... e) {
		this.op = op;
		this.expressions.addAll(Arrays.asList(e));
	}

	@Override
	public Selection toSelection(EntityDefinition ed) {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		ArrayList<String> list = new ArrayList<String>();
		boolean first = true;
		for (Expression e : expressions) {
			if (!first) {
				sb.append(" ").append(op).append(" ");				
			}
			Selection s = e.toSelection(ed); 
			sb.append(s.selection);
			list.addAll(s.selectionArgs);
			first = false;
		}
		sb.append(")");
		return new Selection(sb.toString(), list);
	}

}
