package com.realestate.realestateapp.model

data class Project(
    val child_listings: List<ChildListings>,
    val project_logo_image: String,
    val project_name: String,
    val project_price_from: Any
)