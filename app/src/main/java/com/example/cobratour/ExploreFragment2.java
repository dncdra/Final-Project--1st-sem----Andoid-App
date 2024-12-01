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

public class ExploreFragment2 extends Fragment {

    private GestureDetectorCompat gestureDetector;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the explore_2.xml layout in this fragment
        View view = inflater.inflate(R.layout.explore_2, container, false);

        // Initialize the gesture detector for swipe detection
        gestureDetector = new GestureDetectorCompat(getContext(), new SwipeGestureListener());

        // Set up button listeners for various buttons
        setupButtonListeners(view);

        // Set the onTouchListener for the root view to detect swipes
        view.setOnTouchListener((v, event) -> gestureDetector.onTouchEvent(event));

        return view;
    }

    private void setupButtonListeners(View view) {
        // Set up button listener for the first_page_button
        Button firstPageButton = view.findViewById(R.id.first_page_button);
        firstPageButton.setOnClickListener(v -> replaceFragment(new ExploreFragment(), true));

        // Set up other button listeners...
        Button moreButton = view.findViewById(R.id.more_button);
        moreButton.setOnClickListener(v -> replaceFragment(new MoreFragment(), true));

        Button mapButton = view.findViewById(R.id.map_button);
        mapButton.setOnClickListener(v -> replaceFragment(new MapFragment(), true));

        Button clinicButton = view.findViewById(R.id.clinic_button);
        clinicButton.setOnClickListener(v -> replaceFragment(new ClinicFragment(), true));

        Button ustoreButton = view.findViewById(R.id.ustore_button);
        ustoreButton.setOnClickListener(v -> replaceFragment(new UstoreFragment(), true));

        Button marketingButton = view.findViewById(R.id.marketing_button);
        marketingButton.setOnClickListener(v -> replaceFragment(new MarketingFragment(), true));

        Button foreignLoungeButton = view.findViewById(R.id.foreign_lounge_button);
        foreignLoungeButton.setOnClickListener(v -> replaceFragment(new ForeignLoungeFragment(), true));

        Button univLibButton = view.findViewById(R.id.univ_lib_button);
        univLibButton.setOnClickListener(v -> replaceFragment(new UnivLibFragment1(), true));

        Button chapelButton = view.findViewById(R.id.chapel_button);
        chapelButton.setOnClickListener(v -> replaceFragment(new ChapelFragment(), true));

        Button foodcourtButton = view.findViewById(R.id.foodcourt_button);
        foodcourtButton.setOnClickListener(v -> replaceFragment(new FoodcourtFragment(), true));

        Button gardenButton = view.findViewById(R.id.garden_button);
        gardenButton.setOnClickListener(v -> replaceFragment(new GardenFragment(), true));
    }

    // Method to replace the fragment
    private void replaceFragment(Fragment fragment, boolean addToBackStack) {
        if (getActivity() != null) {
            MainActivity mainActivity = (MainActivity) getActivity();
            mainActivity.replaceFragment(fragment, addToBackStack);
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
                    if (diffX > 0) {
                        // Swipe right detected, go to ExploreFragment
                        replaceFragment(new ExploreFragment(), true);
                    }
                    return true;
                }
            }
            return false;
        }
    }
}
