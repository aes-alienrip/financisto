package ru.orangesoftware.financisto.utils;

import ru.orangesoftware.financisto.db.DatabaseAdapter;

public class IntegrityFix {

    private final DatabaseAdapter db;

    public IntegrityFix(DatabaseAdapter db) {
        this.db = db;
    }

    public void fix() {
        db.restoreSystemEntities();
        db.recalculateAccountsBalances();
        db.rebuildRunningBalances();
    }

}
