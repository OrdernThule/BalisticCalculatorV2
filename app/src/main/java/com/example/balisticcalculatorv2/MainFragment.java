package com.example.balisticcalculatorv2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class MainFragment extends Fragment {

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.main_fragment, container, false);
        loadData(v);
        loadTable(v);
        setButtonEvents(v);
        setDataListeners(v);
        return v;
    }

    private void setDataListeners(final View v) {
        Spinner rifleSpinner = v.findViewById(R.id.main_rifle_spinner);
        rifleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                saveData(v);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        EditText distanceText = v.findViewById(R.id.main_distance_input);
        EditText elevationText = v.findViewById(R.id.main_elevation_input);
        EditText speedText = v.findViewById(R.id.main_speed_input);
        EditText directionText = v.findViewById(R.id.main_direction_input);
        createTextListener(distanceText, v);
        createTextListener(elevationText, v);
        createTextListener(speedText, v);
        createTextListener(directionText, v);
    }

    private void createTextListener(EditText e, final View v) {
        e.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                saveData(v);
            }
        });
    }

    private void setButtonEvents(final View v) {
        final NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        Button atmoNavButton = v.findViewById(R.id.main_atmo_button);
        atmoNavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.atmo_fragment);

            }
        });
        Button scopeNavButton = v.findViewById(R.id.main_scope_button);
        scopeNavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.scope_fragment);

            }
        });
        Button catNavButton = v.findViewById(R.id.main_cat_button);
        catNavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.cat_fragment);

            }
        });
        Button infoNavButton = v.findViewById(R.id.main_info_button);
        infoNavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.info_fragment);

            }
        });
        Button calculate = v.findViewById(R.id.main_calc_button);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UtilLibrary.calculateTable(getActivity(), v);
                saveTable(v);
            }
        });
    }

    private void loadTable(View v) {
        SharedPreferences sp = getActivity().getPreferences(Context.MODE_PRIVATE);
        int vMoad = sp.getInt(getString(R.string.table_v_moa), 0);
        int hMoad = sp.getInt(getString(R.string.table_h_moa), 0);
        int vMRAD = sp.getInt(getString(R.string.table_v_mrad), 0);
        int hMRAD = sp.getInt(getString(R.string.table_h_mrad), 0);
        int vInch = sp.getInt(getString(R.string.table_v_inch), 0);
        int hInch = sp.getInt(getString(R.string.tabke_h_inch), 0);
        int vClick = sp.getInt(getString(R.string.table_v_click), 0);
        int hClick = sp.getInt(getString(R.string.table_h_click), 0);
        TextView vMoadText = v.findViewById(R.id.main_table_v_moa_text);
        TextView hMoaText = v.findViewById(R.id.main_table_h_moa_text);
        TextView vMradText = v.findViewById(R.id.main_table_v_mrad_text);
        TextView hMradText = v.findViewById(R.id.main_table_h_mrad_text);
        TextView vInchText = v.findViewById(R.id.main_table_v_inch_text);
        TextView hInchText = v.findViewById(R.id.main_table_h_inch_text);
        TextView vClickText = v.findViewById(R.id.main_table_v_click_text);
        TextView hClickText = v.findViewById(R.id.main_table_h_click_text);
        vMoadText.setText(String.valueOf(vMoad));
        hMoaText.setText(String.valueOf(hMoad));
        vMradText.setText(String.valueOf(vMRAD));
        hMradText.setText(String.valueOf(hMRAD));
        vInchText.setText(String.valueOf(vInch));
        hInchText.setText(String.valueOf(hInch));
        vClickText.setText(String.valueOf(vClick));
        hClickText.setText(String.valueOf(hClick));
    }

    private void loadData(View v) {
        SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        int rifleValue = sharedPreferences.getInt(getString(R.string.main_rifle_pref), 0);
        int distanceValue = sharedPreferences.getInt(getString(R.string.main_distance_pref), 0);
        int elevationValue = sharedPreferences.getInt(getString(R.string.main_elevation_pref), 0);
        int speedValue = sharedPreferences.getInt(getString(R.string.main_speed_pref), 0);
        int directionValue = sharedPreferences.getInt(getString(R.string.main_direction_pref), 0);
        Spinner rifleSpinner = v.findViewById(R.id.main_rifle_spinner);
        EditText distanceText = v.findViewById(R.id.main_distance_input);
        EditText elevationText = v.findViewById(R.id.main_elevation_input);
        EditText speedText = v.findViewById(R.id.main_speed_input);
        EditText directionText = v.findViewById(R.id.main_direction_input);
        rifleSpinner.setSelection(rifleValue);
        distanceText.setText(String.valueOf(distanceValue));
        elevationText.setText(String.valueOf(elevationValue));
        speedText.setText(String.valueOf(speedValue));
        directionText.setText(String.valueOf(directionValue));
    }

    private void saveData(View v) {
        int distanceValue = 0;
        int elevationValue = 0;
        int speedValue = 0;
        int directionValue = 0;
        int rifleValue = 0;
        Spinner rifleSpinner = v.findViewById(R.id.main_rifle_spinner);
        EditText distanceText = v.findViewById(R.id.main_distance_input);
        EditText elevationText = v.findViewById(R.id.main_elevation_input);
        EditText speedText = v.findViewById(R.id.main_speed_input);
        EditText directionText = v.findViewById(R.id.main_direction_input);
        try {
            rifleValue = rifleSpinner.getSelectedItemPosition();
            distanceValue = Integer.parseInt(distanceText.getText().toString());
            elevationValue = Integer.parseInt(elevationText.getText().toString());
            speedValue = Integer.parseInt(speedText.getText().toString());
            directionValue = Integer.parseInt(directionText.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(getContext(), "Failed to parse data", Toast.LENGTH_SHORT).show();
            return;
        }
        SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(getString(R.string.main_rifle_pref), rifleValue);
        editor.putInt(getString(R.string.main_distance_pref), distanceValue);
        editor.putInt(getString(R.string.main_elevation_pref), elevationValue);
        editor.putInt(getString(R.string.main_speed_pref), speedValue);
        editor.putInt(getString(R.string.main_direction_pref), directionValue);
        editor.commit();
    }

    private void saveTable(View v) {
        int vMOA;
        int hMOA;
        int vMRAD;
        int hMRAD;
        int vInch;
        int hInch;
        int vClick;
        int hClick;
        TextView vMOAText = v.findViewById(R.id.main_table_v_moa_text);
        TextView hMOAText = v.findViewById(R.id.main_table_h_moa_text);
        TextView vMRADText = v.findViewById(R.id.main_table_v_mrad_text);
        TextView hMRADText = v.findViewById(R.id.main_table_h_mrad_text);
        TextView vInchText = v.findViewById(R.id.main_table_v_inch_text);
        TextView hInchText = v.findViewById(R.id.main_table_h_inch_text);
        TextView vClickText = v.findViewById(R.id.main_table_v_click_text);
        TextView hClickText = v.findViewById(R.id.main_table_h_click_text);
        try {
            vMOA = Integer.parseInt(vMOAText.getText().toString());
            hMOA = Integer.parseInt(hMOAText.getText().toString());
            vMRAD = Integer.parseInt(vMRADText.getText().toString());
            hMRAD = Integer.parseInt(hMRADText.getText().toString());
            vInch = Integer.parseInt(vInchText.getText().toString());
            hInch = Integer.parseInt(hInchText.getText().toString());
            vClick = Integer.parseInt(vClickText.getText().toString());
            hClick = Integer.parseInt(hClickText.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(getContext(), "Failed to save data from table", Toast.LENGTH_SHORT).show();
            return;
        }
        SharedPreferences sp = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(getString(R.string.table_v_moa), vMOA);
        editor.putInt(getString(R.string.table_h_moa), hMOA);
        editor.putInt(getString(R.string.table_v_mrad), vMRAD);
        editor.putInt(getString(R.string.table_h_mrad), hMRAD);
        editor.putInt(getString(R.string.table_v_inch), vInch);
        editor.putInt(getString(R.string.tabke_h_inch), hInch);
        editor.putInt(getString(R.string.table_v_click), vClick);
        editor.putInt(getString(R.string.table_h_click), hClick);
        editor.commit();
    }
}