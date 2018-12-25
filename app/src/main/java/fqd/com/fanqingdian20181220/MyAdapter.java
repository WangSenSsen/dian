package fqd.com.fanqingdian20181220;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import org.w3c.dom.Text;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    public List<Json.ResultBean> list;
    public Context context;

    public MyAdapter(List<Json.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView == null) {
            convertView=View.inflate(context,R.layout.list_item,null);
            holder=new ViewHolder();
            holder.imageView=convertView.findViewById(R.id.item_image);
            holder.textView1=convertView.findViewById(R.id.item_text1);
            holder.textView2=convertView.findViewById(R.id.item_text2);
            holder.textView3=convertView.findViewById(R.id.item_text3);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        ImageLoader.getInstance().displayImage(list.get(position).getImageUrl(),holder.imageView);
        holder.textView1.setText(list.get(position).getName());
        holder.textView2.setText("评分"+list.get(position).getRank());
        holder.textView3.setText(list.get(position).getSummary());
        return convertView;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView1;
        TextView textView2;
        TextView textView3;
    }
}
