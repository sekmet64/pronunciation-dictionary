package org.dikso.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SuggestBox;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Dikso implements EntryPoint {
	private SuggestBox searchBox = new SuggestBox();
	private Button searchButton = new Button("szörcs");
	private Button testButton = new Button("test");
	private SqliteImportServiceAsync sqliteImportSvc = GWT.create(SqliteImportService.class);
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		Resources.INSTANCE.css().ensureInjected();
		
		RootPanel.get("search-box").add(searchBox);
		RootPanel.get("search-button").add(searchButton);
		
		searchBox.setFocus(true);
		
		testButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				importSqlite();
			}
		});
		
	}
	
	private void importSqlite() {
		if (sqliteImportSvc == null) {
			sqliteImportSvc =GWT.create(SqliteImportService.class);
		}
		
		AsyncCallback<Void> callback = new AsyncCallback<Void>() {
			public void onFailure(Throwable caught) {
				
			}
			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				
			}
		};
		
		sqliteImportSvc.loadDatabase(callback);
	}
}
