package com.singh.covidtracker.data.network

import android.net.Uri

class UriEncoder {
    fun encodeUrl(url: String) : String {
        return Uri.encode(url)
    }
}