package com.cm.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import com.cm.R
import android.widget.Toast
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import com.cm.presenters.FormScreenGeneralPresenter
import kotlinx.android.synthetic.main.content_form_screen_general.*


class FormScreenGeneral : AppCompatActivity(),View.OnClickListener {

    companion object {
        lateinit var dateView: TextView
    }

    lateinit var searchView: SearchView

    lateinit var onSearched: (text: String) -> Unit
    lateinit var getDatePickerFragment :()->FormScreenGeneralPresenter.DatePickerDialogFragment
    lateinit var  goToTbAssessment  : ()->Unit;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_screen_general)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        dateView = findViewById(R.id.visit_date) as TextView
        dateView.setOnClickListener(this)
        FormScreenGeneralPresenter(this).init()

        searchView = findViewById(R.id.searchView) as SearchView
        searchView.queryHint = "Search client ..."
        searchView.onActionViewExpanded();

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(baseContext, query, Toast.LENGTH_LONG).show()
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                Toast.makeText(baseContext, newText, Toast.LENGTH_LONG).show()
                return false
            }

        })

        searchView.setOnCloseListener { true }

        pres_save.setOnClickListener{
            goToTbAssessment();

        }
    }


    override fun onClick(v: View) {

        val mDatePickerDialogFragment = getDatePickerFragment()
        mDatePickerDialogFragment.show(supportFragmentManager, "datePicker")

    }





    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        return if (id == R.id.menu_search) {
            true
        } else super.onOptionsItemSelected(item)

    }



}
