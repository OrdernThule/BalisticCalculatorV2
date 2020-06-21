package com.example.balisticcalculatorv2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class atmosphereActivity extends Fragment {

    public atmosphereActivity() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.atmo_fragment, container, false);
        loadData(v);
        Button saveButton = v.findViewById(R.id.atmo_save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData(v);
                getActivity().onBackPressed();
            }
        });
        return inflater.inflate(R.layout.atmo_fragment, container, false);

    }
    private void loadData(View v){
        EditText altText = v.findViewById(R.id.atmo_alt_input);
        EditText tempText = v.findViewById(R.id.atmo_temp_input);
        EditText pressText = v.findViewById(R.id.atmo_press_input);
        SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        int altValue = sharedPreferences.getInt(getString(R.string.atmo_alt_pref), 0);
        int tempValue = sharedPreferences.getInt(getString(R.string.atmo_temp_pref),0);
        int pressValue = sharedPreferences.getInt(getString(R.string.atmo_press_pref), 0);
        altText.setText(String.valueOf(altValue));
        tempText.setText(String.valueOf(tempValue));
        pressText.setText(String.valueOf(pressValue));
    }

    private void saveData(View v){
        int altValue = 0;
        int tempValue = 0;
        int pressValue = 0;
        EditText altText = v.findViewById(R.id.atmo_alt_input);
        EditText tempText = v.findViewById(R.id.atmo_temp_input);
        EditText pressText = v.findViewById(R.id.atmo_press_input);
        try {
            altValue = Integer.parseInt(altText.getText().toString());
            tempValue = Integer.parseInt(tempText.getText().toString());
            pressValue = Integer.parseInt(pressText.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(getContext(), "Failed to parse data", Toast.LENGTH_SHORT).show();
            return;
        }
        SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(getString(R.string.atmo_alt_pref), altValue);
        editor.putInt(getString(R.string.atmo_temp_pref), tempValue);
        editor.putInt(getString(R.string.atmo_press_pref), pressValue);
        editor.commit();
    }
}