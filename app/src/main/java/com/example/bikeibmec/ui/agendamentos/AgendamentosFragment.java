package com.example.bikeibmec.ui.agendamentos;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bikeibmec.R;

import com.example.bikeibmec.databinding.FragmentAgendamentosBinding;
import com.example.bikeibmec.ui.pedaladas.PedaladaModel;
import com.example.bikeibmec.ui.pedaladas.PedaladasModel;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class AgendamentosFragment extends Fragment implements OnMapReadyCallback {

    private FragmentAgendamentosBinding binding;
    private AgendamentosViewModel agendamentosViewModel;
    private MapView mapView;
    private Marker currentStartMarker;
    private Marker currentEndMarker;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        agendamentosViewModel = new ViewModelProvider(this).get(AgendamentosViewModel.class);

        binding = FragmentAgendamentosBinding.inflate(inflater, container, false);

        mapView = binding.agendamentosMapView;

        View root = binding.getRoot();

        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(this);

        return root;
    }

    void setAgendamentos() {
        Bundle bundle = this.getArguments();

        AgendamentosModel model;

        if (bundle == null) {
            List<AgendamentoModel> agendamentos = new ArrayList<>();
            Random random = new Random();

            double startLat = -22.950857855820743;
            double startLon = -43.18409697374796;

            double endLat = -22.934175183472234;
            double endLon = -43.17798824716919;

            for (int day = 0; day <= 5; day++) {
                Calendar start = Calendar.getInstance();

                start.add(Calendar.HOUR, day * 24);
                start.add(Calendar.MINUTE, random.nextInt(10));

                agendamentos.add(new AgendamentoModel(
                        start.getTime(),
                        2,
                        new LatLng(startLat - day * 0.003, startLon - day * 0.003),
                        new LatLng(endLat + -day * 0.003, endLon - day * 0.003)));
            }

            model = new AgendamentosModel(agendamentos);
        } else {
            model = (AgendamentosModel)bundle.get("agendamentos");
        }

        ArrayAdapter<AgendamentoModel> adapter = new ArrayAdapter<>(
                this.getActivity(),
                android.R.layout.simple_list_item_1,
                model.getAgendamentos());

        binding.agendamentosListView.setAdapter(adapter);
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
        setAgendamentos();

        binding.agendamentosListView.setClickable(true);
        binding.agendamentosListView.setOnItemClickListener((adapterView, view, i, l) -> {
            AgendamentoModel agendamentoModel = (AgendamentoModel) binding.agendamentosListView.getItemAtPosition(i);

            LatLng start = agendamentoModel.getLocalRetirada();
            LatLng end = agendamentoModel.getLocalEntrega();

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