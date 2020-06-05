package com.example.titaijiaozhengapp.ui.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.titaijiaozhengapp.Utils.DrawUtils;

public class DrawCircle extends View {

    /** 进度条画笔的宽度（dp） */
    private int paintProgressWidth = 3;

    /** 文字百分比的字体大小（sp） */
    private int paintTextSize = 20;

    /** 未完成进度条的颜色 */
    private int paintUndoneColor = 0xffaaaaaa;

    /** 已完成进度条的颜色 */
    private int paintDoneColor = 0xff67aae4;

    /** 百分比文字的颜色 */
    private int paintTextColor = 0xffff0077;

    /** 设置进度条画笔的宽度(px) */
    private int paintProgressWidthPx;

    /** 文字画笔的尺寸(px) */
    private int paintTextSizePx;
    /** Context上下文环境 */
    private Context context;

    /** 调用者设置的进程 0 - 100 */
    private int progress;

    /** 画未完成进度圆弧的画笔 */
    private Paint paintUndone = new Paint();

    /** 画已经完成进度条的画笔 */
    private Paint paintDone = new Paint();

    /** 画文字的画笔 */
    private Paint paintText = new Paint();

    /** 包围进度条圆弧的矩形 */
    private RectF rectF = new RectF();

    /** 包围文字所在路径圆弧的矩形，比上一个矩形略小 */
    private RectF rectF2 = new RectF();

    /** 进度文字所在的路径 */
   // private Path path = new Path();

    /** 文字所在路径圆弧的半径 */
    private int radiusText;

    /** 是否进行过了测量 */
    private boolean isMeasured = false;

    public DrawCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        initData();

    }
    //初始化数据
    private void initData() {
        //设置进度条画笔宽度
        paintProgressWidthPx = DrawUtils.dip2px(context,paintProgressWidth);
        //未完成进度圆环画笔属性
        paintUndone.setColor(paintUndoneColor);
        paintUndone.setStrokeWidth(paintProgressWidthPx);
        //防锯齿
        paintUndone.setAntiAlias(true);
        //设置画笔样式   STROKE：描边  FILL：填充  FILL_AND_STROKE：两种效果
        paintUndone.setStyle(Paint.Style.STROKE);

        //已经完成进度条画笔属性
        paintDone.setColor(paintDoneColor);
        paintDone.setStrokeWidth(paintProgressWidthPx);
        paintDone.setAntiAlias(true);
        paintDone.setStyle(Paint.Style.STROKE);

        //text画笔
        paintText.setColor(paintTextColor);
        paintText.setTextSize(paintTextSize);
        paintText.setStyle(Paint.Style.STROKE);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        paintText.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (!isMeasured){
            getWidthAndHight();
            isMeasured = true;
        }
    }
    /** 得到视图等的高度宽度尺寸数据 */
    private void getWidthAndHight() {
        //自定义视图的高度
        int viewHeight = getMeasuredHeight();
        //宽度
        int viewWidth = getMeasuredWidth();
        //自定义视图X轴中心点
        int viewCenterX = viewWidth/2;
        //Y
        int viewCenterY = viewHeight/2;

        // 取本View长宽较小者的一半为整个圆环部分（包括圆环和文字）最外侧的半径 大于就是width小于就是height
        int minLenth = viewHeight > viewWidth ? viewWidth/2 : viewHeight/2;
        //
        Rect rect = new Rect();
        //得到圆环中间半径
        int radiusArc = minLenth - paintProgressWidthPx/2;
        rectF.left = viewCenterX - radiusArc;
        rectF.right = viewCenterX + radiusArc;
        rectF.top = viewCenterY - radiusArc;
        rectF.bottom = viewCenterY + radiusArc;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画未完成进度的圆环
        canvas.drawArc(rectF,0,360,false,paintUndone);

        //画已经完成进度的圆弧从-90度开始，即从圆环顶部开始
        canvas.drawArc(rectF,-90,progress/100.0f*360,false,paintDone);

        //画数字
        canvas.drawText(String.valueOf(progress),getMeasuredHeight()/2,getMeasuredWidth()/2,paintText);
    }

    /**
     * @param progress 外部传进来的当前进度,强制重绘
     */
    public void setProgress(int progress){
        this.progress = progress;
        //强制重绘
        invalidate();
    }
}
