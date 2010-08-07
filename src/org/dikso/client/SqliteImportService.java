package org.dikso.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("sqliteImport")
public interface SqliteImportService extends RemoteService {
	void loadDatabase();
}
