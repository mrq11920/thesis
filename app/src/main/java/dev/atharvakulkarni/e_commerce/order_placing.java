package dev.atharvakulkarni.e_commerce;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class order_placing extends AppCompatActivity
{
    SeekBar seekBar;
    Button deliver_here,continue_button;
    LinearLayout address,order_summary,payment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_placing);

        getWindow().setStatusBarColor(getResources().getColor(R.color.white,getTheme()));

        seekBar = (SeekBar)findViewById(R.id.seekbar);
        deliver_here = findViewById(R.id.deliver_here);
        continue_button = findViewById(R.id.continue_button);
        address  = findViewById(R.id.address);
        order_summary = findViewById(R.id.order_summary);
        payment = findViewById(R.id.payment);

        seekBar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.green2,getTheme()), PorterDuff.Mode.SRC_ATOP);
        seekBar.getThumb().setColorFilter(getResources().getColor(R.color.green2,getTheme()), PorterDuff.Mode.SRC_ATOP);

        seekBar.setProgress(10);

        deliver_here.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                address.setVisibility(View.GONE);
                order_summary.setVisibility(View.VISIBLE);

                seekBar.setProgress(48);
            }
        });

        continue_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                order_summary.setVisibility(View.GONE);
                payment.setVisibility(View.VISIBLE);

                seekBar.setProgress(48);
            }
        });

        seekBar.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return true;
            }
        });

        /*
        order_placing.sliderListener sldListener = new order_placing.sliderListener();
        seekBar.setOnSeekBarChangeListener(sldListener);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            int stepSize = 3;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b)
            {
                // progress = ((int)Math.round(progress/stepSize))*stepSize;
                seekBar.setProgress(progress);

                Toast.makeText(order_placing.this, progress+"", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });*/
    }

    /*private class sliderListener implements SeekBar.OnSeekBarChangeListener
    {
        private int smoothnessFactor = 10;
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
        {
            progress = Math.round(progress / smoothnessFactor);
            TextView lblProgress = (TextView) findViewById(R.id.seekbar);
            lblProgress.setText(String.valueOf(progress));
        }

        public void onStartTrackingTouch(SeekBar seekBar)
        {
        }

        public void onStopTrackingTouch(SeekBar seekBar)
        {
            seekBar.setProgress(Math.round((seekBar.getProgress() + (smoothnessFactor / 2)) / smoothnessFactor) * smoothnessFactor);
        }
    }*/
}