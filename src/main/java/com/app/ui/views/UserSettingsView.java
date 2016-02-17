package com.app.ui.views;


import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import org.vaadin.addon.leaflet.LMap;
import org.vaadin.addon.leaflet.LOpenStreetMapLayer;

/**
 * Created by riva on 09.09.15.
 */
public class UserSettingsView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "Settings";


    public UserSettingsView() {
        setSizeFull();
        //addStyleName("login-screen");

        AbsoluteLayout innerLayout = new AbsoluteLayout();
        innerLayout.setSizeFull();
        //innerLayout.setWidth("200px");
        //innerLayout.setHeight("400px");
        //innerLayout.setStyleName("background");
        //setCaption("Settings");

        final TextField nameField = new TextField("Name");
        nameField.setWidth(15, Unit.EM);
        nameField.setInputPrompt("Enter your name...");
        //addComponent(nameField);

        final DateField dateField = new DateField("Date of Birth");
        dateField.setWidth(15, Unit.EM);
        //addComponent(dateField);


        final Button submitButton = new Button("Submit");
        submitButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                Notification.show("Thanks!");
            }
        });
        //addComponent(submitButton);
        //innerLayout.addComponent(nameField);
        //innerLayout.addComponent(dateField);
        //innerLayout.setComponentAlignment(nameField, Alignment.MIDDLE_CENTER);
        //innerLayout.setComponentAlignment(dateField, Alignment.MIDDLE_CENTER);
        LMap leafletMap = new LMap();
        leafletMap.setCenter(60.4525, 22.301);
        leafletMap.setZoomLevel(15);
        leafletMap.setSizeFull();
        //leafletMap.setHeight("100%");
        leafletMap.setAttributionPrefix("Powered by Leaflet with v-leaflet");
        leafletMap.addBaseLayer(new LOpenStreetMapLayer(), "CloudMade");
        leafletMap.addStyleName("coloredBorder");

        ComboBox comboBox = new ComboBox();
        comboBox.addItem("sdsd");
        comboBox.setWidth(8, Unit.EM);
        comboBox.setHeight(4, Unit.EM);


        innerLayout.addComponent(leafletMap);
        innerLayout.addComponent(new Label("dfdf"), "left: 50px; top: 50px;");
        addComponent(innerLayout);
        //setComponentAlignment(innerLayout, Alignment.MIDDLE_CENTER);

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
