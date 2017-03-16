package io.airasia.utils;

import android.app.Activity;
import android.graphics.Rect;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;

import io.airasia.HighlightView;

/**
 * Created by nelson on 3/15/17.
 */

public class HighlightUtil {
    public static void highlight(Activity activity, final View view) {
        Rect rect = new Rect();
        Rect offsetViewBounds = new Rect();
        view.getDrawingRect(offsetViewBounds);
        ViewGroup parentViewGroup = ((ViewGroup) activity.getWindow().getDecorView());
        parentViewGroup.offsetDescendantRectToMyCoords(view, offsetViewBounds);

        int relativeTop = offsetViewBounds.top;
        int relativeLeft = offsetViewBounds.left;
        rect.set(relativeLeft, relativeTop, relativeLeft + view.getWidth(), relativeTop + view.getHeight());
        final HighlightView highlightView = new HighlightView(activity, rect);
        parentViewGroup.addView(highlightView);
        new CountDownTimer(1500, 1500) {

            @Override
            public void onTick(long l) {
            }

            @Override
            public void onFinish() {
                highlightView.setVisibility(View.GONE);
            }
        }.start();
    }
}
