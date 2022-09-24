package ru.orangesoftware.orb;


class Or extends CompoundExpression {

	Or(Expression e) {
		super("OR", e);
	}

	Or(Expression... e) {
		super("OR", e);
	}

}
