package com.example.myapplication.ui.notifications;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentNotificationsBinding;
import com.google.android.material.button.MaterialButtonToggleGroup;

public class NotificationsFragment extends Fragment {
    Button button_start;
    Button button_pause;
    Button button_stop;
    private MaterialButtonToggleGroup materialButtonToggleGroup;
    NumberPicker numPicker;
    TextView mTextField;
    CountDownTimer cdt;


    private FragmentNotificationsBinding binding;

    public NotificationsFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);



        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        mTextField = root.findViewById(R.id.textTime);
        button_start = root.findViewById(R.id.buttonStart);
        button_pause = root.findViewById(R.id.buttonPause);
        button_stop = root.findViewById(R.id.buttonStop);
        final NumberPicker numPicker = root.findViewById(R.id.numberPicker);
        String[] myValues = new String[61];
        for(int i = 0; i<myValues.length;i++){
            myValues[i]= String.valueOf(i);
        }
        numPicker.setDisplayedValues(myValues);
        numPicker.setMinValue(0);
        numPicker.setMaxValue(60);
        numPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                // Code here executes on main thread after user selects value
            }
        });
        materialButtonToggleGroup = root.findViewById(R.id.toggleButton);
        materialButtonToggleGroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.
                OnButtonCheckedListener() {
            @Override
            public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId,
                                        boolean isChecked) {
                if (isChecked) {
                    if (checkedId == R.id.buttonStart) {
                        // start timing here
                        cdt=new CountDownTimer(numPicker.getValue()*1000, 1000) {

                            public void onTick(long millisUntilFinished) {


                                mTextField.setText(String.valueOf(millisUntilFinished / 1000) +" s");
                                //mTextField.setText(cdt.start());
                            }

                            public void onFinish() {
                                mTextField.setText("done!");
                            }
                        }.start();

                    } else if (checkedId == R.id.buttonPause) {

                            // pause timing here

                        };



                    } else if (checkedId == R.id.buttonStop) {

                        //stop timing here
                    }
                }

        });



        //final TextView textView = binding.textNotifications;
        //notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}