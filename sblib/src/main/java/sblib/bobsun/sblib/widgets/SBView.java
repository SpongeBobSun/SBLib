package sblib.bobsun.sblib.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by bobsun on 15-5-24.
 */
public class SBView extends View {

    public SBView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int measureWidthSpec,int measureHeightSpec){
        super.onMeasure(measureWidthSpec,measureHeightSpec);
        int measuredWidth = measureWidth(measureWidthSpec);
        int measuredHeight = measureHeight(measureHeightSpec);
        this.setMeasuredDimension(measuredWidth,measuredHeight);
    }

    private int measureWidth(int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        int result = 0;
        if (specMode == MeasureSpec.AT_MOST) {
            result = getWidth();
        } else if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        }
        return result;
    }
    private int measureHeight(int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        int result = 0;
        if (specMode == MeasureSpec.AT_MOST) {
            result = getWidth();
        } else if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        }
        return result;
    }

}
