package com.example.cobratour;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GestureDetectorCompat;
import androidx.fragment.app.Fragment;

public class ExploreFragment extends Fragment {

    private GestureDetectorCompat gestureDetector;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the explore_1.xml layout in this fragment
        View view = inflater.inflate(R.layout.explore_1, container, false);

        // Initialize the gesture detector for swipe detection
        gestureDetector = new GestureDetectorCompat(getContext(), new SwipeGestureListener());

        // Set up button listeners for various buttons
        setupButtonListeners(view);

        // Set the onTouchListener for the root view to detect swipes
        view.setOnTouchListener((v, event) -> gestureDetector.onTouchEvent(event));

        return view;
    }

    private void setupButtonListeners(View view) {
        Button secondPageButton = view.findViewById(R.id.second_page_button);
        secondPageButton.setOnClickListener(v -> replaceFragment(new ExploreFragment2(), true));

        Button moreButton = view.findViewById(R.id.more_button);
        moreButton.setOnClickListener(v -> replaceFragment(new MoreFragment(), true));

        Button mapButton = view.findViewById(R.id.map_button);
        mapButton.setOnClickListener(v -> replaceFragment(new MapFragment(), true));

        Button techHubButton = view.findViewById(R.id.tech_hub_button);
        techHubButton.setOnClickListener(v -> replaceFragment(new TechHubFragment(), true));

        Button phinmaHallButton = view.findViewById(R.id.phinma_hall_button);
        phinmaHallButton.setOnClickListener(v -> replaceFragment(new PhFragment1(), true));

        Button shahsButton = view.findViewById(R.id.shahs_button);
        shahsButton.setOnClickListener(v -> replaceFragment(new ShahsFragment1(), true));

        Button pedroButton = view.findViewById(R.id.pedro_button);
        pedroButton.setOnClickListener(v -> replaceFragment(new PedroFragment(), true));

        Button profLibButton = view.findViewById(R.id.prof_lib_button);
        profLibButton.setOnClickListener(v -> replaceFragment(new ProfLibFragment(), true));

        Button financeRegistrarButton = view.findViewById(R.id.registrar_button);
        financeRegistrarButton.setOnClickListener(v -> replaceFragment(new FinanceRegistrarFragment(), true));

        Button gsdButton = view.findViewById(R.id.gsd_button);
        gsdButton.setOnClickListener(v -> replaceFragment(new GsdFragment(), true));

        Button villaButton = view.findViewById(R.id.swu_villa_button);
        villaButton.setOnClickListener(v -> replaceFragment(new SwuVillaFragment(), true));

        Button studentLifeButton = view.findViewById(R.id.student_life_button);
        studentLifeButton.setOnClickListener(v -> replaceFragment(new StudentLifeFragment(), true));
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
                    if (diffX < 0) {
                        // Swipe left detected, go to ExploreFragment2
                        replaceFragment(new ExploreFragment2(), true);
                    }
                    return true;
                }
            }
            return false;
        }
    }
}
