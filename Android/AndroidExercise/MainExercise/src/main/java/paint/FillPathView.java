package paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 实际 Path」。
 * 所谓实际 Path ，指的就是 drawPath() 的绘制内容的轮廓，要算上线条宽度和设置的 PathEffect。
 */
public class FillPathView extends View {

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint pathPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path path = new Path();
    private Path path1 = new Path();
    private Path path2 = new Path();
    private Path path3 = new Path();

    public FillPathView(Context context) {
        super(context);
    }

    public FillPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FillPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        path.moveTo(50, 100);
        path.rLineTo(50, 100);
        path.rLineTo(80, -150);
        path.rLineTo(100, 100);
        path.rLineTo(70, -120);
        path.rLineTo(150, 80);

        pathPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.getFillPath() 获取实际绘制的 Path

        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(0);
        // 第一处：获取 Path
        canvas.drawPath(path, paint);

        canvas.save();
        canvas.translate(500, 0);
        paint.getFillPath(path, path1);
        canvas.drawPath(path1, pathPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 200);
        paint.setStyle(Paint.Style.STROKE);
        // 第二处：设置 Style 为 STROKE 后再获取 Path
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 200);
        paint.getFillPath(path, path2);
        canvas.drawPath(path2, pathPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 400);
        paint.setStrokeWidth(40);
        // 第三处：Style 为 STROKE 并且线条宽度为 40 时的 Path
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 400);
        paint.getFillPath(path, path3);
        canvas.drawPath(path3, pathPaint);
        canvas.restore();
    }

}