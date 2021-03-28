#

```
curl -X POST \
  http://localhost:8081/api/v1/registerUser \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 6e19ce63-d2c5-1820-f5f8-4bdcae352322' \
  -d '{
	"user" : {
		"firstname" : "John",
		"lastname" : "Doe",
		"emailAddress" : "john@springbank.com",
		"account" : {
			"username": "johnd",
			"password" : "P@ssw0rd1",
			"roles" : [
				"READ_PRIVILEGE","WRITE_PRIVILEGE"	
			]
		}
	}
}'
```

```
curl -X POST \
  http://localhost:8081/api/v1/registerUser \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 4445e098-74fd-b47b-caa0-9c297c810c8c' \
  -d '{
	"user" : {
		"firstname" : "Jane",
		"lastname" : "Doe",
		"emailAddress" : "jane@springbank.com",
		"account" : {
			"username": "janed",
			"password" : "P@ssw0rd2",
			"roles" : [
				"READ_PRIVILEGE"
			]
		}
	}
}'
```

Update Request - 

```
curl -X PUT \
  http://localhost:8081/api/v1/updateUser/9644a5c4-dd42-4dc2-97f5-0e701af95d9b \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 6be58787-e1fa-de45-1511-ab2efe577a9d' \
  -d '{
	"user" : {
		"firstname" : "Mike",
		"lastname" : "Doe",
		"emailAddress" : "mike.doe@springbank.com",
		"account" : {
			"username": "miked",
			"password" : "P@ssw0rd3",
			"roles" : [
				"READ_PRIVILEGE"
			]
		}
	}
}'
```

# find all

```
curl -X GET \
  http://localhost:8082/api/v1/userLookup/ \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 42aaf400-426b-1810-59ec-eb423abaefdf'
```


```
curl -X GET \
  http://localhost:8082/api/v1/userLookup/byFilter/@springbank.com \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 9f5f35c2-123a-c1ba-c5ee-83fcb0310a5d'
```

```
curl -X GET \
  http://localhost:8082/api/v1/userLookup/byFilter/Doe \
  -H 'cache-control: no-cache' \
  -H 'postman-token: bfbaae7c-1336-021c-fe25-f2d8e1f9d4fc'
```


db.getCollection('domainevents').find({})

