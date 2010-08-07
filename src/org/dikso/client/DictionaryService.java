package org.dikso.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("dictionary")
public interface DictionaryService extends RemoteService {
	void AddEntries(String text);
}
