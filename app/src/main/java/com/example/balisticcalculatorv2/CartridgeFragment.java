package com.example.balisticcalculatorv2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class CartridgeFragment extends Fragment {

    public CartridgeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.cartridge_fragment, container, false);
        loadData(v);
        Button saveButton = v.findViewById(R.id.cat_save_button);
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
        int rifleValue = sharedPreferences.getInt(getString(R.string.cat_rifle_pref), 0);
        int weightValue = sharedPreferences.getInt(getString(R.string.cat_weight_pref), 0);
        int coeffValue = sharedPreferences.getInt(getString(R.string.cat_ballistic_pref), 0);
        int speedValue = sharedPreferences.getInt(getString(R.string.cat_speed_pref), 0);
        int tempValue = sharedPreferences.getInt(getString(R.string.cat_temp_pref), 0);
        Spinner rifleSpinner = v.findViewById(R.id.cat_spinner);
        EditText weightText = v.findViewById(R.id.cat_weight_input);
        EditText coeffText = v.findViewById(R.id.cat_ballistic_input);
        EditText speedText = v.findViewById(R.id.cat_speed_input);
        EditText tempText = v.findViewById(R.id.cat_temp_input);
        rifleSpinner.setSelection(rifleValue);
        weightText.setText(String.valueOf(weightValue));
        coeffText.setText(String.valueOf(coeffValue));
        speedText.setText(String.valueOf(speedValue));
        tempText.setText(String.valueOf(tempValue));
    }

    private void saveData(View v) {
        int rifleValue = 0;
        int weightValue = 0;
        int coeffValue = 0;
        int speedValue = 0;
        int tempValue = 0;
        Spinner rifleSpinner = v.findViewById(R.id.cat_spinner);
        EditText weightText = v.findViewById(R.id.cat_weight_input);
        EditText coeffText = v.findViewById(R.id.cat_ballistic_input);
        EditText speedText = v.findViewById(R.id.cat_speed_input);
        EditText tempText = v.findViewById(R.id.cat_temp_input);
        try {
            rifleValue = rifleSpinner.getSelectedItemPosition();
            weightValue = Integer.parseInt(weightText.getText().toString());
            coeffValue = Integer.parseInt(coeffText.getText().toString());
            speedValue = Integer.parseInt(speedText.getText().toString());
            tempValue = Integer.parseInt(tempText.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(getContext(), "Failed to parse data", Toast.LENGTH_SHORT).show();
            return;
        }
        SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(getString(R.string.cat_rifle_pref), rifleValue);
        editor.putInt(getString(R.string.cat_weight_pref), weightValue);
        editor.putInt(getString(R.string.cat_ballistic_pref), coeffValue);
        editor.putInt(getString(R.string.cat_speed_pref), speedValue);
        editor.putInt(getString(R.string.cat_temp_pref), tempValue);
        editor.commit();
    }
}