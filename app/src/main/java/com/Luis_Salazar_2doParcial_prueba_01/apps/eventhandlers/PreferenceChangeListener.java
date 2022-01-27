package com.Luis_Salazar_2doParcial_prueba_01.apps.eventhandlers;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.widget.Toast;

import com.Luis_Salazar_2doParcial_prueba_01.apps.Luis_Salazar_2doParcial_02_prueba.MainActivity_LOSR;
import com.Luis_Salazar_2doParcial_prueba_01.apps.Luis_Salazar_2doParcial_02_prueba.R;

import java.util.Set;

public class PreferenceChangeListener implements OnSharedPreferenceChangeListener {
    private MainActivity_LOSR mainActivityLOSR;

    public PreferenceChangeListener(MainActivity_LOSR mainActivityLOSR) {
        this.mainActivityLOSR = mainActivityLOSR;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        this.mainActivityLOSR.setPreferencesChanged(true);

        if (key.equals(this.mainActivityLOSR.getREGIONS())) {
            this.mainActivityLOSR.getQuizViewModel().setGuessRows(sharedPreferences.getString(
                    MainActivity_LOSR.CHOICES, null));
            this.mainActivityLOSR.getQuizFragment().resetQuiz();
        } else if (key.equals(this.mainActivityLOSR.getCHOICES())) {
            Set<String> regions = sharedPreferences.getStringSet(this.mainActivityLOSR.getREGIONS(),
                    null);
            if (regions != null && regions.size() > 0) {
                this.mainActivityLOSR.getQuizViewModel().setRegionsSet(regions);
                this.mainActivityLOSR.getQuizFragment().resetQuiz();
            } else {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                regions.add(this.mainActivityLOSR.getString(R.string.default_region));
                editor.putStringSet(this.mainActivityLOSR.getREGIONS(), regions);
                editor.apply();
                Toast.makeText(this.mainActivityLOSR, R.string.default_region_message,
                        Toast.LENGTH_LONG).show();
            }
        }

        Toast.makeText(this.mainActivityLOSR, R.string.restarting_quiz,
                Toast.LENGTH_SHORT).show();
    }
}
