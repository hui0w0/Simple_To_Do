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
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText ettask;
    Button btnadd;
    Button btndelete;
    Button btnclear;
    ListView lvtasks;
    Spinner spinneraddremove;
    ArrayList<String> altasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ettask = findViewById(R.id.editTaskList);
        btnadd = findViewById(R.id.buttonAdd);
        btndelete = findViewById(R.id.buttonDelete);
        btnclear = findViewById(R.id.buttonClear);
        lvtasks = findViewById(R.id.listViewTasks);
        spinneraddremove = findViewById(R.id.spinner1);
        altasks = new ArrayList<>();

        ArrayAdapter aatasks = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,altasks);
        lvtasks.setAdapter(aatasks);
        spinneraddremove.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                switch(position){
                    case 0:
                        btndelete.setEnabled(false);
                        btnadd.setEnabled(true);
                        ettask.setHint("Type in a new task");

                        btnadd.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String newtask = ettask.getText().toString();
                                altasks.add(newtask);
                                aatasks.notifyDataSetChanged();
                            }

                        });
                        break;
                    case 1:
                        btndelete.setEnabled(true);
                        btnadd.setEnabled(false);
                        ettask.setHint("Type in the index of the task to be removed");

                        btndelete.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                int taskindex = Integer.parseInt(ettask.getText().toString());

                                if(altasks.size() == 0){
                                    Toast.makeText(MainActivity.this,"You don't have any task to remove",Toast.LENGTH_SHORT).show();

                                }else if(altasks.size() != 0){
                                    for(int i = 0; i < altasks.size();i++){
                                        if(taskindex == i){
                                            altasks.remove(taskindex);
                                            aatasks.notifyDataSetChanged();
                                        }else{
                                            Toast.makeText(MainActivity.this,"Wrong index number",Toast.LENGTH_SHORT).show();

                                        }
                                    }
                                }
                            }
                        });
                        break;
                }
                btnclear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        altasks.clear();
                        aatasks.notifyDataSetChanged();
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }
}