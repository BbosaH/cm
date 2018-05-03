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
class Visit : BaseModel(){

    @PrimaryKey
    @Column
    var id : String?=null

    @ForeignKey
    @Column
    var cddpPoint : CddpPoint?=null;

    @Column
    var visitDate : Date?=null;

    @Column
    var peerLeader : String?=null;

    @Column
    var clientNumber : String ? =null;

    //tb
    @Column
    var TBHasCough : String?=null;

    @Column
    var TBHasFever : String? = null;
    @Column
    var TBHasNoticeableWeight : String?=null;

    @Column
    var TBHasExcessiveNightSweat : String?=null;

    //patient assessment
    @Column
    var PatientAnyComplaintsToday : String?=null

    @Column
    var PatientGotSickAfterLastVisit : String?=null
    @Column
    var PatientDidYouGetTreatment : String?=null;
    @Column
    var PatientWhereDidYouGetTreatment : String?=null;
    //female
    @Column
    var FemaleLastDateOfPeriods : Date?=null;
    @Column
    var FemaleFamilyPlanningMethodUsed : String?=null;




}