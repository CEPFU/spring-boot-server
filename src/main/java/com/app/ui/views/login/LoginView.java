package com.app.ui.views.login;

/**
 * Created by riva on 25.01.16.
 */

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.CssLayout;


/**
 * UI content when the user is not logged in yet.
 */
public class LoginView extends CssLayout implements View {


    public LoginView() {
        setSizeFull();
        //LoginForm loginForm = new LoginForm();
        //loginForm.setSizeFull();
        //addComponent(loginForm);
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}

