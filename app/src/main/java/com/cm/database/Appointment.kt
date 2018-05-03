package com.cm.database

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.structure.BaseModel
import java.util.*

/**
 * Created by magicwand on 4/17/2018.
 */
@Table(database = CmDatabase::class)
class Appointment:BaseModel(){
    @PrimaryKey
    @Column
    var id : String?=null
    @Column
    var appointmentDate: Date?=null

}