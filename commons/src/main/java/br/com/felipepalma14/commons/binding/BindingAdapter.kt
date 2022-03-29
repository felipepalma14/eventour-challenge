package br.com.felipepalma14.commons.binding

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.ViewFlipper
import androidx.databinding.BindingAdapter
import br.com.felipepalma14.commons.R
import br.com.felipepalma14.commons.state.ScreenState
import br.com.felipepalma14.commons.state.ScreenState.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.text.DecimalFormat
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Date

@BindingAdapter("displayedVisibleChild")
fun displayedVisibleChild(
    viewFlipper: ViewFlipper,
    child: Int?
){
    child?.let {
        if(it == -1) viewFlipper.visibility = View.INVISIBLE
        else {
            viewFlipper.visibility = View.VISIBLE
            viewFlipper.displayedChild = child
        }
    }
}

@BindingAdapter("displayedVisibleChild")
fun displayedVisibleChild(
    viewFlipper: ViewFlipper,
    state: ScreenState?
){
    state?.let {
        when(it) {
            UI, LOADING, ERROR -> {
                viewFlipper.displayedChild = it.ordinal
                viewFlipper.visibility = View.VISIBLE
            }
            else -> viewFlipper.visibility = View.INVISIBLE
        }
    }
}
@BindingAdapter("currency")
fun bindCurrency(textView: TextView, eventPrice: Double) {

    val formatter = NumberFormat.getCurrencyInstance()
    if (formatter is DecimalFormat) {
        formatter.isDecimalSeparatorAlwaysShown = true
    }

    if (eventPrice > 0) {
        val formatedCurrentCurrency = formatter.format(eventPrice)
        textView.text = "Por $formatedCurrentCurrency"
    }else{
        textView.text = textView.context.getString(R.string.text_unknow_price)
    }
}

@SuppressLint("SimpleDateFormat")
@BindingAdapter("postDate")
fun bindPostDate(textView: TextView, postDate: Long){
    val formatter = SimpleDateFormat("dd/MM/yyyy")
    if(postDate != null || postDate > 0) {
        val dateConverted = Date(postDate)
        try {
            val dateFormatted = formatter.format(dateConverted)
            textView.text = "Data de postagem: $dateFormatted"
        } catch (e: Exception) {
            textView.text = textView.context.getString(R.string.text_unknow_postdate)
        }
    }
}

@BindingAdapter("loadImageUrl")
fun bindLoadImage(imgView: ImageView, imgUrl: String?) {
    if (imgUrl.isNullOrEmpty()) {
        imgView.setImageResource(R.drawable.ic_baseline_broken_image_24)
        return
    }

    Glide.with(imgView.context)
        .load(imgUrl)
        .apply(
            RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_baseline_broken_image_24)
//                .circleCrop()
        )
        .into(imgView)
}



