package com.imranrana.bdjobs.utils

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

fun toNameDate(date:String):String{

    val originalDateFormat = SimpleDateFormat("MM/dd/yyyy",Locale.getDefault())
    val originalDate:Date = originalDateFormat.parse(date)!!
    val dayFormat = SimpleDateFormat("dd",Locale.getDefault())
    val targetDF = when(dayFormat.format(originalDate)){
        "01","21","31"-> {
            SimpleDateFormat("dd'st' MMMM, yyyy", Locale.getDefault())
        }
        "02","22"-> {
            SimpleDateFormat("dd'nd' MMMM, yyyy", Locale.getDefault())
        }
        "03","23"-> {
            SimpleDateFormat("dd'nd' MMMM, yyyy", Locale.getDefault())
        }
        else -> SimpleDateFormat("dd'th' MMMM, yyyy", Locale.getDefault())

    }

    return targetDF.format(originalDate)
}

fun reformatDate(date:String):String{
    val originalDateFormat = SimpleDateFormat("ddd MMM yyyy",Locale.getDefault())
    val targetDF = SimpleDateFormat("ddd MMM, yyyy",Locale.getDefault())
    val originalDate = originalDateFormat.parse(date)
    return targetDF.format(originalDate!!)
}

