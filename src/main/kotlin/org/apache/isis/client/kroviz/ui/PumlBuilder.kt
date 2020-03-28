/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.isis.client.kroviz.ui

import org.apache.isis.client.kroviz.core.model.meta.MetaClass
import org.apache.isis.client.kroviz.core.model.meta.MetaPackage
import org.apache.isis.client.kroviz.to.DomainType

class PumlBuilder {

    private val Q = "\""
    private val NL = "\\n"

    fun with(pkgList: Set<MetaPackage>): String {
        var code = "$Q@startuml$NL"
        pkgList.forEach { p ->
            code += amendByPackage(p)
        }
        code += "@enduml$Q"
        return code
    }

    fun with(pkg:MetaPackage): String {
        var code = "$Q@startuml$NL"
        code += amendByPackage(pkg)
        code += "@enduml$Q"
        return code
    }

    private fun amendByPackage(pkg:MetaPackage): String {
        val packageName = pkg.name
        var code = "package $packageName {$NL"
        pkg.classes.forEach { cls ->
            code += amendByClass(cls)
        }
        code += "}$NL"
        return code
    }

    private fun amendByClass(cls:MetaClass): String {
        val className = cls.name
        var code = "class $className$NL"
        cls.properties.forEach { p ->
            code += "$className : ${p.name}$NL"
        }
        cls.actions.forEach { a ->
            code += "$className : ${a.name}()$NL"
        }
        return code
    }

    fun with(domainType: DomainType): String {
        val cn = domainType.canonicalName
        val cls = cn.split(".").last()
        val pkg = cn.replace(".$cls", "")
        var pumlCode = "$Q@startuml$NL package $pkg {$NL" +
                "class $cls$NL"
        domainType.members.forEach { m ->
            val memberName = m.name()
            when {
                m.isProperty() -> pumlCode += "$cls : $memberName$NL"
                else -> {
                    pumlCode += "$cls : $memberName()$NL"
                }
            }
        }
        pumlCode += "}$NL@enduml$Q"
        return pumlCode
    }

}
