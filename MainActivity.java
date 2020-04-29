package com.example.maps5;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.JointType;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RoundCap;
import static com.example.maps5.R.id.map;


public class MainActivity extends AppCompatActivity
        implements OnMapReadyCallback
       {

    private static final int warna_garis = 0xff000000;
    private static final int px_garis = 12;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        GoogleMap mMap = googleMap;

        LatLng Surabaya = new LatLng(-7.260471, 112.746190);
        mMap.addMarker(new MarkerOptions().position(Surabaya).title("Current Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Surabaya));

        LatLng SMP1Sby = new LatLng(-7.257279, 112.747671);
        mMap.addMarker(new MarkerOptions().position(SMP1Sby).title("SMP 1 Surabaya"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SMP1Sby));

        Polyline polyline1 = googleMap.addPolyline(new PolylineOptions()
                .clickable(true)
                .add(
                        new LatLng(-7.260471, 112.746190),
                        new LatLng(-7.260412, 112.745888),
                        new LatLng(-7.258767, 112.746322),
                        new LatLng(-7.255835, 112.746852),
                        new LatLng(-7.255845, 112.746994),
                        new LatLng(-7.255954, 112.748741),
                        new LatLng(-7.257093, 112.748942),
                        new LatLng(-7.257033, 112.747795)));
        stylePolyline(polyline1);
    }

    private void stylePolyline(Polyline polyline) {
        polyline.setStartCap(new RoundCap());
        polyline.setEndCap(new RoundCap());
        polyline.setWidth(px_garis);
        polyline.setColor(warna_garis);
        polyline.setJointType(JointType.ROUND);
    }

}
