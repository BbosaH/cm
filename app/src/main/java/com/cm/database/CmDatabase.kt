package com.cm.database

import com.raizlabs.android.dbflow.annotation.Database
import com.raizlabs.android.dbflow.annotation.Migration
import com.raizlabs.android.dbflow.sql.SQLiteType
import com.raizlabs.android.dbflow.sql.migration.AlterTableMigration

/**
 * Created by magicwand on 4/15/2018.
 */
@Database(name = CmDatabase.name, version = CmDatabase.VERSION)
class CmDatabase {

    companion object {
        const val name = "CmDatabase"
        const val VERSION = 1
    }

//    @Migration(version = 6, database = CmDatabase::class)
//    class Migration1(table: Class<MilkRecord>) : AlterTableMigration<MilkRecord>(table) {
//
//        override fun onPreMigrate() {
//            super.onPreMigrate()
//            addColumn(SQLiteType.INTEGER, "actual_milk_collected")
//
//        }
//
//
//    }


}