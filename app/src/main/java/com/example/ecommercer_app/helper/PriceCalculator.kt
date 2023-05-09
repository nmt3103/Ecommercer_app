package com.example.ecommercer_app.helper

fun Float?.getProductPrice(price: Float): Float{
    if (this == null)
        return price
    val remainingPricePercentage = 1f - this
    val priceAffterOffer = remainingPricePercentage * price

    return priceAffterOffer
}