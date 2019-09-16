package com.acampdev.busstop;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;

import android.util.Log;
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


public class LineaCalifornia  extends Fragment implements OnMapReadyCallback {
    private String TAG = "so47492459";
    private GoogleMap mMap;
    LocationManager locationManager;
    private static final int LOCATION_REQUEST = 500;


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

        LatLng empCalifornia = new LatLng(-8.04843094543942,-79.05355531281018);
        mMap.addMarker(new MarkerOptions().position(empCalifornia).title("Emp. California"));

        LatLng esperanza = new LatLng(-8.04563428020198,-79.05207910624196);
        mMap.addMarker(new MarkerOptions().position(esperanza).title("La Esperanza El Triunfo"));

        LatLng esperanza1 = new LatLng(-8.045341944366129,-79.0508784581894);
        mMap.addMarker(new MarkerOptions().position(esperanza1).title("La Esperanza El Triunfo"));

        LatLng esperanza2 = new LatLng(-8.049941328574818,-79.04918680344042);
        mMap.addMarker(new MarkerOptions().position(esperanza2).title("La Esperanza El Triunfo"));

        LatLng esperanza3 = new LatLng(-8.052513842830322,-79.05611513293745);
        mMap.addMarker(new MarkerOptions().position(esperanza3).title("Av Panamericana"));

        LatLng esperanza4 = new LatLng(-8.073603186619579,-79.04851600561747);
        mMap.addMarker(new MarkerOptions().position(esperanza4).title("Av Tahuantinsuyo"));

        LatLng tupac = new LatLng(-8.087594040022253,-79.03993397124414);
        mMap.addMarker(new MarkerOptions().position(tupac).title("Av Tupac Amaru"));

        LatLng avAmNorte1 = new LatLng(-8.097627443301377,-79.02961866186554);
        mMap.addMarker(new MarkerOptions().position(avAmNorte1).title("Av America Norte"));

        LatLng avAmNorte2 = new LatLng(-8.093856477892885,-79.02518957422924);
        mMap.addMarker(new MarkerOptions().position(avAmNorte2).title("Av America Norte Hermelinda"));

        LatLng avAmNorte3 = new LatLng(-8.095707709234915,-79.01937332041308);
        mMap.addMarker(new MarkerOptions().position(avAmNorte3).title("Av America Norte Av Miraflores"));

        LatLng avAmNorte4 = new LatLng(-8.099371174794257,-79.0141672319247);
        mMap.addMarker(new MarkerOptions().position(avAmNorte4).title("Av America Norte Av Peru"));

        LatLng avAmSur1 = new LatLng(-8.102674110883115,-79.01110656376315);
        mMap.addMarker(new MarkerOptions().position(avAmSur1).title("Av America Sur Av Cesar Vallejo"));

        LatLng avAmSur2 = new LatLng(-8.106006248555374,-79.0108314864834);
        mMap.addMarker(new MarkerOptions().position(avAmSur2).title("Av America Sur "));

        LatLng avAmSur3 = new LatLng(-8.112419380547223,-79.01395120295393);
        mMap.addMarker(new MarkerOptions().position(avAmSur3).title("Av America Sur Av Ricardo Palma"));

        LatLng avAmSur4 = new LatLng(-8.11658539621149,-79.01653908393183);
        mMap.addMarker(new MarkerOptions().position(avAmSur4).title("Av America Sur Calle F. Zela"));

        LatLng incas1 = new LatLng(-8.113637948283326,-79.02049608114687);
        mMap.addMarker(new MarkerOptions().position(incas1).title("Av Los Incas"));

        LatLng incas2 = new LatLng(-8.116383535348561,-79.023169835445);
        mMap.addMarker(new MarkerOptions().position(incas2).title("Av Los Incas"));

        LatLng incas3 = new LatLng(-8.118858209309252,-79.02565381297343);
        mMap.addMarker(new MarkerOptions().position(incas3).title("Av Los Incas"));

        LatLng panama1 = new LatLng(-8.116574600941547,-79.02813616436089);
        mMap.addMarker(new MarkerOptions().position(panama1).title("Av Panama"));

        LatLng espn1 = new LatLng(-8.116374873599412,-79.02828378502178);
        mMap.addMarker(new MarkerOptions().position(espn1).title("Av España"));

        LatLng espn2 = new LatLng(-8.116452815991295,-79.0295926881778);
        mMap.addMarker(new MarkerOptions().position(espn2).title("Av España"));

        LatLng espn3 = new LatLng(-8.116452815991295,-79.0295926881778);
        mMap.addMarker(new MarkerOptions().position(espn3).title("Av España Bolivar"));

        LatLng espn4 = new LatLng(-8.11570796808499,-79.03115746713291);
        mMap.addMarker(new MarkerOptions().position(espn4).title("Av España Pizarro"));

