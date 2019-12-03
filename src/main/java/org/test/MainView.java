package org.test;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dnd.DragSource;
import com.vaadin.flow.component.dnd.DropTarget;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

/**
 * The main view contains a button and a click listener.
 */
@Route
@PWA(name = "My Application", shortName = "My Application")
public class MainView extends VerticalLayout {

    public MainView() {
        Button a = new Button("I want to be dragged around!");
        Button b = new Button("I want my drops!");
        
        DragSource<Button> dragSource = DragSource.create(a);
        dragSource.addDragStartListener(event -> {
        	event.getComponent().setText("I want you to drop me");
        });
        dragSource.addDragEndListener(event -> {
        	event.getComponent().setText("I want to be dragged around");
        });
        
        DropTarget<Button> dropTarget = DropTarget.create(b);
        dropTarget.addDropListener(event -> {
        	
        });
        
        add(a, b);
    }
}
