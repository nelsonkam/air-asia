package io.airasia;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by nelson on 3/16/17.
 */

public class HighlightView extends View {
    private RectF rectF;
    private Rect rect;
    private Paint paint;

    public HighlightView(Context context, Rect rect) {
        super(context);
        this.rect = rect;
        init();
    }

    private void init() {
        rectF = new RectF();
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        rectF.set(this.rect);

        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(4);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRoundRect(rectF, 8, 8, paint);
    }
}
