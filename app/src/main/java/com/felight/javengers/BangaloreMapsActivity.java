package com.felight.javengers;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Color;
import android.graphics.Point;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toast;
import android.Manifest;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.vision.CameraSource;

import java.util.ArrayList;

public class BangaloreMapsActivity extends FragmentActivity implements GoogleMap.InfoWindowAdapter,GoogleMap.OnMarkerDragListener, ActivityCompat.OnRequestPermissionsResultCallback, OnMapReadyCallback,  GoogleMap.OnMapClickListener,GoogleMap.OnMapLongClickListener {

    private GoogleMap mMap;
    private static final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION=2;
    private static final LatLng SYDNEY = new LatLng(-33.88,151.21);
    private static final LatLng MOUNTAIN_VIEW = new LatLng(37.4, -122.1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangalore_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
       /* if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {



                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.

        }*/

    }
   /* @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (permissions.length == 1 && permissions[0] == Manifest.permission.ACCESS_FINE_LOCATION
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    mMap.setMyLocationEnabled(true);


                }

            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

   @Override
    public void onCameraChange(CameraPosition cameraPosition) {
        Toast.makeText(getBaseContext(),""+cameraPosition.toString(), Toast.LENGTH_LONG).show();
    }*/

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {

    }

    @Override
    public void onMapClick(LatLng latLng) {
        Toast.makeText(getBaseContext(), ""+latLng, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        Toast.makeText(getBaseContext(), ""+latLng, Toast.LENGTH_LONG).show();

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
       /* Uri data = Uri.parse("geo:0,0?q= 13.0109, 77.5550(Orion+mall)&z=16");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, data);
        mapIntent.setPackage("com.google.android.apps.maps");
        if(mapIntent.resolveActivity(getPackageManager())!= null) {
            startActivity(mapIntent)
        }*/
       /* Uri data = Uri.parse("google.navigation:q=13.0109, 77.5550 &mode=d");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW,data);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);*/


        /*LatLng target = new LatLng(13.0109, 77.5550);
        // Add a marker in Bangalore and move the camera
        MarkerOptions myMarker = new MarkerOptions();
                myMarker.draggable(true)
                .position(target)
                .snippet("Population: 2000")
                .title("Orion Mall")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));

        mMap.addMarker(myMarker).showInfoWindow();
        mMap.setOnMarkerDragListener(this);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(target, 15f));*/
        //polyline/polygon demo

       /* ArrayList<LatLng> holes = new ArrayList<>();
        holes.add(new LatLng(37.36, -122.0));
        holes.add(new LatLng(37.44, -122.0));
        holes.add(new LatLng(37.44, -122.1));
        holes.add(new LatLng(37.36, -122.1));
        holes.add(new LatLng(37.36, -122.0));


        PolygonOptions polygonOptions = new PolygonOptions()
                .add(new LatLng(37.35, -122.0))
                .add(new LatLng(37.45, -122.0))
                .add(new LatLng(37.45, -122.2))
                .add(new LatLng(37.35, -122.2))
                .addHole(holes)
                .fillColor(Color.CYAN)
                .strokeColor(Color.GREEN)
                .strokeWidth(2f);


       mMap.addPolygon(polygonOptions);
       mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.45, -122.0),11f));*/

        //Circle demo

        CircleOptions circleOptions = new CircleOptions()
                .center(new LatLng(37.35, -122.0))
                .radius(1000)
                .strokeWidth(3f)
                .strokeColor(Color.GREEN)
                .fillColor(Color.CYAN)
                .clickable(true)
                .zIndex(10);
        Circle circle= mMap.addCircle(circleOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.35, -122.0),11f));
        circle.setVisible(true);



       // mMap.moveCamera(CameraUpdateFactory.zoomTo(13f));
        //mMap.moveCamera(CameraUpdateFactory.zoomBy(4));
        //mMap.setOnMapClickListener(this);
        //mMap.setOnMapLongClickListener(this);
        //mMap.setOnCameraChangeListener(this);
        // disabling zoom, camera tilt, rotate and scroll gestures
        // disabling zoom gesture means user would be able to zoom in and out but wouldn't be able to use double tap, double tap with two fingers etc
       /* mMap.getUiSettings().setZoomGesturesEnabled(false);
        mMap.getUiSettings().setTiltGesturesEnabled(false);
        mMap.getUiSettings().setRotateGesturesEnabled(false);
        mMap.getUiSettings().setScrollGesturesEnabled(false);*/


        //Latlng Bounds
        //LatLngBounds India = new LatLngBounds(new LatLng(8.0883,74.8577), new LatLng(32.7218, 77.5385));
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(India.getCenter(), 5));

        //Animating Camera
        /*mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SYDNEY, 10));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15),3000,null);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(MOUNTAIN_VIEW).zoom(15f).bearing(90).tilt(30).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));*/
    }
}
