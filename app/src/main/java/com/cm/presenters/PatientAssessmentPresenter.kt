package com.cm.presenters

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.widget.DatePicker
import com.cm.Utilities.longToast
import com.cm.activities.FemalePatientAssessment
import com.cm.activities.FormScreenGeneral
import com.cm.activities.PatientAssessmentActivity
import com.dewarder.akommons.startActivity
import khronos.Dates
import kotlinx.android.synthetic.main.content_patient_assessment.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by magicwand on 4/24/2018.
 */
class PatientAssessmentPresenter(val myActivity : PatientAssessmentActivity){

    var  complaints : String="No"
    var  got_sick : String="No"
    var  got_treatment:String="No"
    var  got_where_got_treatment:String="No"


    fun init(){
        fillSpinners();

        myActivity.goToFemaleAssessmentActivity= { bundle ->

                goToFemaleAssessmentActivity(bundle,complaints,got_sick,got_treatment,got_where_got_treatment);
                myActivity.patient_assess_error.text=""


        }
    }


    private fun  goToFemaleAssessmentActivity(bundle: Bundle, complaints:String,
                                              got_sick:String, got_treatment:String,
                                              got_where_got_treatment:String){

        bundle.putString("complaints",complaints)
        bundle.putString("got_sick",got_sick)
        bundle.putString("got_treatment",got_treatment)
        bundle.putString("got_where_got_treatment",got_where_got_treatment)
        myActivity.startActivity<FemalePatientAssessment>(){
            putExtras(bundle)
        }
    }

    private fun fillSpinners(){

        val spinner_complaints = myActivity.complaints_spinner
        spinner_complaints.setItems("No", "Yes");
        spinner_complaints.setOnItemSelectedListener { view, position, id,
                                                       item ->
            complaints=item.toString()
        }

        val spinner_got_sick = myActivity.got_sick_spinner
        spinner_got_sick.setItems("No", "Yes")
        spinner_got_sick.setOnItemSelectedListener { view, position, id, item -> got_sick=item.toString() }

        val spinner_got_treatment = myActivity.got_treatment_spinner
        spinner_got_treatment.setItems("No", "Yes")
        spinner_got_treatment.setOnItemSelectedListener { view, position, id, item -> got_treatment = item.toString() }

        val spinner_where_treatment = myActivity.where_treatment_spinner
        spinner_where_treatment.setItems("No", "Yes")
        spinner_where_treatment.setOnItemSelectedListener { view, position, id, item -> got_where_got_treatment=item.toString() }
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
            FormScreenGeneral.dateView!!.setText(format.format(calendar.time))

        }


    }






}