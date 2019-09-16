package com.acampdev.busstop;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.DirectionsStep;
import com.google.maps.model.EncodedPolyline;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class LineaHuanchaco extends Fragment implements OnMapReadyCallback{
//, TaskLoadedCallback
    private GoogleMap mMap;
    private static final int LOCATION_REQUEST = 500;
    LocationManager locationManager;
    private String TAG = "so47492459";

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

        LatLng avRivera = new LatLng(-8.073401828747961,-79.11935087054981);
        mMap.addMarker(new MarkerOptions().position(avRivera).title("Av Rivera Huanchaco"));

        LatLng avCircunvalacion1 = new LatLng(-8.073575120950963,-79.1181072679733);
        mMap.addMarker(new MarkerOptions().position(avCircunvalacion1).title("Av Circunvalación Huanchaco"));

        LatLng avCircunvalacion2 = new LatLng(-8.074618534962951,-79.11765240484512);
        mMap.addMarker(new MarkerOptions().position(avCircunvalacion2).title("Av Circunvalación Huanchaco"));

        LatLng avCircunvalacion3 = new LatLng(-8.076140474208316,-79.11760395695995);
        mMap.addMarker(new MarkerOptions().position(avCircunvalacion3).title("Av Circunvalación Huanchaco"));

        LatLng avCircunvalacion4 = new LatLng(-8.077403051016162,-79.1178839655573);
        mMap.addMarker(new MarkerOptions().position(avCircunvalacion4).title("Av Circunvalación Huanchaco"));

        LatLng avDean1 = new LatLng(-8.07858605983239,-79.11805494939323);
        mMap.addMarker(new MarkerOptions().position(avDean1).title("Av Dean Saavedra Huanchaco"));

        LatLng avDean2 = new LatLng(-8.080282145860394,-79.1187005765701);
        mMap.addMarker(new MarkerOptions().position(avDean2).title("Av Dean Saavedra Huanchaco"));

        LatLng avDean3 = new LatLng(-8.081381263486236,-79.11902123578473);
        mMap.addMarker(new MarkerOptions().position(avDean3).title("Av Dean Saavedra Huanchaco"));

        LatLng avDean4 = new LatLng(-8.08275857328428,-79.11931859155148);
        mMap.addMarker(new MarkerOptions().position(avDean4).title("Av Dean Saavedra Huanchaco"));

        LatLng caLosPinos1 = new LatLng(-8.082284926615358,-79.12104891395946);
        mMap.addMarker(new MarkerOptions().position(caLosPinos1).title("Calle Los Pinos"));

        LatLng caLosPinos2 = new LatLng(-8.081847278934234,-79.12279425727466);
        mMap.addMarker(new MarkerOptions().position(caLosPinos2).title("Calle Los Pinos"));

        LatLng avRivera1 = new LatLng(-8.082828141285347,-79.12317181835574);
        mMap.addMarker(new MarkerOptions().position(avRivera1).title("Av Rivera Huanchaco"));

        LatLng avRivera2 = new LatLng(-8.084600878751232,-79.12297449417099);
        mMap.addMarker(new MarkerOptions().position(avRivera2).title("Av Rivera Huanchaco"));

        LatLng avRivera3 = new LatLng(-8.08603159195549,-79.12202487874703);
        mMap.addMarker(new MarkerOptions().position(avRivera3).title("Av Rivera Huanchaco"));

        LatLng avRivera4 = new LatLng(-8.08719867561193,-79.12108026981663);
        mMap.addMarker(new MarkerOptions().position(avRivera4).title("Av Rivera Huanchaco"));

        LatLng avRivera5 = new LatLng(-8.088525322107728,-79.11999575973849);
        mMap.addMarker(new MarkerOptions().position(avRivera5).title("Av Rivera Huanchaco"));

        LatLng avRivera6 = new LatLng(-8.096727703495716,-79.11337514106685);
        mMap.addMarker(new MarkerOptions().position(avRivera6).title("Av Rivera Huanchaco"));

        LatLng avRivera7 = new LatLng(-8.096472416265698,-79.10860243019981);
        mMap.addMarker(new MarkerOptions().position(avRivera7).title("Av Rivera Huanchaco"));

        LatLng avRivera8 = new LatLng(-8.086747831841421,-79.09874743792692);
        mMap.addMarker(new MarkerOptions().position(avRivera8).title("Av Rivera Huanchaco"));

        LatLng avRivera9 = new LatLng(-8.087348417288567,-79.09705952372266);
        mMap.addMarker(new MarkerOptions().position(avRivera9).title("Av Rivera Huanchaco"));

        LatLng carreteraH1 = new LatLng(-8.087730797680067,-79.09620243650984);
        mMap.addMarker(new MarkerOptions().position(carreteraH1).title("Ovalo Huanachaco"));

        LatLng carreteraH2 = new LatLng(-8.089195897085915,-79.09082257681646);
        mMap.addMarker(new MarkerOptions().position(carreteraH2).title("carretera Huanachaco"));

        LatLng carreteraH3 = new LatLng(-8.090777679422004,-79.08594001202367);
        mMap.addMarker(new MarkerOptions().position(carreteraH3).title("carretera Huanachaco"));

        LatLng carreteraH4 = new LatLng(-8.092468804972029,-79.08019602756302);
        mMap.addMarker(new MarkerOptions().position(carreteraH4).title("carretera Huanachaco"));

        LatLng carreteraH5 = new LatLng(-8.093788515170004,-79.0736995283264);
        mMap.addMarker(new MarkerOptions().position(carreteraH5).title("carretera Huanachaco"));

        LatLng carreteraH6 = new LatLng(-8.09858857114915,-79.06822417941908);
        mMap.addMarker(new MarkerOptions().position(carreteraH6).title("carretera Huanachaco"));

        LatLng carreteraH7 = new LatLng(-8.10058469582195,-79.06102748933348);
        mMap.addMarker(new MarkerOptions().position(carreteraH7).title("carretera Huanachaco"));

        LatLng avMan01 = new LatLng(-8.101078885657017,-79.05564294127943);
        mMap.addMarker(new MarkerOptions().position(avMan01).title("Av. Mansiche"));

        LatLng avMan02 = new LatLng(-8.100944754179636,-79.0492925265874);
        mMap.addMarker(new MarkerOptions().position(avMan02).title("Av. Mansiche MAll Plaza"));

        LatLng avMan03 = new LatLng(-8.10153063322781,-79.04434126979565);
        mMap.addMarker(new MarkerOptions().position(avMan03).title("Av. Mansiche Av. America Oeste"));

        LatLng avMan04 = new LatLng(-8.102847355387055,-79.03917711797206);
        mMap.addMarker(new MarkerOptions().position(avMan04).title("Av. Mansiche "));

        LatLng avMan05 = new LatLng(-8.104869323434812,-79.03566998832626);
        mMap.addMarker(new MarkerOptions().position(avMan05).title("Av. Mansiche Hosp. Regional"));

        LatLng ovalo1 = new LatLng(-8.10593186592925,-79.03610796792506);
        mMap.addMarker(new MarkerOptions().position(ovalo1).title("Av. Mansiche Hosp. Regional"));

        LatLng ovalo2 = new LatLng(-8.106667808355198,-79.03481635807167);
        mMap.addMarker(new MarkerOptions().position(ovalo2).title("Av. Mansiche Fac. Medicina"));

        LatLng ovalo3 = new LatLng(-8.105655812429859,-79.03430929917502);
        mMap.addMarker(new MarkerOptions().position(ovalo3).title("Av. Mansiche Volvo"));

        LatLng avAmericaNorte1= new LatLng(-8.103137051734379,-79.03299192009801);
        mMap.addMarker(new MarkerOptions().position(avAmericaNorte1).title("Av. América Norte Av. Vera Enrique"));

        LatLng avAmericaNorte2= new LatLng(-8.100304894123227,-79.03154612365225);
        mMap.addMarker(new MarkerOptions().position(avAmericaNorte2).title("Av. América Norte Av. Valderrama"));

        LatLng avAmericaNorte3= new LatLng(-8.097655516584268,-79.02967512479634);
        mMap.addMarker(new MarkerOptions().position(avAmericaNorte3).title("Av. América Norte Av. Tupac Amaru"));

        LatLng avAmericaNorte4= new LatLng(-8.095278682179242,-79.0274449697721);
        mMap.addMarker(new MarkerOptions().position(avAmericaNorte4).title("Av. América Norte Av. Uceda Mesa"));

        LatLng avAmNorte2 = new LatLng(-8.093856477892885,-79.02518957422924);
        mMap.addMarker(new MarkerOptions().position(avAmNorte2).title("Av America Norte Hermelinda"));

        LatLng avAmNorte3 = new LatLng(-8.095707709234915,-79.01937332041308);
        mMap.addMarker(new MarkerOptions().position(avAmNorte3).title("Av America Norte Av Miraflores"));

        LatLng avAmNorte4 = new LatLng(-8.099371174794257,-79.0141672319247);
        mMap.addMarker(new MarkerOptions().position(avAmNorte4).title("Av America Norte Av Peru"));

        LatLng avAmSur1 = new LatLng(-8.102674110883115,-79.01110656376315);
        mMap.addMarker(new MarkerOptions().position(avAmSur1).title("Av America Sur Av Cesar Vallejo"));

        LatLng avAmSur2 = new LatLng(-8.103267701824393,-79.01099247295235);
        mMap.addMarker(new MarkerOptions().position(avAmSur2).title("Av America Sur La Noria"));

        LatLng avBlas1 = new LatLng(-8.103558291074677,-79.01007407322751);
        mMap.addMarker(new MarkerOptions().position(avBlas1).title("Av Blas PAscal"));

        LatLng avBlas2 = new LatLng(-8.104653679269646,-79.00781705333091);
        mMap.addMarker(new MarkerOptions().position(avBlas2).title("Av Blas PAscal Parque Los Filosofos"));

        LatLng avBlas3 = new LatLng(-8.105284152537408,-79.00652831575972);
        mMap.addMarker(new MarkerOptions().position(avBlas3).title("Av Blas PAscal Av. R. Sanzio"));

        List<LatLng> path= new ArrayList();

        GeoApiContext context= new GeoApiContext.Builder()
                .apiKey(getString(R.string.google_maps_key))
                .build();
        DirectionsApiRequest request= DirectionsApi.getDirections(context,avRivera.toString(), avBlas3.toString());
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

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ovalo3, 12));
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
