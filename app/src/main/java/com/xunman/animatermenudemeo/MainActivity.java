package com.xunman.animatermenudemeo;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int[] res = {R.id.img_7, R.id.img_2, R.id.img_3, R.id.img_4, R.id.img_5, R.id.img_6, R.id.img_1};
    private List<ImageView> imageViewList = new ArrayList<>();
    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < res.length; i++) {
            ImageView imageView = (ImageView) findViewById(res[i]);
            imageView.setOnClickListener(this);
            imageViewList.add(imageView);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_7:
                if (flag) {
                    startAnim();
                } else {
                    stopAnim();
                }
                break;
            default:
                Toast.makeText(this, "这是id=====" + view.getId(), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * 控制动画  菜单弹关闭的动画   速度都是一样的依次弹出
     * 可以通过设置插值器来改变动画的运行效果
     * animator.setInterpolator(new BounceInterpolator());//自由落体的插值器
     * android提供 五中插值器
     */
    private void stopAnim() {
        for (int i = 1; i < res.length; i++) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(imageViewList.get(i), "translationY", i * 150f, 0f);
            animator.setDuration(500);
            animator.setInterpolator(new BounceInterpolator());//自由落体的插值器
            animator.setStartDelay(i * 300);//设置依次延迟时间
            animator.start();
            flag = true;
        }
    }

    /**
     * 控制动画  菜单弹出来的动画  速度都是一样的依次弹出
     * 可以通过设置插值器来改变动画的运行效果
     * animator.setInterpolator(new BounceInterpolator());//自由落体的插值器
     * android提供 五中插值器
     */
    private void startAnim() {
        for (int i = 1; i < res.length; i++) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(imageViewList.get(i), "translationY", 0f, i * 150f);
            animator.setDuration(500);
            animator.setInterpolator(new BounceInterpolator());//自由落体的插值器
            animator.setStartDelay(i * 300);//设置依次延迟时间
            animator.start();
            flag = false;
        }
    }
}
