package client

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import data.WikiData
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.util.function.BiConsumer


class WikiClient {

    private val json = Json {
        ignoreUnknownKeys = true
    }

    fun getCharacterList(url: String) {
        val httpAsync = url.httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        println(ex)
                    }

                    is Result.Success -> {
                        val data = result.get()
                        val characterData = json.decodeFromString<WikiData>(data);
                        characterData.query.pages.forEach {
                            it.value.links.forEach {
                                println(it.title)
                            }
                        }
                    }
                }
            }

        httpAsync.join()
    }
}
