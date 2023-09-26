package ru.orangesoftware.financisto.model;

import ru.orangesoftware.financisto.R;
import ru.orangesoftware.financisto.utils.EntityEnum;

public enum CardIssuer implements EntityEnum {

	DEFAULT(R.string.card_issuer_default, R.drawable.account_type_card_default),
	MIR(R.string.card_issuer_mir, R.drawable.account_type_card_mir),
	MIR_SUPREME(R.string.card_issuer_mir_supreme, R.drawable.account_type_card_mir_supreme),
	MAESTRO(R.string.card_issuer_maestro, R.drawable.account_type_card_maestro),
	MASTERCARD(R.string.card_issuer_mastercard, R.drawable.account_type_card_mastercard),
	VISA(R.string.card_issuer_visa, R.drawable.account_type_card_visa),
	VISA_ELECTRON(R.string.card_issuer_electron, R.drawable.account_type_card_visa_electron),
	JCB(R.string.card_issuer_jcb, R.drawable.account_type_card_jcb),
	UNIONPAY(R.string.card_issuer_unionpay, R.drawable.account_type_card_unionpay),
	AMEX(R.string.card_issuer_amex, R.drawable.account_type_card_amex),
	CIRRUS(R.string.card_issuer_cirrus, R.drawable.account_type_card_cirrus),
	DINERS(R.string.card_issuer_diners, R.drawable.account_type_card_diners),
	DISCOVER(R.string.card_issuer_discover, R.drawable.account_type_card_discover),
	NETS(R.string.card_issuer_nets, R.drawable.account_type_card_nets);

	public final int titleId;
	public final int iconId;

	CardIssuer(int titleId, int iconId) {
		this.titleId = titleId;
		this.iconId = iconId;
	}

	@Override
	public int getTitleId() {
		return titleId;
	}

	@Override
	public int getIconId() {
		return iconId;
	}

}