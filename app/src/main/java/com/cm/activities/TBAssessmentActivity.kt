package com.cm.activities

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.DatePicker
import android.widget.TextView

import com.cm.R
import com.cm.presenters.TBAssessmentPresenter
import com.dewarder.akommons.startActivity
import com.jaredrummler.materialspinner.MaterialSpinner
import khronos.Dates
import khronos.month
import khronos.plus
import kotlinx.android.synthetic.main.content_tb_assessment.*
import java.util.*

class TBAssessmentActivity : AppCompatActivity() {

    lateinit var goToPatientAssessmentActivity : (bundle:Bundle)->Unit;

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cb_assessment)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        TBAssessmentPresenter(this).init();
        tb_assessment_next.setOnClickListener{ goToPatientAssessmentActivity(intent.extras) }
    }



}