        LatLng espn5 = new LatLng(-8.113769142836674,-79.03257954613495);
        mMap.addMarker(new MarkerOptions().position(espn5).title("Av España San Martin"));

        LatLng espn6 = new LatLng(-8.112024697107998,-79.03275177026704);
        mMap.addMarker(new MarkerOptions().position(espn6).title("Av España Club Libertad"));

        LatLng pjSanLuis = new LatLng(-8.111961368230226,-79.03311590120654);
        mMap.addMarker(new MarkerOptions().position(pjSanLuis).title("Psj. San Luis"));

        LatLng avJuanPablo1 = new LatLng(-8.11141089364169,-79.03350955629985);
        mMap.addMarker(new MarkerOptions().position(avJuanPablo1).title("Av Juan Pablo"));

        LatLng avJuanPablo2 = new LatLng(-8.113845942749876,-79.03560453872038);
        mMap.addMarker(new MarkerOptions().position(avJuanPablo2).title("Av Juan Pablo UNT"));

        LatLng avJuanPablo3 = new LatLng(-8.116857551540846,-79.03823343306318);
        mMap.addMarker(new MarkerOptions().position(avJuanPablo3).title("Av Juan Pablo UNT"));

        LatLng avJuanPablo4 = new LatLng(-8.119176074971662,-79.04022603573164);
        mMap.addMarker(new MarkerOptions().position(avJuanPablo4).title("Av Juan Pablo Ovalo Papal"));

        LatLng avAmOeste1 = new LatLng(-8.119444000006325,-79.04072302527733);
        mMap.addMarker(new MarkerOptions().position(avAmOeste1).title("Av America Oeste Ovalo Papal"));

        LatLng avAmSur5 = new LatLng(-8.120004206089021,-79.04031952882809);
        mMap.addMarker(new MarkerOptions().position(avAmSur5).title("Av America Sur Ovalo Papal"));

        LatLng avAmSur6 = new LatLng(-8.122050169934724,-79.03962079108308);
        mMap.addMarker(new MarkerOptions().position(avAmSur6).title("Av America Sur San Andres"));

        LatLng avAmSur7 = new LatLng(-8.124321662500947,-79.03894580774268);
        mMap.addMarker(new MarkerOptions().position(avAmSur7).title("Av America Sur Ovalo Larco"));

        LatLng avLarco1 = new LatLng(-8.125563842645164,-79.03973311795149);
        mMap.addMarker(new MarkerOptions().position(avLarco1).title("Av Larco"));

        LatLng avLarco2 = new LatLng(-8.127531603606798,-79.04141623907873);
        mMap.addMarker(new MarkerOptions().position(avLarco2).title("Av Larco Av Fatima"));

        LatLng avFatima1 = new LatLng(-8.128140511010542,-79.04076670817535);
        mMap.addMarker(new MarkerOptions().position(avFatima1).title("Av Fatima"));

        LatLng avFatima2 = new LatLng(-8.129527416330788,-79.03712063448633);
        mMap.addMarker(new MarkerOptions().position(avFatima2).title("Av Fatima Av Los Angeles"));

        LatLng avFatima3 = new LatLng(-8.131641528854203,-79.03377948694009);
        mMap.addMarker(new MarkerOptions().position(avFatima3).title("Av Fatima Av Pro. Vallejo"));

        LatLng avProv1 = new LatLng(-8.132094551170113,-79.03405996613945);
        mMap.addMarker(new MarkerOptions().position(avProv1).title("Pro. Vallejo"));

        LatLng avProv2 = new LatLng(-8.135001626614141,-79.036623527228);
        mMap.addMarker(new MarkerOptions().position(avProv2).title("Pro. Vallejo - Av El Golf"));

        LatLng avHuman1 = new LatLng(-8.137360254365007,-79.03831107399833);
        mMap.addMarker(new MarkerOptions().position(avHuman1).title("Av. Huaman"));

        LatLng avHuman2 = new LatLng(-8.135723545708117,-79.04299556957069);
        mMap.addMarker(new MarkerOptions().position(avHuman2).title("Av. Huaman"));

        LatLng avSeoane1 = new LatLng(-8.136614967734985,-79.04340890741047);
        mMap.addMarker(new MarkerOptions().position(avSeoane1).title("Av Seoane"));

        LatLng avSeoane2 = new LatLng(-8.13916520072911,-79.04558988623734);
        mMap.addMarker(new MarkerOptions().position(avSeoane2).title("Av Seoane "));

        LatLng avSeoane3 = new LatLng(-8.142985271137448,-79.04887218592529);
        mMap.addMarker(new MarkerOptions().position(avSeoane3).title("Av Seoane Fin Paradero"));

        List<LatLng> path= new ArrayList();

        GeoApiContext context= new GeoApiContext.Builder()
                .apiKey(getString(R.string.google_maps_key))
                .build();
        DirectionsApiRequest request= DirectionsApi.getDirections(context,empCalifornia.toString(), avSeoane3.toString());
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
