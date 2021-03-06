package com.app.ui.views.login;

/**
 * Created by riva on 28.01.16.
 */

import com.app.AppUI;
import com.app.auth.AccessControl;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.Page;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.context.ApplicationContext;

import java.io.Serializable;

public class LoginForm extends CssLayout {


    private TextField username;
    private PasswordField password;
    private Button login;
    private Button forgotPassword;
    private Button register;
    private LoginListener loginListener;
    private AccessControl accessControl;


    public LoginForm(AccessControl accessControl, LoginListener loginListener) {
        buildUI();
        this.loginListener = loginListener;
        this.accessControl = accessControl;

    }


    private void buildUI() {
        addStyleName("login-screen");

        // login form, centered in the available part of the screen
        Component loginForm = buildLoginForm();

        // layout to center login form when there is sufficient screen space
        VerticalLayout centeringLayout = new VerticalLayout();
        centeringLayout.setStyleName("centering-layout");
        centeringLayout.addComponent(loginForm);
        centeringLayout.setComponentAlignment(loginForm,
                Alignment.MIDDLE_CENTER);

        // information text about logging in
        CssLayout loginInformation = buildLoginInformation();

        addComponent(centeringLayout);
        addComponent(loginInformation);
    }

    private Component buildLoginForm() {
        FormLayout loginForm = new FormLayout();

        loginForm.addStyleName("login-form");
        loginForm.setSizeUndefined();
        loginForm.setMargin(false);

        loginForm.addComponent(username = new TextField("Username"));
        username.setWidth(15, Unit.EM);
        username.setImmediate(true);
        loginForm.addComponent(password = new PasswordField("Password"));
        password.setWidth(15, Unit.EM);
        password.setDescription("Write anything");
        password.setImmediate(true);
        CssLayout buttons = new CssLayout();
        buttons.setStyleName("buttons");
        loginForm.addComponent(buttons);

        buttons.addComponent(login = new Button("Login"));
        login.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        login.addStyleName(ValoTheme.BUTTON_FRIENDLY);
        LoginButtonListener loginButtonListener = getLoginButtonListener();
        login.addClickListener(loginButtonListener);

        buttons.addComponent(forgotPassword = new Button("Forgot password?"));
        forgotPassword.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                showNotification(new Notification("Hint: Try anything"));
            }
        });
        forgotPassword.addStyleName(ValoTheme.BUTTON_LINK);

        buttons.addComponent((register = new Button("Register")));
        RegisterButtonListener registerButtonListener = getRegisterButtonListener();
        register.addClickListener(registerButtonListener);
        return loginForm;
    }


    private CssLayout buildLoginInformation() {
        CssLayout loginInformation = new CssLayout();
        loginInformation.setStyleName("login-information");
        Label loginInfoText = new Label(
                "<h1>Welcome</h1>"
                        + "With this application you can receive custom notifications for weather events",
                ContentMode.HTML);
        loginInformation.addComponent(loginInfoText);
        return loginInformation;
    }


    public TextField getTxtLogin() {
        return username;
    }

    public PasswordField getTxtPassword() {
        return password;
    }

    public LoginButtonListener getLoginButtonListener() {
        AppUI ui = (AppUI) UI.getCurrent();
        ApplicationContext context = ui.getApplicationContext();
        return context.getBean(LoginButtonListener.class);
    }

    public RegisterButtonListener getRegisterButtonListener() {
        AppUI ui = (AppUI) UI.getCurrent();
        ApplicationContext context = ui.getApplicationContext();
        return context.getBean(RegisterButtonListener.class);
    }

    private void showNotification(Notification notification) {
        // keep the notification visible a little while after moving the
        // mouse, or until clicked
        notification.setDelayMsec(2000);
        notification.show(Page.getCurrent());
    }

    public LoginListener getLoginListener() {
        return this.loginListener;
    }

    private void login() {
        if (accessControl.signIn(username.getValue(), password.getValue())) {
            loginListener.loginSuccessful();
        } else {
            showNotification(new Notification("Login failed",
                    "Please check your username and password and try again.",
                    Notification.Type.HUMANIZED_MESSAGE));
            username.focus();
        }
    }


    public interface LoginListener extends Serializable {
        void loginSuccessful();
    }


}
