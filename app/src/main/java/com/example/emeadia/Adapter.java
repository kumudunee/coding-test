package com.example.emeadia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context mContext;
    private List<model> mData;

    public Adapter(Context context, List<model> modelList) {
        this.mData = modelList;
        this.mContext = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        v = inflater.inflate(R.layout.item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.title.setText(mData.get(position).getTitle());
        holder.address.setText(mData.get(position).getAddress());

        //using glide library to display the image
//        Glide.with(mContext)
//                .load(mData.get(position).getImg())
//                .into(holder.img);
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(mData.get(position).getImg());
//            System.out.println(jsonObject.getString("small"));
            Glide.with(mContext)
                    .load(jsonObject.getString("small"))
                    //response img url is not working
                    .into(holder.img);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title;
        TextView address;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            address = itemView.findViewById(R.id.address);
            img = itemView.findViewById(R.id.imageView);
        }
    }

}
