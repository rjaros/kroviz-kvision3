package org.apache.isis.client.kroviz.core.event

import kotlinx.serialization.Serializable

@Serializable
data class ReplayEvent(
        val url:String,
        val method: String,
        val request: String? = "",
        val state:String,
        val offset:Long,
        val response:String) {
}
