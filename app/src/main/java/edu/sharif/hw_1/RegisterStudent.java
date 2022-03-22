package edu.sharif.hw_1;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gilecode.yagson.YaGson;

import java.util.ArrayList;

import Controller.Controller;
import Model.User;


public class RegisterStudent extends Fragment {


    private SharedPreferences sp;
    private SharedPreferences.Editor editor;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register_student, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button registerButton = view.findViewById(R.id.registerbuttonstudent);
        TextView username = view.findViewById(R.id.usernamestudent);
        TextView firstname = view.findViewById(R.id.firstnamestudent);
        TextView lastname = view.findViewById(R.id.lastnamestudent);
        TextView password = view.findViewById(R.id.passwordstudent);
        TextView studentId = view.findViewById(R.id.studentid);


        registerButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                if (Controller.checkUsernameForRegister(username.getText().toString())) {
                    if (Controller.isNumeric(studentId.getText().toString())) {
                        ArrayList<User> users = Controller.addStudent(firstname.getText().toString(), lastname.getText().
                                        toString(),
                                studentId.getText().toString(), username.getText().toString(),
                                password.getText().toString());

                        YaGson yaGson = new YaGson();
                        String data = yaGson.toJson(users);

                        Toast toast = Toast.makeText(getContext(), "register account was " +
                                "successfully", Toast.LENGTH_SHORT);

                        sp = PreferenceManager.getDefaultSharedPreferences(getContext());
                        editor = sp.edit();
                        editor.putString("users", data);
                        editor.commit();

                        toast.show();
                        
                        NavHostFragment.findNavController(RegisterStudent.this)
                                .navigate(R.id.action_registerStudent_to_login);
                    } else {
                        Toast toast = Toast.makeText(getContext(), "student number should contains only" +
                                "numbers", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                } else {
                    Toast toast = Toast.makeText(getContext(), "this username is already " +
                                    "exist",
                            Toast.LENGTH_SHORT);
                    toast.show();
                }

            }

        });

    }
}
