package data

import kotlinx.serialization.Serializable

@Serializable
data class QueryData(val pages : Map<String, PageData>)
