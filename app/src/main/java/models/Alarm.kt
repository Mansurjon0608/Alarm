package models

import com.google.android.material.timepicker.MaterialTimePicker

class Alarm {
    var title:String? = null
    var hours:Int? = null
    var minute:Int? = null
    var isRun:Boolean = true
    var vibration = false



    constructor(
        title: String?,
        hours: Int?,
        minute: Int?,
        isRun: Boolean,
        vibration: Boolean,

    ) {
        this.title = title
        this.hours = hours
        this.minute = minute
        this.isRun = isRun
        this.vibration = vibration

    }

    constructor()

    override fun toString(): String {
        return "Alarm(title=$title, hours=$hours, minute=$minute, isRun=$isRun, vibration=$vibration)"
    }


}