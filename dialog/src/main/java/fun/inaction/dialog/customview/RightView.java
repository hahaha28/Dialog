package fun.inaction.dialog.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class RightView extends View {

    /**
     * 画笔颜色
     */
    private int paintColor = 0xff2186FA;
    /**
     * 画笔宽度
     */
    private float strokeWidth = 5;

    /**
     * 画笔
     */
    private Paint paint;

    public RightView(Context context) {
        this(context,null);
    }

    public RightView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RightView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    /**
     * 画笔初始化
     */
    private void initPaint(){
        paint = new Paint();
        paint.setColor(paintColor);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(strokeWidth);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setAntiAlias(true);
    }

    /**
     * 设置画笔颜色
     * @param color 画笔颜色
     */
    public void setColor(int color){
        this.paintColor = color;
        paint.setColor(paintColor);
        invalidate();
    }

    /**
     * 设置画笔宽度
     * @param strokeWidth 画笔宽度
     */
    public void setStrokeWidth(float strokeWidth){
        this.strokeWidth = strokeWidth;
        paint.setStrokeWidth(strokeWidth);
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //宽高相同
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float width = getMeasuredWidth();
        canvas.drawLine(0.1f*width,width/2*1.2f,width*0.4f,width*0.9f,paint);
        canvas.drawLine(width*0.4f,width*0.9f,width*0.9f,width*0.1f,paint);
    }
}
