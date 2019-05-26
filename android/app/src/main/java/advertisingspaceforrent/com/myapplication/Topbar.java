package advertisingspaceforrent.com.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ace on 2016/2/3.
 */
public class Topbar extends RelativeLayout {

    //声明我们需要的控件
    private Button leftButton,rightButton;
    private TextView tv_title;

    private int leftTextColor;
    private String leftText;
    private Drawable leftBackground;

    private int rightTextColor;
    private String rightText;
    private Drawable rightBackground;

    private String title;
    private int titleTextColor;
    private float titleTextSize;

    //4 定义布局属性
    private RelativeLayout.LayoutParams leftParams , rightParams,titleParams;

    public Topbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        //1 通过 context.obtainStyledAttributes 得到 TypedArray对象 并拿到属性值
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        leftText = ta.getString(R.styleable.TopBar_leftText);
        leftTextColor = ta.getColor(R.styleable.TopBar_leftTextColor, 0);
        leftBackground = ta.getDrawable(R.styleable.TopBar_leftBackground);

        rightText = ta.getString(R.styleable.TopBar_rightText);
        rightTextColor = ta.getColor(R.styleable.TopBar_rightTextColor, 0);
        rightBackground = ta.getDrawable(R.styleable.TopBar_rightBackground);

        title = ta.getString(R.styleable.TopBar_title);
        titleTextColor = ta.getColor(R.styleable.TopBar_titleTextColor, 0);
        titleTextSize = ta.getDimension(R.styleable.TopBar_titleTextSize, 0);
        //记得回收下 防止出现一些内存问题
        ta.recycle();

        // 2 new出控件
        leftButton = new Button(context);
        rightButton = new Button(context);
        tv_title = new TextView(context);

        //3 把自定义的属性赋给控件

        leftButton.setTextColor(leftTextColor);
        leftButton.setBackground(leftBackground);
        leftButton.setText(leftText);

        rightButton.setTextColor(rightTextColor);
        rightButton.setBackground(rightBackground);
        rightButton.setText(rightText);

        tv_title.setTextColor(titleTextColor);
        tv_title.setTextSize(titleTextSize);
        tv_title.setText(title);
        tv_title.setGravity(Gravity.CENTER);

        setBackgroundColor(0x87CEEB);


        // 5 new出LayoutParams 设置宽高
        leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        // 6 设置规则 可以看出LayoutParams布局参数就是把你的控件以什么样的方式显示在组合控件
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,RelativeLayout.CENTER_VERTICAL);
        //7 添加到布局中(控件,布局参数)
        addView(leftButton ,leftParams);
        rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.CENTER_VERTICAL);
        addView(rightButton, rightParams);
        titleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.MATCH_PARENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        addView(tv_title,titleParams);

        //8 TopBar的静态部分已经完毕了 到这一步就很明白了 我们采用的组合方式,用系统以及有的控件组合在一起,组成一个新的控件,这个思路是否可以延伸到其他地方呢?思考下

    }




}