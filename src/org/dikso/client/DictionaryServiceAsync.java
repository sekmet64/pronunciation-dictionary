package org.dikso.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DictionaryServiceAsync {
	void AddEntries(String text, AsyncCallback<Void> callback);
}