```
/* 1 */
{
    "_id" : ObjectId("60605b928a9ca0081611fffe"),
    "aggregateIdentifier" : "635c9d5a-723f-4ace-b7b9-a0403811c344",
    "type" : "UserAggregate",
    "sequenceNumber" : NumberLong(0),
    "serializedPayload" : "<com.springbank.user.core.events.UserRegisteredEvent><id>635c9d5a-723f-4ace-b7b9-a0403811c344</id><user><id>635c9d5a-723f-4ace-b7b9-a0403811c344</id><firstname>John</firstname><lastname>Doe</lastname><emailAddress>john@springbank.com</emailAddress><account><username>johnd</username><password>$2a$12$aQJ8M1qVDOjlFaDYLguYuuEuCm2o2xl9ABYgHAofRPrEgdAVM8a0K</password><roles><com.springbank.user.core.models.Role>READ_PRIVILEGE</com.springbank.user.core.models.Role><com.springbank.user.core.models.Role>WRITE_PRIVILEGE</com.springbank.user.core.models.Role></roles></account></user></com.springbank.user.core.events.UserRegisteredEvent>",
    "timestamp" : "2021-03-28T10:33:54.3128277Z",
    "payloadType" : "com.springbank.user.core.events.UserRegisteredEvent",
    "payloadRevision" : null,
    "serializedMetaData" : "<meta-data><entry><string>traceId</string><string>ac2ad61f-677e-459c-837a-2f3a129c963e</string></entry><entry><string>correlationId</string><string>ac2ad61f-677e-459c-837a-2f3a129c963e</string></entry></meta-data>",
    "eventIdentifier" : "5094ad43-babd-46c5-b1b6-9acc76af6d47"
}

/* 2 */
{
    "_id" : ObjectId("60605bc78a9ca0081611ffff"),
    "aggregateIdentifier" : "e950598a-640f-4c25-8de5-4bb7bbfc2c35",
    "type" : "UserAggregate",
    "sequenceNumber" : NumberLong(0),
    "serializedPayload" : "<com.springbank.user.core.events.UserRegisteredEvent><id>e950598a-640f-4c25-8de5-4bb7bbfc2c35</id><user><id>e950598a-640f-4c25-8de5-4bb7bbfc2c35</id><firstname>Jane</firstname><lastname>Doe</lastname><emailAddress>jane@springbank.com</emailAddress><account><username>janed</username><password>$2a$12$CrjEZQup12Ymx2Jq/CAICe5p4Fjce9.o5c2bKsuFqxGppVNJ3509u</password><roles><com.springbank.user.core.models.Role>READ_PRIVILEGE</com.springbank.user.core.models.Role><com.springbank.user.core.models.Role>WRITE_PRIVILEGE</com.springbank.user.core.models.Role></roles></account></user></com.springbank.user.core.events.UserRegisteredEvent>",
    "timestamp" : "2021-03-28T10:34:47.5533438Z",
    "payloadType" : "com.springbank.user.core.events.UserRegisteredEvent",
    "payloadRevision" : null,
    "serializedMetaData" : "<meta-data><entry><string>traceId</string><string>eeaa0aef-dc8c-455f-b379-93361b173a88</string></entry><entry><string>correlationId</string><string>eeaa0aef-dc8c-455f-b379-93361b173a88</string></entry></meta-data>",
    "eventIdentifier" : "a363db2b-76ba-460b-be60-68199a3a810f"
}

/* 3 */
{
    "_id" : ObjectId("60605c138a9ca00816120000"),
    "aggregateIdentifier" : "24577f8d-7d59-4553-9987-84b34efa37b6",
    "type" : "UserAggregate",
    "sequenceNumber" : NumberLong(0),
    "serializedPayload" : "<com.springbank.user.core.events.UserRegisteredEvent><id>24577f8d-7d59-4553-9987-84b34efa37b6</id><user><id>24577f8d-7d59-4553-9987-84b34efa37b6</id><firstname>Mike</firstname><lastname>Doe</lastname><emailAddress>mike@springbank.com</emailAddress><account><username>miked</username><password>$2a$12$VnICM/d3SYnZANzhVnTMreVkCZxW08oxMjsX9AN7VY86Ry45I1aPa</password><roles><com.springbank.user.core.models.Role>READ_PRIVILEGE</com.springbank.user.core.models.Role></roles></account></user></com.springbank.user.core.events.UserRegisteredEvent>",
    "timestamp" : "2021-03-28T10:36:03.3750279Z",
    "payloadType" : "com.springbank.user.core.events.UserRegisteredEvent",
    "payloadRevision" : null,
    "serializedMetaData" : "<meta-data><entry><string>traceId</string><string>41c3aacb-3678-4026-a8fd-05815337b7d4</string></entry><entry><string>correlationId</string><string>41c3aacb-3678-4026-a8fd-05815337b7d4</string></entry></meta-data>",
    "eventIdentifier" : "dd46f164-ba00-47da-b368-b061784528cd"
}

/* 4 */
{
    "_id" : ObjectId("60605ca68a9ca00816120002"),
    "aggregateIdentifier" : "24577f8d-7d59-4553-9987-84b34efa37b6",
    "type" : "UserAggregate",
    "sequenceNumber" : NumberLong(2),
    "serializedPayload" : "<com.springbank.user.core.events.UserRemovedEvent><id>24577f8d-7d59-4553-9987-84b34efa37b6</id></com.springbank.user.core.events.UserRemovedEvent>",
    "timestamp" : "2021-03-28T10:38:30.125788Z",
    "payloadType" : "com.springbank.user.core.events.UserRemovedEvent",
    "payloadRevision" : null,
    "serializedMetaData" : "<meta-data><entry><string>traceId</string><string>cf1f038f-c621-47ea-a351-8e2d8e9763be</string></entry><entry><string>correlationId</string><string>cf1f038f-c621-47ea-a351-8e2d8e9763be</string></entry></meta-data>",
    "eventIdentifier" : "f3b4bc5a-43c8-4de3-bc6a-c627a9bc15c8"
}

/* 5 */
{
    "_id" : ObjectId("60605c558a9ca00816120001"),
    "aggregateIdentifier" : "24577f8d-7d59-4553-9987-84b34efa37b6",
    "type" : "UserAggregate",
    "sequenceNumber" : NumberLong(1),
    "serializedPayload" : "<com.springbank.user.core.events.UserUpdatedEvent><id>61034790-68db-4b0a-833b-5223c15c01d3</id><user><id>24577f8d-7d59-4553-9987-84b34efa37b6</id><firstname>Mike</firstname><lastname>Doe</lastname><emailAddress>mike.doe@springbank.com</emailAddress><account><username>miked</username><password>$2a$12$yrFmFZVJh8/0BngjMCGOKe2y1O44LmsGHcxHLm5nnFvnBfEfQZc0K</password><roles><com.springbank.user.core.models.Role>READ_PRIVILEGE</com.springbank.user.core.models.Role></roles></account></user></com.springbank.user.core.events.UserUpdatedEvent>",
    "timestamp" : "2021-03-28T10:37:09.7773907Z",
    "payloadType" : "com.springbank.user.core.events.UserUpdatedEvent",
    "payloadRevision" : null,
    "serializedMetaData" : "<meta-data><entry><string>traceId</string><string>814ea759-1976-46ae-bd06-30db6ab31123</string></entry><entry><string>correlationId</string><string>814ea759-1976-46ae-bd06-30db6ab31123</string></entry></meta-data>",
    "eventIdentifier" : "c2f42aad-c4d6-4c4b-aa9c-026e923a94fa"
}
```


