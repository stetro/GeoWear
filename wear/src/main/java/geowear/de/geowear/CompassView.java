package geowear.de.geowear;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CompassView extends View {
    private Paint paint;
    private int y;
    private int x;

    public CompassView(Context context) {
        super(context);
        init();
    }

    public CompassView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);
        canvas.drawCircle(x, y, 10, paint);
    }

    public void setX(int x) {
        this.x = x;
        this.invalidate();
    }

    public void setY(int y) {
        this.y = y;
        this.invalidate();
    }
}
