package com.example.adellahlouh.eschooladmin.RegisterAdmin;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.adellahlouh.eschooladmin.FirebaseKey.SchoolKey;
import com.example.adellahlouh.eschooladmin.R;
import com.firebase.client.Firebase;

import java.util.Objects;


public class RigisterFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    Button btn_name_school;
    EditText edt_name_school, edt_name_location;
    ProgressBar prog_name_school;

    Firebase mRoot;

    String nameLocation, nameSchool;

    SchoolKey mSchoolKey;
//    RecyclerView mRecyclerView ;
//    RecyclerView.LayoutManager layoutManager ;
//    RecyclerView.Adapter adapter ;





    public RigisterFragment() {
    }


    public static RigisterFragment newInstance(String param1, String param2) {
        RigisterFragment fragment = new RigisterFragment();
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
        Firebase.setAndroidContext(Objects.requireNonNull(getContext()));

        mRoot = new Firebase("https://eschooladmin-2f828.firebaseio.com/Admin/School/Location");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_rigister, container, false);

//        mRecyclerView = view.findViewById(R.id.recycler_view_rigister);
//
//        layoutManager = new LinearLayoutManager(getContext());
//        mRecyclerView.setLayoutManager(layoutManager);
//        adapter = new RecyclerAdapterRigister() ;
//        mRecyclerView.setAdapter(adapter);

        edt_name_school = view.findViewById(R.id.edt_name_school);
        btn_name_school = view.findViewById(R.id.btn_name_school);
        prog_name_school = view.findViewById(R.id.prog_name_school);
        edt_name_location = view.findViewById(R.id.edt_name_location);

        mSchoolKey = new SchoolKey();


        btn_name_school.setOnClickListener(v -> {


            nameLocation = edt_name_location.getText().toString();
            nameSchool = edt_name_school.getText().toString();

            if (nameLocation.equals("Irbid")) {
                mSchoolKey.setSchoolKeyIrbid(nameSchool);
            } else if (nameLocation.equals("Amman")) {
                mSchoolKey.setSchoolKeyAmman(nameSchool);
            }
        });
        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
