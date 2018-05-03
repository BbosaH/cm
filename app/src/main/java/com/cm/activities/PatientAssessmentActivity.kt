package com.cm.activities

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View

import com.cm.R
import com.cm.presenters.PatientAssessmentPresenter
import com.dewarder.akommons.startActivity
import com.jaredrummler.materialspinner.MaterialSpinner
import kotlinx.android.synthetic.main.content_patient_assessment.*

class PatientAssessmentActivity : AppCompatActivity() {

    lateinit var goToFemaleAssessmentActivity : (bundle:Bundle)->Unit;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_assessment)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        PatientAssessmentPresenter(this).init();

        patient_assessment_next.setOnClickListener{
            goToFemaleAssessmentActivity(intent.extras)
        }
    }

}
