package com.cm.database

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.structure.BaseModel

/**
 * Created by magicwand on 4/17/2018.
 */
@Table(database = CmDatabase::class)
class Drug :BaseModel(){
    @PrimaryKey
    @Column
    var id : String?=null

    @Column
    var name : String?=null;

    @Column
    var drugCode : String?=null

    @Column
    var drugDescription : String ?=null;

}