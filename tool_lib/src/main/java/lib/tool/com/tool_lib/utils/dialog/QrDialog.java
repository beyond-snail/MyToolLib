package lib.tool.com.tool_lib.utils.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import lib.tool.com.tool_lib.R;


/**
 * Created by Administrator on 2018/2/2 0002.
 */

public class QrDialog extends Dialog {

    public QrDialog(@NonNull Context context) {
        super(context);
    }

    public QrDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public static class Builder {
        private Context context;
        private Bitmap image;
        private String title;
        private String bottom;
        private boolean isShowTitle;
        private boolean isShowBottom;

        public Builder(Context context) {
            this.context = context;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBottom() {
            return bottom;
        }

        public void setBottom(String bottom) {
            this.bottom = bottom;
        }

        public boolean isShowTitle() {
            return isShowTitle;
        }

        public void setShowTitle(boolean showTitle) {
            isShowTitle = showTitle;
        }

        public boolean isShowBottom() {
            return isShowBottom;
        }

        public void setShowBottom(boolean showBottom) {
            isShowBottom = showBottom;
        }

        public Bitmap getImage() {
            return image;
        }

        public void setImage(Bitmap image) {
            this.image = image;
        }

        public QrDialog create() {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final QrDialog dialog = new QrDialog(context, R.style.MyDialogStyleBottom);
            View layout = inflater.inflate(R.layout.dialog_share_qrcode, null);
            dialog.addContentView(layout, new WindowManager.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT
                    , ViewGroup.LayoutParams.WRAP_CONTENT));
            dialog.setContentView(layout);
            ImageView img = (ImageView)layout.findViewById(R.id.img_qrcode);
            TextView title = layout.findViewById(R.id.title);
            TextView bottom = layout.findViewById(R.id.bottom);
            img.setImageBitmap(getImage());
            if (isShowTitle){
                title.setVisibility(View.VISIBLE);
                title.setText(getTitle());
            }else{
                title.setVisibility(View.GONE);
            }
            if (isShowBottom){
                bottom.setVisibility(View.VISIBLE);
                bottom.setText(getBottom());
            }else{
                bottom.setVisibility(View.GONE);
            }
            return dialog;
        }
    }
}
