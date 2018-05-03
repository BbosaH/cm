package com.cm.activities

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.TextView

import com.cm.R
import com.cm.presenters.FemalePatientAssessmentPresenter
import com.cm.presenters.FormScreenGeneralPresenter
import com.dewarder.akommons.startActivity
import kotlinx.android.synthetic.main.content_female_patient_asessment.*

class FemalePatientAssessment : AppCompatActivity() ,View.OnClickListener{

    lateinit var goToDrugAdmin : (bundle:Bundle)->Unit
    lateinit var getDatePickerFragment :()->FemalePatientAssessmentPresenter.DatePickerDialogFragment
    companion object {
        lateinit var dateView: TextView
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_female_patient_asessment)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        dateView = findViewById(R.id.last_period_date) as TextView
        dateView.setOnClickListener(this)
        FemalePatientAssessmentPresenter(this).init()

        female_patient_assessment_next.setOnClickListener{
            startActivity<DrugAdministration>()
            goToDrugAdmin(intent.extras)
        }
    }
    override fun onClick(v: View) {
        val id = v.id
        val mDatePickerDialogFragment = getDatePickerFragment()
        mDatePickerDialogFragment.show(supportFragmentManager, "datePicker")

    }


}
