package ru.orangesoftware.orb;

public interface Expression {
	
	Selection toSelection(EntityDefinition ed);
	
}
