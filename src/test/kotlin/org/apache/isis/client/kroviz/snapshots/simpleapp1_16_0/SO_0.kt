package org.apache.isis.client.kroviz.snapshots.simpleapp1_16_0

import org.apache.isis.client.kroviz.snapshots.Response

object SO_0 : Response() {
    override val url = "http://localhost:8080/restful/objects/simple.SimpleObject/0"
    override val str = """{
        "links": [
            {
                "rel": "self",
                "href": "http://localhost:8080/restful/objects/simple.SimpleObject/0",
                "method": "GET",
                "type": "application/jsonprofile=\"urn:org.restfulobjects:repr-types/object\"",
                "title": "Object: Foo"
            },
            {
                "rel": "describedby",
                "href": "http://localhost:8080/restful/domain-types/simple.SimpleObject",
                "method": "GET",
                "type": "application/jsonprofile=\"urn:org.restfulobjects:repr-types/domain-type\""
            },
            {
                "rel": "urn:org.apache.isis.restfulobjects:rels/layout",
                "href": "http://localhost:8080/restful/domain-types/simple.SimpleObject/layout",
                "method": "GET",
                "type": "application/xmlprofile=\"urn:org.restfulobjects:repr-types/layout-bs3\""
            },
            {
                "rel": "urn:org.restfulobjects:rels/update",
                "href": "http://localhost:8080/restful/objects/simple.SimpleObject/0",
                "method": "PUT",
                "type": "application/jsonprofile=\"urn:org.restfulobjects:repr-types/object\"",
                "arguments": {}
            }
        ],
        "extensions": {
            "oid": "simple.SimpleObject:0",
            "isService": false,
            "isPersistent": true
        },
        "title": "Object: Foo",
        "domainType": "simple.SimpleObject",
        "instanceId": "0",
        "members": {
            "name": {
                "id": "name",
                "memberType": "property",
                "links": [
                    {
                        "rel": "urn:org.restfulobjects:rels/detailsproperty=\"name\"",
                        "href": "http://localhost:8080/restful/objects/simple.SimpleObject/0/properties/name",
                        "method": "GET",
                        "type": "application/jsonprofile=\"urn:org.restfulobjects:repr-types/object-property\""
                    }
                ],
                "value": "Foo",
                "extensions": {
                    "x-isis-format": "string"
                },
                "disabledReason": "Immutable"
            },
            "notes": {
                "id": "notes",
                "memberType": "property",
                "links": [
                    {
                        "rel": "urn:org.restfulobjects:rels/detailsproperty=\"notes\"",
                        "href": "http://localhost:8080/restful/objects/simple.SimpleObject/0/properties/notes",
                        "method": "GET",
                        "type": "application/jsonprofile=\"urn:org.restfulobjects:repr-types/object-property\""
                    }
                ],
                "value": null,
                "extensions": {
                    "x-isis-format": "string"
                }
            },
            "datanucleusIdLong": {
                "id": "datanucleusIdLong",
                "memberType": "property",
                "links": [
                    {
                        "rel": "urn:org.restfulobjects:rels/detailsproperty=\"datanucleusIdLong\"",
                        "href": "http://localhost:8080/restful/objects/simple.SimpleObject/0/properties/datanucleusIdLong",
                        "method": "GET",
                        "type": "application/jsonprofile=\"urn:org.restfulobjects:repr-types/object-property\""
                    }
                ],
                "value": 0,
                "format": "int",
                "extensions": {
                    "x-isis-format": "long"
                },
                "disabledReason": "Contributed property"
            },
            "datanucleusVersionTimestamp": {
                "id": "datanucleusVersionTimestamp",
                "memberType": "property",
                "links": [
                    {
                        "rel": "urn:org.restfulobjects:rels/detailsproperty=\"datanucleusVersionTimestamp\"",
                        "href": "http://localhost:8080/restful/objects/simple.SimpleObject/0/properties/datanucleusVersionTimestamp",
                        "method": "GET",
                        "type": "application/jsonprofile=\"urn:org.restfulobjects:repr-types/object-property\""
                    }
                ],
                "value": 1514897074953,
                "format": "utc-millisec",
                "extensions": {
                    "x-isis-format": "javasqltimestamp"
                },
                "disabledReason": "Contributed property"
            },
            "downloadLayoutXml": {
                "id": "downloadLayoutXml",
                "memberType": "action",
                "links": [
                    {
                        "rel": "urn:org.restfulobjects:rels/detailsaction=\"downloadLayoutXml\"",
                        "href": "http://localhost:8080/restful/objects/simple.SimpleObject/0/actions/downloadLayoutXml",
                        "method": "GET",
                        "type": "application/jsonprofile=\"urn:org.restfulobjects:repr-types/object-action\""
                    }
                ]
            },
            "rebuildMetamodel": {
                "id": "rebuildMetamodel",
                "memberType": "action",
                "links": [
                    {
                        "rel": "urn:org.restfulobjects:rels/detailsaction=\"rebuildMetamodel\"",
                        "href": "http://localhost:8080/restful/objects/simple.SimpleObject/0/actions/rebuildMetamodel",
                        "method": "GET",
                        "type": "application/jsonprofile=\"urn:org.restfulobjects:repr-types/object-action\""
                    }
                ]
            },
            "downloadJdoMetadata": {
                "id": "downloadJdoMetadata",
                "memberType": "action",
                "links": [
                    {
                        "rel": "urn:org.restfulobjects:rels/detailsaction=\"downloadJdoMetadata\"",
                        "href": "http://localhost:8080/restful/objects/simple.SimpleObject/0/actions/downloadJdoMetadata",
                        "method": "GET",
                        "type": "application/jsonprofile=\"urn:org.restfulobjects:repr-types/object-action\""
                    }
                ]
            },
            "delete": {
                "id": "delete",
                "memberType": "action",
                "links": [
                    {
                        "rel": "urn:org.restfulobjects:rels/detailsaction=\"delete\"",
                        "href": "http://localhost:8080/restful/objects/simple.SimpleObject/0/actions/delete",
                        "method": "GET",
                        "type": "application/jsonprofile=\"urn:org.restfulobjects:repr-types/object-action\""
                    }
                ]
            },
            "updateName": {
                "id": "updateName",
                "memberType": "action",
                "links": [
                    {
                        "rel": "urn:org.restfulobjects:rels/detailsaction=\"updateName\"",
                        "href": "http://localhost:8080/restful/objects/simple.SimpleObject/0/actions/updateName",
                        "method": "GET",
                        "type": "application/jsonprofile=\"urn:org.restfulobjects:repr-types/object-action\""
                    }
                ]
            },
            "clearHints": {
                "id": "clearHints",
                "memberType": "action",
                "links": [
                    {
                        "rel": "urn:org.restfulobjects:rels/detailsaction=\"clearHints\"",
                        "href": "http://localhost:8080/restful/objects/simple.SimpleObject/0/actions/clearHints",
                        "method": "GET",
                        "type": "application/jsonprofile=\"urn:org.restfulobjects:repr-types/object-action\""
                    }
                ]
            }
        }
    }"""
}
