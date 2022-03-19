package edu.sharif.hw_1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Controller.Controller;

public class StudentCourseFragment extends Fragment implements RecyclerViewAdapter.SelectListener {
    private String courseName;
    private ArrayList<RecyclerViewAdapter.ListItem> homeworkItemList;
    TextView courseTextView;
    TextView profTextView;
    EditText homeworkNameEditText;
    Button enterHomeworkButton;
    RecyclerView homeworkRecyclerView;
    RecyclerViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_course, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        courseTextView = view.findViewById(R.id.courseNameTextView);
        profTextView = view.findViewById(R.id.profNameTextView);
        homeworkNameEditText = view.findViewById(R.id.homeworkNameEditText);
        enterHomeworkButton = view.findViewById(R.id.enterHomeworkButton);
        homeworkRecyclerView = view.findViewById(R.id.courseHomeworkRecyclerView);

        courseName = StudentCourseFragmentArgs.fromBundle(getArguments()).getCourseName();
        courseTextView.setText(courseName);
//        profTextView.setText(Controller.getCourseProfessorName(courseName));

        homeworkRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        homeworkItemList = new ArrayList<>();

        homeworkItemList.add(new RecyclerViewAdapter.ListItem("HW-1", ""));
        homeworkItemList.add(new RecyclerViewAdapter.ListItem("HW-2", ""));
        homeworkItemList.add(new RecyclerViewAdapter.ListItem("HW-3", ""));
        homeworkItemList.add(new RecyclerViewAdapter.ListItem("HW-4", ""));
        homeworkItemList.add(new RecyclerViewAdapter.ListItem("HW-5", ""));
        homeworkItemList.add(new RecyclerViewAdapter.ListItem("HW-6", ""));
        homeworkItemList.add(new RecyclerViewAdapter.ListItem("HW-7", ""));

        adapter = new RecyclerViewAdapter(getActivity(), homeworkItemList, this);
        homeworkRecyclerView.setAdapter(adapter);


        enterHomeworkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String homeworkName = homeworkNameEditText.getText().toString();
                // TODO: go to homework page
            }
        });
    }

    @Override
    public void onItemClicked(RecyclerViewAdapter.ListItem listItem) {
        String homeworkName = listItem.getLeftString();
        // TODO: go to homework page
        Toast.makeText(getActivity(), homeworkName, Toast.LENGTH_SHORT).show();
    }
}
