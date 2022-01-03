package adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.os3ketchup.yanvargi.databinding.ItemRvBinding
import models.Alarm

class RvAdapter(
    val context: Context?,
    var list: ArrayList<Alarm>,
    var rvClick: RvClick,
    var like: Int = 0
) : RecyclerView.Adapter<RvAdapter.Vh>() {

    inner class Vh(var itemRv: ItemRvBinding) : RecyclerView.ViewHolder(itemRv.root) {


        fun onBind(alarm: Alarm) {
            itemRv.txtTitle.text = alarm.title

        }
    }


    interface RvClick {
        fun onClick(alarm: Alarm)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}