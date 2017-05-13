package com.example.cice.seleccionarfechahora;

import android.app.Dialog;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by cice on 13/5/17.
 */

public class HoraDialog extends DialogFragment implements TimePickerDialog.OnTimeSetListener {


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Log.d("MENSAJE","HORA SELECCIONADA= "+hourOfDay+":"+minute);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //return super.onCreateDialog(savedInstanceState);
        Dialog timePicker=null;

        Calendar c=Calendar.getInstance();
        int hour=c.get(Calendar.HOUR_OF_DAY);
        int minute=c.get(Calendar.MINUTE);
        timePicker=new TimePickerDialog(getActivity(),this,hour,minute,true);

        return timePicker;
    }
}
