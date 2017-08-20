package com.ambev.tamojunto.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ambev.tamojunto.PaymentActivity;
import com.ambev.tamojunto.R;
import com.ambev.tamojunto.helper.DownloadImageTask;
import com.ambev.tamojunto.model.Data;

import java.util.List;

/**
 * Created by matheuscatossi on 19/08/17.
 */


public class DataCustomAdapter extends RecyclerView.Adapter<DataCustomAdapter.MyViewHolder> {

    private Context mContext;
    private List<Data> dataList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView data, horaIni, horaFim, qtdVagas;
        public ImageView img_data;
        public LinearLayout ll_data;

        public MyViewHolder(View view) {
            super(view);
            data          = (TextView) view.findViewById(R.id.data);
            horaIni           = (TextView) view.findViewById(R.id.horaIni);
            horaFim         = (TextView) view.findViewById(R.id.horaFim);
//            qtdVagas          = (TextView) view.findViewById(R.id.qtdVagas);
//            img_data        = (ImageView) view.findViewById(R.id.img_data);
            ll_data        = (LinearLayout) view.findViewById(R.id.ll_data);
        }
    }

    public DataCustomAdapter(Context mContext, List<Data> dataList) {
        this.mContext = mContext;
        this.dataList = dataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item_data, parent, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        final Data data = dataList.get(position);
        holder.horaFim.setText(data.getHorarioFim());
        holder.horaIni.setText(data.getHorarioIni());
        holder.data.setText(data.getData());
//        holder.qtdVagas.setText("" + data.getQtdVagas());


        holder.ll_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PaymentActivity.class);
                intent.putExtra("id", "" + data.getId());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });

//        new DownloadImageTask(holder.img_data).execute("http://www.freeiconspng.com/uploads/schedule-icon-7.png");
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}
