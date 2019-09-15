package com.acampdev.busstop;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.acampdev.busstop.Helpers.FetchURL;
import com.acampdev.busstop.Helpers.TaskLoadedCallback;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.Objects;

public class LineaHuanchaco extends Fragment implements OnMapReadyCallback{
//, TaskLoadedCallback
    private GoogleMap mMap;
    Button btnRuta;
    MarkerOptions place1,place2;
    Polyline polyline;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        rootView=inflater.inflate(R.layout.fragment_linea_huanchaco,container,false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment supportMapFragment=(SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapsHuanchaco);
        assert supportMapFragment != null;
        supportMapFragment.getMapAsync(this);
        btnRuta= Objects.requireNonNull(getActivity()).findViewById(R.id.btnRutaHID);
        /*
        btnRuta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FetchURL(getContext()).execute(getUrl(place1.getPosition(),place2.getPosition(),"driving"),"driving");
            }
        });
        place1= new MarkerOptions().position(new LatLng(-8.093771135751751,-79.0183357588554)).title("Location 1");
        place2= new MarkerOptions().position(new LatLng(-8.100611912338351,-79.01272457752192)).title("Location 2");

        //String url= getUrl(place1.getPosition(),place2.getPosition(),"driving");
*/
    }

    private String getUrl(LatLng origin, LatLng dest,String directionMode ){
        String str_origin="origin="+origin.latitude+","+origin.longitude;
        String str_dest="destination="+dest.latitude+","+dest.longitude;
        String mode= "mode="+directionMode;
        String parameters=str_origin + "&" + str_dest+ "&"+mode;
        String output="json";
        String url="https://maps.googleapis.com/maps/api/directions/"+output+ "?" + parameters + "&key="+getString(R.string.google_maps_key) ;
        return  url;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap=googleMap;
        LatLng sydney = new LatLng(-8.100611912338351, -79.01272457752192);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        /*
        Log.d("myLog","Address Markers");
        mMap.addMarker(place1);
        mMap.addMarker(place2);*/
    }
    /*
    @Override
    public void onTaskDone(Object... values){
        if(polyline!=null){
            polyline.remove();
            polyline=mMap.addPolyline((PolylineOptions)values[0]);
        }
    }*/

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
