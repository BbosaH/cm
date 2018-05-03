package com.cm.presenters

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import com.cm.activities.NextAppointment;
import khronos.Dates;
import kotlinx.android.synthetic.main.content_next_appointment.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by magicwand on 2/19/2018.
 */
class NextAppointmentPresenter(val myActivity : NextAppointment){
    var switched_to_art_model :String ="No";
    var reffered_t_facility :String ="No";

    fun init (){
        fillSpinners();
        myActivity.getDatePickerFragment={
            DatePickerDialogFragment()
        }


    }
    private fun fillSpinners (){

        val spinner_art_model = myActivity.art_model_spinner
        spinner_art_model.setItems("No", "Yes")
        spinner_art_model.setOnItemSelectedListener { view, position, id, item -> switched_to_art_model=item.toString() }

        val spinner_referal = myActivity.refferal_spinner
        spinner_referal.setItems("No", "Yes")
        spinner_referal.setOnItemSelectedListener { view, position, id, item -> reffered_t_facility=item.toString() }

    }

    class DatePickerDialogFragment() : DialogFragment(), DatePickerDialog.OnDateSetListener {


        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val date_dialog = DatePickerDialog(getActivity(), this, year, month, day)
            date_dialog.datePicker.maxDate= Dates.today.time
            return date_dialog;

        }

        override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int) {

            val calendar = Calendar.getInstance()
            calendar.set(year, monthOfYear, dayOfMonth)
            val format = SimpleDateFormat("dd/MM/yyyy")
            NextAppointment.dateView!!.setText(format.format(calendar.time))

        }


    }
}