package com.example.sqlliteprogram;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    TextView lst;
    EditText s_id;
    EditText s_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lst = (TextView) findViewById(R.id.list);
        s_id = (EditText) findViewById(R.id.studentID);
        s_name = (EditText) findViewById(R.id.studentName);

    }
    public void addStudent (View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        int id = Integer.parseInt(s_id.getText().toString());
        String name = s_name.getText().toString();
        Student student = new Student(id,name);
        dbHandler.addHandler(student);
        s_id.setText("");
        s_name.setText("");
    }



    public void loadStudents(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        lst.setText(dbHandler.loadHandler());
        s_id.setText("");
        s_name.setText("");
    }

    public void deleteStudent(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null,
                null, 1);
        boolean result = dbHandler.deleteHandler(Integer.parseInt(
                s_id.getText().toString()));
        if (result) {
            s_id.setText("");
            s_name.setText("");
            lst.setText("Record Deleted");
        } else
            s_id.setText("No Match Found");
    }

    public void updateStudent(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null,
                null, 1);
        boolean result = dbHandler.updateHandler(Integer.parseInt(
                s_id.getText().toString()), s_name.getText().toString());
        if (result) {
            s_id.setText("");
            s_name.setText("");
            lst.setText("Record Updated");
        } else
            s_id.setText("Record not Found");
    }
}