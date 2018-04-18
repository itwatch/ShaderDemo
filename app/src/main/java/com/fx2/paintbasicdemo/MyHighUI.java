package com.fx2.paintbasicdemo;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by chenshuo on 2018/4/18.
 */

public class MyHighUI  extends View{


    public MyHighUI(Context context) {
        this(context,null);
    }

    public MyHighUI(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyHighUI(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //drawStrokeJoin(canvas);

       // drawCornerPathEffect(canvas);


        //myPaintMainMethod(canvas);
       // drawCornerPathEffectDemo(canvas);


        drawDashPathEffectDemo(canvas);

    }

    private void myPaintMainMethod(Canvas canvas) {

        Paint paint = getPaint();


        /**
         * 三个方法一个是 路径的规则
         * 一个是shader  着色器    各种颜色
         *
         * 一个是  setStrokeJion  设置结合处的样子
         *
         *
         *
         * */
        paint.setPathEffect(new PathEffect());




        paint.setShader(new BitmapShader(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));


        paint.setStrokeJoin(Paint.Join.MITER);



    }

    private void drawCornerPathEffect(Canvas canvas) {

        Paint paint = getPaint();
        Path path = new Path();
        path.moveTo(100,600);
        path.lineTo(400,100);
        path.lineTo(700,900);



        canvas.drawPath(path,paint);
        paint.setColor(Color.RED);
        paint.setPathEffect(new CornerPathEffect(100));
        canvas.drawPath(path,paint);


        paint.setPathEffect(new CornerPathEffect(200));
        paint.setColor(Color.YELLOW);
        canvas.drawPath(path,paint);

    }


    /**
     * 画正常的线    paint.setStrokeJoin(Paint.Join.MITER);  paint  的各种用法  画笔的各种用法
     * */

    private void drawStrokeJoin(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        Paint  paint = new Paint();

        // 宽度
        paint.setStrokeWidth(40);


        paint.setStyle(Paint.Style.STROKE);

         // 抗锯齿
        paint.setAntiAlias(true);

        Path path  = new Path();
        path.moveTo(100,100);
        path.lineTo(450,100);
        path.lineTo(100,300);


        paint.setStrokeJoin(Paint.Join.MITER);
        canvas.drawPath(path,paint);





        path.moveTo(100,400);
        path.lineTo(450,400);
        path.lineTo(100,600);
        paint.setStrokeJoin(Paint.Join.BEVEL);
        canvas.drawPath(path,paint);



        path.moveTo(100,700);
        path.lineTo(450,700);
        path.lineTo(100,900);
        paint.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawPath(path,paint);

    }

    public Paint getPaint() {
        Paint paint = new Paint();
        paint.setStrokeWidth(4);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        return paint;
    }




    /**
     * CornerPathEffect
     * @param canvas
     */
    private void drawCornerPathEffectDemo(Canvas canvas){
        Paint paint = getPaint();
        Path path = getPath();
        canvas.drawPath(path,paint);



        //  圆角平滑的过度

        paint.setPathEffect(new CornerPathEffect(200));
        //canvas.save();
        canvas.translate(0,150);
        canvas.drawPath(path,paint);
    }


    private Path getPath(){
        Path path = new Path();
        // 定义路径的起点
        path.moveTo(0, 0);

        // 定义路径的各个点
        for (int i = 0; i <= 40; i++) {
            path.lineTo(i*35, (float) (Math.random() * 150));
        }
        return path;
    }


   /**
    *
    * 根据点来画虚线    dashPathEffect   虚线   CornerPathEffect  平滑的线
    * */
    private void drawDashPathEffectDemo(Canvas canvas){
        Paint paint = getPaint();
        Path path = getPath();


        // 路径  虚线
        paint.setPathEffect(new DashPathEffect(new float[]{15,20,15,15},0));

       // paint.setPathEffect(new CornerPathEffect(20));
        canvas.drawPath(path,paint);

        canvas.save();

         paint.setPathEffect(new CornerPathEffect(20));

        canvas.translate(100,100);

        canvas.drawPath(path,paint);

    }

}
