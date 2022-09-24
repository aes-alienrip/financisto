package ru.orangesoftware.financisto.model;

import ru.orangesoftware.financisto.db.DatabaseHelper.TransactionAttributeColumns;
import android.content.ContentValues;
import android.database.Cursor;

public class TransactionAttribute {
	
	public long attributeId;
	public long transactionId;
	public String value;
	
	public static TransactionAttribute fromCursor(Cursor c) {
		TransactionAttribute v = new TransactionAttribute();
		v.attributeId = c.getLong(TransactionAttributeColumns.Indicies.ATTRIBUTE_ID);
		v.transactionId = c.getLong(TransactionAttributeColumns.Indicies.TRANSACTION_ID);
		v.value = c.getString(TransactionAttributeColumns.Indicies.VALUE);
		return v;
	}
	
	public ContentValues toValues() {
		ContentValues values = new ContentValues();
		values.put(TransactionAttributeColumns.TRANSACTION_ID, transactionId);
		values.put(TransactionAttributeColumns.ATTRIBUTE_ID, attributeId);
		values.put(TransactionAttributeColumns.VALUE, value);
		return values;
	}
}
