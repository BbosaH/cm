package com.cm.database

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.sql.language.SQLite
import com.raizlabs.android.dbflow.structure.BaseModel

/**
 * Created by magicwand on 4/15/2018.
 */
@Table(database = CmDatabase::class)
class Facility : BaseModel(){

    @Column
    @PrimaryKey
    var id : String?=null;

    @Column
    var name: String?=null;
    @Column
    var location :String?=null;

    companion object {
        fun getAllFacilities():List<Facility>{
           return SQLite.select().from(Facility::class.java)
                    .queryList()
        }
    }



}