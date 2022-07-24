#

- Note: User with `WRITE_PRIVILEDGE` should be able to create user and use with `READ_PRIVILEDGE` should only be able to read data.

Goto https://www.base64encode.org/ and `springbankClient:springbankSecret` and get encoded value `c3ByaW5nYmFua0NsaWVudDpzcHJpbmdiYW5rU2VjcmV0`

# Create Token!

```sh
curl --location --request POST 'http://localhost:8084/oauth/token?grant_type=password&username=janed&password=P@ssword2' \
--header 'Authorization: Basic c3ByaW5nYmFua0NsaWVudDpzcHJpbmdiYW5rU2VjcmV0' \
--header 'Cookie: JSESSIONID=F3978A05C8315B430A6159B61219FC09'
```

Copy token and make the subsequent request.

GET -> 

```sh
curl --location --request GET 'http://localhost:8092/api/v1/userLookup/' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NTg2Nzk4ODgsInVzZXJfbmFtZSI6ImphbmVkIiwiYXV0aG9yaXRpZXMiOlsiUkVBRF9QUklWSUxFREdFIl0sImp0aSI6IlVPYk0xdVVkSndMUGkta0pPRXYzdVlZS0FqbyIsImNsaWVudF9pZCI6InNwcmluZ2JhbmtDbGllbnQiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXX0.bH1JXR5ylcnQ0NsY1kw6xC-Y3SGCk4LafIsNgsRh5wQ' \
--header 'Cookie: JSESSIONID=F3978A05C8315B430A6159B61219FC09'
```

Response:

```sh
{
    "message": null,
    "users": [
        {
            "id": "4a299492-b7b9-4e9a-a69b-2e808e894408",
            "firstname": "John",
            "lastname": "Doe",
            "emailAddress": "john.doe@springbank.com",
            "account": {
                "username": "johnd",
                "password": "$2a$12$5sSOVFanmoDxsjxw1rWZBukI6O7t9eBhneMEDoQFeJ7Ni35Hl8/zO",
                "roles": [
                    "READ_PRIVILEDGE",
                    "WRITE_PRIVILEDGE"
                ]
            }
        },
        {
            "id": "f599c03b-a9a3-4518-b191-d1541771ce2c",
            "firstname": "Jane",
            "lastname": "Doe",
            "emailAddress": "jane.doe@springbank.com",
            "account": {
                "username": "janed",
                "password": "$2a$12$FN3I11muZfp4pes82zLL.uqMcuoKvzs351VJJDxO5NPGVdTlREVzW",
                "roles": [
                    "READ_PRIVILEDGE"
                ]
            }
        },
        {
            "id": "9bae0a74-4f13-4833-91e3-59fda3e59d06",
            "firstname": "James",
            "lastname": "Doe",
            "emailAddress": "james.doe@springbank.com",
            "account": {
                "username": "jamesd",
                "password": "$2a$12$UGC6B8oIj8oCKZPD3mpM7.LUej.mQ3JhCOoWOXoUgrpyGghrWBmsm",
                "roles": [
                    "WRITE_PRIVILEDGE"
                ]
            }
        }
    ]
}
```



