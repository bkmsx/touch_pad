package asia.trente.amoveimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by tien on 7/17/2017.
 */

public class ImageShow extends AppCompatImageView{

	private Matrix	matrix	= new Matrix();
	private Paint	paint	= new Paint();
	private float	x		= 0;
	private float	y		= 0;
	private Bitmap	bitmap;
	private int		width, height;
	private float[] centerPoint = new float[2];
	private float scale = 1f;
	private float saveScale = 1f;

	public ImageShow(Context context){
		super(context);
	}

	public ImageShow(Context context, @Nullable AttributeSet attrs){
		super(context, attrs);
		bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_scale);
		width = bitmap.getWidth();
		height = bitmap.getHeight();
	}

	public void move(float moveX, float moveY){
		x += moveX;
		y += moveY;
		invalidate();
	}

	public void scale(float scale) {
		this.scale = saveScale * scale;
		invalidate();
	}

	public void endScale() {
		saveScale = scale;
	}

	@Override
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		matrix.reset();
		centerPoint[0] = width / 2;
		centerPoint[1] = height / 2;

		matrix.setTranslate(x, y);

		matrix.mapPoints(centerPoint);

		matrix.postScale(scale, scale, centerPoint[0], centerPoint[1]);

		canvas.drawBitmap(bitmap, matrix, paint);
	}

	private void log(String msg) {
		Log.e("ImageShow", msg);
	}
}
