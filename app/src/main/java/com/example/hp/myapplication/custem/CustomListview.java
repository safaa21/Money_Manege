package com.example.hp.myapplication.custem;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.myapplication.R;

public class CustomListview  extends ArrayAdapter<String>{
    private String[] Category;
    private Integer[] imigd ;
    private Activity context;

    public CustomListview(Activity context, String[] Category, Integer[] imigd ) {
       super(context, R.layout.listview,Category);
       this.context=context;
       this.Category = Category;
       this.imigd= imigd;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View r = convertView;
        ViewHolder viewHolder = null;
        if(r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.listview,null,true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) r.getTag();

        }
        viewHolder.iv.setImageResource(imigd[position]);
        viewHolder.tv1.setText(Category[position]);

        return r;
    }

    class ViewHolder {
        TextView tv1;
        ImageView iv;
        ViewHolder(View v){
            tv1 = v.findViewById(R.id.tv1);
            iv = v.findViewById(R.id.image);

        }
    }
}
