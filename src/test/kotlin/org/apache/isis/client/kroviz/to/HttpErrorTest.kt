package org.apache.isis.client.kroviz.to

import kotlinx.serialization.UnstableDefault
import org.apache.isis.client.kroviz.handler.HttpErrorHandler
import org.apache.isis.client.kroviz.snapshots.demo2_0_0.DEMO_HTTP_ERROR_500
import org.apache.isis.client.kroviz.snapshots.demo2_0_0.HTTP_ERROR_405
import org.apache.isis.client.kroviz.snapshots.simpleapp1_16_0.HTTP_ERROR
import org.apache.isis.client.kroviz.snapshots.simpleapp1_16_0.HTTP_ERROR_500_UNIQUE_CONSTRAINT_VIOLATION
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

@UnstableDefault
class HttpErrorTest {

    @Test
    fun testDemo500() {
        val jsonStr = DEMO_HTTP_ERROR_500.str
        val error = HttpErrorHandler().parse(jsonStr) as HttpError
        val code = error.httpStatusCode
        assertEquals(500, code)
        assertNotNull(error.message)

        val detail = error.detail
        assertNotNull(detail)
        assertNotNull(detail.className)
        assertNotNull(detail.message)
        assertEquals(error.message, detail.message)
        assertNotNull(detail.element)
        assertTrue(detail.element.size > 0)
    }

    @Test
    fun test405() {
        val jsonStr = HTTP_ERROR_405.str
        val error = HttpErrorHandler().parse(jsonStr) as HttpError
        val code = error.httpStatusCode
        assertEquals(405, code)
        assertNotNull(error.message)

        val detail = error.detail
        assertNotNull(detail)
        assertNotNull(detail.className)
        assertNotNull(detail.message)
        assertEquals(error.message, detail.message)
        assertNotNull(detail.element)
        assertTrue(detail.element.size > 0)
    }

    @Test
    fun test400() {
        val jsonStr = HTTP_ERROR.str
        val error = HttpErrorHandler().parse(jsonStr) as HttpError
        val code = error.httpStatusCode
        assertEquals(400, code)
        assertNotNull(error.message)

        val detail = error.detail
        assertNotNull(detail)
        assertNotNull(detail.className)
        assertNotNull(detail.message)
        assertEquals(error.message, detail.message)
        assertNotNull(detail.element)
        assertTrue(detail.element.size > 0)
    }

    //@Test //TODO handle nested causedBy's
    fun test500() {
        val jsonStr = HTTP_ERROR_500_UNIQUE_CONSTRAINT_VIOLATION.str
        val error = HttpErrorHandler().parse(jsonStr) as HttpError
        val code = error.httpStatusCode
        assertEquals(400, code)
        assertNotNull(error.message)

        val detail = error.detail
        assertNotNull(detail)
        assertNotNull(detail.className)
        assertNotNull(detail.message)
        assertEquals(error.message, detail.message)
        assertNotNull(detail.element)
        assertTrue(detail.element.size > 0)
    }

}
