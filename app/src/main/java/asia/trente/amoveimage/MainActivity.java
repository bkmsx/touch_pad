package asia.trente.amoveimage;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import asia.trente.amoveimage.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements TouchPad.OnTouchPadListener{
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.touchPad.setCallback(this);
    }

    @Override
    public void onTouchMove(float moveX, float moveY) {
        binding.imageShow.move(moveX, moveY);
    }

    @Override
    public void onTouchScale(float scale) {
        binding.imageShow.scale(scale);
    }

    @Override
    public void onTouchScaleEnd() {
        binding.imageShow.endScale();
    }

    @Override
    public void onTouchPadClick() {
        log("click");
    }

    private void log(String msg) {
        Log.e("MainActivity", msg);
    }
}
