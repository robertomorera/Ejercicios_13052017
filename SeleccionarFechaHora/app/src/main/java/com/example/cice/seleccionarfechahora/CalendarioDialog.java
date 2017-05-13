package com.example.cice.seleccionarfechahora;

import android.app.DatePickerDialog;
import android.app.Dialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by cice on 13/5/17.
 */

public class CalendarioDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Log.d("MENSAJE","FECHA SELECCIONADA "+year+" "+month+" "+dayOfMonth);


    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //return super.onCreateDialog(savedInstanceState);
        DatePickerDialog datePickerDialog=null;
        //Fecha seleccionada.
        Calendar c=Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DAY_OF_MONTH);

        datePickerDialog=new DatePickerDialog(getActivity(),this,year,month,day);
        return datePickerDialog;
    }
}
