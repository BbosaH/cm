package com.cm.presenters

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.widget.DatePicker
import com.cm.Utilities.longToast
import com.cm.activities.DrugAdministration
import com.cm.activities.FemalePatientAssessment
import com.cm.activities.FormScreenGeneral
import com.dewarder.akommons.startActivity
import khronos.Dates
import kotlinx.android.synthetic.main.content_female_patient_asessment.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by magicwand on 4/24/2018.
 */
class FemalePatientAssessmentPresenter(val myActivity : FemalePatientAssessment){
     var  family_planning_method:String?=null
    fun init(){
        fillSpinners()
        myActivity.goToDrugAdmin ={ prevBundle:Bundle->
            if(family_planning_method!=null){
                goToDrugAdmin(prevBundle,family_planning_method!!);
            }else{
                myActivity.longToast("Please select al fields")
            }

        }
        myActivity.getDatePickerFragment={
            DatePickerDialogFragment()
        }
    }

    private fun goToDrugAdmin(bundle: Bundle,family_planning_method:String){
        bundle.putString("family_planning_method",family_planning_method)
        myActivity.startActivity<DrugAdministration>{
           putExtras(bundle)
        }
    }
    private fun fillSpinners(){

        val spinner_family_planning = myActivity.fp_spinner
        spinner_family_planning.setItems("---select---","Implants", "Condoms","UDI")
        spinner_family_planning.setOnItemSelectedListener { view, position, id, item ->
            if(!item.toString().startsWith("--")){
                family_planning_method=item.toString()
            }else{
                family_planning_method=null;
            }

        }

    }

    class DatePickerDialogFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {


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
            FemalePatientAssessment.dateView!!.setText(format.format(calendar.time))

        }


    }
}