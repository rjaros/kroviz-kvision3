package org.apache.isis.client.kroviz.core.model

import kotlinx.serialization.Serializable
import org.apache.isis.client.kroviz.to.MemberType
import org.apache.isis.client.kroviz.to.TObject
import org.apache.isis.client.kroviz.ui.IconManager

/**
 * Makes properties of delegate available for display in Lists.
 * For regular TObjects these are members (properties).
 * For FixtureResults these are: result, resultClass etc.
 *
 * Exposer bears some similarity to the JS "Revealing Module Pattern"
 * (see: https://addyosmani.com/resources/essentialjsdesignpatterns/book/),
 * but it goes further since it even reveals members of it's delegate.
 */
@Serializable
class Exposer(val delegate: TObject) {

    var iconName = ""
    var selected = false //TODO add attribute dynamically???

    fun dynamise(): dynamic {
        val thys = this.asDynamic()
        for (m in delegate.members) {
            val member = m.value
            if (member.memberType == MemberType.PROPERTY.type) {
                val realValue = member.value
                if (realValue != null) {
                    thys[member.id] = realValue.content
                }
            }
        }
        iconName = IconManager.find(delegate.title)
        if (iconName == IconManager.DEFAULT_ICON) {
            iconName = IconManager.find(delegate.domainType)
        }
        return thys
    }

    // eg. for dataNucleusId
    fun get(propertyName: String): Any? {
        val delegatedProperty = delegate.getProperty(propertyName)
        if (delegatedProperty != null) {
            return delegatedProperty.value
        }
        return null
    }

}
