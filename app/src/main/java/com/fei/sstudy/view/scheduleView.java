package com.fei.sstudy.view;

import android.app.Service;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Looper;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.fei.sstudy.R;
import com.fei.sstudy.view.OnLongClickListener;

import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class scheduleView extends View {
    private final String TAG = "scheduleView";
    private ConstraintLayout parent;

    private int mFirstX;
    private int mFirstY;
    private Paint mPaint;
    private RectF mRectF;

    private final int schduleWidth = getResources().getDimensionPixelSize(R.dimen.schadle_rect_width);
    private final int schduleHeight = getResources().getDimensionPixelSize(R.dimen.schadle_rect_hight);
    private int scheduleHightCount;  //当个框占的格数
    private Context mContext;

    private boolean isLongCilck = false; //是否已经长按

    private com.fei.sstudy.view.OnLongClickListener mLongClickListener;

    private Handler mHandler = new android.os.Handler(Looper.getMainLooper());

    public scheduleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setLongClickListener(com.fei.sstudy.view.OnLongClickListener listener){
        mLongClickListener = listener;
    }

    private Runnable mLongClickRunnable = new Runnable() {
        @Override
        public void run() {
            Log.d(TAG,"--------isLongClick--------");
            isLongCilck = true;
            toVibrator();

            /**
             * todo 长按后操作
             */
//            mLongClickListener.onLongClick();
        }
    };


    public scheduleView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public scheduleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public scheduleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    public void setColor(int color){
        mPaint.setColor(color);
    }

    public void setHightCount(int h){
        scheduleHightCount = h;
    }

    private void init(){
        scheduleHightCount = 1;
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(schduleWidth,schduleHeight*scheduleHightCount);
        mRectF = new RectF(0,0,schduleWidth,schduleHeight*scheduleHightCount-4);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRoundRect(mRectF,20,20,mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();
        parent = (ConstraintLayout) getParent();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG,"event.ACTION_DOWN");
                mFirstX = x;
                mFirstY = y;
                mHandler.postDelayed(mLongClickRunnable,2000);
                parent.requestDisallowInterceptTouchEvent(true);
                return true;

            case MotionEvent.ACTION_MOVE:
                Log.d(TAG,"event.ACTION_MOVE");
                int deltaX = Math.abs(x - mFirstX);
                int deltaY = Math.abs(y - mFirstY);
                Log.d(TAG,"deltaX:"+deltaX);
                Log.d(TAG,"deltaY:"+deltaY);
                if (deltaX > 20 || deltaY > 20){
                    if (!isLongCilck){
                        Log.d(TAG,"-----------callback----------");
                        mHandler.removeCallbacks(mLongClickRunnable);
                        parent.requestDisallowInterceptTouchEvent(false);
                    }
                }
                break;

            case MotionEvent.ACTION_UP:
                Log.d(TAG,"event.ACTION_UP");
                isLongCilck = false;
                mHandler.removeCallbacks(mLongClickRunnable);
                parent.requestDisallowInterceptTouchEvent(false);
                break;
        }

        return super.onTouchEvent(event);
    }

    /**
     * 震动
     */
    private void toVibrator(){
        Vibrator vibrator = (Vibrator) mContext.getSystemService(Service.VIBRATOR_SERVICE);
        vibrator.vibrate(100);
    }
}