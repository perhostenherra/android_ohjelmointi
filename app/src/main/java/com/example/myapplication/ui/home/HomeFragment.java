package com.example.myapplication.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.PeliDemo;
import com.example.myapplication.R;
import com.example.myapplication.RajapintaHaku;
import com.example.myapplication.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    private Button peliDemoButton;
    private Button welcomeButton;
    private Button searchButton;
    private EditText searchText;
    private View welcomeTextView;
    String searchTerm;
    public static final String TAG ="MyAppMessage";

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        welcomeButton = root.findViewById(R.id.hello_button);
        welcomeTextView = root.findViewById(R.id.textView);
        peliDemoButton = root.findViewById(R.id.peliDemoButton);
        searchButton = root.findViewById(R.id.searchButton);
        searchText=root.findViewById(R.id.searchText);
        Log.e(TAG, "activating play view");
        welcomeTextView.setVisibility(View.INVISIBLE);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickEvents(view);
            }
        });

        peliDemoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickEvents(view);
            }
        });
        welcomeButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                handleClickEvents(v);
            }

        });

        //final TextView textView = binding.textHome;
        //homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void handleClickEvents (View v)
    {
        switch(v.getId()) {
            case R.id.peliDemoButton:
                Intent i = new Intent(getActivity(), PeliDemo.class);
                startActivity(i);


                break;

            case R.id.searchButton:
                searchTerm = String.valueOf(searchText.getText());
                Intent i2 = new Intent(getActivity(), RajapintaHaku.class);
                i2.putExtra("searchTerm",searchTerm);
                Log.e(TAG,"searchTerm:"+searchTerm);
                startActivity(i2);

                break;

            case R.id.hello_button:
                if (welcomeTextView.getVisibility() == View.INVISIBLE)
                    welcomeTextView.setVisibility(View.VISIBLE);

                else if (welcomeTextView.getVisibility() == View.VISIBLE)
                    welcomeTextView.setVisibility(View.INVISIBLE);

                break;

            default:
        }
    }
}