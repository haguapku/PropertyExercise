package com.example.propertyexercise.model

data class Listing(val Id: String, val AgencyLogoUrl: String, val Area: String, val AuctionDate: String,
                   val AvailableFrom: String?, val Bathrooms: String, val Bedrooms: String, val Carspaces: String,
                   val DateFirstListed: String, val DateUpdated: String, val Description: String, val DisplayPrice: String,
                   val Currency: String, val Location : Location, val owner: Owner, val ImageUrls: List<String>,
                   val is_premium: Int, val IsPriority: Int, val Latitude: Float, val ListingPrice: String?,
                   val ListingStatistics: String?, val ListingType: String?, val ListingTypeString: String,
                   val Longitude: Float)