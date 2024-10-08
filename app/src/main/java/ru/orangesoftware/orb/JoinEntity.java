package ru.orangesoftware.orb;

public class JoinEntity {

	public final FieldInfo field;
	public final EntityDefinition entity;
	public final int index;
	public final int parentIndex;
	public final boolean required;
	
	public JoinEntity(FieldInfo field, EntityDefinition entity, 
			int index, int parentIndex, boolean required) {
		this.field = field;
		this.entity = entity;
		this.index = index;
		this.parentIndex = parentIndex;
		this.required = required;
	}
		
}
