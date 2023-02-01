package data

import kotlinx.serialization.Serializable

@Serializable
data class Normalized(val normalized : List<Map<String, String>>)