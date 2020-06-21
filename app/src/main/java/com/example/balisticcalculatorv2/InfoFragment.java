package com.example.balisticcalculatorv2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InfoFragment extends Fragment {

    public InfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.info_fragment, container, false);
        loadData(v);
        Button saveButton = v.findViewById(R.id.info_save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               saveData(v);
               getActivity().onBackPressed();
            }
        });
        return v;
    }

    private void loadData(View v){
        EditText soundSpeedText = v.findViewById(R.id.info_sound_input);
        EditText targetSpeedText = v.findViewById(R.id.info_target_input);
        EditText flyTimeText = v.findViewById(R.id.info_time_input);
        SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        int soundSpeedValue = sharedPreferences.getInt(getString(R.string.info_sound_pref), 0);
        int targetSpeedValue = sharedPreferences.getInt(getString(R.string.info_target_pref),0);
        int flyTimeValue = sharedPreferences.getInt(getString(R.string.info_time_pref), 0);
        soundSpeedText.setText(String.valueOf(soundSpeedValue));
        targetSpeedText.setText(String.valueOf(targetSpeedValue));
        flyTimeText.setText(String.valueOf(flyTimeValue));
    }

    private void saveData(View v){
        int soundSpeedValue = 0;
        int targetSpeedValue = 0;
        int flyTimeValue = 0;
        EditText soundSpeedText = v.findViewById(R.id.info_sound_input);
        EditText targetSpeedText = v.findViewById(R.id.info_target_input);
        EditText flyTimeText = v.findViewById(R.id.info_time_input);
        try {
            soundSpeedValue = Integer.parseInt(soundSpeedText.getText().toString());
            targetSpeedValue = Integer.parseInt(targetSpeedText.getText().toString());
            flyTimeValue = Integer.parseInt(flyTimeText.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(getContext(), "Failed to parse data", Toast.LENGTH_SHORT).show();
            return;
        }
        SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(getString(R.string.info_sound_pref), soundSpeedValue);
        editor.putInt(getString(R.string.info_target_pref), targetSpeedValue);
        editor.putInt(getString(R.string.info_time_pref), flyTimeValue);
        editor.commit();
    }
}