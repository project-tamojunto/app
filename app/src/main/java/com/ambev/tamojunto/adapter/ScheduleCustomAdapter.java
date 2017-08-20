package com.ambev.tamojunto.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ambev.tamojunto.R;
import com.ambev.tamojunto.model.Data;

import java.util.ArrayList;

/**
 * Created by matheuscatossi on 19/08/17.
 */

public class ScheduleCustomAdapter extends ArrayAdapter<Data> implements View.OnClickListener {

    private ArrayList<Data> dataSet;
    private Context mContext;

    @Override
    public void onClick(View v) {

    }

    private static class ViewHolder {
        TextView tv_ini;
        TextView tv_fim;
        TextView tv_data;
        LinearLayout ll_line;
    }

    public ScheduleCustomAdapter(ArrayList<Data> data, Context context) {
        super(context, R.layout.row_item_schedules, data);

        this.dataSet = data;
        this.mContext = context;
    }

    private int lastPosition = -1;

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        final Data data = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item_schedules, parent, false);

            viewHolder.tv_ini = (TextView) convertView.findViewById(R.id.horaIni);
            viewHolder.tv_fim = (TextView) convertView.findViewById(R.id.horaFim);
            viewHolder.tv_data = (TextView) convertView.findViewById(R.id.data);
            viewHolder.ll_line = (LinearLayout) convertView.findViewById(R.id.ll_line);

            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.tv_ini.setText(data.getHorarioIni());
        viewHolder.tv_fim.setText(data.getHorarioFim());
        viewHolder.tv_data.setText(data.getData());

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.ll_line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(mContext, InformationUserActivity.class);
//                i.putExtra("id", String.valueOf(schedules.getId()));
//                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                mContext.startActivity(i);
            }
        });

        return convertView;
    }
}
