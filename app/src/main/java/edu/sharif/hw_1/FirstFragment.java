package edu.sharif.hw_1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.gilecode.yagson.YaGson;
import com.gilecode.yagson.com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import Controller.Controller;
import Model.User;
import edu.sharif.hw_1.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState


    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

     public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button loginButton = view.findViewById(R.id.loginButton);
        Switch isProfessor = view.findViewById(R.id.isProfessor);

        sp = PreferenceManager.getDefaultSharedPreferences(getContext());

        editor = sp.edit();
        //editor.clear();

        editor.commit();
        System.out.println("here");
        System.out.println(sp.getString("users", ""));
        System.out.println(sp.getAll());

        YaGson yaGson = new YaGson();
        String data = sp.getString("users", "");
        Type type = new TypeToken<ArrayList<User>>() {

        }.getType();

        ArrayList<User> users = yaGson.fromJson(data, type);


         System.out.println("array");

         System.out.println(users);
         for (User user : users) {
             System.out.println("--------------------------------------------------------");
             System.out.println("" + user.toString());

             System.out.println("firstname : " + user.getFirstname());
             System.out.println("lastname : " + user.getLastname());
             System.out.println("username : " + user.getUsername());
             System.out.println("password : " + user.getPassword());

             System.out.println("--------------------------------------------------------");
         }

         User.setUsers(users);


         Controller.initializer(users);


        binding.RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isProfessor.isChecked()) {
                    NavHostFragment.findNavController(FirstFragment.this)
                            .navigate(R.id.action_FirstFragment_to_registerProfessor);
                } else {
                    NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.
                            action_FirstFragment_to_registerStudent);
                }
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this).
                        navigate(R.id.action_FirstFragment_to_login);
                
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}