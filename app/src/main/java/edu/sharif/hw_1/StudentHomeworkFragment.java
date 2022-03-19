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

import Controller.Controller;

public class StudentHomeworkFragment extends Fragment {
    private String courseName;
    private String homeworkName;
    TextView courseNameTextView;
    TextView homeworkNameTextView;
    TextView questionTextView;
    EditText answerEditText;
    Button submitButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_homework, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        courseNameTextView = view.findViewById(R.id.courseNameInHomeworkTextView);
        homeworkNameTextView = view.findViewById(R.id.homeworkNameTextView);
        questionTextView = view.findViewById(R.id.homeworkQuestionTextView);
        answerEditText = view.findViewById(R.id.homeworkAnswerEditText);
        submitButton = view.findViewById(R.id.answerSubmitButton);

        courseName = StudentHomeworkFragmentArgs.fromBundle(getArguments()).getCourseName();
        homeworkName = StudentHomeworkFragmentArgs.fromBundle(getArguments()).getHomeworkName();
        courseNameTextView.setText(courseName);
        homeworkNameTextView.setText(homeworkName);
//        questionTextView.setText(Controller.getHomeworkQuestion(courseName, homeworkName));

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = answerEditText.getText().toString();
                boolean result = Controller.setAnswerForOnlineUser(courseName, homeworkName, answer);
                if (result) {
                    Toast toast = Toast.makeText(getContext(),
                            "Answer submitted successfully!", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(getContext(),
                            "An error occurred!", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }
}
