package com.realestate.realestateapp.rvadapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.realestate.realestateapp.R
import com.realestate.realestateapp.utility.DataHandling.convertDoubleToInt
import com.realestate.realestateapp.utility.DataHandling.convertStringToInt
import com.realestate.realestateapp.databinding.ItemListingBinding
import com.realestate.realestateapp.model.Listing
import java.lang.NullPointerException

class ListingsRVAdapter(
    private var listing: Listing
) : RecyclerView.Adapter<ListingsRVAdapter.ListingViewHolder>() {

    /**
     * An adapter class that uses ViewBinding to bind each
     * item to ViewHolder in the Recyclerview
     *
     * @param itemListingBinding An ItemListingBinding object
     */
    inner class ListingViewHolder(val itemListingBinding: ItemListingBinding) :
        RecyclerView.ViewHolder(itemListingBinding.root)

    /**
     * Called when recyclerview needs a new view holder for a particular item it wants to present
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to an
     * ...adapter position.
     * @param viewType The view type of the new View
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingViewHolder {
        val view = ItemListingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListingViewHolder(view)
    }


    /**
     * Called by RecyclerView to display the data at the specified position.
     * This method should update the contents of the RecyclerView.ViewHolder.itemView to reflect
     * the item at the given position
     *
     * @param holder The ViewHolder that is updated to represent the item at a given position
     * @param position The position of the item within the adapter's data set
     */
    override fun onBindViewHolder(holder: ListingViewHolder, position: Int) {
        holder.itemListingBinding.apply {
            subItemLayout.addressTv.text =
                root.context.getString(R.string.address, listing.search_results[position].address)
            try {
                val url = listing.search_results[position].media[0].image_url
                Glide.with(root).load(url)
                    .into(imageView)
                setViews(holder, position)
            } catch (exception: NullPointerException) {
                //Handle the exception here
                Log.e("ADAPTER", "Crash stopped in adapter ${position}: " + exception)
                exception.printStackTrace()
            }
        }
    }

    /**
     * Called to get the total number of items in the data set
     *
     * @return An integer representing size of data set
     */
    override fun getItemCount(): Int {
        return listing.search_results.size
    }

    /**
     * Called to set views according to the dataset provided.
     *
     * @param holder The ViewHolder that is updated to represent the item at a given position
     * @param position The position of the item within the adapter's data set
     */
    private fun setViews(holder: ListingViewHolder, position: Int) {
        val itemListingBinding = holder.itemListingBinding

        if (listing.search_results[position].listing_type == "project") {
            val projectPriceFrom = "$" + listing.search_results[position].project.project_price_from
            val bedroomCount =
                convertStringToInt(listing.search_results[position].project.child_listings[0].bedroom_count)
            val bathroomCount =
                convertStringToInt(listing.search_results[position].project.child_listings[0].bathroom_count)
            val carspaceCount =
                convertStringToInt(listing.search_results[position].project.child_listings[0].carspace_count)
            val logoUrl = listing.search_results[position].project.project_logo_image

            itemListingBinding.subItemLayout.priceTv.text =
                itemListingBinding.root.context.getString(
                    R.string.pricefrom, projectPriceFrom
                )
            itemListingBinding.subItemLayout.bedBathParkTv.text =
                itemListingBinding.root.context.getString(
                    R.string.bedBathCar,
                    bedroomCount,
                    bathroomCount,
                    carspaceCount
                )
            Glide.with(itemListingBinding.root)
                .load(logoUrl)
                .into(itemListingBinding.subItemLayout.imageView2)

        } else {
            val price =
                listing.search_results[position].price
            val bedroomCount =
                convertDoubleToInt(listing.search_results[position].bedroom_count)
            val bathroomCount =
                convertDoubleToInt(listing.search_results[position].bathroom_count)
            val carspaceCount =
                listing.search_results[position].carspace_count
            val logoUrl = listing.search_results[position].advertiser.images.logo_url

            itemListingBinding.subItemLayout.priceTv.text =
                itemListingBinding.root.context.getString(
                    R.string.price, price
                )
            itemListingBinding.subItemLayout.bedBathParkTv.text =
                itemListingBinding.root.context.getString(
                    R.string.bedBathCar,
                    bedroomCount,
                    bathroomCount,
                    carspaceCount
                )
            Glide.with(itemListingBinding.root)
                .load(logoUrl)
                .into(itemListingBinding.subItemLayout.imageView2)
        }
    }
}