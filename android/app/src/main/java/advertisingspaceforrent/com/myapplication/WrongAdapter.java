package advertisingspaceforrent.com.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import advertisingspaceforrent.com.myapplication.vo.Question;

public class WrongAdapter extends BaseAdapter {
    private List<Question> list;
    private Context context;

    public WrongAdapter(Context context , List<Question> list) {

        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        WrongAdapter.viewHolder viewHolder;
        if (convertView == null){
            viewHolder = new WrongAdapter.viewHolder();
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.activity_wrong_list,null);
            viewHolder.textView = (TextView)convertView.findViewById(R.id.textView);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (WrongAdapter.viewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(list.indexOf(i));
        return convertView;
    }

    class viewHolder{
        TextView textView;
    }
}