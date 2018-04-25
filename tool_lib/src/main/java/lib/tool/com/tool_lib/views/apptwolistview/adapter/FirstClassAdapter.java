package lib.tool.com.tool_lib.views.apptwolistview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import lib.tool.com.tool_lib.R;
import lib.tool.com.tool_lib.views.apptwolistview.model.FirstClassItem;


/**
 * 一级分类（即左侧菜单）的adapter Created by hanj on 14-9-25.
 */
public class FirstClassAdapter extends BaseAdapter {
	private Context context;
	private List<FirstClassItem> list;
	private List<ImageView> imageViews;

	public FirstClassAdapter(Context context, final List<FirstClassItem> list) {
		this.context = context;
		this.list = list;
		
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				for (int i = 0; i < list.size(); i++ ){
//					String imageUrl = ConfigApp.ZF_SERVER_API + list.get(i).getUrl();// vo.getPicturePath();
//					ImageLoader.getInstance().displayImage(imageUrl, );// 加载图片
//				}
//				
//			}
//		}).start();
		
	}

	@Override
	public int getCount() {
		return list == null ? 0 : list.size();
	}

	@Override
	public Object getItem(int i) {
		return null;
	}

	@Override
	public long getItemId(int i) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup viewGroup) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.left_listview_item, null);
			holder = new ViewHolder();

			holder.nameTV = (TextView) convertView.findViewById(R.id.left_item_name);
			holder.icon = (ImageView) convertView.findViewById(R.id.id_left_icon);
			convertView.setTag(holder);
			
			
			
//			if (position != 0 && !StringUtil.isBlank(list.get(position).getUrl())) {
//				String imageUrl = list.get(position).getUrl();// vo.getPicturePath();
//				ImageLoader.getInstance().displayImage(imageUrl, holder.icon);// 加载图片
//			}else{
//				holder.icon.setImageResource(R.drawable.icon_all);
//			}
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		// 选中和没选中时，设置不同的颜色
		if (position == selectedPosition) {
			convertView.setBackgroundResource(R.color.divide_line);
		} else {
			convertView.setBackgroundResource(R.drawable.selector_left_normal);
		}

		holder.nameTV.setText(list.get(position).getName());
		// if (list.get(position).getSecondList() != null &&
		// list.get(position).getSecondList().size() > 0) {
		// holder.nameTV.setCompoundDrawablesWithIntrinsicBounds(0, 0,
		// R.drawable.arrow_right, 0);
		// } else {
		// holder.nameTV.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
		// }

		
//		if (list.get(position).getName().equals("全部")){
//			holder.icon.setImageResource(R.drawable.icon_all);
//		}else{
//			String imageUrl = list.get(position).getUrl();// vo.getPicturePath();
//			ImageLoader.getInstance().displayImage(imageUrl, holder.icon);// 加载图片
//		}
		

		return convertView;
	}

	private int selectedPosition = 0;

	public void setSelectedPosition(int selectedPosition) {
		this.selectedPosition = selectedPosition;
	}

	public int getSelectedPosition() {
		return selectedPosition;
	}

	private class ViewHolder {
		TextView nameTV;
		ImageView icon;
	}
}
