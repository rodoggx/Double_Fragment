package com.example.simpledoublefragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class LeftFragment extends Fragment {

    private CallbackComponent mCallbackComponent;
    private Button mButtonEdwin;
    private Button mButtonGaudencio;

private ListView mListView;

    private ArrayList<String> dataArrayList = new ArrayList<String>();

    private ArrayAdapter<String> arrayAdapter;

    interface CallbackComponent {
        void buttonClicked(String name);
    }

    public LeftFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallbackComponent = (CallbackComponent) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_left, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mButtonEdwin = (Button) view.findViewById(R.id.f_left_btn);
        mButtonGaudencio = (Button) view.findViewById(R.id.f_left_btng);
        mListView = (ListView) view.findViewById(R.id.f_left_list);

        dataArrayList.add("Mike");
        dataArrayList.add("Chris");
        dataArrayList.add("Edwin");
        dataArrayList.add("John");
        dataArrayList.add("Karles");


        arrayAdapter =
                new ArrayAdapter<String>(
                        getContext(),
                        //android.R.layout.simple_list_item_1, used for default android layout, code below for custom
                        //android.R.layout.activity_list_item,
                        android.R.layout.simple_list_item_1,
                        dataArrayList);



        //attach adapter to listview
       mListView.setAdapter(arrayAdapter);

        mButtonEdwin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallbackComponent.buttonClicked("Edwin");
            }
        });

        mButtonGaudencio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallbackComponent.buttonClicked("Gaudencio");
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(), "Hello World " + i + " " + l, Toast.LENGTH_SHORT).show();
                mCallbackComponent.buttonClicked("String: " + i);
            }
        });

    }

}
