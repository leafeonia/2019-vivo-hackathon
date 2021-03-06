package advertisingspaceforrent.com.myapplication;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import advertisingspaceforrent.com.myapplication.vo.CategoryVO;

public class QuizAdapter extends BaseAdapter {

    List<CategoryVO> quizs;
    Context context;

    public QuizAdapter(List<CategoryVO> quizs, Context context) {
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
            viewHolder.tv_quizCompleted = (TextView)convertView.findViewById(R.id.tv_completion_status) ;
            viewHolder.img = (ImageView) convertView.findViewById(R.id.iv_enter_or_tick);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (QuizAdapter.ViewHolder) convertView.getTag();
        }
        viewHolder.tv_quizName.setText(quizs.get(position).getName());
        Log.i("quizFinished",quizs.get(position).getFinish().toString());
        String completed = quizs.get(position).getFinish()==1 ? "completed" : "not completed";
        viewHolder.tv_quizCompleted.setText(completed);
        if(completed.equals("not completed")){
            viewHolder.tv_quizCompleted.setTextColor(android.graphics.Color.RED);
            viewHolder.img.setImageResource(R.drawable.enter);
        }
//        notifyDataSetChanged();
        return convertView;
    }

    class ViewHolder{
        TextView tv_quizName,tv_quizCompleted;
        ImageView img;
    }
}
