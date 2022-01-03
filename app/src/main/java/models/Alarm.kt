package models

import com.google.android.material.timepicker.MaterialTimePicker

class Alarm {

    var title:String? = null
    var date = MaterialTimePicker()
    var voice:Int? = null

    constructor(title: String?, date: MaterialTimePicker, voice: Int?) {
        this.title = title
        this.date = date
        this.voice = voice
    }

    constructor()

    override fun toString(): String {
        return "Alarm(title=$title, date=$date, voice=$voice)"
    }


}