package org.dikso.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SqliteImportServiceAsync {

	void loadDatabase(AsyncCallback<Void> callback);

}
