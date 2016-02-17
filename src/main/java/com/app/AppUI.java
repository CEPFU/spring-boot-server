package com.app;

import com.app.auth.AccessControl;
import com.app.auth.BasicAccessControl;
import com.app.ui.views.MainScreen;
import com.app.ui.views.login.LoginForm;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.WrappedHttpSession;
import com.vaadin.server.WrappedSession;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

@SpringUI
@Theme("theme")
@Widgetset("com.app.gwt.VaadinDesktopWidgetSet")
public class AppUI extends UI {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private ApplicationContext applicationContext;
    private AccessControl accessControl = new BasicAccessControl();


    @Override
    protected void init(VaadinRequest request) {
        Responsive.makeResponsive(this);

        WrappedSession session = request.getWrappedSession();
        HttpSession httpSession = ((WrappedHttpSession) session).getHttpSession();
        ServletContext servletContext = httpSession.getServletContext();
        applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);


        getPage().setTitle("WeatherApp");
        if (!accessControl.isUserSignedIn()) {
            setContent(new LoginForm(accessControl, new LoginForm.LoginListener() {


                @Override
                public void loginSuccessful() {
                    showMainView();
                }
            }));
        } else {
            showMainView();
        }


    }

    protected void showMainView() {
        addStyleName(ValoTheme.UI_WITH_MENU);
        setContent(new MainScreen(AppUI.this));
        //getNavigator().navigateTo(getNavigator().getState());
    }


    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

}
