package advertisingspaceforrent.com.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class QuizAdapter extends BaseAdapter {

    List<Map.Entry<String,String>> quizs;
    Context context;

    public QuizAdapter(List<Map.Entry<String, String>> quizs, Context context) {
        this.quizs = quizs;
        this.context = context;
    }

    @Override
    public int getCount() {
        return quizs.size();
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

        QuizAdapter.ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new QuizAdapter.ViewHolder();
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.quiz_item,parent,false);
            viewHolder.tv_quizName =(TextView)convertView.findViewById(R.id.tv_quizName);
            viewHolder.tv_quizCompleted = (TextView)convertView.findViewById(R.id.tv_quizCompleted) ;
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (QuizAdapter.ViewHolder) convertView.getTag();
        }
        viewHolder.tv_quizName.setText(quizs.get(position).getKey());
        viewHolder.tv_quizCompleted.setText(quizs.get(position).getValue());//.toString().split("\\*")[0]);
//        notifyDataSetChanged();
        return convertView;
    }

    class ViewHolder{
        TextView tv_quizName,tv_quizCompleted;
    }
}
