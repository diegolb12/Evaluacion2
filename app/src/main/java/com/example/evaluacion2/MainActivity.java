package com.example.evaluacion2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private final Map<Integer, Fragment> fragmentMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentMap.put(R.id.navigation_home, new HomeFragment());
        fragmentMap.put(R.id.navigation_map, new MapFragment());

        // Cargar el fragmento inicial (pantalla principal)
        loadFragment(fragmentMap.get(R.id.navigation_home));

        // Configurar la barra de navegación inferior
        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = fragmentMap.get(item.getItemId());
            return loadFragment(selectedFragment);
        });
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}