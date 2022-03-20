package edu.sharif.hw_1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import Controller.Controller;
import Model.Professor;
import Model.User;
import edu.sharif.hw_1.databinding.FragmentFirstBinding;

public class CreateCourse extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button createCourse = view.findViewById(R.id.createcoursebutton1);
        TextView textView = view.findViewById(R.id.courseNameForCreation);
        createCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Controller.createNewCourse(textView.getText().toString(),
                        (Professor) User.getUserByUsername(User.onlineUser.getUsername()));
            }
        });
    }
}
