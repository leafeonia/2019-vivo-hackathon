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
    public View getView(int position, View convertView, ViewGroup parent) {
        WrongAdapter.viewHolder viewHolder;
        if (convertView == null){
            viewHolder = new WrongAdapter.viewHolder();
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.wrong_list_item,parent,false);
            viewHolder.tvContext = (TextView)convertView.findViewById(R.id.tv_wrong_context);
            viewHolder.tvCorrect = convertView.findViewById(R.id.tv_wrong_correct);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (WrongAdapter.viewHolder) convertView.getTag();
        }
        String correct = "Assert";
        Question current = list.get(position);
        switch (current.getCorrect()){
            case 1: correct = current.getChoiceA();break;
            case 2: correct = current.getChoiceB();break;
            case 3: correct = current.getChoiceC();break;
            case 4: correct = current.getChoiceD();break;
        }
        viewHolder.tvCorrect.setText(correct);
        viewHolder.tvContext.setText(current.getContext());
        return convertView;
    }

    class viewHolder{
        TextView tvContext, tvCorrect;
    }
}
