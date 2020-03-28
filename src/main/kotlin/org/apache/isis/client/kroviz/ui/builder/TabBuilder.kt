package org.apache.isis.client.kroviz.ui.builder

import org.apache.isis.client.kroviz.to.TObject
import org.apache.isis.client.kroviz.to.bs3.Tab
import org.apache.isis.client.kroviz.ui.kv.RoDisplay
import pl.treksoft.kvision.core.Component
import pl.treksoft.kvision.core.CssSize
import pl.treksoft.kvision.core.UNIT
import pl.treksoft.kvision.panel.VPanel

class TabBuilder {

    fun create(tabLayout: Tab, tObject: TObject, tab: RoDisplay): Component {
        val result = VPanel()
        result.width = CssSize(100, UNIT.perc)
        result.height = CssSize(100, UNIT.perc)
        var b: VPanel
        for (r in tabLayout.rowList) {
            b = RowBuilder().create(r, tObject, tab)
            b.title = r.id
            result.add(b)
        }
        return result
    }

}
