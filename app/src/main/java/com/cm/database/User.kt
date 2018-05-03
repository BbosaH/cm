package com.cm.database

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.sql.language.SQLite
import com.raizlabs.android.dbflow.structure.BaseModel

/**
 * Created by magicwand on 4/17/2018.
 */
@Table(database = CmDatabase::class)
class User : BaseModel(){

    @PrimaryKey
    @Column
    var id : String? =null

    @Column
    var firstName : String? =null

    @Column
    var lastName : String?=null

    @Column
    var userName : String?=null

    @Column
    var password : String? =null;

    @Column
    var role :String?=null

    companion object {
        fun getCurrentUser(callback : (User?)->Unit){

            SQLite.select()
                    .from(User::class.java)
                    .async()
                    .querySingleResultCallback { _, result -> callback(result) }
                    .execute()
        }
        fun getPeerLeaders(role:String):MutableList<User>{

            return SQLite.select()
                    .from(User::class.java)
                    .where(User_Table.role.eq(role))
                    .queryList()

        }
    }


}