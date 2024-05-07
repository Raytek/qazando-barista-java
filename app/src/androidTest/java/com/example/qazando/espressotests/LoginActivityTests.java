package com.example.qazando.espressotests;

import android.support.test.rule.ActivityTestRule;

import com.example.qazando.espressotests.ui.activity.LoginActivity;

import org.junit.Rule;
import org.junit.Test;

import static com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed;
import static com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickBack;
import static com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickOn;
import static com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo;
import static com.schibsted.spain.barista.interaction.BaristaKeyboardInteractions.closeKeyboard;

public class LoginActivityTests {

    @Rule
    public ActivityTestRule<LoginActivity>
            mActivityRule = new ActivityTestRule<>(LoginActivity.class, false, true);

    @Test
    public void CheckSuccessfullyLogin() {
        writeTo(R.id.login_username, "qa@test.com");
        closeKeyboard();
        writeTo(R.id.login_password, "Pass@123");
        closeKeyboard();
        clickOn(R.id.login_button);
        assertDisplayed("Lista de Usuários");
    }

    @Test
    public void CheckWelcomeMessage() {
        assertDisplayed(R.id.welcome_txt,"Bem vindo Novamente");
    }

    @Test
    public void CheckLogo() {
        assertDisplayed(R.id.login_image);
    }

    @Test
    public void CheckAccountCreationButton() {
        clickOn("CADASTRAR");
        assertDisplayed(R.id.title_sign_up, "Qual seu E-mail?");
        clickBack();
        assertDisplayed(R.id.login_image);
    }

    @Test
    public void CheckAccountCreationMessage() {
        assertDisplayed("Não tem uma conta?");
    }

}
