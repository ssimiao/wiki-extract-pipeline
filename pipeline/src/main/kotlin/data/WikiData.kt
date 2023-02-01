package data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WikiData(@SerialName("batchcomplete") val batchComplete: String,
                    val query: QueryData) {
}