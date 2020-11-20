package co.eventbox.tedxtehran.view.home.sponsors

import android.content.Context
import co.eventbox.tedxtehran.R
import co.eventbox.tedxtehran.utilities.load
import co.eventbox.tedxtehran.utilities.openBrowser
import co.eventbox.tedxtehran.utilities.toImageURL
import com.apollographql.apollo.co.eventbox.tedxtehran.GetEventSponsorsQuery
import ir.farshid_roohi.customadapterrecycleview.AdapterRecyclerView
import kotlinx.android.synthetic.main.row_sponsor.view.*

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 7/10/20.
 */
class SponsorAdapter : AdapterRecyclerView<GetEventSponsorsQuery.Sponsor>(
    R.layout.row_sponsor,
    R.layout.row_loading,
    R.layout.row_error,
    R.id.btnErrorLoadList
) {
    override fun onBindView(
        viewHolder: ItemViewHolder,
        position: Int,
        context: Context,
        element: GetEventSponsorsQuery.Sponsor?
    ) {
        val itemView = viewHolder.itemView
        itemView.imgSponsor.load(element?.logo()?.toImageURL())
        itemView.txtTitle.text = element?.title()
        itemView.layoutRoot.setOnClickListener {
            itemView.context.openBrowser(element?.link())
        }
    }

}