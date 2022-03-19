package edu.sharif.hw_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class StudentHomeworkFragment extends Fragment {
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView questionTextView = view.findViewById(R.id.homeworkQuestionTextView);
        EditText answerEditText = view.findViewById(R.id.homeworkAnswerEditText);
        Button submitButton = view.findViewById(R.id.answerSubmitButton);

        // TODO: set questionTextView / Format: "CourseName + TAB + HomeworkName + \n + Question"

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = answerEditText.getText().toString();
                // TODO: save answer
            }
        });

    }
}
