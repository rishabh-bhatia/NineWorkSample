package com.realestate.realestateapp.model

data class SearchResult(
    val address: String,
    val advertiser: Advertiser,
    val bathroom_count: Double,
    val bedroom_count: Double,
    val carspace_count: Int,
    val dwelling_type: String,
    val id: Int,
    val listing_type: String,
    val media: List<Media>,
    val price: String,
    val project: Project,
)