package com.realestate.realestateapp.model

data class Listing(
    val results_returned: Int,
    val results_total: Int,
    val search_results: List<SearchResult>,
)