package com.example.cobratour;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GestureDetectorCompat;
import androidx.fragment.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class UnivLibFragment1 extends Fragment {

    private GestureDetectorCompat gestureDetector;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the univ_lib_1.xml layout
        View view = inflater.inflate(R.layout.univ_lib_1, container, false);

        // Initialize the gesture detector for swipe detection
        gestureDetector = new GestureDetectorCompat(getContext(), new SwipeGestureListener());

        // Setup button listeners for navigation
        setupButtonListeners(view);

        // Set the onTouchListener for the root view to detect swipes
        view.setOnTouchListener((v, event) -> gestureDetector.onTouchEvent(event));

        return view;
    }

    private void setupButtonListeners(View view) {
        // Set up button listener for the second_page_button
        Button secondPageButton = view.findViewById(R.id.second_page_button);
        secondPageButton.setOnClickListener(v -> replaceFragment(new UnivLibFragment2()));

        // Set up button listener for the back_button
        Button backButton = view.findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> replaceFragment(new ExploreFragment2())); // Navigate back to ExploreFragment
    }

    // Helper method to replace fragment
    private void replaceFragment(Fragment fragment) {
        if (getActivity() != null) {
            MainActivity mainActivity = (MainActivity) getActivity();
            mainActivity.replaceFragment(fragment, true); // true to add to backstack
        }
    }

    // Custom GestureListener class to detect swipe gestures
    private class SwipeGestureListener extends GestureDetector.SimpleOnGestureListener {

        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float diffX = e2.getX() - e1.getX();
            float diffY = e2.getY() - e1.getY();
            if (Math.abs(diffX) > Math.abs(diffY)) {
                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX < 0) {
                        // Swipe left detected, go to UnivLibFragment2
                        replaceFragment(new UnivLibFragment2());
                    }
                    return true;
                }
            }
            return false;
        }
    }
}
