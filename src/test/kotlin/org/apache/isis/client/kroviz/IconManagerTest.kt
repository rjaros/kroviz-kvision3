package org.ro.ui

import kotlin.test.Test
import kotlin.test.assertEquals

class IconManagerTest {

    @Test
    fun testFind() {
        //given
        val name = "OK"
        val expected = "fas fa-check"
        //when
        val actual =org.apache.isis.client.kroviz.ui.IconManager.find(name)
        //
        assertEquals(expected, actual)
    }

}
