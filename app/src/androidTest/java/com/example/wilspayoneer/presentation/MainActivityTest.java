package com.example.wilspayoneer.presentation;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.wilspayoneer.R;
import com.example.wilspayoneer.core.ExpressoIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private static final String CODE = "VISA";

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new
            ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void register_idling_resource() {
        IdlingRegistry.getInstance().register(ExpressoIdlingResource.getInstance().getCountingIdlingResource());
    }

    @Test
    public void main_activity_visible() {
        onView(withId(R.id.til_enter_code)).check(matches(isDisplayed()));
    }

    @Test
    public void main_activity_second_activity_navigation() throws InterruptedException {
        onView(withId(R.id.til_enter_code)).check(matches(isDisplayed()));
        onView(withId(R.id.actv_enter_code)).perform(typeText(CODE), closeSoftKeyboard());

        onView(withId(R.id.bt_search)).perform(click());
        Thread.sleep(250);
        onView(withId(R.id.iv_logo)).check(matches(isDisplayed()));
    }

    @After
    public void unregister_idling_resource() {
        IdlingRegistry.getInstance().unregister(ExpressoIdlingResource.getInstance().getCountingIdlingResource());
    }

}