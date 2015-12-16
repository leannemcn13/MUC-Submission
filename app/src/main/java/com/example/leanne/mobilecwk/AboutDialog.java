package com.example.leanne.mobilecwk;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by leanne on 16/12/2015.
 */
public class AboutDialog extends DialogFragment{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        //Use the builder class for convenient dialog construction
        AlertDialog.Builder AboutDialogue = new AlertDialog.Builder(getActivity());
        AboutDialogue.setMessage("Everything you need to know about the Scottish Premiership in one place. Get the latests news, check the League table, find stadiums or have fun. Click the menu to begin.")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        AboutDialogue.setTitle("About");
        AboutDialogue.setIcon(R.drawable.ic_action_about);
        //Create the AlertDialog object and return it
        return AboutDialogue.create();


    }
}
