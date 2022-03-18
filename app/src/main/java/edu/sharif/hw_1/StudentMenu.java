package edu.sharif.hw_1;

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

import java.util.ArrayList;

import Controller.Controller;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StudentMenu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudentMenu extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StudentMenu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StudentMenu.
     */
    // TODO: Rename and change types and number of parameters
    public static StudentMenu newInstance(String param1, String param2) {
        StudentMenu fragment = new StudentMenu();
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
        return inflater.inflate(R.layout.fragment_student_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText classIdTextView = view.findViewById(R.id.studentCourseEditText);
        Button joinButton = view.findViewById(R.id.studentJoinClassButton);
        Button enterButton = view.findViewById(R.id.studentJoinClassButton);
        RecyclerView courseRecyclerView;
        RecyclerViewAdapter adapter;

        courseRecyclerView = view.findViewById(R.id.studentCourseRecyclerView);
        courseRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ArrayList<String> names = Controller.getCourseNames(username);
//        names.add("Parsa");
//        names.add("Mohammad");
        adapter = new RecyclerViewAdapter(getActivity(), names);
        courseRecyclerView.setAdapter(adapter);
//        names.add("Ali");
//        adapter.notifyDataSetChanged();

    }
}