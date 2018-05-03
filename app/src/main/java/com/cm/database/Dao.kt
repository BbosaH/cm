package com.cm.database

import java.util.*

/**
 * Created by magicwand on 4/17/2018.
 * To add temporary data for usage
 * Not for production
 */


class Dao {

    companion object {

        fun insertUser (){
            val user = User()
            user.id = "1";
            user.firstName = "john";
            user.lastName = "doe";
            user.userName ="johndoe";
            user.password ="johndoe";
            user.role ="community worker"
            user.save();

            val user2 = User()
            user2.id = "2";
            user2.firstName = "foo";
            user2.lastName = "bar";
            user2.userName ="";
            user2.role="peer leader"
            user2.password ="";
            user2.save();
        }

        fun inserFacility(id:String,name:String,location:String) : Facility {
            val facility = Facility()
            facility.id = id;
            facility.name = name;
            facility.location = location;
            facility.save()
            return facility;
        }


        fun insertCddpPoint(id:String,name:String,facility:Facility):CddpPoint{
            val cddp = CddpPoint();
            cddp.id=id;
            cddp.name=name;
            cddp.facility = facility;
            cddp.save();
            return cddp;
        }
    }


}