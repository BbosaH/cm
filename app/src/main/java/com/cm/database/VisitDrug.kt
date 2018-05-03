package com.cm.database

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.structure.BaseModel

/**
 * Created by magicwand on 4/18/2018.
 */
@Table(database = CmDatabase::class)
class VisitDrug : BaseModel() {
    @PrimaryKey
    @Column
    var id : String ? =null

    @Column
    @ForeignKey
    var drug : Drug ? =null

    @Column
    @ForeignKey
    var visit : Visit? = null;

    @Column
    var lastVisitPills : Int =0;
    @Column
    var pillsRemaining : Int =0;

    @Column
    var pillsTaken : Int=0;

    @Column
    var pillsDispenced : Int =0;

}