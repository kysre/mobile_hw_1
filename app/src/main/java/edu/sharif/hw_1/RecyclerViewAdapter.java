package edu.sharif.hw_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<String> names;
    private LayoutInflater inflater;

    public RecyclerViewAdapter(Context context, List<String> names) {
        this.names = names;
        this.inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.recyclerview_row, parent, false));
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.rowTextView.setText(names.get(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView rowTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rowTextView = itemView.findViewById(R.id.rowTextView);
        }
    }
}
