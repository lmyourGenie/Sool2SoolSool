package com.example.sool2soolsool;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sool2soolsool.databinding.ActivityMainBinding;

public class MainActivity extends Activity {
    private ActivityMainBinding binding;

    private TextView textSoju;
    private TextView textTerra;

    private Button btnPlus;
    private Button btnMinus;

    private LinearLayout layoutSoju;
    private LinearLayout layoutTerra;

    private ImageView imageGreenLine;
    private ImageView imageYellowLine;

    int sojuCount, terraCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        textSoju = binding.textSoju;
        textTerra = binding.textTerra;

        btnPlus = binding.btnPlus;
        btnMinus = binding.btnMinus;

        layoutSoju = binding.layoutSoju;
        layoutTerra = binding.layoutTerra;
        imageGreenLine = binding.imageGreenLine;
        imageYellowLine = binding.imageYellowLine;

        textSoju.setText("00잔");
        textTerra.setText("00잔");

        layoutSoju.setOnClickListener(view -> {
            if (View.INVISIBLE == imageGreenLine.getVisibility()) {
                imageGreenLine.setVisibility(View.VISIBLE);
            } else {
                // do nothing
            }
        });

        layoutTerra.setOnClickListener(view -> {
            if (View.INVISIBLE == imageYellowLine.getVisibility()) {
                imageYellowLine.setVisibility(View.VISIBLE);
            } else {
                // do nothing
            }
        });

        btnPlus.setOnClickListener(view1 -> {
            if (View.VISIBLE == imageGreenLine.getVisibility()) {
                sojuCount += 1;
                setSojuText(sojuCount);
            }
            if (View.VISIBLE == imageYellowLine.getVisibility()) {
                terraCount += 1;
                setTerraText(terraCount);
            } else {
                // do nothing
            }
        });

        btnMinus.setOnClickListener(view1 -> {
            if (View.VISIBLE == imageGreenLine.getVisibility()) {
                if (0 != sojuCount) {
                    sojuCount -= 1;
                    setSojuText(sojuCount);
                } else {
                    imageGreenLine.setVisibility(View.INVISIBLE);
                }
            }
            if (View.VISIBLE == imageYellowLine.getVisibility()) {
                if (0 != terraCount) {
                    terraCount -= 1;
                    setTerraText(terraCount);
                } else {
                    imageYellowLine.setVisibility(View.INVISIBLE);
                }
            } else {
                // do nothing
            }
        });
    }

    void setSojuText(int cnt) {
        imageGreenLine.setVisibility(View.INVISIBLE);

        if (0 == cnt) {
            textSoju.setText("00잔");
        } else if (10 <= cnt) {
            textSoju.setText(cnt + "잔");
        } else {
            textSoju.setText("0" + cnt + "잔");
        }
    }

    void setTerraText(int cnt) {
        imageYellowLine.setVisibility(View.INVISIBLE);

        if (0 == cnt) {
            textTerra.setText("00잔");
        } else if (10 <= cnt) {
            textTerra.setText(cnt + "잔");
        } else {
            textTerra.setText("0" + cnt + "잔");
        }
    }
}