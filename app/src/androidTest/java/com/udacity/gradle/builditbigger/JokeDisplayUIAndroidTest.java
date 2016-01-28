package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Paul Aranas on 1/20/2016.
 */
@RunWith(JUnit4.class)
public class JokeDisplayUIAndroidTest {

    @Rule
    public ActivityTestRule mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityToJokeDisplayUITest() {
        onView(withId(R.id.tell_joke)).perform(click());
        onView(withId(R.id.jokeTextView)).check(matches(isDisplayed()));
    }
}
