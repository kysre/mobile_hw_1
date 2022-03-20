package edu.sharif.hw_1;

import android.annotation.SuppressLint;
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

public class ProfessorCourseFragment extends Fragment implements RecyclerViewAdapter.SelectListener {
    private ArrayList<RecyclerViewAdapter.ListItem> listItems;
    private String courseName;
    private RecyclerViewAdapter adapter;
    TextView courseNameTextView;
    TextView profNameTextView;
    EditText homeworkNameEditText;
    EditText homeworkQuestionEditText;
    Button createHomeworkButton;
    RecyclerView homeworkRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_professor_course, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        courseNameTextView = view.findViewById(R.id.profCourseNameTextView);
        profNameTextView = view.findViewById(R.id.profProfNameTextView);
        homeworkNameEditText = view.findViewById(R.id.homeworkNameEditText);
        homeworkQuestionEditText = view.findViewById(R.id.homeworkQuestionEditText);
        createHomeworkButton = view.findViewById(R.id.createHomeworkButton);
        homeworkRecyclerView = view.findViewById(R.id.profCourseHomeworkRecyclerView);

        courseName = ProfessorCourseFragmentArgs.fromBundle(getArguments()).getCourseName();
        courseNameTextView.setText(courseName);
        profNameTextView.setText(Controller.getCourseProfessorName(courseName));

        homeworkRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        listItems = new ArrayList<>();
        listItems.addAll(Controller.getHomeworkListItems(courseName));
        adapter = new RecyclerViewAdapter(getActivity(), listItems, this);
        homeworkRecyclerView.setAdapter(adapter);

        createHomeworkButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                String homeworkName = homeworkNameEditText.getText().toString();
                String homeworkQuestion = homeworkQuestionEditText.getText().toString();
                if (homeworkName.equals("")) {
                    Toast toast = Toast.makeText(getContext(),
                            "Homework name can't be empty!", Toast.LENGTH_LONG);
                    toast.show();
                } else if (homeworkQuestion.equals("")) {
                    Toast toast = Toast.makeText(getContext(),
                            "Homework question can't be empty!", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    boolean result = Controller
                            .createHomeworkForCourse(courseName, homeworkName, homeworkQuestion);
                    if (result) {
                        Toast toast = Toast.makeText(getContext(),
                                "Homework created successfully!", Toast.LENGTH_LONG);
                        toast.show();
                        homeworkNameEditText.setText("");
                        homeworkQuestionEditText.setText("");
                        listItems.clear();
                        listItems.addAll(Controller.getHomeworkListItems(courseName));
                        adapter.notifyDataSetChanged();
                    } else {
                        Toast toast = Toast.makeText(getContext(),
                                "Homework already exists! Choose a different name.", Toast.LENGTH_LONG);
                        toast.show();
                        homeworkNameEditText.setText("");
                    }
                }
            }
        });
    }

    @Override
    public void onItemClicked(RecyclerViewAdapter.ListItem listItem) {
        // TODO: go to homework page
    }
}
