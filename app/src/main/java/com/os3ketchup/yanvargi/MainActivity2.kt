package com.os3ketchup.yanvargi

import adapter.RvAdapter
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TimePicker
import android.widget.Toast
import com.google.android.material.timepicker.MaterialTimePicker

import com.os3ketchup.yanvargi.databinding.ActivityMain2Binding
import models.Alarm

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    lateinit var picker: MaterialTimePicker
    lateinit var alarm:Alarm
    lateinit var rvAdapter:RvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnDate.setOnClickListener {
            showTimePicker()


        }

        binding.btnSave.setOnClickListener {
            val list = ArrayList<Alarm>()
            val title = binding.editTitle.text.toString()

        }
    }

    private fun showTimePicker() {
        val timePickerDialog =
            TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener {
                override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                    Toast.makeText(this@MainActivity2, "$hourOfDay:$minute", Toast.LENGTH_SHORT)
                        .show()
                }
            }, 24, 60, true)
        timePickerDialog.updateTime(12, 24)
        timePickerDialog.show()

    }
}