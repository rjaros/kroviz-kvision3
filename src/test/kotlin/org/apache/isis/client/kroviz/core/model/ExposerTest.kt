package org.apache.isis.client.kroviz.core.model

import kotlinx.serialization.UnstableDefault
import org.apache.isis.client.kroviz.handler.TObjectHandler
import org.apache.isis.client.kroviz.snapshots.simpleapp1_16_0.CFG_1
import org.apache.isis.client.kroviz.snapshots.simpleapp1_16_0.SO_0
import org.apache.isis.client.kroviz.to.TObject
import org.apache.isis.client.kroviz.to.Value
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

@UnstableDefault
class ExposerTest {

    @Test
    fun testConfiguration() {
        val jsonStr = CFG_1.str
        val to = TObjectHandler().parse(jsonStr) as TObject

        val exposer = Exposer(to).dynamise()

        val actKey = exposer["key"]
        assertEquals("isis.appManifest", actKey)

        val actValue = exposer["value"]
        assertEquals("domainapp.application.manifest.DomainAppAppManifest", actValue)

        val members = to.members
        assertFalse(members.isEmpty())
    }

    @Test
    fun testSimpleObject() {
        val jsonStr = SO_0.str
        val to = TObjectHandler().parse(jsonStr) as TObject
        val exposer = Exposer(to)

        //TODO datanucleus may be gone with Apache Isis 2.0.x
        val actualDnId = exposer.get("datanucleusIdLong") as Value
        assertEquals(0, actualDnId.content as Long)

        val actualDnvers = exposer.get("datanucleusVersionTimestamp") as Value
        assertEquals(1514897074953L, actualDnvers.content as Long)

        val dynEx = exposer.dynamise()
        val actKey = dynEx["name"]
        assertEquals("Foo", actKey)

        val actValue = dynEx["notes"]
        assertEquals("", actValue)

        val members = to.members
        assertFalse(members.isEmpty())
    }

}
