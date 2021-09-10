/**
 * created by Tia Sarwoedhi on 10/9/2021
 **/

package tia.sarwoedhi.stockbit.features.home.watch_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sarwoedhi.features.R
import com.sarwoedhi.features.databinding.ItemWatchListBinding
import tia.sarwoedhi.stockbit.common.extension.addPrefix
import tia.sarwoedhi.stockbit.common.extension.changeTextColor
import tia.sarwoedhi.stockbit.common.utils.ValueHelper
import tia.sarwoedhi.stockbit.model.Crypto
import tia.sarwoedhi.stockbit.repository.coin.CryptoEntity

class WatchListAdapter(private var cryptoList : MutableList<CryptoEntity>) : ListAdapter<Crypto, WatchListAdapter.ItemViewHolder>(ItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchListAdapter.ItemViewHolder {
        val binding = ItemWatchListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int = cryptoList.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(cryptoList[position])
    }



    inner class ItemViewHolder(private val binding: ItemWatchListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: CryptoEntity?) {
            with(binding) {
                tvCode.text = model?.name
                tvCompanyName.text = model?.companyName
                tvPriceChange.changeTextColor(model?.changePctHour?:0.0, itemView.context)
                tvPrice.text = model?.price?.toString()
                val changePercentage = ValueHelper.formatPriceChanges(model?.changeHour?:0.0).addPrefix()
                val changePrice = ValueHelper.formatPriceChanges(model?.changePctHour?:0.0).addPrefix()
                tvPriceChange.text = itemView.context.getString(R.string.info_price, changePrice, changePercentage)
            }
        }
    }

    class ItemDiffCallback : DiffUtil.ItemCallback<Crypto>() {
        override fun areItemsTheSame(oldItem: Crypto, newItem: Crypto): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Crypto, newItem: Crypto): Boolean {
            return oldItem == newItem
        }
    }
}
