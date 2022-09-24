package ru.orangesoftware.financisto.export.qif;

import android.content.Intent;
import ru.orangesoftware.financisto.activity.QifExportActivity;
import ru.orangesoftware.financisto.filter.WhereFilter;
import ru.orangesoftware.financisto.model.Currency;
import ru.orangesoftware.financisto.utils.CurrencyExportPreferences;

import java.text.SimpleDateFormat;

/**
 * Created by IntelliJ IDEA.
 * User: Denis Solonenko
 * Date: 7/10/11 7:01 PM
 */
public class QifExportOptions {

    public static final String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";

    public final Currency currency;
    public final SimpleDateFormat dateFormat;
    public final WhereFilter filter;
    public final long[] selectedAccounts;
    public final boolean uploadToDropbox;

    public QifExportOptions(Currency currency, String dateFormat, long[] selectedAccounts, WhereFilter filter, boolean uploadToDropbox) {
        this.currency = currency;
        this.dateFormat = new SimpleDateFormat(dateFormat);
        this.selectedAccounts = selectedAccounts;
        this.filter = filter;
        this.uploadToDropbox = uploadToDropbox;
    }

    public static QifExportOptions fromIntent(Intent data) {
        WhereFilter filter = WhereFilter.fromIntent(data);
        Currency currency = CurrencyExportPreferences.fromIntent(data, "qif");
        String dateFormat = data.getStringExtra(QifExportActivity.QIF_EXPORT_DATE_FORMAT);
        long[] selectedAccounts = data.getLongArrayExtra(QifExportActivity.QIF_EXPORT_SELECTED_ACCOUNTS);
        boolean uploadToDropbox = data.getBooleanExtra(QifExportActivity.QIF_EXPORT_UPLOAD_TO_DROPBOX, false);
        return new QifExportOptions(currency, dateFormat, selectedAccounts, filter, uploadToDropbox);
    }

}
