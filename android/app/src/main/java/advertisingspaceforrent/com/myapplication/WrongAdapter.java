package advertisingspaceforrent.com.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        viewHolder viewHolder = null;
        if (view == null){
            viewHolder = new viewHolder();
            viewHolder.textView  = (TextView) view.findViewById(R.id.textView);
            view.setTag(viewHolder);
        }else{
            viewHolder = (WrongAdapter.viewHolder) view.getTag();
        }

        viewHolder.textView.setText(list.indexOf(i));
        return view;
    }

    class viewHolder{
        TextView textView;
    }
}
