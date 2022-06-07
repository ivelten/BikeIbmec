package com.example.bikeibmec.ui.pedaladas;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.bikeibmec.R;
import com.example.bikeibmec.databinding.FragmentPedaladasBinding;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PedaladasFragment extends Fragment implements OnMapReadyCallback {

    private FragmentPedaladasBinding binding;
    private GoogleMap googleMap;
    private MapView mapView;
    private PedaladasViewModel pedaladasViewModel;
    private Marker currentStartMarker;
    private Marker currentEndMarker;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        pedaladasViewModel = new ViewModelProvider(this).get(PedaladasViewModel.class);

        binding = FragmentPedaladasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mapView = binding.mapView;

        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(this);

        return root;
    }

    void setPedaladas() {
        Bundle bundle = this.getArguments();

        PedaladasModel model;

        if (bundle == null) {
            List<PedaladaModel> pedaladas = new ArrayList<PedaladaModel>();
            Random random = new Random();

            double startLat = -22.950857855820743;
            double startLon = -43.18409697374796;

            double endLat = -22.934175183472234;
            double endLon = -43.17798824716919;

            for (int day = -5; day <= 0; day++) {
                Calendar start = Calendar.getInstance();

                start.add(Calendar.HOUR, day * 24);
                start.add(Calendar.MINUTE, random.nextInt(10));

                Calendar end = Calendar.getInstance();

                end.add(Calendar.HOUR, day * 24);
                end.add(Calendar.MINUTE, random.nextInt(120) + 50);

                pedaladas.add(new PedaladaModel(
                        startLat + day * 0.005,
                        startLon + day * 0.005,
                        endLat + day * 0.003,
                        endLon + day * 0.003,
                        start.getTime(),
                        end.getTime()));
            }

            Calendar now = Calendar.getInstance();

            model = new PedaladasModel(pedaladas);
        } else {
            model = (PedaladasModel)bundle.get("pedaladas");
        }

        ArrayAdapter<PedaladaModel> adapter = new ArrayAdapter<PedaladaModel>(
                this.getActivity(),
                android.R.layout.simple_list_item_1,
                model.getPedaladas());

        binding.listView.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        setPedaladas();

        binding.listView.setClickable(true);
        binding.listView.setOnItemClickListener((adapterView, view, i, l) -> {
            PedaladaModel pedaladaModel = (PedaladaModel)binding.listView.getItemAtPosition(i);

            LatLng start = new LatLng(pedaladaModel.getStartLat(), pedaladaModel.getStartLon());
            LatLng end = new LatLng(pedaladaModel.getEndLat(), pedaladaModel.getEndLon());

            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            builder.include(start);
            builder.include(end);
            LatLngBounds bounds = builder.build();

            if (currentStartMarker != null) {
                currentStartMarker.remove();
            }

            if (currentEndMarker != null) {
                currentEndMarker.remove();
            }

            currentStartMarker = googleMap.addMarker(new MarkerOptions().position(start).title("Início"));
            currentEndMarker = googleMap.addMarker(new MarkerOptions().position(end).title("Fim"));

            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, 200);
            googleMap.animateCamera(cameraUpdate);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}