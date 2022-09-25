package ru.orangesoftware.financisto.widget;

import android.app.Activity;
import ru.orangesoftware.financisto.model.Currency;

/**
 * Created by IntelliJ IDEA.
 * User: denis.solonenko
 * Date: 1/19/12 11:57 PM
 */
public interface RateNodeOwner {

    void onBeforeRateDownload();
    void onAfterRateDownload();
    void onSuccessfulRateDownload();
    void onRateChanged();

    Activity getActivity();

    Currency getCurrencyFrom();
    Currency getCurrencyTo();

}
