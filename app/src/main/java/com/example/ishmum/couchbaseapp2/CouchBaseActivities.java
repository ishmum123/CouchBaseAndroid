package com.example.ishmum.couchbaseapp2;

import android.content.Context;
import android.support.annotation.NonNull;

import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.Document;
import com.couchbase.lite.LiveQuery;
import com.couchbase.lite.Manager;
import com.couchbase.lite.Query;
import com.couchbase.lite.QueryEnumerator;
import com.couchbase.lite.QueryRow;
import com.couchbase.lite.SavedRevision;
import com.couchbase.lite.UnsavedRevision;
import com.couchbase.lite.android.AndroidContext;
import com.couchbase.lite.replicator.Replication;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CouchBaseActivities {

    CouchBaseActivities(Context context) {
        try {
            Manager manager = new Manager(new AndroidContext(context), Manager.DEFAULT_OPTIONS);
            performDatabaseTasks(manager, "julydb");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void performDatabaseTasks(Manager manager, String dbName) {
        try {
            Database database = manager.getDatabase(dbName);
            Document document = database.getDocument("11july2017");
            try {
                document.createRevision().save();
                document.putProperties(getProperties());
            } catch (Exception ignored) {
            }
            startReplication(database);
            startConflictLiveQuery(database, document);
            updateDoc(document);
        } catch (CouchbaseLiteException e) {
            e.printStackTrace();
        }
    }

    private void startReplication(Database database) {
        try {
            URL url = new URL("http://213.136.81.86:4984/db");
            Replication push = database.createPushReplication(url);
            Replication pull = database.createPullReplication(url);

            push.setContinuous(true);
            pull.setContinuous(true);

            push.start();
            pull.start();
        } catch (MalformedURLException ignored) {
        }
    }

    private void updateDoc(Document doc) {
        try {
            doc.update(new Document.DocumentUpdater() {
                @Override
                public boolean update(UnsavedRevision newRevision) {
                    Map<String, Object> properties = newRevision.getUserProperties();
                    properties.put("title", "someTitle");
                    properties.put("notes", "someNotes");
                    newRevision.setUserProperties(properties);
                    return true;
                }
            });
        } catch (CouchbaseLiteException e) {
            e.printStackTrace();
        }
    }

    @NonNull
    private Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("title", "Couchbase Mobile");
        properties.put("sdk", "Android");
        return properties;
    }

    private void startConflictLiveQuery(final Database database, final Document document) {
        LiveQuery conflictsLiveQuery = database.createAllDocumentsQuery().toLiveQuery();
        conflictsLiveQuery.setAllDocsMode(Query.AllDocsMode.ONLY_CONFLICTS);
        conflictsLiveQuery.addChangeListener(new LiveQuery.ChangeListener() {
            @Override
            public void changed(LiveQuery.ChangeEvent event) {
                try {
                    resolveConflicts(event.getRows(), document);
                } catch (CouchbaseLiteException e) {
                    e.printStackTrace();
                }
            }
        });
        conflictsLiveQuery.start();
    }

    private void resolveConflicts(QueryEnumerator rows, Document document) throws CouchbaseLiteException {
        for (QueryRow row : rows) {
            List<SavedRevision> revs = row.getConflictingRevisions();
            if (revs.size() > 1) {
                final SavedRevision defaultWinning = revs.get(0);
                String type = (String) defaultWinning.getProperty("type");
                document.update(new Document.DocumentUpdater() {
                    @Override
                    public boolean update(UnsavedRevision newRevision) {
                        newRevision.setUserProperties(defaultWinning.getUserProperties());
                        return true;
                    }
                });
            }
        }
    }
}