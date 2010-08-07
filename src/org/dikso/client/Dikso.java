package org.dikso.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TabLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Dikso implements EntryPoint {
	
	private TabLayoutPanel tabLayoutPanel;
	private DockLayoutPanel dictionaryPanel;
	private AdminTab adminTab;
	
	
	private SuggestBox searchBox;
	//private Button searchButton;
	
	

	public void onModuleLoad() {
		Resources.INSTANCE.css().ensureInjected();
		
		dictionaryPanel = new DockLayoutPanel(Unit.EM);
		adminTab = new AdminTab();
		
		searchBox = new SuggestBox();
		//searchButton = new Button("szörcs");
		dictionaryPanel.add(searchBox);
		//dictionaryPanel.add(searchButton);
		
		tabLayoutPanel = new TabLayoutPanel(1.5, Unit.EM);
		tabLayoutPanel.add(dictionaryPanel, "dictionary");
		tabLayoutPanel.add(adminTab, "admin");
		
		tabLayoutPanel.addSelectionHandler(new SelectionHandler<Integer>(){
			public void onSelection(SelectionEvent<Integer> event) {
				History.newItem(Page.toPage(event.getSelectedItem()).toString());
			}});
		
		History.addValueChangeHandler(new ValueChangeHandler<String>() {
			public void onValueChange(ValueChangeEvent<String> event) {
				
		        switch (Page.toPage(event.getValue())) {
		        	case DICTIONARY:
		        		tabLayoutPanel.selectTab(dictionaryPanel);
		        		break;
		        	case ADMIN:
		        		tabLayoutPanel.selectTab(adminTab);
		        		break;
		        }
			}
		});

		

		RootLayoutPanel rootPanel = RootLayoutPanel.get();
		rootPanel.add(tabLayoutPanel);
	}
}
	
