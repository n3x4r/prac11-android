package com.udl.android.menu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

//important https://www.youtube.com/watch?v=KOX8LtsGKuk
//https://developer.android.com/guide/topics/ui/menus.html?hl=es#FloatingContextMenu
// https://developer.android.com/guide/topics/resources/menu-resource.html?hl=es
//https://developer.android.com/guide/components/fragments.html?hl=es
/**
 * Created by Dark on 5/16/2017.
 */

public class Fragment4 extends Fragment {
    /*
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        TextView txt = (TextView)findViewById(R.id.text);

    }*/

    public Fragment4() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String text = getArguments().getString("NAME");
        View v  = inflater.inflate(R.layout.fragment_fragment4, container, false);
        TextView txt = (TextView)v.findViewById(R.id.text);
        registerForContextMenu(txt);
        txt.setText(text);
        return v;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch(item.getItemId()){
            case R.id.mc1:
                makeToast(item.getOrder());
                return true;
            case R.id.mc2:
                makeToast(item.getOrder());
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void makeToast(int order){
        String p = String.format(getString(R.string.select_menu1), order );
        Toast.makeText(getActivity(), p , Toast.LENGTH_LONG).show();
    }
}