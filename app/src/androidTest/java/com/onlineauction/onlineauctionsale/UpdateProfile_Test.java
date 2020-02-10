package com.onlineauction.onlineauctionsale;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class UpdateProfile_Test {
    @Rule
    public ActivityTestRule<UserUpdateActivity> activityTestRule = new ActivityTestRule<>(UserUpdateActivity.class);

    @Test
    public void UpdateTest() {
        onView(withId(R.id.etuptfirst)).perform(typeText("Sajik"));
        closeSoftKeyboard();
        onView(withId(R.id.etuptsecond)).perform(typeText("Shrestha"), closeSoftKeyboard());

        onView(withId(R.id.btnUpdate)).perform(click());
    }
}