package com.app.ui.views.createEvent;

import com.vaadin.event.LayoutEvents;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by riva on 09.09.15.
 */
public class CreateEventsView extends CssLayout implements View {

    public static final String VIEW_NAME = "Create Event";
    private VerticalLayout weatherStationLayout;

    public CreateEventsView() {
        setSizeFull();

        final CssLayout contentLayout = new CssLayout();
        contentLayout.setSizeFull();

        final AbsoluteLayout selectWeatherStation = new SelectWeatherStationForm();
        final VerticalLayout customizeEvent = new CustomizeEventForm();

        //contentLayout.addStyleName("blueBackground");
        Label header = new Label("Create an event");
        header.setSizeUndefined();
        //header.addStyleName(ValoTheme.LABEL_H3);
        HorizontalLayout headerLayout = new HorizontalLayout();
        //headerLayout.addStyleName("createEventHeader");
        header.addStyleName(ValoTheme.LABEL_COLORED);
        header.addStyleName(ValoTheme.LABEL_HUGE);
        headerLayout.addComponent(header);
        headerLayout.setComponentAlignment(header, Alignment.MIDDLE_CENTER);
        headerLayout.setWidth("100%");
        headerLayout.setHeight(42, Unit.PIXELS);
        //headerLayout.setSizeFull();

        // Horizonzal layout to switch between the map and event customizing
        HorizontalLayout optionsLayout = new HorizontalLayout();

        Label map = new Label("Select Weather Station");
        map.setSizeUndefined();
        CssLayout mapButton = new CssLayout();
        mapButton.setSizeUndefined();
        mapButton.addLayoutClickListener(new LayoutEvents.LayoutClickListener() {
            @Override
            public void layoutClick(LayoutEvents.LayoutClickEvent layoutClickEvent) {
                contentLayout.replaceComponent(customizeEvent, selectWeatherStation);
            }
        });
        mapButton.addComponent(map);


        Label event = new Label("Customize Event");
        event.setSizeUndefined();
        CssLayout eventButton = new CssLayout();
        eventButton.setSizeUndefined();
        eventButton.addLayoutClickListener(new LayoutEvents.LayoutClickListener() {
            @Override
            public void layoutClick(LayoutEvents.LayoutClickEvent layoutClickEvent) {
                contentLayout.replaceComponent(selectWeatherStation, customizeEvent);
            }
        });
        eventButton.addComponent(event);


        optionsLayout.addComponent(mapButton);
        optionsLayout.addComponent(eventButton);
        optionsLayout.setHeight(42, Unit.PIXELS);
        optionsLayout.setWidth("100%");
        optionsLayout.addStyleName("createEventHeader");


        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        //layout.addStyleName("blueBackground");


        contentLayout.addComponent(headerLayout);
        contentLayout.addComponent(optionsLayout);
        contentLayout.addComponent(selectWeatherStation);
        //contentLayout.addComponent(tabSheet);
        //contentLayout.setExpandRatio(header, 0.05f);
        //contentLayout.setExpandRatio(tabSheet, 0.95f);
        addComponent(contentLayout);
        //addComponent(layout);
        //setUpSelectWeatherStation();


    }

    public void setUpSelectWeatherStation() {


    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }


}
