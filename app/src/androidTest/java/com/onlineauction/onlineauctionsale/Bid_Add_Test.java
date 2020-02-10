package com.onlineauction.onlineauctionsale;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class Bid_Add_Test {

    @Rule
    public ActivityTestRule<ProductDetailActivity> activityTestRule = new ActivityTestRule<>(ProductDetailActivity.class );
    @Test
    public void loginTest(){
        onView(withId(R.id.amount)).perform(typeText( "500000" ),closeSoftKeyboard());


        onView( withId( R.id.bit_button ) ).perform( click() );

    }
}
