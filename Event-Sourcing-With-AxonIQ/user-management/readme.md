# Event Sourcing using CQRS and AXONIQ

# Create User
POST ->

```sh
curl --location --request POST 'http://localhost:8091/api/v1/registerUser' \
--header 'Content-Type: application/json' \
--data-raw '{
    "user": {
        "firstname": "John",
        "lastname": "Doe",
        "emailAddress": "john.doe@springbank.com",
        "account": {
            "username": "johnd",
            "password": "P@ssword1",
            "roles":[
                "READ_PRIVILEDGE","WRITE_PRIVILEDGE"
            ]
        }
    }
}'
```


```sh
curl --location --request POST 'http://localhost:8091/api/v1/registerUser' \
--header 'Content-Type: application/json' \
--data-raw '{
    "user": {
        "firstname": "Jane",
        "lastname": "Doe",
        "emailAddress": "jane.doe@springbank.com",
        "account": {
            "username": "janed",
            "password": "P@ssword2",
            "roles":[
                "READ_PRIVILEDGE"
            ]
        }
    }
}'
```


```sh
curl --location --request POST 'http://localhost:8091/api/v1/registerUser' \
--header 'Content-Type: application/json' \
--data-raw '{
    "user": {
        "firstname": "Mike",
        "lastname": "Doe",
        "emailAddress": "mike.doe@springbank.com",
        "account": {
            "username": "miked",
            "password": "P@ssword3",
            "roles":[
                "READ_PRIVILEDGE"
            ]
        }
    }
}'
```

# Update User By Id
PUT ->

```sh
curl --location --request PUT 'http://localhost:8091/api/v1/updateUser/b76b6640-8042-47b7-a791-93dc3eb6089a' \
--header 'Content-Type: application/json' \
--data-raw '{
    "user": {
        "firstname": "Mike007",
        "lastname": "Doe",
        "emailAddress": "mike.doe@springbank.com",
        "account": {
            "username": "miked",
            "password": "P@ssword3",
            "roles":[
                "READ_PRIVILEDGE","WRITE_PRIVILEDGE"
            ]
        }
    }
}'
```

# Delete User By Id
DELETE ->

```sh
curl --location --request DELETE 'http://localhost:8091/api/v1/removeUser/b76b6640-8042-47b7-a791-93dc3eb6089a'
```

-------

```json
db.getCollection('users').find({})

/* 1 */
{
    "_id" : "4a299492-b7b9-4e9a-a69b-2e808e894408",
    "firstname" : "John",
    "lastname" : "Doe",
    "emailAddress" : "john.doe@springbank.com",
    "account" : {
        "username" : "johnd",
        "password" : "$2a$12$5sSOVFanmoDxsjxw1rWZBukI6O7t9eBhneMEDoQFeJ7Ni35Hl8/zO",
        "roles" : [ 
            "READ_PRIVILEDGE", 
            "WRITE_PRIVILEDGE"
        ]
    },
    "_class" : "com.example.demo.models.User"
}

/* 2 */
{
    "_id" : "f599c03b-a9a3-4518-b191-d1541771ce2c",
    "firstname" : "Jane",
    "lastname" : "Doe",
    "emailAddress" : "jane.doe@springbank.com",
    "account" : {
        "username" : "janed",
        "password" : "$2a$12$FN3I11muZfp4pes82zLL.uqMcuoKvzs351VJJDxO5NPGVdTlREVzW",
        "roles" : [ 
            "READ_PRIVILEDGE"
        ]
    },
    "_class" : "com.example.demo.models.User"
}
```


