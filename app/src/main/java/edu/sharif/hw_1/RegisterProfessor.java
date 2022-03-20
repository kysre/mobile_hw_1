package edu.sharif.hw_1;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gilecode.yagson.YaGson;

import java.util.ArrayList;

import Controller.Controller;
import Model.Professor;
import Model.User;


public class RegisterProfessor extends Fragment {

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegisterProfessor() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static RegisterProfessor newInstance(String param1, String param2) {
        RegisterProfessor fragment = new RegisterProfessor();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registerprofessor, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button registerButton = view.findViewById(R.id.button);
        EditText firstName = view.findViewById(R.id.firstname);
        EditText lastName = view.findViewById(R.id.lastname);
        EditText university = view.findViewById(R.id.universityname);
        EditText username = view.findViewById(R.id.username);
        EditText password = view.findViewById(R.id.password);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Controller.checkUsernameForRegister(username.getText().toString())) {
                    ArrayList<User> professors = Controller.addProfessor(firstName.getText().toString(), lastName.getText().toString(),
                            university.getText().toString(), username.getText().toString()
                            , password.getText().toString());
                    YaGson yaGson = new YaGson();
                    String data = yaGson.toJson(professors);
                    Toast toast=Toast.makeText(getContext(),"register was successfully",
                            Toast.LENGTH_SHORT);
                    sp = PreferenceManager.getDefaultSharedPreferences(getContext());
                    editor = sp.edit();
                    editor.putString("users", data);
                    editor.commit();

                    toast.show();
                }else{
                    Toast toast=Toast.makeText(getContext(),"this username is already exist",
                            Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

    }

}