package net.valerauko.newplaying

import java.net.URL

/**
 * Created by valerauko on 18/03/04.
 */
data class MastodonData(
    val token: String = "",
    val secret: String = "",
    val user: String = "",
    val url: URL = URL("https://pawoo.net/api/v1/statuses"))
