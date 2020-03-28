package org.apache.isis.client.kroviz.ui.kv

import org.apache.isis.client.kroviz.core.aggregator.ActionDispatcher
import org.apache.isis.client.kroviz.to.Link
import org.apache.isis.client.kroviz.to.Member
import org.apache.isis.client.kroviz.to.TObject
import org.apache.isis.client.kroviz.to.mb.Menu
import org.apache.isis.client.kroviz.ui.IconManager
import org.apache.isis.client.kroviz.utils.Utils
import pl.treksoft.kvision.core.Component
import pl.treksoft.kvision.dropdown.Direction
import pl.treksoft.kvision.dropdown.DropDown
import pl.treksoft.kvision.dropdown.ddLink
import pl.treksoft.kvision.dropdown.separator
import pl.treksoft.kvision.html.ButtonStyle

object MenuFactory {

    fun buildFor(tObject: TObject,
                 withText: Boolean = true,
                 style: ButtonStyle = ButtonStyle.LIGHT): DropDown {
        val type = tObject.domainType
        val dd = DropDown(
                type,
                style = style,
                direction = Direction.DROPDOWN
        )
        if (withText) {
            dd.text = "Actions for $type"
        } else {
            dd.text = ""
        }
        dd.icon = IconManager.find("Actions")
        val actions = tObject.getActions()
        actions.forEach {
            val title = it.id
            val link = it.getInvokeLink()!!
            action(dd, title, link)
        }
        return dd
    }

    fun buildFor(menu: Menu): DropDown {
        val title = menu.named
        val dd = DropDown(text = title, style = ButtonStyle.LIGHT, forNavbar = false)
        dd.icon = IconManager.find(title)
        menu.section.forEachIndexed { index, section ->
            section.serviceAction.forEach { sa ->
                action(dd, sa.id!!, sa.link!!)
            }
            if (index < menu.section.size - 1) {
                dd.separator()
            }
        }
        return dd
    }

    private fun action(dd: DropDown, label: String, link: Link) {
        val icon = IconManager.find(label)
        val classes = IconManager.findStyleFor(label)
        val title = Utils.deCamel(label)
        dd.ddLink(title, icon = icon, classes = classes).onClick {
            ActionDispatcher().invoke(link)
        }
    }

    // initially added items will be enabled
    fun amendWithSaveUndo(dd: DropDown, tObject: TObject) {
        dd.separator()

        val saveLink = tObject.links.first()
        action(dd, "save", saveLink)

        val undoLink = Link(href = "")
        action(dd, "undo", undoLink)
    }

    // disabled when tObject.isClean
    // IMPROVE use tr("Dropdowns (disabled)") to DD.DISABLED.option,
    fun disableSaveUndo(dd: DropDown) {
        val menuItems = dd.getChildren()

        val saveItem = menuItems[menuItems.size - 2]
        switchCssClass(saveItem, IconManager.OK, IconManager.DISABLED)

        val undoItem = menuItems[menuItems.size - 1]
        switchCssClass(undoItem, IconManager.OK, IconManager.WARN)
    }

    fun enableSaveUndo(dd: DropDown) {
        val menuItems = dd.getChildren()

        val saveItem = menuItems[menuItems.size - 2]
        switchCssClass(saveItem, IconManager.DISABLED, IconManager.OK)

        val undoItem = menuItems[menuItems.size - 1]
        switchCssClass(undoItem, IconManager.DISABLED, IconManager.WARN)
    }

    private fun switchCssClass(menuItem: Component, from: String, to: String) {
        menuItem.removeCssClass(from)
        menuItem.addCssClass(to)
    }

    fun Member.getInvokeLink(): Link? {
        return links.firstOrNull { it.rel.indexOf(id) > 0 }
    }

}
