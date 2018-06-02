package com.scriptgo.cossiocafe.utils;

import io.realm.Realm;

/**
 * Created by lbalarezo on 09/03/2018.
 */

public class RealmManager {
    private static Realm realm;

    public static Realm open() {
        if (realm == null) {
            realm = Realm.getDefaultInstance();
        }
        return realm;
    }

    public static Realm using() {
        checkForOpenRealm();
        return realm;
    }

    public static void close() {
        if (realm != null) {
            realm.close();
        }
    }

    public static void cancelTransaction(){
        if (realm != null && realm.isInTransaction()) {
            realm.cancelTransaction();
        }
    }

    private static void checkForOpenRealm() {
        if (realm == null || realm.isClosed()) {
            throw new IllegalStateException("RealmManager: Realm is closed, call open() method first");
        }
    }
}
