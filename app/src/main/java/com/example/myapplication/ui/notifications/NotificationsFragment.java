package com.example.myapplication.ui.notifications;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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

    private FragmentNotificationsBinding binding;
    Button button_start;
    Button button_pause;
    Button button_stop;
    private MaterialButtonToggleGroup materialButtonToggleGroup;
    NumberPicker numPicker;
    TextView mTextField;
    CountDownTimer cdt;
    TextView textView;
    long timeLeft;
    boolean timeIsRunning;
    Uri ringtoneUri;
    Ringtone alarm;
    Animation animation;
    public static final String TAG = "My TAG";


    public NotificationsFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);


        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ringtoneUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        alarm = RingtoneManager.getRingtone(getContext(), ringtoneUri);
        animation = AnimationUtils.loadAnimation(getContext(), R.anim.roundanimation);
        //textView = root.findViewById(R.id.text_notifications);
        mTextField = root.findViewById(R.id.text_notifications);
        button_start = root.findViewById(R.id.buttonStart);
        button_pause = root.findViewById(R.id.buttonPause);
        button_stop = root.findViewById(R.id.buttonStop);
        final NumberPicker numPicker = root.findViewById(R.id.numberPicker);
        String[] myValues = new String[61];
        for (int i = 0; i < myValues.length; i++) {
            myValues[i] = String.valueOf(i);
        }
        button_pause.setEnabled(false);
        button_stop.setEnabled(false);
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
                        Log.e(TAG, String.valueOf(+timeLeft));
                        // Alussa pystyy painamaan vain START-painiketta
                        button_pause.setEnabled(true);
                        button_stop.setEnabled(true);
                        long startTime;
                        if (timeLeft > 0) {
                            startTime = timeLeft;
                            button_start.setText("START");
                        } else {
                            startTime = numPicker.getValue() * 1000;
                        }

                        cdt = new CountDownTimer(startTime, 1000) {


                            public void onTick(long millisUntilFinished) {

                                mTextField.setText(String.valueOf(millisUntilFinished / 1000) + " s");
                                //mTextField.setText(cdt.start());
                                timeLeft = millisUntilFinished;
                                //long min = (millisUntilFinished/(1000*60));
                                //long sec = ((millisUntilFinished/1000)-min*60);

                            }


                            public void onFinish() {
                                //Pysäytetään ajastin, jonkinlainen reset?
                                timeLeft=0;
                                mTextField.setText("Done!");
                                alarm.play();
                                binding.textNotifications.startAnimation(animation);


                            }


                        };
                        cdt.start();


                        //button_start.setEnabled(false);


                    } else if (checkedId == R.id.buttonPause) {
                        //Log.e(TAG, String.valueOf(+timeLeft));
                        cdt.cancel();
                        button_start.setText("RESUME");



                    } else if (checkedId == R.id.buttonStop) {

                        //button_pause.setEnabled(false);
                        cdt.cancel();
                        cdt.onFinish();
                        alarm.stop();
                        binding.textNotifications.clearAnimation();
                        button_start.setText("START");


                    }

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