db.getCollection('users').find({})

```
/* 1 */
{
    "_id" : "635c9d5a-723f-4ace-b7b9-a0403811c344",
    "firstname" : "John",
    "lastname" : "Doe",
    "emailAddress" : "john@springbank.com",
    "account" : {
        "username" : "johnd",
        "password" : "$2a$12$aQJ8M1qVDOjlFaDYLguYuuEuCm2o2xl9ABYgHAofRPrEgdAVM8a0K",
        "roles" : [ 
            "READ_PRIVILEGE", 
            "WRITE_PRIVILEGE"
        ]
    },
    "_class" : "com.springbank.user.core.models.User"
}

/* 2 */
{
    "_id" : "e950598a-640f-4c25-8de5-4bb7bbfc2c35",
    "firstname" : "Jane",
    "lastname" : "Doe",
    "emailAddress" : "jane@springbank.com",
    "account" : {
        "username" : "janed",
        "password" : "$2a$12$CrjEZQup12Ymx2Jq/CAICe5p4Fjce9.o5c2bKsuFqxGppVNJ3509u",
        "roles" : [ 
            "READ_PRIVILEGE", 
            "WRITE_PRIVILEGE"
        ]
    },
    "_class" : "com.springbank.user.core.models.User"
}
```

you will notice that I have selected Axon framework for this course instead of an event streaming platform such as Apache Kafka, or a message-broker such as RabbitMQ. While both Kafka and RabbitMQ are excellent choices to implement CQRS and Event Sourcing, it is honestly rather complicated as you have suggested.

Now, as you progress through this course, you will be surprised just how easy CQRS and Event Sourcing becomes when you use the Axon framework. The Axon framework has been designed to separate business logic from infrastructural concerns, by abstracting most of the complexities that you would have to build yourself when using tools such as Apache Kafka or RabbitMQ.

My answer would simply be that if you use the Axon framework, you can base all of your microservice implementations on CQRS and Event Sourcing, because with Axon you almost only focus on writing domain or business logic code. However, when using other tools such as the ones that I have mentioned above (with a lower level of abstraction) things can get rather complex, since you will have to write a lot of additional code that is not required with Axon.


1. If you have a microservice that performs all of the CRUD operations, you will have to scale the entire service if that service takes a lot of hits. Data is often more frequently queried than altered (the reverse is also sometimes true). In other words, with CRUD you will have to scale up the entire service although only the read part could be the reason for the service taking strain.

2. It also makes sense to opt for CQRS if your read and write representation of data differs. On the read side, there might be additional columns or fields that you want to return that is not required on the write side, or you might want to update some data (from the command side) that you do not want to return on your query side. Segregating the command and query side reduces complexity and makes the models more maintainable and flexible.

3. Executing command and query operations on the same data model could cause data contention. Where data contention refers to multiple processes or instances competing for access to the same index or data block at the same time.

4. CQRS also allows you to optimize your microservices for high performance. In other words, since you have a write database on the command side, and a read database on the query side, it provides you with the ability to optimize your data access with indexes. To increase database read performance, one would typically create a number of indexes. The problem, however, is that indexes tends to slow down your database writes. So having a single database and a single service that performs CRUD, will force you to find a middle way and compromise performance somewhat to ensure that read and write performance are still acceptable. Therefore, it makes a lot of sense to go for an optimized CQRS design where we have two separate databases. Then we can add as much indexes to the tables or collections in the query database to optimize query performance. While removing all indexes from the tables or collections of the command database to optimize writes.

5. CQRS also promotes the idea of managing command and query security and permission differently. As you would know, user roles are generally based on read and/or write access. If you have two separate databases, reads do not require access on the write databases, and visa versa. At the same time, having a hard separation between writes and reads simplifies access permissions between commands and queries.


