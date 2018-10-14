package com.example.adellahlouh.eschooladmin.FirebaseKey;

import com.firebase.client.Firebase;

public class SchoolKey {

    private Firebase mRoot;


    public void setSchoolKey(String nameSchool, String location, String full_name, String major, String id, String birth, String age, String phone) {
        mRoot = new Firebase("https://eschooladmin-2f828.firebaseio.com/Admin/School/Location/" + location + "/");
        Firebase childe = mRoot.child(location);
        childe.push();
        childe = mRoot.child(nameSchool);
        childe.setValue("");

        //key name school
        mRoot = new Firebase("https://eschooladmin-2f828.firebaseio.com/Admin/School/Location/" + location + "/" + nameSchool + "/");
        childe = mRoot.child(major);
        childe.push();

        // key Manager
        mRoot = new Firebase("https://eschooladmin-2f828.firebaseio.com/Admin/School/Location/" + location + "/" + nameSchool + "/" + "Manager/");

        //value name
        childe = mRoot.child("Age");
        childe.setValue(age);

        //value age
        childe = mRoot.child("Birth day");
        childe.setValue(birth);

        //value major
        childe = mRoot.child("Major");
        childe.setValue(major);

        //value ID
        childe = mRoot.child("ID");
        childe.setValue(id);

        //vlaue location
        childe = mRoot.child("Location");
        childe.setValue(location);

        //value Name
        childe = mRoot.child("Name");
        childe.setValue(full_name);

        //value number phone
        childe = mRoot.child("Number phone");
        childe.setValue(phone);

    }
}
