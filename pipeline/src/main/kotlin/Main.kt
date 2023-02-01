import client.WikiClient
import common.Constant

fun main(args: Array<String>) {
    WikiClient()
        .getCharacterList(Constant.CHARACTER_LIST_URL)
}