package com.acampdev.busstop;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class LineaCalifornia  extends Fragment implements OnMapReadyCallback {

    private static final int REQUEST_LOCATION_PERMISSION=1;
    private  final String TAG="data";
    GoogleMap mMap;
    MapView mapView;
    LocationManager locationManager;
    Marker marker;
    LocationListener locationListener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        rootView=inflater.inflate(R.layout.fragment_linea_california,container,false);
        return rootView;
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment supportMapFragment=(SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapsCalifornia);
        assert supportMapFragment != null;
        supportMapFragment.getMapAsync(this);

        locationManager=(LocationManager) Objects.requireNonNull(getActivity()).getSystemService(Context.LOCATION_SERVICE);
        if(ActivityCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)!=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_LOCATION_PERMISSION);
        }
        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    final double latitude=location.getLatitude();
                    final double longitude=location.getLongitude();

                    LatLng latLng= new LatLng(latitude,longitude);
                    if (getActivity()!=null){
                        Geocoder geocoder= new Geocoder(getActivity(), Locale.getDefault());
                        try{
                            List<Address> addressList= geocoder.getFromLocation(latitude,longitude,1);
                            final  String dir=addressList.get(0).getAddressLine(0);

                            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                            mMap.addMarker(new MarkerOptions().position(latLng).title(dir));
                            CameraPosition cameraPosition=CameraPosition.builder().target(latLng).zoom(16).bearing(0).tilt(45).build();
                            mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                        }catch (IOException e){e.printStackTrace();}
                    }
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            });
        }else if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    final double latitude=location.getLatitude();
                    final double longitude=location.getLongitude();

                    LatLng latLng= new LatLng(latitude,longitude);
                    if (getActivity()!=null){
                        Geocoder geocoder= new Geocoder(getActivity(), Locale.getDefault());
                        try{
                            List<Address> addressList= geocoder.getFromLocation(latitude,longitude,1);
                            final  String dir=addressList.get(0).getAddressLine(0);

                            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                            mMap.addMarker(new MarkerOptions().position(latLng).title(dir));
                            CameraPosition cameraPosition=CameraPosition.builder().target(latLng).zoom(16).bearing(0).tilt(45).build();
                            mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                        }catch (IOException e){e.printStackTrace();}
                    }
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            });
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,0,locationListener);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locationListener);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap=googleMap;
        /*

        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/
    }


}
