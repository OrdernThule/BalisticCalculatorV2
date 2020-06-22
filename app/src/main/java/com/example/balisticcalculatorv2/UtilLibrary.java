package com.example.balisticcalculatorv2;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

final public class UtilLibrary {
    private UtilLibrary() {
    }

    //Placeholder for actual ballistic calculations
    static void calculateTable(Activity a, View v) {
        TextView vMOAText = v.findViewById(R.id.main_table_v_moa_text);
        TextView hMOAText = v.findViewById(R.id.main_table_h_moa_text);
        TextView vMRADText = v.findViewById(R.id.main_table_v_mrad_text);
        TextView hMRADText = v.findViewById(R.id.main_table_h_mrad_text);
        TextView vInchText = v.findViewById(R.id.main_table_v_inch_text);
        TextView hInchText = v.findViewById(R.id.main_table_h_inch_text);
        TextView vClickText = v.findViewById(R.id.main_table_v_click_text);
        TextView hClickText = v.findViewById(R.id.main_table_h_click_text);
        long sum = getSumOfAllInputs(a);
        System.out.println(sum);
        Random r = new Random(sum);

        int vMOA = r.nextInt(1000);
        int hMOA = r.nextInt(1000);
        int vMRAD = r.nextInt(1000);
        int hMRAD = r.nextInt(1000);
        int vInch = r.nextInt(1000);
        int hInch = r.nextInt(1000);
        int vClick = r.nextInt(1000);
        int hClick = r.nextInt(1000);

        vMOAText.setText(String.valueOf(vMOA));
        hMOAText.setText(String.valueOf(hMOA));
        vMRADText.setText(String.valueOf(vMRAD));
        hMRADText.setText(String.valueOf(hMRAD));
        vInchText.setText(String.valueOf(vInch));
        hInchText.setText(String.valueOf(hInch));
        vClickText.setText(String.valueOf(vClick));
        hClickText.setText(String.valueOf(hClick));
    }

    static int getSumOfAllInputs(Activity a) {
        SharedPreferences sp = a.getPreferences(Context.MODE_PRIVATE);
        int sum = 0;
        sum += sp.getInt(a.getString(R.string.main_distance_pref), 0);
        sum += sp.getInt(a.getString(R.string.main_elevation_pref), 0);
        sum += sp.getInt(a.getString(R.string.main_speed_pref), 0);
        sum += sp.getInt(a.getString(R.string.main_direction_pref), 0);
        sum += sp.getInt(a.getString(R.string.main_rifle_pref), 0);

        sum += sp.getInt(a.getString(R.string.info_sound_pref), 0);
        sum += sp.getInt(a.getString(R.string.info_target_pref), 0);
        sum += sp.getInt(a.getString(R.string.info_time_pref), 0);

        sum += sp.getInt(a.getString(R.string.atmo_alt_pref), 0);
        sum += sp.getInt(a.getString(R.string.atmo_temp_pref), 0);
        sum += sp.getInt(a.getString(R.string.atmo_press_pref), 0);

        sum += sp.getInt(a.getString(R.string.cat_rifle_pref), 0);
        sum += sp.getInt(a.getString(R.string.cat_weight_pref), 0);
        sum += sp.getInt(a.getString(R.string.cat_ballistic_pref), 0);
        sum += sp.getInt(a.getString(R.string.cat_speed_pref), 0);
        sum += sp.getInt(a.getString(R.string.cat_temp_pref), 0);

        sum += sp.getInt(a.getString(R.string.scope_distance_pref), 0);
        sum += sp.getInt(a.getString(R.string.scope_height_pref), 0);
        sum += sp.getInt(a.getString(R.string.scope_v_click_pref), 0);
        sum += sp.getInt(a.getString(R.string.scope_h_click_pref), 0);
        sum += sp.getInt(a.getString(R.string.scope_unit_pref), 0);
        sum += sp.getInt(a.getString(R.string.scope_grid_pref), 0);
        return sum;
    }
}
