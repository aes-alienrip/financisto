package ru.orangesoftware.financisto.export;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.TabActivity;
import android.content.Context;
import android.widget.TabHost;

import ru.orangesoftware.financisto.R;
import ru.orangesoftware.financisto.activity.MainActivity;
import ru.orangesoftware.financisto.backup.DatabaseImport;
import ru.orangesoftware.financisto.db.DatabaseAdapter;

/**
 * Created by IntelliJ IDEA.
 * User: Denis Solonenko
 * Date: 11/9/11 2:21 AM
 */
public class BackupImportTask extends ImportExportAsyncTask {

    public BackupImportTask(final Activity activity, ProgressDialog dialog) {
        super(activity, dialog);
    }

    @Override
    protected Object work(Context context, DatabaseAdapter db, String... params) throws Exception {
        DatabaseImport.createFromFileBackup(context, db, params[0]).importDatabase();
        return true;
    }

    @Override
    protected String getSuccessMessage(Object result) {
        return context.getString(R.string.restore_database_success);
    }

}
