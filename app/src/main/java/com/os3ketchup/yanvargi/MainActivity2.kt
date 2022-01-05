package com.os3ketchup.yanvargi

import AlarmReceiver
import adapter.RvAdapter
import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.TimePicker
import android.widget.Toast
import com.google.android.material.timepicker.MaterialTimePicker

import com.os3ketchup.yanvargi.databinding.ActivityMain2Binding
import models.Alarm
import utils.MySharedPreferences

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    lateinit var alarm: Alarm
    lateinit var rvAdapter: RvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        MySharedPreferences.init(this)


        binding.numPicker1.minValue = 0
        binding.numPicker1.maxValue = 12
        binding.numPicker2.minValue = 0
        binding.numPicker2.maxValue = 59


        binding.switchVibrate.setOnClickListener {
            binding.switchVibrate.isChecked = !binding.switchVibrate.isChecked
        }
        var time = SystemClock.elapsedRealtime() + 1000
        val intent = Intent(this, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0)

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.setRepeating(
            AlarmManager.ELAPSED_REALTIME_WAKEUP,
            time,
            10000,
            pendingIntent
        )

        val hours = binding.numPicker1.value
        val min = binding.numPicker2.value

        binding.btnSave.setOnClickListener {
            if (binding.editTitle.text.toString() != ""){
                val list = MySharedPreferences.alarmList
                list.add(Alarm(alarm.title, hours, min, true, binding.switchVibrate.isChecked))
                MySharedPreferences.alarmList = list
                rvAdapter = RvAdapter(list, object : RvAdapter.RvClick{
                    override fun longClick(alarmObekt: Alarm, position: Int) {

                    }

                    override fun switchOnOff(alarmObekt: Alarm, position: Int) {

                    }

                })
                finishAffinity()
            } else Toast.makeText(this, "Eslatma uchun nom berilmagan...", Toast.LENGTH_SHORT).show()




        }
    }

}