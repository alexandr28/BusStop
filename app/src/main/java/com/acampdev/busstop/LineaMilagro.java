package com.acampdev.busstop;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.LocationManager;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.DirectionsStep;
import com.google.maps.model.EncodedPolyline;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LineaMilagro extends Fragment implements OnMapReadyCallback {


    private String TAG = "so47492459";
    private GoogleMap mMap;
    LocationManager locationManager;
    private static final int LOCATION_REQUEST = 500;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        rootView=inflater.inflate(R.layout.fragment_linea_milagro,container,false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment supportMapFragment=(SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapsMilagro);
        assert supportMapFragment != null;
        supportMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap=googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        locationManager=(LocationManager) Objects.requireNonNull(getActivity()).getSystemService(Context.LOCATION_SERVICE);
        if(ActivityCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)!=
                        PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQUEST);
        }
        mMap.setMyLocationEnabled(true);

        LatLng milagro = new LatLng(-8.013800466671356,-79.06796575586036);
        mMap.addMarker(new MarkerOptions().position(milagro).title("Av Panamericana Norte Milagro"));

        LatLng milagro2 = new LatLng(-8.022909186493052,-79.06498064814585);
        mMap.addMarker(new MarkerOptions().position(milagro2).title("Av Panamericana Norte Milagro"));

        LatLng milagro3 = new LatLng(-8.039971396084084,-79.05950806395582);
        mMap.addMarker(new MarkerOptions().position(milagro3).title("Av Panamericana Norte Milagro"));

        LatLng esperanza = new LatLng(-8.074423539104714,-79.04784581351211);
        mMap.addMarker(new MarkerOptions().position(esperanza).title("Av Condorcanqui El Triunfo"));

        LatLng esperanza1 = new LatLng(-8.056009837334514,-79.05432882139075);
        mMap.addMarker(new MarkerOptions().position(esperanza1).title("Av Condorcanqui Winchanzao"));

        LatLng esperanza2 = new LatLng(-8.062091515565001,-79.05239583854564);
        mMap.addMarker(new MarkerOptions().position(esperanza2).title("Av Condorcanqui Av Indoamerica"));

        LatLng esperanza3 = new LatLng(-8.069062157686133,-79.05021208318304);
        mMap.addMarker(new MarkerOptions().position(esperanza3).title("Av Panamericana Norte Esperanza"));

        LatLng esperanza4 = new LatLng(-8.073603186619579,-79.04851600561747);
        mMap.addMarker(new MarkerOptions().position(esperanza4).title("Av Tahuantinsuyo Esperanza"));

        LatLng esperanza5 = new LatLng(-8.083348142236233,-79.04268842924436);
        mMap.addMarker(new MarkerOptions().position(esperanza5).title("Av Tahuantinsuyo Muni. Esperanza"));

        LatLng tupac = new LatLng(-8.087594040022253,-79.03993397124414);
        mMap.addMarker(new MarkerOptions().position(tupac).title("Av Tupac Amaru"));

        LatLng tupacAmaru = new LatLng(-8.097491989955216,-79.02944075292804);
        mMap.addMarker(new MarkerOptions().position(tupacAmaru).title("Av America Norte"));

        LatLng avAmNorte = new LatLng(-8.093925941922734,-79.02453974713016);
        mMap.addMarker(new MarkerOptions().position(avAmNorte).title("Av America Norte"));

        LatLng avAmNorte3 = new LatLng(-8.095707709234915,-79.01937332041308);
        mMap.addMarker(new MarkerOptions().position(avAmNorte3).title("Av America Norte Av Miraflores"));

        LatLng avAmNorte4 = new LatLng(-8.099371174794257,-79.0141672319247);
        mMap.addMarker(new MarkerOptions().position(avAmNorte4).title("Av America Norte Av Peru"));

        LatLng avAmSur = new LatLng(-8.102717763175406,-79.01111438020128);
        mMap.addMarker(new MarkerOptions().position(avAmSur).title("Av America Sur"));

        LatLng avAmSur1 = new LatLng(-8.105348399540148,-79.01052389763258);
        mMap.addMarker(new MarkerOptions().position(avAmSur1).title("Av America Sur Noria"));

        LatLng avAmSur2 = new LatLng(-8.112419380547223,-79.01395120295393);
        mMap.addMarker(new MarkerOptions().position(avAmSur2).title("Av America Sur Av Ricardo Palma"));

        LatLng avAmSur3 = new LatLng(-8.11491597638144,-79.01514934489303);
        mMap.addMarker(new MarkerOptions().position(avAmSur3).title("Av America Sur con Av Eguren"));

        LatLng avAmSur4 = new LatLng(-8.119760272063829,-79.01926169038899);
        mMap.addMarker(new MarkerOptions().position(avAmSur4).title("Av America Sur - Av Gonzales Prada"));

        LatLng avAmSur5 = new LatLng(-8.124131334677287,-79.02392785327798);
        mMap.addMarker(new MarkerOptions().position(avAmSur5).title("Av America Sur Ovalo Grau"));

        LatLng avAmSur6 = new LatLng(-8.126076805166235,-79.02779812584062);
        mMap.addMarker(new MarkerOptions().position(avAmSur6).title("Av America Sur Trans. Linea"));

        LatLng avAmSur7 = new LatLng(-8.126653149411098,-79.03152027765636);
        mMap.addMarker(new MarkerOptions().position(avAmSur7).title("Av America Sur UPAO"));

        LatLng avAmSur8 = new LatLng(-8.125707766525721,-79.03545154843736);
        mMap.addMarker(new MarkerOptions().position(avAmSur8).title("Av America Sur Av. Husares"));

        LatLng avAmSur9 = new LatLng(-8.124696405527075,-79.03823721555386);
        mMap.addMarker(new MarkerOptions().position(avAmSur9).title("Av America Sur Ovalo Larco"));

        LatLng avLarco1 = new LatLng(-8.125563842645164,-79.03973311795149);
        mMap.addMarker(new MarkerOptions().position(avLarco1).title("Av Larco"));

        LatLng avLarco2 = new LatLng(-8.127531603606798,-79.04141623907873);
        mMap.addMarker(new MarkerOptions().position(avLarco2).title("Av Larco Av Fatima"));

        LatLng avLarco22 = new LatLng(-8.129541051929593,-79.04315349654783);
        mMap.addMarker(new MarkerOptions().position(avLarco22).title("Av Larco UCV"));

        LatLng avLarco3 = new LatLng(-8.13387382697421,-79.04677953079829);
        mMap.addMarker(new MarkerOptions().position(avLarco3).title("Av Larco Av Huaman"));

        LatLng avLarco4 = new LatLng(-8.137219856364439,-79.04966389857118);
        mMap.addMarker(new MarkerOptions().position(avLarco4).title("Av Larco Vista Alegre"));

        LatLng avLarco5 = new LatLng(-8.140563503939589,-79.05262340637904);
        mMap.addMarker(new MarkerOptions().position(avLarco5).title("Av Larco Av Panamericana Norte"));

        LatLng avLarco6 = new LatLng(-8.143764733440605,-79.05545701836603);
        mMap.addMarker(new MarkerOptions().position(avLarco6).title("Av Larco Balneario"));

        LatLng buenosAires = new LatLng(-8.138830881186081,-79.06141248826324);
        mMap.addMarker(new MarkerOptions().position(buenosAires).title("Calle Miguel Grau"));

        List<LatLng> path= new ArrayList();

        GeoApiContext context= new GeoApiContext.Builder()
                .apiKey(getString(R.string.google_maps_key))
                .build();
        DirectionsApiRequest request= DirectionsApi.getDirections(context,milagro.toString(), buenosAires.toString());
        try {
            DirectionsResult res = request.await();
            if (res.routes != null && res.routes.length > 0) {
                DirectionsRoute route = res.routes[0];

                if (route.legs !=null) {
                    for(int i=0; i<route.legs.length; i++) {
                        DirectionsLeg leg = route.legs[i];
                        if (leg.steps != null) {
                            for (int j=0; j<leg.steps.length;j++){
                                DirectionsStep step = leg.steps[j];
                                if (step.steps != null && step.steps.length >0) {
                                    for (int k=0; k<step.steps.length;k++){
                                        DirectionsStep step1 = step.steps[k];
                                        EncodedPolyline points1 = step1.polyline;
                                        if (points1 != null) {

                                            List<com.google.maps.model.LatLng> coords1 = points1.decodePath();
                                            for (com.google.maps.model.LatLng coord1 : coords1) {
                                                path.add(new LatLng(coord1.lat, coord1.lng));
                                            }
                                        }
                                    }
                                } else {
                                    EncodedPolyline points = step.polyline;
                                    if (points != null) {

                                        List<com.google.maps.model.LatLng> coords = points.decodePath();
                                        for (com.google.maps.model.LatLng coord : coords) {
                                            path.add(new LatLng(coord.lat, coord.lng));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch(Exception ex) {
            Log.e(TAG, ex.getLocalizedMessage());
        }
        if (path.size() > 0) {
            PolylineOptions opts = new PolylineOptions().addAll(path).color(Color.RED).width(5);
            mMap.addPolyline(opts);
        }

        mMap.getUiSettings().setZoomControlsEnabled(true);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(avAmSur4, 12));
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