```json
/* 1 */
{
    "_id" : ObjectId("62dce01aadf723064c397b8b"),
    "aggregateIdentifier" : "4a299492-b7b9-4e9a-a69b-2e808e894408",
    "type" : "UserAggregate",
    "sequenceNumber" : NumberLong(0),
    "serializedPayload" : "<com.example.demo.events.UserRegisteredEvent><id>4a299492-b7b9-4e9a-a69b-2e808e894408</id><user><id>4a299492-b7b9-4e9a-a69b-2e808e894408</id><firstname>John</firstname><lastname>Doe</lastname><emailAddress>john.doe@springbank.com</emailAddress><account><username>johnd</username><password>$2a$12$5sSOVFanmoDxsjxw1rWZBukI6O7t9eBhneMEDoQFeJ7Ni35Hl8/zO</password><roles><com.example.demo.models.Role>READ_PRIVILEDGE</com.example.demo.models.Role><com.example.demo.models.Role>WRITE_PRIVILEDGE</com.example.demo.models.Role></roles></account></user></com.example.demo.events.UserRegisteredEvent>",
    "timestamp" : "2022-07-24T06:00:58.634Z",
    "payloadType" : "com.example.demo.events.UserRegisteredEvent",
    "payloadRevision" : null,
    "serializedMetaData" : "<meta-data><entry><string>traceId</string><string>e5147a83-5935-459f-a872-75f1002c4281</string></entry><entry><string>correlationId</string><string>e5147a83-5935-459f-a872-75f1002c4281</string></entry></meta-data>",
    "eventIdentifier" : "b922d0d1-f1fc-4871-bf96-09e404ea09ec"
}

/* 2 */
{
    "_id" : ObjectId("62dce05cadf723064c397b8c"),
    "aggregateIdentifier" : "f599c03b-a9a3-4518-b191-d1541771ce2c",
    "type" : "UserAggregate",
    "sequenceNumber" : NumberLong(0),
    "serializedPayload" : "<com.example.demo.events.UserRegisteredEvent><id>f599c03b-a9a3-4518-b191-d1541771ce2c</id><user><id>f599c03b-a9a3-4518-b191-d1541771ce2c</id><firstname>Jane</firstname><lastname>Doe</lastname><emailAddress>jane.doe@springbank.com</emailAddress><account><username>janed</username><password>$2a$12$FN3I11muZfp4pes82zLL.uqMcuoKvzs351VJJDxO5NPGVdTlREVzW</password><roles><com.example.demo.models.Role>READ_PRIVILEDGE</com.example.demo.models.Role></roles></account></user></com.example.demo.events.UserRegisteredEvent>",
    "timestamp" : "2022-07-24T06:02:04.394Z",
    "payloadType" : "com.example.demo.events.UserRegisteredEvent",
    "payloadRevision" : null,
    "serializedMetaData" : "<meta-data><entry><string>traceId</string><string>e36faa01-602f-452f-908d-eaeab8b47e2f</string></entry><entry><string>correlationId</string><string>e36faa01-602f-452f-908d-eaeab8b47e2f</string></entry></meta-data>",
    "eventIdentifier" : "40117bce-b766-4c1c-a4b8-98c72a5d567b"
}

/* 3 */
{
    "_id" : ObjectId("62dce073adf723064c397b8d"),
    "aggregateIdentifier" : "b76b6640-8042-47b7-a791-93dc3eb6089a",
    "type" : "UserAggregate",
    "sequenceNumber" : NumberLong(0),
    "serializedPayload" : "<com.example.demo.events.UserRegisteredEvent><id>b76b6640-8042-47b7-a791-93dc3eb6089a</id><user><id>b76b6640-8042-47b7-a791-93dc3eb6089a</id><firstname>Mike</firstname><lastname>Doe</lastname><emailAddress>mike.doe@springbank.com</emailAddress><account><username>miked</username><password>$2a$12$iHDM1Fke6mQsPmaXbkvKX.909TLMkpGSuZYZ.kN95l4JuNbEzCLcK</password><roles><com.example.demo.models.Role>READ_PRIVILEDGE</com.example.demo.models.Role></roles></account></user></com.example.demo.events.UserRegisteredEvent>",
    "timestamp" : "2022-07-24T06:02:27.589Z",
    "payloadType" : "com.example.demo.events.UserRegisteredEvent",
    "payloadRevision" : null,
    "serializedMetaData" : "<meta-data><entry><string>traceId</string><string>226d1838-0d8b-4c74-bf19-067820f15cf7</string></entry><entry><string>correlationId</string><string>226d1838-0d8b-4c74-bf19-067820f15cf7</string></entry></meta-data>",
    "eventIdentifier" : "bbc0c397-caf1-4a36-9761-eadd000ece74"
}

/* 4 */
{
    "_id" : ObjectId("62dce14aadf723064c397b8e"),
    "aggregateIdentifier" : "b76b6640-8042-47b7-a791-93dc3eb6089a",
    "type" : "UserAggregate",
    "sequenceNumber" : NumberLong(1),
    "serializedPayload" : "<com.example.demo.events.UserUpdatedEvent><id>b76b6640-8042-47b7-a791-93dc3eb6089a</id><user><id>b76b6640-8042-47b7-a791-93dc3eb6089a</id><firstname>Mike007</firstname><lastname>Doe</lastname><emailAddress>mike.doe@springbank.com</emailAddress><account><username>miked</username><password>$2a$12$sTtJC/oS90g2pndQBuznyepQ5M/l0rL40SBP3GibxfI9039zl3S9m</password><roles><com.example.demo.models.Role>READ_PRIVILEDGE</com.example.demo.models.Role><com.example.demo.models.Role>WRITE_PRIVILEDGE</com.example.demo.models.Role></roles></account></user></com.example.demo.events.UserUpdatedEvent>",
    "timestamp" : "2022-07-24T06:06:02.881Z",
    "payloadType" : "com.example.demo.events.UserUpdatedEvent",
    "payloadRevision" : null,
    "serializedMetaData" : "<meta-data><entry><string>traceId</string><string>dba08b84-9195-458d-a2e7-c00f7eae49e6</string></entry><entry><string>correlationId</string><string>dba08b84-9195-458d-a2e7-c00f7eae49e6</string></entry></meta-data>",
    "eventIdentifier" : "aa6f7170-d8c9-454b-ae62-05e9faf8e5db"
}

/* 5 */
{
    "_id" : ObjectId("62dce168adf723064c397b8f"),
    "aggregateIdentifier" : "b76b6640-8042-47b7-a791-93dc3eb6089a",
    "type" : "UserAggregate",
    "sequenceNumber" : NumberLong(2),
    "serializedPayload" : "<com.example.demo.events.UserRemovedEvent><id>b76b6640-8042-47b7-a791-93dc3eb6089a</id></com.example.demo.events.UserRemovedEvent>",
    "timestamp" : "2022-07-24T06:06:32.074Z",
    "payloadType" : "com.example.demo.events.UserRemovedEvent",
    "payloadRevision" : null,
    "serializedMetaData" : "<meta-data><entry><string>traceId</string><string>c85f1e0c-8747-402d-89cb-9079dafd9376</string></entry><entry><string>correlationId</string><string>c85f1e0c-8747-402d-89cb-9079dafd9376</string></entry></meta-data>",
    "eventIdentifier" : "bd619d15-e0c0-4b36-9fee-0ee1af2c52aa"
}
```

-------------

# Get All Users
GET -> `http://localhost:8092/api/v1/userLookup/`

# Get User By UserId
GET -> `http://localhost:8092/api/v1/userLookup/byId/4a299492-b7b9-4e9a-a69b-2e808e894408`

# Search User By Filter
- GET -> `http://localhost:8092/api/v1/userLookup/byFilter/@springbank.com`

- GET -> `http://localhost:8092/api/v1/userLookup/byFilter/john`

- GET -> `http://localhost:8092/api/v1/userLookup/byFilter/jane`

- GET -> `http://localhost:8092/api/v1/userLookup/byFilter/Doe`
