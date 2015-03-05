package geowear.de.geowear;


import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class CacheDetailView extends Activity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor rotationSensor;

    private CompassView compassView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        rotationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.cache_detail_view);
        compassView = (CompassView) findViewById(R.id.compass_view);

        TextView descriptionTextView = (TextView) findViewById(R.id.cache_detail_description);
        TextView nameTextView = (TextView) findViewById(R.id.cache_detail_description);

        descriptionTextView.setText(getIntent().getStringExtra("description"));
        nameTextView.setText(getIntent().getStringExtra("name"));

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, rotationSensor, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float zRotation = event.values[2];
        float goalValue = 0.0f;
        Log.d("Sensor", zRotation + "");
        if (compassView != null) {

            float angle = (-zRotation) * (float) Math.PI;
            int x = (int) (Math.sin(angle) * 140.0) + 160;
            int y = (int) (Math.cos(angle) * 140.0) + 160;

            compassView.setX(x);
            compassView.setY(y);
        }

    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
