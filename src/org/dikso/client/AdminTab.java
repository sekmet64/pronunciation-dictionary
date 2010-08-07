package org.dikso.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Creates the administrator tab. 
 */	
public class AdminTab extends VerticalPanel {
	/**
	 * Text area where database entries need to entered
	 */
	private TextArea sourceBox;
	/**
	 * Text area where database entries need to entered
	 */
	private Button addButton;
	
	private final DictionaryServiceAsync dictionaryService =
		(DictionaryServiceAsync) GWT.create(DictionaryService.class);
	private AsyncCallback<Void> addEntriesCallback = new AsyncCallback<Void>() {
		@Override
		public void onFailure(Throwable caught) {
			
		}
		@Override
		public void onSuccess(Void result) {
			// 
			
		}
	};
		
		
	
	private ClickHandler addButtonClickHandler = new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			dictionaryService.AddEntries(sourceBox.getText(), addEntriesCallback);
		}
		
	};
	/**
	 * Constructor of the admin tab. Instantiates the buttons and the superclass
	 */
	public AdminTab() {
		sourceBox = new TextArea();
		addButton = new Button("Add");
		this.add(sourceBox);
		this.add(addButton);
		addButton.addClickHandler(addButtonClickHandler);
	}
	
	
}
