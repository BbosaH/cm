package com.cm.activities

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.TextView

import com.cm.R
import com.cm.presenters.NextAppointmentPresenter

class NextAppointment : AppCompatActivity(),View.OnClickListener {

    lateinit var getDatePickerFragment :()->NextAppointmentPresenter.DatePickerDialogFragment

    companion object {
        lateinit var dateView: TextView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_appointment)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        dateView = findViewById(R.id.next_appointment_date) as TextView
        dateView.setOnClickListener(this)
        NextAppointmentPresenter(this).init()

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }
    override fun onClick(v: View) {
        val mDatePickerDialogFragment = getDatePickerFragment()
        mDatePickerDialogFragment.show(supportFragmentManager, "datePicker")

    }

}
