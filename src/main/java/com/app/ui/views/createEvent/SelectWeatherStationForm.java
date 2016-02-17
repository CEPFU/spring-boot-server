package com.app.ui.views.createEvent;

import com.app.utility.JsonReader;
import com.vaadin.server.Responsive;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.vaadin.addon.leaflet.LMap;
import org.vaadin.addon.leaflet.LOpenStreetMapLayer;

import java.io.IOException;

/**
 * Created by riva on 31.01.16.
 */
public class SelectWeatherStationForm extends AbsoluteLayout {

    public SelectWeatherStationForm() {
        // ###### SELECT WEATHERSTATION


        VerticalLayout horizontalLayout = new VerticalLayout();
        horizontalLayout.setSizeFull();
        //"Step 1: Select a weather station which is closest to your place of interest"
        ComboBox comboBox = new ComboBox();
        comboBox.addItem("sdsd");
        comboBox.setWidth(300, Sizeable.Unit.PIXELS);
        comboBox.setHeight(80, Sizeable.Unit.PIXELS);
        try {
            populateCombobox(comboBox);
        } catch (IOException e) {
            e.printStackTrace();
        }
        horizontalLayout.addComponent(comboBox);
        horizontalLayout.setComponentAlignment(comboBox, Alignment.MIDDLE_CENTER);
        Label header = new Label();
        //header.setSizeUndefined();
        header.setWidth(15, Sizeable.Unit.EM);
        header.setHeight(4, Sizeable.Unit.EM);
        header.addStyleName("headerText");
        header.setValue("Step 1: Select a weather station which is closest to your place of interest");
        horizontalLayout.addStyleName("headerText");


        // The Map where all the Weatherstations will be listed on
        LMap leafletMap = new LMap();
        leafletMap.setCenter(60.4525, 22.301);
        leafletMap.setZoomLevel(15);
        leafletMap.setSizeFull();
        leafletMap.setAttributionPrefix("Powered by Leaflet with v-leaflet");
        leafletMap.addBaseLayer(new LOpenStreetMapLayer(), "CloudMade");

        // AbsoluteLayout which inherits the map and a combobox overlapping the map
        // CssLayout absoluteLayout = new CssLayout();
        setSizeFull();
        addComponent(leafletMap);
        addComponent(comboBox);
        Responsive.makeResponsive(this);
        addStyleName("responsiveCssLayout");
        comboBox.addStyleName("boxMarginLeft");




       /* // Wrap Header + Map + Footer with WeatherStationLayout
        weatherStationLayout = new VerticalLayout();
        weatherStationLayout.setSizeFull();
        //weatherStationLayout.addComponent(header);
        //weatherStationLayout.addComponent(horizontalLayout);
        weatherStationLayout.addComponent(absoluteLayout);
        weatherStationLayout.addComponent(continueButton);
        weatherStationLayout.setExpandRatio(absoluteLayout, 0.9f);
        weatherStationLayout.setExpandRatio(continueButton, 0.1f);
        weatherStationLayout.setComponentAlignment(continueButton, Alignment.MIDDLE_CENTER);
        weatherStationLayout.addStyleName("blueBackground");
        addComponent(weatherStationLayout);*/
    }

    public void populateCombobox(ComboBox box) throws IOException, JSONException {
        JsonReader jsonReader = new JsonReader();
        JSONArray json = jsonReader.readJsonArrayFromUrl("http://localhost:8080/location");

        for (int i = 0; i < json.length(); i++) {
            json.get(i);
            JSONObject jsonObject = (JSONObject) json.get(i);

            box.addItem(jsonObject);
            box.setItemCaption(jsonObject, (String) jsonObject.get("locationDescription"));


        }


    }
}
