package com.onlineauction.onlineauctionsale;

import androidx.test.rule.ActivityTestRule;


import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class Login_Test {
    @Rule
    public ActivityTestRule<LoginActivity> activityTestRule = new ActivityTestRule<>(LoginActivity.class );
    @Test
    public void loginTest(){
        onView(withId(R.id.etLogEmail)).perform(typeText( "sajik.shrestha@gmail.com" ));
        closeSoftKeyboard();
        onView( withId( R.id.etLogPassword) ).perform(typeText("greenmamba"),closeSoftKeyboard());

        onView( withId( R.id.btnLogin ) ).perform( click() );

    }
}
