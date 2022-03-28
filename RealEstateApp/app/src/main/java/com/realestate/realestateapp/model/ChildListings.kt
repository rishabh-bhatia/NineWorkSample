package com.realestate.realestateapp.model

data class ChildListings(
    val bathroom_count: Any,
    var bedroom_count: Any,
    val carspace_count: Any,
    val homepass_enabled: Boolean,
    val id: Int,
    val price: String,
)