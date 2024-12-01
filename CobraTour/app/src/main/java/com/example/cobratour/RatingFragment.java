package com.example.cobratour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RatingFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the explore_1.xml layout in this fragment
        View view = inflater.inflate(R.layout.rating_page, container, false);

        Button backButton = view.findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> replaceFragment(new MoreFragment(), true));

        Button foodcourtButton2 = view.findViewById(R.id.foodcourt_button2);
        foodcourtButton2.setOnClickListener(v -> replaceFragment(new FeedbackFragment(), true));

        Button foreignButton2 = view.findViewById(R.id.foreign_button2);
        foreignButton2.setOnClickListener(v -> replaceFragment(new FeedbackFragment(), true));

        Button gsdButton2 = view.findViewById(R.id.gsd_button2);
        gsdButton2.setOnClickListener(v -> replaceFragment(new FeedbackFragment(), true));

        Button marketingButton2 = view.findViewById(R.id.marketing_button2);
        marketingButton2.setOnClickListener(v -> replaceFragment(new FeedbackFragment(), true));

        Button pedroButton2 = view.findViewById(R.id.pedro_button2);
        pedroButton2.setOnClickListener(v -> replaceFragment(new FeedbackFragment(), true));

        Button phinmaHallButton2 = view.findViewById(R.id.phinma_button2);
        phinmaHallButton2.setOnClickListener(v -> replaceFragment(new FeedbackFragment(), true));

        Button profLibButton2 = view.findViewById(R.id.proflib_button2);
        profLibButton2.setOnClickListener(v -> replaceFragment(new FeedbackFragment(), true));

        Button financeRegistrarButton2 = view.findViewById(R.id.reg_finance_button2);
        financeRegistrarButton2.setOnClickListener(v -> replaceFragment(new FeedbackFragment(), true));

        Button shahsButton2 = view.findViewById(R.id.shahs_button2);
        shahsButton2.setOnClickListener(v -> replaceFragment(new FeedbackFragment(), true));

        Button studentLifeButton2 = view.findViewById(R.id.studentlife_button2);
        studentLifeButton2.setOnClickListener(v -> replaceFragment(new FeedbackFragment(), true));

        Button villaButton2 = view.findViewById(R.id.villa_button2);
        villaButton2.setOnClickListener(v -> replaceFragment(new FeedbackFragment(), true));

        Button techhubButton2 = view.findViewById(R.id.tech_hub_button2);
        techhubButton2.setOnClickListener(v -> replaceFragment(new FeedbackFragment(), true));

        Button clinicButton2 = view.findViewById(R.id.clinic_button2);
        clinicButton2.setOnClickListener(v -> replaceFragment(new FeedbackFragment(), true));

        Button univlibButton2 = view.findViewById(R.id.univ_lib_button2);
        univlibButton2.setOnClickListener(v -> replaceFragment(new FeedbackFragment(), true));

        Button ustoreButton2 = view.findViewById(R.id.ustore_button2);
        ustoreButton2.setOnClickListener(v -> replaceFragment(new FeedbackFragment(), true));

        return view;

    }

    // Method to replace the fragment
    private void replaceFragment(Fragment fragment, boolean addToBackStack) {
        if (getActivity() != null) {
            MainActivity mainActivity = (MainActivity) getActivity();
            mainActivity.replaceFragment(fragment, addToBackStack);
        }
    }

}
