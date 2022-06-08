package sg.edu.rp.c346.id21016163.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etntask;
    Button btnadd;
    Button btnclear;
    ListView lvtasks;
    ArrayList<String> altasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etntask = findViewById(R.id.editTaskList);
        btnadd = findViewById(R.id.buttonAdd);
        btnclear = findViewById(R.id.buttonClear);
        lvtasks = findViewById(R.id.listViewTasks);

        altasks = new ArrayList<String>();


        ArrayAdapter aatask = new ArrayAdapter(this, android.R.layout.simple_list_item_1,altasks);
        lvtasks.setAdapter(aatask);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tasks = etntask.getText().toString();

                altasks.add(tasks);
                aatask.notifyDataSetChanged();

            }
        });
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                altasks.clear();
                aatask.notifyDataSetChanged();
            }
        });


    }
}