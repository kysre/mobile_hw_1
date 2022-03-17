package edu.sharif.hw_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CourseRecyclerViewAdapter extends RecyclerView.Adapter<CourseRecyclerViewAdapter.ViewHolder> {

    private List<String> courseNames;
    private LayoutInflater inflater;

    public CourseRecyclerViewAdapter(Context context, List<String> courseNames) {
        this.courseNames = courseNames;
        this.inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.recyclerview_row, parent, false));
    }

    @Override
    public int getItemCount() {
        return courseNames.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.rowTextView.setText(courseNames.get(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView rowTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rowTextView = itemView.findViewById(R.id.rowTextView);
        }
    }
}
