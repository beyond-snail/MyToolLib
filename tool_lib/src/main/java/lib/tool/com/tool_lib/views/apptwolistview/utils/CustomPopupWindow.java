package lib.tool.com.tool_lib.views.apptwolistview.utils;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import lib.tool.com.tool_lib.R;
import lib.tool.com.tool_lib.utils.utils.StringUtils;


////////////////////////////////////////////////////////////////////
//                          _ooOoo_                               //
//                         o8888888o                              //
//                         88" . "88                              //
//                         (| ^_^ |)                              //
//                         O\  =  /O                              //
//                      ____/`---'\____                           //
//                    .'  \\|     |//  `.                         //
//                   /  \\|||  :  |||//  \                        //
//                  /  _||||| -:- |||||-  \                       //
//                  |   | \\\  -  /// |   |                       //
//                  | \_|  ''\---/''  |   |                       //
//                  \  .-\__  `-`  ___/-. /                       //
//                ___`. .'  /--.--\  `. . ___                     //
//              ."" '<  `.___\_<|>_/___.'  >'"".                  //
//            | | :  `- \`.;`\ _ /`;.`/ - ` : | |                 //
//            \  \ `-.   \_ __\ /__ _/   .-` /  /                 //
//      ========`-.____`-.___\_____/___.-`____.-'========         //
//                           `=---='                              //
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //
//              佛祖保佑       永无BUG     永不修改                  //
//                                                                //
//          佛曰:                                                  //
//                  写字楼里写字间，写字间里程序员；                   //
//                  程序人员写程序，又拿程序换酒钱。                   //
//                  酒醒只在网上坐，酒醉还来网下眠；                   //
//                  酒醉酒醒日复日，网上网下年复年。                   //
//                  但愿老死电脑间，不愿鞠躬老板前；                   //
//                  奔驰宝马贵者趣，公交自行程序员。                   //
//                  别人笑我忒疯癫，我笑自己命太贱；                   //
//                  不见满街漂亮妹，哪个归得程序员？                   //
////////////////////////////////////////////////////////////////////

/**********************************************************
 *                                                        *
 *                  Created by wucongpeng on 2017/7/7.        *
 **********************************************************/


public class CustomPopupWindow extends PopupWindow implements View.OnClickListener {
	
	
	
	
    private Button btnOk;
    private View mPopView;
    private TextView goodsAmount;
    private OnItemClickListener mListener;
    private Context mContext;
    private AmountView mAmountView;
    private String goodsName; //商品名称
    private String Amount; //商品金额
    private int categroyNum; //数量
    private int goodsOnhand; //库存数量
    private String imgUrl; // 图片下载路径
    private int totalPrice;

    public CustomPopupWindow(Context context, String goodsName, String amount, String url, int goodsOnhand) {
        super(context);
        // TODO Auto-generated constructor stub
        this.mContext = context;
        this.goodsName = goodsName;
        this.goodsOnhand = goodsOnhand;
        this.Amount = amount;
        this.imgUrl = url;
        this.categroyNum = 1; //默认数量是1
        init(context);
        setPopupWindow();


    }

    /**
     * 初始化
     *
     * @param context
     */
    private void init(Context context) {
        // TODO Auto-generated method stub
        LayoutInflater inflater = LayoutInflater.from(context);
        //绑定布局
        mPopView = inflater.inflate(R.layout.categroy_pop, null);

        btnOk = (Button) mPopView.findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(this);

        //右上角关闭按钮
        ImageView img = (ImageView) mPopView.findViewById(R.id.id_pop_diss);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        
        //加载图片
        ImageView imgIcon = (ImageView) mPopView.findViewById(R.id.iv_mall);
        try {
			// 异步加载图片
			ImageLoader.getInstance().displayImage(imgUrl, imgIcon);
		} catch (Exception e) {
			Log.e("CustomPopupWindow", "图片加载失败：路径->" + imgUrl);
		}

        //数量选择器
        mAmountView = (AmountView) mPopView.findViewById(R.id.amount_view);
        mAmountView.setGoods_storage(goodsOnhand);
        mAmountView.setOnAmountChangeListener(new AmountView.OnAmountChangeListener() {
            @Override
            public void onAmountChange(View view, int amount) {
                //获取选中的数量
                categroyNum = amount;
                totalPrice = getTotalPrice(categroyNum);
                goodsAmount.setText("￥"+ StringUtils.formatIntMoney(totalPrice));
            }
        });
        
        //商品名称
        TextView tvGoodsName = (TextView) mPopView.findViewById(R.id.id_goods_name);
        tvGoodsName.setText(goodsName);
        
        //商品价钱
        goodsAmount = (TextView) mPopView.findViewById(R.id.id_goods_amount);
        goodsAmount.setText("￥"+Amount);
    }
    
    /**
     * 计算总金额
     * @param categroyNum
     * @return
     */
//    private double getTotalPrice(int categroyNum) {
//        double total = 0d;
//        if (!TextUtils.isEmpty(Amount)) {
//            double priceFloat = Double.parseDouble(Amount);
//            total = ArithUtil.add(total, ArithUtil.mul(categroyNum, priceFloat));
//        }
//        return total;
//    }
    
    private int getTotalPrice(int categroyNum) {
//    	int total = 0d;
//        if (!TextUtils.isEmpty(Amount)) {
//            int priceFloat = Amount*100;//Double.parseDouble(Amount);
//            total = ArithUtil.add(total, ArithUtil.mul(categroyNum, priceFloat));
//        }
    	int priceFloat = (int)(Double.parseDouble(Amount)*100);
        return priceFloat*categroyNum;
    }
    
    
    
    

    /**
     * 设置窗口的相关属性
     */
    @SuppressLint("InlinedApi")
    private void setPopupWindow() {


        this.setContentView(mPopView);// 设置View
        this.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);// 设置弹出窗口的宽
        this.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);// 设置弹出窗口的高
        this.setFocusable(true);// 设置弹出窗口可
        this.setAnimationStyle(R.style.take_photo_anim);// 设置动画
        this.setBackgroundDrawable(new ColorDrawable(0x00000000));// 设置背景透明
        mPopView.setOnTouchListener(new View.OnTouchListener() {// 如果触摸位置在窗口外面则销毁

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                int height = mPopView.findViewById(R.id.pop_layout).getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        dismiss();
                    }
                }
                return true;
            }
        });
        this.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                setBackgroundAlpha(1.0f);
                
                if(mListener != null){
            		mListener.disMisItemClick(categroyNum);
            	}
            }
        });

    }

    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha
     *            屏幕透明度0.0-1.0 1表示完全不透明
     */
    public void setBackgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = ((Activity) mContext).getWindow()
                .getAttributes();
        lp.alpha = bgAlpha;
        if (bgAlpha == 1) { //解决华为 背景不变暗的情况
            ((Activity) mContext).getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);//不移除该Flag的话,在有视频的页面上的视频会出现黑屏的bug
        } else {
            ((Activity) mContext).getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);//此行代码主要是解决在华为手机上半透明效果无效的bug
        }
        ((Activity) mContext).getWindow().setAttributes(lp);
    }

    /**
     * 定义一个接口，公布出去 在Activity中操作按钮的单击事件
     */
    public interface OnItemClickListener {
        void setOnItemClick(View v, int num, int totalPrice);
        //关闭时候，将商品数量添加一次
        void disMisItemClick(int num);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (mListener != null) {
            mListener.setOnItemClick(v, categroyNum, totalPrice);
        }
    }

}
