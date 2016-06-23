package com.lvg.todolist;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import com.lvg.todolist.fragments.ItemsListFragment;
import com.lvg.todolist.fragments.NewItemFragment;
import com.lvg.todolist.fragments.SkeletonFragment;

import java.util.ArrayList;

public class ToDoListActivity extends Activity implements NewItemFragment.OnNewItemAddedListener {

    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> allItems;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.main);
        FragmentManager fragmentManager = getFragmentManager();

        ItemsListFragment fragment = (ItemsListFragment)fragmentManager.findFragmentById(R.id.ItemsListFragment);

        allItems = new ArrayList<String>();

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, allItems);

        fragment.setListAdapter(arrayAdapter);

    }

    @Override
    public void onNewItemAdded(String item) {
        allItems.add(0,item);
        arrayAdapter.notifyDataSetChanged();
    }
}
