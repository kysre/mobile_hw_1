package edu.sharif.hw_1;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

import Controller.Controller;

public class StudentMenu extends Fragment implements RecyclerViewAdapter.SelectListener {

    private ArrayList<RecyclerViewAdapter.ListItem> listItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText classIdTextView = view.findViewById(R.id.studentCourseEditText);
        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch joinSwitch = view.findViewById(R.id.studentJoinSwitch);
        Button enterButton = view.findViewById(R.id.studentEnterCourseButton);
        RecyclerView courseRecyclerView;
        RecyclerViewAdapter adapter;

        courseRecyclerView = view.findViewById(R.id.studentCourseRecyclerView);
        courseRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

//        listItems = Controller.getCourseListItems();
        listItems = new ArrayList<>();
        listItems.add(new RecyclerViewAdapter.ListItem("course-1", "40085"));
        listItems.add(new RecyclerViewAdapter.ListItem("course-2", "40095"));
        listItems.add(new RecyclerViewAdapter.ListItem("course-3", "21085"));
        listItems.add(new RecyclerViewAdapter.ListItem("course-4", "20085"));
        listItems.add(new RecyclerViewAdapter.ListItem("course-5", "33085"));
        listItems.add(new RecyclerViewAdapter.ListItem("course-6", "12085"));

        adapter = new RecyclerViewAdapter(getActivity(), listItems, this);
        courseRecyclerView.setAdapter(adapter);

        joinSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    enterButton.setText("Join");
                    listItems = Controller.getNotJoinedCourseListItems();
                } else {
                    enterButton.setText("Enter");
                    listItems = Controller.getCourseListItems();
                }
                adapter.notifyDataSetChanged();
            }
        });

        enterButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                boolean isEnter = enterButton.getText().toString().equals("Enter");
                int courseId = Integer.parseInt(classIdTextView.getText().toString());
                if (isEnter) {
                    // TODO: enter class with classId
                } else {
                    if (Controller.joinCourse(courseId)) {
                        Toast toast = Toast.makeText(getContext(),
                                "Course joined Successfully!", Toast.LENGTH_LONG);
                        toast.show();
                        listItems = Controller.getNotJoinedCourseListItems();
                        adapter.notifyDataSetChanged();
                    } else {
                        Toast toast = Toast.makeText(getContext(),
                                "Unable to join course!", Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
            }
        });
    }

    @Override
    public void onItemClicked(RecyclerViewAdapter.ListItem listItem) {
        // TODO: go to course page or join course after being clicked
        Toast.makeText(getActivity(), listItem.getLeftString(), Toast.LENGTH_SHORT).show();
    }
}