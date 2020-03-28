package org.apache.isis.client.kroviz.ui

import org.apache.isis.client.kroviz.to.Member
import org.apache.isis.client.kroviz.to.ValueType
import pl.treksoft.kvision.window.Window

class FormItem(
        val label: String,
        val type: String,
        var content: Any? = null,
        val size: Int? = null,
        val description: String? = "not set",
        val member:org.apache.isis.client.kroviz.to.Member? = null,
        var dspl:org.apache.isis.client.kroviz.ui.Displayable? = null,
        val callBackId: String? = null) {

    private var originalContent: Any?
    var readOnly = false

    init {
        originalContent = content
        if (member != null) {
            readOnly = member.isReadOnly()
        }
    }

    fun changed(value: String?) {
        dspl?.setDirty(true)
        if (member != null) {
            member.value?.content = value
        }
        //IMPROVE this is special logic in a generic place
        if (type ==org.apache.isis.client.kroviz.to.ValueType.SLIDER.type) {
            setOpacity(value!!)
        }
    }

    fun reset() {
        dspl?.setDirty(false)
        if (member != null) {
            content = originalContent
        }
    }

    fun setDisplay(displayable:org.apache.isis.client.kroviz.ui.Displayable) {
        dspl = displayable
    }

    @Deprecated("this needs a better home")
    fun setOpacity(value: String) {
        val opacity = value.toDouble()
        (dspl as Window).getElementJQuery()?.css(
                "background-color",
                "rgba(255, 255, 255, $opacity)"
        )
    }

}
