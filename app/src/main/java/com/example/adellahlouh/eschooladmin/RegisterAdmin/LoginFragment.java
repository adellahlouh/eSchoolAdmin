package com.example.adellahlouh.eschooladmin.RegisterAdmin;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.adellahlouh.eschooladmin.R;
import com.google.firebase.auth.FirebaseAuth;

public class LoginFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;



    Button btn_login;
    EditText edt_email, edt_password;
    ProgressBar mProgressBar ;
    String email, password;

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthStateListener ;


    private OnFragmentInteractionListener mListener;

    public LoginFragment() {
    }


    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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
       View view =inflater.inflate(R.layout.fragment_login, container, false);

        btn_login = view.findViewById(R.id.btn_login);
        edt_email = view.findViewById(R.id.edt_Email);
        edt_password = view.findViewById(R.id.edt_Pass);
        mProgressBar = view.findViewById(R.id.progress_circular);

        mAuth = FirebaseAuth.getInstance();

        mAuthStateListener = firebaseAuth -> {

            if(firebaseAuth.getCurrentUser() != null){

                mProgressBar.setVisibility(View.GONE);

                Fragment fragment = new RigisterFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.contentFragment, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
        };

        //هاي شكل من اشكال OnClick اسمها لمدا فائدتها بتقدر تختصر من الكود و بتقدر تسكرها كامله
        btn_login.setOnClickListener(v -> {

            StartLogin();
            mProgressBar.setVisibility(View.VISIBLE);
        });


       return view;
    }

    private void StartLogin() {

        email = edt_email.getText().toString();
        password = edt_password.getText().toString();


        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {

            Toast.makeText(getContext(), "Fields are empty ", Toast.LENGTH_SHORT).show();

        } else {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {

                if (!task.isSuccessful()) {
                    Toast.makeText(getContext(), "Sign in problem", Toast.LENGTH_SHORT).show();
                }


            });

        }
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthStateListener);

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
