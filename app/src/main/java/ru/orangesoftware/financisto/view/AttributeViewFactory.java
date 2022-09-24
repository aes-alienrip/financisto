package ru.orangesoftware.financisto.view;

import ru.orangesoftware.financisto.model.Attribute;
import android.content.Context;

public class AttributeViewFactory {
	private AttributeViewFactory(){}
	
	public static AttributeView createViewForAttribute(Context context, Attribute attribute) {
		switch (attribute.type) {
		case Attribute.TYPE_TEXT:
			return new TextAttributeView(context, attribute);
		case Attribute.TYPE_NUMBER:
			return new NumberAttributeView(context, attribute);
		case Attribute.TYPE_LIST:
			return new ListAttributeView(context, attribute);
		case Attribute.TYPE_CHECKBOX:
			return new CheckBoxAttributeView(context, attribute);
		}
		return null;
	}
}
