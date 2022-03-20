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
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import Controller.Controller;


public class ProfessorMenu extends Fragment implements RecyclerViewAdapter.SelectListener {
    private ArrayList<RecyclerViewAdapter.ListItem> listItems;
    EditText createCourseEditText;
    EditText courseIdEditText;
    Button createCourseButton;
    Button enterCourseButton;
    RecyclerView createdCoursesRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_professor_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        createCourseEditText = view.findViewById(R.id.createCourseEditText);
        courseIdEditText = view.findViewById(R.id.courseIdEditText);
        createCourseButton = view.findViewById(R.id.createCourseButton);
        enterCourseButton = view.findViewById(R.id.professorEnterCourseButton);

        createdCoursesRecyclerView = view.findViewById(R.id.professorCourseRecyclerView);
        createdCoursesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        listItems = new ArrayList<>();
        listItems.addAll(Controller.getCourseListItems());
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(), listItems, this);
        createdCoursesRecyclerView.setAdapter(adapter);

        createCourseButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                String courseName = createCourseEditText.getText().toString();
                boolean result = Controller.createNewCourse(courseName);
                if (result) {
                    Toast toast = Toast.makeText(getContext(),
                            "Course created successfully!", Toast.LENGTH_LONG);
                    toast.show();
                    listItems.clear();
                    listItems.addAll(Controller.getCourseListItems());
                    adapter.notifyDataSetChanged();
                } else {
                    Toast toast = Toast.makeText(getContext(),
                            "Course already exists!", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        enterCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: go to prof course page
            }
        });
    }

    @Override
    public void onItemClicked(RecyclerViewAdapter.ListItem listItem) {
        // TODO: go to prof course page
    }
}