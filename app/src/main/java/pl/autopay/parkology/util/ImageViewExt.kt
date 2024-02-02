package pl.autopay.parkology.util

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.loadImage(url: String?) {
    Picasso.get().load(url?.takeIf { it.isNotBlank() }).into(this)
}