package br.com.jd.sistemas.emocao

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import br.com.jd.sistemas.emocao.ui.activities.MainActivity
import org.junit.Rule
import org.junit.runner.RunWith
import androidx.test.rule.ActivityTestRule
import org.hamcrest.CoreMatchers.not
import org.junit.Before
import org.junit.Test


@RunWith(AndroidJUnit4::class)
@LargeTest
class CadastrarEmocaoTest {

    @get:Rule
    var mainActivityActivityTestRule = ActivityTestRule(MainActivity::class.java)


    @Test
    fun whenActivityIsLaunched_shouldDisplayInitial() {
        onView(withId(R.id.txt_emocao)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_salvar)).check(matches(isDisplayed()))
    }

    @Test
    fun quandoSubmterFormularioComEmocaoVazio() {
        onView(withId(R.id.txt_emocao)).perform(typeText(""), closeSoftKeyboard())
        onView(withId(R.id.btn_salvar)).perform(click())
        onView(withText(R.string.msg_emocao_required)).inRoot( ToastMatcher())
            .check(matches(withText(R.string.msg_emocao_required)))
    }

}