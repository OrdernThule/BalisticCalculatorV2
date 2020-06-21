package com.example.balisticcalculatorv2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainFragment extends Fragment {

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.main_fragment, container, false);
        final NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        Button atmoshpereButton = v.findViewById(R.id.main_atmo_button);
        atmoshpereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.atmosphereActivity);

            }
        });
    /*    Button buttonRifle = v.findViewById(R.id.buttonRifle);
        buttonRifle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.rifleActivity);

            }
        });*/
        Button buttonScope = v.findViewById(R.id.main_scope_button);
        buttonScope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.scopeActivity);

            }
        });
        Button buttonCartridge = v.findViewById(R.id.main_cat_button);
        buttonCartridge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.cartridgeActivity);

            }
        });
        Button buttonAdditionalInfo = v.findViewById(R.id.main_info_button);
        buttonAdditionalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.additionalInfoActivity);

            }
        });
        Button calculate = v.findViewById(R.id.main_calc_button);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResult(v);

            }
        });
        return v;
    }

    private void calculateResult(View v) {
        EditText fieldDistance = v.findViewById(R.id.main_distance_input);
        System.out.println(fieldDistance.getText());
        EditText fieldTargetEl = v.findViewById(R.id.main_elevation_input);
        EditText fieldWindSpeed = v.findViewById(R.id.main_speed_input);
        EditText fieldWindDirection = v.findViewById(R.id.main_direction_input);
        double res = 0;
        try {
             res = Double.parseDouble(fieldDistance.getText().toString())
                    + Double.parseDouble(fieldTargetEl.getText().toString())
                    + Double.parseDouble(fieldWindSpeed.getText().toString())
                    + Double.parseDouble(fieldWindDirection.getText().toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        TextView table00 = v.findViewById(R.id.main_table_v_mpa_text);
        table00.setText(String.valueOf(res));
        TextView table01 = v.findViewById(R.id.main_table_h_mpa_text);
        table01.setText(String.valueOf(res));
        TextView table10 = v.findViewById(R.id.main_table_v_mrad_text);
        table10.setText(String.valueOf(res));
        TextView table11 = v.findViewById(R.id.main_table_h_mrad_text);
        table11.setText(String.valueOf(res));
        TextView table20 = v.findViewById(R.id.main_table_v_inch_text);
        table20.setText(String.valueOf(res));
        TextView table21 = v.findViewById(R.id.main_table_h_inch_text);
        table21.setText(String.valueOf(res));
        TextView table30 = v.findViewById(R.id.main_table_v_click_text);
        table30.setText(String.valueOf(res));
        TextView table31 = v.findViewById(R.id.main_table_h_click_text);
        table31.setText(String.valueOf(res));
    }


}