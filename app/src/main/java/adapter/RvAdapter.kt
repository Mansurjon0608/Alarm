package adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.os3ketchup.yanvargi.databinding.ItemRvBinding
import models.Alarm

class RvAdapter(
    var list: List<Alarm>,
    val rvClick: RvClick,

) : RecyclerView.Adapter<RvAdapter.Vh>() {

    inner class Vh(var itemRv: ItemRvBinding) : RecyclerView.ViewHolder(itemRv.root) {


        fun onBind(alarm: Alarm) {
            itemRv.txtTitle.text = alarm.title
            itemRv.txtTime.text = alarm.hours.toString()

            if (alarm.isRun) {
                itemRv.rvSwitch.isChecked = true
            }


            itemRv.root.setOnLongClickListener{
                println("position: $position")
                rvClick.longClick(alarm, position)
                true
            }
            itemRv.rvSwitch.setOnCheckedChangeListener { button, b ->
                alarm.isRun = b
                rvClick.switchOnOff(alarm, position)
            }
        }
    }


    interface RvClick{
        fun longClick(alarmObekt: Alarm, position: Int)
        fun switchOnOff(alarmObekt: Alarm, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}