package com.example.balisticcalculatorv2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ScopeFragment extends Fragment {

    public ScopeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.scope_fragment, container, false);
        loadData(v);
        Button saveButton = v.findViewById(R.id.scope_save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData(v);
                getActivity().onBackPressed();
            }
        });
        return v;
    }

    private void loadData(View v) {
        SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        int unitValue = sharedPreferences.getInt(getString(R.string.scope_unit_pref), 0);
        int gridValue = sharedPreferences.getInt(getString(R.string.scope_grid_pref), 0);
        int distanceValue = sharedPreferences.getInt(getString(R.string.scope_distance_pref), 0);
        int heightValue = sharedPreferences.getInt(getString(R.string.scope_height_pref), 0);
        int vClickValue = sharedPreferences.getInt(getString(R.string.scope_v_click_pref), 0);
        int hClickValue = sharedPreferences.getInt(getString(R.string.scope_h_click_pref), 0);
        Spinner unitSpinner = v.findViewById(R.id.scope_unit_spinner);
        Spinner gridSpinner = v.findViewById(R.id.scope_grid_spinner);
        EditText distanceText = v.findViewById(R.id.scope_dist_input);
        EditText heightText = v.findViewById(R.id.scope_height_input);
        EditText vClicksText = v.findViewById(R.id.scope_v_click_input);
        EditText hClickText = v.findViewById(R.id.scope_h_click_input);
        unitSpinner.setSelection(unitValue);
        gridSpinner.setSelection(gridValue);
        distanceText.setText(String.valueOf(distanceValue));
        heightText.setText(String.valueOf(heightValue));
        vClicksText.setText(String.valueOf(vClickValue));
        hClickText.setText(String.valueOf(hClickValue));
    }

    private void saveData(View v) {
        int distanceValue = 0;
        int heightValue = 0;
        int vClickValue = 0;
        int hClickValue = 0;
        int unitValue = 0;
        int gridValue = 0;
        Spinner unitSpinner = v.findViewById(R.id.scope_unit_spinner);
        Spinner gridSpinner = v.findViewById(R.id.scope_grid_spinner);
        EditText distanceText = v.findViewById(R.id.scope_dist_input);
        EditText heightText = v.findViewById(R.id.scope_height_input);
        EditText vClicksText = v.findViewById(R.id.scope_v_click_input);
        EditText hClickText = v.findViewById(R.id.scope_h_click_input);
        try {
            unitValue = unitSpinner.getSelectedItemPosition();
            gridValue = gridSpinner.getSelectedItemPosition();
            distanceValue = Integer.parseInt(distanceText.getText().toString());
            heightValue = Integer.parseInt(heightText.getText().toString());
            vClickValue = Integer.parseInt(vClicksText.getText().toString());
            hClickValue = Integer.parseInt(hClickText.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(getContext(), "Failed to parse data", Toast.LENGTH_SHORT).show();
            return;
        }
        SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(getString(R.string.scope_unit_pref), unitValue);
        editor.putInt(getString(R.string.scope_grid_pref), gridValue);
        editor.putInt(getString(R.string.scope_distance_pref), distanceValue);
        editor.putInt(getString(R.string.scope_height_pref), heightValue);
        editor.putInt(getString(R.string.scope_v_click_pref), vClickValue);
        editor.putInt(getString(R.string.scope_h_click_pref), hClickValue);
        editor.commit();
    }
}