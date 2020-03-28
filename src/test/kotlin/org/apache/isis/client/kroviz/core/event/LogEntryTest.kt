package org.apache.isis.client.kroviz.core.event

import kotlinx.serialization.UnstableDefault
import kotlin.test.Test
import kotlin.test.assertTrue

@UnstableDefault
class LogEntryTest {

    @Test
    fun testCalculate() {
        // given
        val le =org.apache.isis.client.kroviz.core.event.LogEntry("http://test/url")

        // when
        le.setSuccess()

        // then
        assertTrue(0 <= le.duration)

        if (le.duration < 0 && le.cacheHits == 0) {
//            console.log("[LogEntry.calculate] duration out of range")
//            console.log(this)
            //TODO add assert
        }
    }

}
