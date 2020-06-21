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
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.main_layout, container, false);
        final NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        Button atmoshpereButton = v.findViewById(R.id.buttonAtmosphere);
        atmoshpereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.atmosphereActivity);

            }
        });
        Button buttonRifle = v.findViewById(R.id.buttonRifle);
        buttonRifle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.rifleActivity);

            }
        });
        Button buttonScope = v.findViewById(R.id.buttonScope);
        buttonScope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.scopeActivity);

            }
        });
        Button buttonCartridge = v.findViewById(R.id.buttonCartridge);
        buttonCartridge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.cartridgeActivity);

            }
        });
        Button buttonAdditionalInfo = v.findViewById(R.id.buttonAdditionalInfo);
        buttonAdditionalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.additionalInfoActivity);

            }
        });
        Button calculate = v.findViewById(R.id.buttonCalculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResult(v);

            }
        });
        return v;
    }

    private void calculateResult(View v) {
        EditText fieldDistance = v.findViewById(R.id.editTextDistance);
        System.out.println(fieldDistance.getText());
        EditText fieldTargetEl = v.findViewById(R.id.editTextNumber2);
        EditText fieldWindSpeed = v.findViewById(R.id.editTextWindSpeed);
        EditText fieldWindDirection = v.findViewById(R.id.editTextNumber4);
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
        TextView table00 = v.findViewById(R.id.textMOA2);
        table00.setText(String.valueOf(res));
        TextView table01 = v.findViewById(R.id.textMOA3);
        table01.setText(String.valueOf(res));
        TextView table10 = v.findViewById(R.id.textMRAD3);
        table10.setText(String.valueOf(res));
        TextView table11 = v.findViewById(R.id.textMRAD4);
        table11.setText(String.valueOf(res));
        TextView table20 = v.findViewById(R.id.textInches2);
        table20.setText(String.valueOf(res));
        TextView table21 = v.findViewById(R.id.textInches3);
        table21.setText(String.valueOf(res));
        TextView table30 = v.findViewById(R.id.textClicks2);
        table30.setText(String.valueOf(res));
        TextView table31 = v.findViewById(R.id.textClicks3);
        table31.setText(String.valueOf(res));
    }


}