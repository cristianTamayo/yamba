package co.edu.udea.cmovil.gr3.yamba;

import android.app.Activity;
import android.os.Bundle;

public class SettingsActivity extends SubActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {

            // Creando un fragment
            SettingsFragment fragment = new SettingsFragment(); //
            getFragmentManager()
                    .beginTransaction()
                    .add(android.R.id.content, fragment,
                            fragment.getClass().getSimpleName())
                    .commit(); //
        }
    };
}
