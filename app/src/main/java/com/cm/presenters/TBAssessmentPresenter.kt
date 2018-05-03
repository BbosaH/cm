package com.cm.presenters

import android.os.Bundle
import android.support.design.widget.Snackbar
import com.cm.R
import com.cm.activities.PatientAssessmentActivity
import com.cm.activities.TBAssessmentActivity
import com.dewarder.akommons.startActivity
import com.jaredrummler.materialspinner.MaterialSpinner
import kotlinx.android.synthetic.main.content_tb_assessment.*

/**
 * Created by magicwand on 4/24/2018.
 */
class TBAssessmentPresenter(val myactivity : TBAssessmentActivity) {


    var  has_cough : String="No"
    var  has_fever : String="No"
    var  has_weight_loss:String="No"
    var  has_sweat:String="No"

    fun init(){
           fillSpinners ();
           myactivity.goToPatientAssessmentActivity ={ prevbundle : Bundle ->
               goToPatientAssessmentActivity(prevbundle,has_cough,has_fever,has_weight_loss,has_sweat)

           }
    }

    private fun  goToPatientAssessmentActivity(bundle:Bundle,has_cough:String,
                                                has_fever:String,has_weight_loss:String,
                                                night_sweat:String){
        bundle.putString("has_cough",has_cough);
        bundle.putString("has_fever",has_fever);
        bundle.putString("has_weight_loss",has_weight_loss);
        bundle.putString("night_sweat",night_sweat);

        myactivity.startActivity<PatientAssessmentActivity>(){ putExtras(bundle) };
    }

    private fun fillSpinners (){

        val spinner_has_cough = myactivity.has_cough_spinner
        spinner_has_cough.setItems("No", "Yes")
        spinner_has_cough.setOnItemSelectedListener { view, position, id, item -> has_cough=item.toString() }

        val spinner_has_fever = myactivity.has_fever_spinner
        spinner_has_fever.setItems("No", "Yes")
        spinner_has_fever.setOnItemSelectedListener { view, position, id, item -> has_fever=item.toString() }

        val spinner_has_weight_loss = myactivity.weight_loss_spinner
        spinner_has_weight_loss.setItems("No", "Yes")
        spinner_has_weight_loss.setOnItemSelectedListener { view, position, id, item -> has_weight_loss=item.toString() }

        val spinner_night_sweat = myactivity.sweat_spinner
        spinner_night_sweat.setItems("No", "Yes")
        spinner_night_sweat.setOnItemSelectedListener { view, position, id, item -> has_sweat=item.toString() }
    }

}