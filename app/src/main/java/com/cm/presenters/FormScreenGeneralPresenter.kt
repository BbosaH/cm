package com.cm.presenters

/**
 * Created by magicwand on 2/19/2018.
 */
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import com.dewarder.akommons.startActivity
import android.widget.DatePicker;
import com.cm.activities.FormScreenGeneral;
import com.cm.activities.TBAssessmentActivity
import com.cm.database.CddpPoint;
import com.cm.database.Facility;
import com.cm.database.User;
import khronos.Dates;
import kotlinx.android.synthetic.main.content_form_screen_general.*;
import java.text.SimpleDateFormat;
import java.util.*;

class FormScreenGeneralPresenter(val formScreenGeneral : FormScreenGeneral){


     var  cddpPoint : String?=null
     var  dateOfRecord : String?=null
     var  peerleader : String?=null
     var  clientNumber : String?=null

    fun init (){

        formScreenGeneral.getDatePickerFragment={
            DatePickerDialogFragment()
        }
        dateOfRecord = formScreenGeneral.visit_date.text.toString()
        println("The assigned of record ${dateOfRecord}")
        var facility_names : List<String?> = Facility.getAllFacilities().map {
            it.name
        };
        print(facility_names)
        loadFacilities(){
            item:String -> cddpPoint = item
            loadPeerLeaders(){
                item:String -> peerleader =item


                clientNumber = "07849339563993"
                println("The cddp point ${cddpPoint}")
                println("The peer leader ${peerleader}")
                println("The date of record ${dateOfRecord}")
                if(cddpPoint !=null && peerleader!=null && dateOfRecord!=null){
                    val bundle = startBundle (cddpPoint!!,peerleader!!,dateOfRecord!!,clientNumber!!)
                    formScreenGeneral.goToTbAssessment = {
                        formScreenGeneral.startActivity<TBAssessmentActivity>(){
                            putExtras(bundle)
                        }


                    }
                }
            };

        };




        formScreenGeneral.onSearched = {

        }





    }
    private fun startBundle (cddpPoint:String,
                             peerleader:String,
                             dateOfRecord:String,
                             clientNumber:String ):Bundle{

        val bundle = Bundle()
        bundle.putString("cddpPoint_id",cddpPoint)
        bundle.putString("peerleader",peerleader)
        bundle.putString("dateOfRecord",dateOfRecord);
        bundle.putString("clientNumber",clientNumber);
        return bundle
    }

    private fun loadPeerLeaders(callback : (item:String)->Unit){
        var peer_leaders : MutableList<User> = User.getPeerLeaders("peer leader")
        var peer_leader_names : List<String> = peer_leaders.map { it.firstName+' '+it.lastName }
        formScreenGeneral.peer_leader_spinner.setItems(peer_leader_names);
        formScreenGeneral.peer_leader_spinner.setOnItemSelectedListener { view, position, id, item ->
            callback(item.toString())
        }
    }

    private  fun loadFacilities(callback: (item: String) -> Unit){

        var facilities = Facility.getAllFacilities();
        var cddps = CddpPoint.getAllCddpPoints();
        var facility_names : List<String?> = facilities.map { it.name };
        formScreenGeneral.facility_spinner.setItems(facility_names);
        formScreenGeneral.facility_spinner.setOnItemSelectedListener { view, position, id, item ->
            var facility_id = facilities.filter{it.name==item}.map { it.id  }.reduce {acc, s ->acc  }
            var facility_cddps = cddps.filter { it.facility!!.id == facility_id }
            formScreenGeneral.cddp_point_spinner.setItems(facility_cddps.map { it.name })
            formScreenGeneral.cddp_point_spinner.setOnItemSelectedListener { view, position, id, item ->
                var cddp_id = facility_cddps.filter{it.name==item}.map { it.id  }.reduce {acc, s ->acc  }
                Snackbar.make(view, "Clicked ${id} position ${position} id ${facility_id}" + item, Snackbar.LENGTH_LONG).show();
                callback(cddp_id.toString())

            }
        }

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