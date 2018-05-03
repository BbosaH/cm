package com.cm.activities

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View

import com.cm.R
import de.codecrafters.tableview.TableView
import com.cm.R.id.tableView
import de.codecrafters.tableview.model.TableColumnWeightModel
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter
import com.cm.R.id.tableView
import de.codecrafters.tableview.model.TableColumnDpWidthModel
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter
import com.cm.R.id.tableView
import com.dewarder.akommons.startActivity
import kotlinx.android.synthetic.main.activity_drug_administration.*


class DrugAdministration : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drug_administration)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val DATA_TO_SHOW = arrayOf(
                arrayOf("ABC/3TC/AVR", "15", "03","12","20"),
                arrayOf("Cotrim", "03", "0","0","0"),
                arrayOf("Dapson", "100", "0","0","84")
                )

        val tableView = findViewById(R.id.tableView) as TableView<Array<String>>
        val columnModel = TableColumnDpWidthModel(this, 5, 100)
        columnModel.setColumnWidth(0, 170)
        columnModel.setColumnWidth(1, 180)
        columnModel.setColumnWidth(2, 180)
        columnModel.setColumnWidth(3, 180);
        columnModel.setColumnWidth(4, 180);

        tableView.columnModel = columnModel
        tableView.setHeaderAdapter(SimpleTableHeaderAdapter(this, "Drug Name", "Last Visit Pills", "Pills Remaining","Pills Taken", "Pills Dispensed"))
        tableView.setDataAdapter(SimpleTableDataAdapter(this, DATA_TO_SHOW))
        drug_admin_next.setOnClickListener{
            startActivity<NextAppointment>()
        }
        drug_admin_go_to_next.setOnClickListener{
            startActivity<NextAppointment>()
        }

    }

}
