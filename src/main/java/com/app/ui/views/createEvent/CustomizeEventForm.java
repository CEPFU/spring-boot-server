package com.app.ui.views.createEvent;

import com.vaadin.data.Property;
import com.vaadin.event.LayoutEvents;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by riva on 01.02.16.
 */
public class CustomizeEventForm extends VerticalLayout {

    Label event;
    String aboveOrBelow;
    String number;

    public CustomizeEventForm() {

        /*final CssLayout temperatureLayout = new CssLayout();
        temperatureLayout.setWidth("100%");
        Label title = new Label("Temperature");
        //title.addStyleName("conditionTitle");
        // Serve the image from the theme
        Resource res = new ThemeResource("weather-icons/Sunny-64.png");
        // Display the image without caption
        Image image = new Image(null, res);
        TextField from = new TextField("From");
        from.setWidth(2, Sizeable.Unit.EM);
        TextField to = new TextField("To");
        to.setWidth(2, Sizeable.Unit.EM);
        DateField dateField = new DateField("From");



        temperatureLayout.addComponent(title);
        temperatureLayout.addComponent(image);
        temperatureLayout.addComponent(from);
        temperatureLayout.addComponent(to);
        temperatureLayout.addComponent(dateField);
        //temperatureLayout.setSpacing(true);
        temperatureLayout.addStyleName("condition");
        temperatureLayout.setWidth("70%");;

        VerticalLayout vLayout = new VerticalLayout();
        vLayout.setSizeFull();
        //vLayout.addStyleName("blueBackground");

        final CheckBox checkTemperature = new CheckBox();
        checkTemperature.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                if (checkTemperature.getValue() == true) {
                    temperatureLayout.setVisible(true);
                }
                else {
                    temperatureLayout.setVisible(false);
                }
            }
        });
        checkTemperature.setCaption("Temperature");
        CheckBox checkHumidity = new CheckBox();
        checkHumidity.setCaption("Humidity");

        Label headLine = new Label("Create a profile");
        //headLine.setWidth(20, Unit.PIXELS);

        VerticalLayout headerLayout = new VerticalLayout();
        headerLayout.setWidth("100%");
        headerLayout.setHeight(3, Sizeable.Unit.EM);
        headerLayout.addComponent(headLine);
        headerLayout.setComponentAlignment(headLine, Alignment.MIDDLE_CENTER);
        headerLayout.addStyleName("head-title");


        CssLayout selectLayout = new CssLayout();
        selectLayout.setWidth("100%");
        selectLayout.addComponent(checkHumidity);
        selectLayout.addComponent(checkTemperature);
        selectLayout.addStyleName("selectConditions");





        setSizeFull();
        addStyleName("selectLayout");
        //addComponent(headerLayout);
        addComponent(selectLayout);
        addComponent(temperatureLayout);


        temperatureLayout.setVisible(false);*/

        //operatorValue = "below";
        setSizeFull();

        NativeSelect operator = new NativeSelect();
        operator.addItem("Below");
        operator.addItem("Above");
        operator.setValue(0);
        operator.select("Below");
        operator.setNullSelectionAllowed(false);
        operator.setImmediate(true);
        operator.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                event.setValue("Alert me when temperature is " + (String) valueChangeEvent.getProperty().getValue() + " " + number + " °");
                aboveOrBelow = (String) valueChangeEvent.getProperty().getValue();
            }
        });
        operator.setSizeUndefined();
        // operator.addStyleName(ValoTheme.);

        TextField value = new TextField();
        value.setImmediate(true);
        value.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                event.setValue("Alert me when temperature is " + aboveOrBelow + " " + valueChangeEvent.getProperty().getValue() + " °");
                number = (String) valueChangeEvent.getProperty().getValue();
            }
        });
        value.setSizeUndefined();
        value.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);


        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.addComponent(new Label("Test"));
        horizontalLayout.addComponent(operator);
        horizontalLayout.addComponent(value);
        horizontalLayout.setSizeUndefined();

        aboveOrBelow = "above";
        number = "15";
        event = new Label("Alert me when Temperature is above 15 °");
        event.setContentMode(ContentMode.HTML);
        event.setImmediate(true);
        event.setSizeUndefined();
        event.addStyleName("eventStyle");

        VerticalLayout createButton = createButton();

        HorizontalLayout eventLayout = new HorizontalLayout();
        Label textBegin = new Label("Alert me when Temperature is ");
        textBegin.setSizeUndefined();
        textBegin.addStyleName("eventStyle");


        addComponent(horizontalLayout);
        addComponent(event);
        addComponent(createButton);
        setComponentAlignment(horizontalLayout, Alignment.BOTTOM_CENTER);
        setComponentAlignment(event, Alignment.TOP_CENTER);
        setComponentAlignment(createButton, Alignment.MIDDLE_CENTER);
        setExpandRatio(horizontalLayout, 0.2f);
        setExpandRatio(event, 0.7f);
        setExpandRatio(createButton, 0.1f);
        //addStyleName("blueBackground");
    }

    public VerticalLayout createButton() {
        // implementation of continue-button, which is simply a clickable css-layout
        VerticalLayout continueButton = new VerticalLayout();
        continueButton.addStyleName("footerButton");
        continueButton.setWidth(15, Unit.EM);
        continueButton.setHeight(4, Unit.EM);
        Label buttonName = new Label();
        buttonName.setValue("create");
        buttonName.setSizeUndefined();
        continueButton.addComponent(buttonName);
        continueButton.setComponentAlignment(buttonName, Alignment.MIDDLE_CENTER);

        continueButton.addLayoutClickListener(new LayoutEvents.LayoutClickListener() {
            @Override
            public void layoutClick(LayoutEvents.LayoutClickEvent event) {

            /*CssLayout fLayout = setUpOptions(new CssLayout());
                replaceComponent(weatherStationLayout, fLayout);*/

            }
        });

        return continueButton;
    }
}
