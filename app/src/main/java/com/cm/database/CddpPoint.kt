package com.cm.database

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.sql.language.SQLite
import com.raizlabs.android.dbflow.structure.BaseModel

/**
 * Created by magicwand on 4/16/2018.
 */
@Table(database = CmDatabase::class)
class CddpPoint : BaseModel(){

    @PrimaryKey
    @Column
    var id:String?= null
    @Column
    var name:String=""
    @Column
    var location : String=""
    @ForeignKey
    @Column
    var facility : Facility?=null;

    companion object {

        fun getAllCddpPoints():List<CddpPoint>{
            return SQLite.select().from(CddpPoint::class.java)
                    .queryList()
        }
    }



}