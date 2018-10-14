package com.example.adellahlouh.eschooladmin.FirebaseKey;

import com.firebase.client.Firebase;

public class SchoolKey {

    private Firebase mRoot;


    public void setSchoolKeyIrbid(String nameSchool) {
        mRoot = new Firebase("https://eschooladmin-2f828.firebaseio.com/Admin/School/Location/Irbid/");
        Firebase childe = mRoot.child("Irbid");
        childe.push();
        childe = mRoot.child(nameSchool);
        childe.setValue("");

        //key name school
        mRoot = new Firebase("https://eschooladmin-2f828.firebaseio.com/Admin/School/Location/Irbid/" + nameSchool + "/");
        childe = mRoot.child("Manager");
        childe.push();

        // key Manager
        mRoot = new Firebase("https://eschooladmin-2f828.firebaseio.com/Admin/School/Location/Irbid/" + nameSchool + "/" + "Manager/");

        //value name
        childe = mRoot.child("Age");
        childe.setValue("21");

        //value age
        childe = mRoot.child("Birth day");
        childe.setValue("17/7/1996");

        //value major
        childe = mRoot.child("Major");
        childe.setValue("Manager");

        //value ID
        childe = mRoot.child("ID");
        childe.setValue("9961049550");

        //vlaue location
        childe = mRoot.child("Location");
        childe.setValue("Irbid");

        //value Name
        childe = mRoot.child("Name");
        childe.setValue("Adel");

        //value number phone
        childe = mRoot.child("Number phone");
        childe.setValue("0789461941");

    }

    public void setSchoolKeyAmman(String nameSchool) {

        mRoot = new Firebase("https://eschooladmin-2f828.firebaseio.com/Admin/School/Location/Amman/");
        Firebase childe = mRoot.child("Irbid");
        childe.push();
        childe = mRoot.child(nameSchool);
        childe.setValue("");

        //key name school
        mRoot = new Firebase("https://eschooladmin-2f828.firebaseio.com/Admin/School/Location/Amman/" + nameSchool + "/");
        childe = mRoot.child("Manager");
        childe.push();

        // key Manager
        mRoot = new Firebase("https://eschooladmin-2f828.firebaseio.com/Admin/School/Location/Amman/" + nameSchool + "/" + "Manager/");

        //value name
        childe = mRoot.child("Age");
        childe.setValue("21");

        //value age
        childe = mRoot.child("Birth day");
        childe.setValue("17/7/1996");

        //value major
        childe = mRoot.child("Major");
        childe.setValue("Manager");

        //value ID
        childe = mRoot.child("ID");
        childe.setValue("9961049550");

        //vlaue location
        childe = mRoot.child("Location");
        childe.setValue("Irbid");

        //value Name
        childe = mRoot.child("Name");
        childe.setValue("Adel");

        //value number phone
        childe = mRoot.child("Number phone");
        childe.setValue("0789461941");


    }


}
