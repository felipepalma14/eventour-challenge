package br.com.felipepalma14.commons.binding

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import br.com.felipepalma14.commons.R
import java.text.DecimalFormat
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Date

@BindingAdapter("loadImageUrl")
fun bindLoadImage(imgView: ImageView, imgUrl: String?) {

//    if (imgUrl.isNullOrEmpty()) {
//        imgView.setImageResource(R.drawable.ic_baseline_broken_image_24)
//        return
//    }
//
//    Glide.with(imgView.context)
//        .load(imgUrl)
//        .apply(
//            RequestOptions()
//                .placeholder(R.drawable.loading_animation)
//                .error(R.drawable.ic_baseline_broken_image_24)
////                .circleCrop()
//        )
//        .into(imgView)
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