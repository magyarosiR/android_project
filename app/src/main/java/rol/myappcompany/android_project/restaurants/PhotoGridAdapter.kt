package rol.myappcompany.android_project.restaurants

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import rol.myappcompany.android_project.databinding.CustomListBinding
import rol.myappcompany.android_project.model.Restaurants


class PhotoGridAdapter:
        ListAdapter<Restaurants, PhotoGridAdapter.RestaurantsViewHolder>(DiffCallback) {

    class RestaurantsViewHolder(private var binding: CustomListBinding):
            RecyclerView.ViewHolder(binding.root) {
        fun bind(rest: Restaurants) {
            binding.property = rest
            binding.executePendingBindings()
        }
    }

    /**
     * Allows the RecyclerView to determine which items have changed when the [List] of [MarsProperty]
     * has been updated.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<Restaurants>() {
        override fun areItemsTheSame(oldItem: Restaurants, newItem: Restaurants): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Restaurants, newItem: Restaurants): Boolean {
            return oldItem.id == newItem.id
        }
    }

    /**
     * Create new [RecyclerView] item views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): RestaurantsViewHolder {
        return RestaurantsViewHolder(CustomListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: RestaurantsViewHolder, position: Int) {
        val rest = getItem(position)
        /*holder.itemView.setOnClickListener {
            onClickListener.onClick(rest)
        }*/
        holder.bind(rest)
    }

    /**
     * Custom listener that handles clicks on [RecyclerView] items.  Passes the [MarsProperty]
     * associated with the current item to the [onClick] function.
     * @param clickListener lambda that will be called with the current [MarsProperty]
     */
    /*class OnClickListener(val clickListener: (rest: Restaurants) -> Unit) {
        fun onClick(rest:Restaurants) = clickListener(rest)
    }*/
}
