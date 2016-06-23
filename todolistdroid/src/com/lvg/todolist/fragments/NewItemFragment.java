package com.lvg.todolist.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.lvg.todolist.R;

/**
 * Created by Victor on 23.06.2016.
 */
public class NewItemFragment extends Fragment {

    private OnNewItemAddedListener onNewItemAddedListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_item_fragment, container, false);

        final EditText editText = (EditText)view.findViewById(R.id.txtEditAddItem);
        editText.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ( event.getAction() == KeyEvent.ACTION_DOWN){

                    if ( keyCode == KeyEvent.KEYCODE_DPAD_CENTER ||
                            keyCode == KeyEvent.KEYCODE_ENTER){
                        String newItem = editText.getText().toString();
                        onNewItemAddedListener.onNewItemAdded(newItem);
                        editText.setText("");
                        return true;
                    }
                }

                return false;
            }
        });

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            onNewItemAddedListener = (OnNewItemAddedListener)activity;
        }catch (ClassCastException ex){
            throw new ClassCastException(activity.toString() + " must implement OnNewItemAddedListener!");
        }

    }

    public interface OnNewItemAddedListener {
        public void onNewItemAdded(String item);
    }
}
