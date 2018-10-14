package com.example.adellahlouh.eschooladmin.RegisterAdmin;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    ProgressBar prog_name_school;

    Firebase mRoot;

    String nameLocation, nameSchool, location, arrayData;

    TextInputEditText edt_name_school, edt_name_location, edt_full_name, edt_major, edt_id, edt_birth, edt_age, edt_phone;




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



        edt_name_school = view.findViewById(R.id.edt_name_school);
        btn_name_school = view.findViewById(R.id.btn_name_school);
        prog_name_school = view.findViewById(R.id.prog_name_school);
        edt_name_location = view.findViewById(R.id.edt_name_location);
        edt_full_name = view.findViewById(R.id.edt_txt_full_name);
        edt_major = view.findViewById(R.id.edt_major);
        edt_id = view.findViewById(R.id.edt_id);
        edt_birth = view.findViewById(R.id.edt_txt_birth);
        edt_age = view.findViewById(R.id.edt_age);
        edt_phone = view.findViewById(R.id.edt_phone);



        mSchoolKey = new SchoolKey();


        btn_name_school.setOnClickListener(v -> {

            prog_name_school.setVisibility(View.VISIBLE);

            nameLocation = edt_name_location.getText().toString();
            nameSchool = edt_name_school.getText().toString();


            if (nameLocation.equals("Irbid")) {
                location = "Irbid";
                mSchoolKey.setSchoolKey(nameSchool, location
                        , edt_full_name.getText().toString()
                        , edt_major.getText().toString()
                        , edt_id.getText().toString()
                        , edt_birth.getText().toString()
                        , edt_age.getText().toString()
                        , edt_phone.getText().toString());


            } else if (nameLocation.equals("Amman")) {
                location = "Amman";
                mSchoolKey.setSchoolKey(nameSchool, location
                        , edt_full_name.getText().toString()
                        , edt_major.getText().toString()
                        , edt_id.getText().toString()
                        , edt_birth.getText().toString()
                        , edt_age.getText().toString()
                        , edt_phone.getText().toString());
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
//        mRecyclerView = view.findViewById(R.id.recycler_view_rigister);
//
//        layoutManager = new LinearLayoutManager(getContext());
//        mRecyclerView.setLayoutManager(layoutManager);
//        adapter = new RecyclerAdapterRigister() ;
//        mRecyclerView.setAdapter(adapter);000