package com.example.myapplication.ui.dashboard;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentDashboardBinding;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;
import java.util.Locale;

public class DashboardFragment extends Fragment implements LocationListener {


    Geocoder geocoder;
    List<Address> addresses;
    String address;
    String city;
    String country;
    String postalCode;
    LocationManager locationManager;
    String currentLocation;
    Location lastLocation;
    public static final String TAG = "MyAppMessage";
    TextInputEditText latField;
    TextInputEditText longField;
    TextInputEditText addField;
    Button mapButton;


    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        latField = root.findViewById(R.id.textInput1);
        longField = root.findViewById(R.id.textInput2);
        addField = root.findViewById(R.id.textInput3);
        mapButton = root.findViewById(R.id.mapbutton);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMap();

            }
        });



        //final TextView textView = binding.textDashboard;
        //dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;


    }

    private void showMap(){
        Uri gmmIntentUri = Uri.parse("geo:"+lastLocation.getLatitude()+","+lastLocation.getLongitude());

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

        mapIntent.setPackage("com.google.android.apps.maps");

                /*if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }

                 */ startActivity(mapIntent);


    }
    @Override
    public void onStart() {
        super.onStart();
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 0, this);
        lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        latField.setText(Double.toString(lastLocation.getLatitude()));
        longField.setText(Double.toString(lastLocation.getLongitude()));


        try {
            Geocoder geocoder = new Geocoder(getContext(), Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(
                    lastLocation.getLatitude(),
                    lastLocation.getLongitude(), 1);
            Address address = addresses.get(0);
            currentLocation = address.getAddressLine(0);
        } catch (Exception e) {
            Log.e(TAG, "Jotain meni pieleen");
        } addField.setText(currentLocation);
    }


    @Override
    public void onStop() {
        super.onStop();
        locationManager.removeUpdates(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
    }

    @Override
    public void onLocationChanged(Location location) {

        latField.setText(Double.toString(location.getLatitude()));
        longField.setText(Double.toString(location.getLongitude()));

        try {
            Geocoder geocoder = new Geocoder(getContext(), Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(
                    location.getLatitude(),
                    location.getLongitude(), 1);
            Address address = addresses.get(0);
            String currentLocation = address.getAddressLine(0);
            addField.setText(currentLocation);

        } catch (Exception e) {
            Log.e(TAG, "Jotain meni pieleen");
        }

    }



}