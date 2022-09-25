package ru.orangesoftware.orb;


class And extends CompoundExpression {

	And(Expression e) {
		super("AND", e);
	}

	And(Expression... e) {
		super("AND", e);
	}

}
