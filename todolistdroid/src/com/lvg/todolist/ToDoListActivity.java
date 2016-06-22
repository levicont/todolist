package com.lvg.todolist;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import com.lvg.todolist.fragments.SkeletonFragment;

import java.util.ArrayList;

public class ToDoListActivity extends Activity {


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.main);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.layout.skeletonfragment, new SkeletonFragment());
        ft.commit();

        final ArrayList<String> todoItems = new ArrayList<String>();
        final EditText txtEditAddItem = (EditText)findViewById(R.id.txtEditAddItem);
        final ListView itemListView = (ListView)findViewById(R.id.itemListView);
        final ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1 ,todoItems);

        itemListView.setAdapter(aa);
        txtEditAddItem.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ( event.getAction() == KeyEvent.ACTION_DOWN){

                    if ( keyCode == KeyEvent.KEYCODE_DPAD_CENTER ||
                            keyCode == KeyEvent.KEYCODE_ENTER){
                        todoItems.add(0, txtEditAddItem.getText().toString());
                        aa.notifyDataSetChanged();
                        txtEditAddItem.setText("");
                        return true;
                    }
                }

                return false;
            }
        });


    }


}
