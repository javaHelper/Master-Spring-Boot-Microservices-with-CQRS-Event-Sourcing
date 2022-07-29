# Bank Account

# Create Token:

```sh
curl --location --request POST 'http://localhost:8084/oauth/token?grant_type=password&username=johnd&password=P@ssword1' \
--header 'Authorization: Basic c3ByaW5nYmFua0NsaWVudDpzcHJpbmdiYW5rU2VjcmV0' \
--header 'Cookie: JSESSIONID=F3978A05C8315B430A6159B61219FC09'
```

Response:

```json
{
    "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NTkwMzU0MzUsInVzZXJfbmFtZSI6ImpvaG5kIiwiYXV0aG9yaXRpZXMiOlsiUkVBRF9QUklWSUxFREdFIiwiV1JJVEVfUFJJVklMRURHRSJdLCJqdGkiOiJ5QXdDOGxWbkpTdWlnTnZ2dnVOd2JnQ2lScGMiLCJjbGllbnRfaWQiOiJzcHJpbmdiYW5rQ2xpZW50Iiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl19.ArL-dWh24PVTCnmnu-BIMMuX7rKVBBeAho02fdWB1Wo",
    "token_type": "bearer",
    "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJqb2huZCIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJhdGkiOiJ5QXdDOGxWbkpTdWlnTnZ2dnVOd2JnQ2lScGMiLCJleHAiOjE2NTkwMzY2MzUsImF1dGhvcml0aWVzIjpbIlJFQURfUFJJVklMRURHRSIsIldSSVRFX1BSSVZJTEVER0UiXSwianRpIjoiTDlpRGprY3lBZzRtc0VmWjNBYTIyajlaRkRBIiwiY2xpZW50X2lkIjoic3ByaW5nYmFua0NsaWVudCJ9.4xWsEewgBQnctq74G9j0QJodhbPrZTvG72dnjEEHaAs",
    "expires_in": 299,
    "scope": "read write",
    "jti": "yAwC8lVnJSuigNvvvuNwbgCiRpc"
}
```

# User Lookup

```sh
curl --location --request GET 'http://localhost:2000/api/v1/userLookup/' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NTkwMzU0MzUsInVzZXJfbmFtZSI6ImpvaG5kIiwiYXV0aG9yaXRpZXMiOlsiUkVBRF9QUklWSUxFREdFIiwiV1JJVEVfUFJJVklMRURHRSJdLCJqdGkiOiJ5QXdDOGxWbkpTdWlnTnZ2dnVOd2JnQ2lScGMiLCJjbGllbnRfaWQiOiJzcHJpbmdiYW5rQ2xpZW50Iiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl19.ArL-dWh24PVTCnmnu-BIMMuX7rKVBBeAho02fdWB1Wo'
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
        },
        {
            "id": "9ba5a78b-5933-4012-859f-77831ca33670",
            "firstname": "Mike",
            "lastname": "Doe",
            "emailAddress": "mike.doe@springbank.com",
            "account": {
                "username": "miked",
                "password": "$2a$12$xK9DUQFNbmR.bEygCWXTNe8ZY3CgMhTy9E5cFMbHIPHJWmhY.gP1q",
                "roles": [
                    "WRITE_PRIVILEDGE"
                ]
            }
        }
    ]
}
```

# Open Bank Account 

```sh
curl --location --request POST 'http://localhost:9071/api/v1/openBankAccount' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NTkwMzU0MzUsInVzZXJfbmFtZSI6ImpvaG5kIiwiYXV0aG9yaXRpZXMiOlsiUkVBRF9QUklWSUxFREdFIiwiV1JJVEVfUFJJVklMRURHRSJdLCJqdGkiOiJ5QXdDOGxWbkpTdWlnTnZ2dnVOd2JnQ2lScGMiLCJjbGllbnRfaWQiOiJzcHJpbmdiYW5rQ2xpZW50Iiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl19.ArL-dWh24PVTCnmnu-BIMMuX7rKVBBeAho02fdWB1Wo' \
--header 'Content-Type: application/json' \
--data-raw '{
    "accountHolderId": "4a299492-b7b9-4e9a-a69b-2e808e894408",
    "accountType": "CURRENT",
    "openingBalance": 100.0
}'
```

Response:

```
{
    "message": "successfully opened a new bank account!",
    "id": "1dabfabc-f9d5-4b08-b967-0608642daf97"
}
```json


# Deposite Funds

```sh
curl --location --request PUT 'http://localhost:2000/api/v1/depositFunds/0cdfe416-7b3c-4582-8c22-3cd77a376b6a' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NTkwNjk0MDAsInVzZXJfbmFtZSI6ImpvaG5kIiwiYXV0aG9yaXRpZXMiOlsiUkVBRF9QUklWSUxFREdFIiwiV1JJVEVfUFJJVklMRURHRSJdLCJqdGkiOiJNcjI1amRjYjVXcl9yZG5XTmNydnJBRG96eU0iLCJjbGllbnRfaWQiOiJzcHJpbmdiYW5rQ2xpZW50Iiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl19.ea5MWgUjqJCJcLpMc1_LFUwaiqABVO1tD_JtL__Myko' \
--header 'Content-Type: application/json' \
--data-raw '{
    "amount": 50.0
}'
```

Response:

```
{
    "message": "Funds successfully deposited!"
}
```

<img width="1049" alt="Screenshot 2022-07-29 at 10 33 52 AM" src="https://user-images.githubusercontent.com/54174687/181686436-89f5eade-2808-416c-a500-883684b02a7b.png">

# Withdraw Funds

```sh
curl --location --request PUT 'http://localhost:2000/api/v1/withdrawFunds/0cdfe416-7b3c-4582-8c22-3cd77a376b6a' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NTkwNzM5NTIsInVzZXJfbmFtZSI6ImpvaG5kIiwiYXV0aG9yaXRpZXMiOlsiUkVBRF9QUklWSUxFREdFIiwiV1JJVEVfUFJJVklMRURHRSJdLCJqdGkiOiJFTUo2eG1WMFZRZHp6cV90b2FaekdobXUwazQiLCJjbGllbnRfaWQiOiJzcHJpbmdiYW5rQ2xpZW50Iiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl19.HfDjtPVOoCXw8aLj7sMhYE8f_tOBK4fZzteGqh0wZlY' \
--header 'Content-Type: application/json' \
--data-raw '{
    "amount": 99.0
}'
```

Response:

```
{
    "message": "Withdrawal successfully completed!"
}
```

<img width="753" alt="Screenshot 2022-07-29 at 11 19 31 AM" src="https://user-images.githubusercontent.com/54174687/181691462-ebc63e9c-a9da-4adb-9c3d-9c3f76cc7ae9.png">

# Delete Bank Account

```sh
curl --location --request PUT 'http://localhost:2000/api/v1/closeBankAccount/0cdfe416-7b3c-4582-8c22-3cd77a376b6a' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NTkwNzM5NTIsInVzZXJfbmFtZSI6ImpvaG5kIiwiYXV0aG9yaXRpZXMiOlsiUkVBRF9QUklWSUxFREdFIiwiV1JJVEVfUFJJVklMRURHRSJdLCJqdGkiOiJFTUo2eG1WMFZRZHp6cV90b2FaekdobXUwazQiLCJjbGllbnRfaWQiOiJzcHJpbmdiYW5rQ2xpZW50Iiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl19.HfDjtPVOoCXw8aLj7sMhYE8f_tOBK4fZzteGqh0wZlY' \
--header 'Content-Type: application/json' \
--data-raw '{
    "amount": 99.0
}'
```

- Add 3 bank Accounts from scratch for John, Jane, Mike


```sh
curl --location --request POST 'http://localhost:9071/api/v1/openBankAccount' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NTkwNzQ1MDQsInVzZXJfbmFtZSI6ImpvaG5kIiwiYXV0aG9yaXRpZXMiOlsiUkVBRF9QUklWSUxFREdFIiwiV1JJVEVfUFJJVklMRURHRSJdLCJqdGkiOiJIekE3ZzVzRXdNbkZtRmxFd1NfRlhYcUgwX0UiLCJjbGllbnRfaWQiOiJzcHJpbmdiYW5rQ2xpZW50Iiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl19.3boguviTOC7NbqYNNhWCWRJHKWuZLfZOPwpfnmcSvCo' \
--header 'Content-Type: application/json' \
--data-raw '{
    "accountHolderId": "9bae0a74-4f13-4833-91e3-59fda3e59d06",
    "accountType": "CURRENT",
    "openingBalance": 300.0
}'
```



# Get All Accounts

```sh
curl --location --request GET 'http://localhost:2000/api/v1/bankAccountLookup/' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NTkwNzQzMTUsInVzZXJfbmFtZSI6ImpvaG5kIiwiYXV0aG9yaXRpZXMiOlsiUkVBRF9QUklWSUxFREdFIiwiV1JJVEVfUFJJVklMRURHRSJdLCJqdGkiOiIxbTRONHBSMTRScG5pSHk0bllfRmhGdUM2b1EiLCJjbGllbnRfaWQiOiJzcHJpbmdiYW5rQ2xpZW50Iiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl19.Pz40fp3ivdObH9ZxiXyTnbLMRJmi7Xvc7Th-HAqkHQ8' \
--header 'Content-Type: application/json' \
--data-raw '{
    "amount": 99.0
}'
```

Response:

```json
{
    "message": "Successfully Returned 3 Bank Account(s)!",
    "accounts": [
        {
            "id": "97b0529d-411d-44e3-986f-b7c9ed1fed01",
            "accountHolderId": "f599c03b-a9a3-4518-b191-d1541771ce2c",
            "creationDate": "2022-07-29T05:57:49.027+00:00",
            "accountType": "CURRENT",
            "balance": 200.0
        },
        {
            "id": "a9e3ab4f-6d9f-45ae-9134-346c53bf3a98",
            "accountHolderId": "9bae0a74-4f13-4833-91e3-59fda3e59d06",
            "creationDate": "2022-07-29T05:58:17.544+00:00",
            "accountType": "CURRENT",
            "balance": 300.0
        },
        {
            "id": "f99addce-2d08-4d76-8cac-5973b9256856",
            "accountHolderId": "4a299492-b7b9-4e9a-a69b-2e808e894408",
            "creationDate": "2022-07-29T05:57:01.493+00:00",
            "accountType": "SAVINGS",
            "balance": 100.0
        }
    ]
}
```

# Get Account By Id 

```sh
curl --location --request GET 'http://localhost:2000/api/v1/bankAccountLookup/byId/97b0529d-411d-44e3-986f-b7c9ed1fed01' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NTkwNzQ2NjIsInVzZXJfbmFtZSI6ImpvaG5kIiwiYXV0aG9yaXRpZXMiOlsiUkVBRF9QUklWSUxFREdFIiwiV1JJVEVfUFJJVklMRURHRSJdLCJqdGkiOiJicFpjN0RadkhuSUFLSktGQTNsLUZDRkdHN2ciLCJjbGllbnRfaWQiOiJzcHJpbmdiYW5rQ2xpZW50Iiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl19.B-Ir1Heb9qvzFcStpA03iblJkTbTZKJPjucES2Ekdew' \
--header 'Content-Type: application/json' \
--data-raw '{
    "amount": 99.0
}'
```

Response:

```json
{
    "message": "Bank Account Successfully Returned!",
    "accounts": [
        {
            "id": "97b0529d-411d-44e3-986f-b7c9ed1fed01",
            "accountHolderId": "f599c03b-a9a3-4518-b191-d1541771ce2c",
            "creationDate": "2022-07-29T05:57:49.027+00:00",
            "accountType": "CURRENT",
            "balance": 200.0
        }
    ]
}
```

# Get Account By HolderId

```sh
curl --location --request GET 'http://localhost:2000/api/v1/bankAccountLookup/byHolderId/f599c03b-a9a3-4518-b191-d1541771ce2c' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NTkwNzQ2NjIsInVzZXJfbmFtZSI6ImpvaG5kIiwiYXV0aG9yaXRpZXMiOlsiUkVBRF9QUklWSUxFREdFIiwiV1JJVEVfUFJJVklMRURHRSJdLCJqdGkiOiJicFpjN0RadkhuSUFLSktGQTNsLUZDRkdHN2ciLCJjbGllbnRfaWQiOiJzcHJpbmdiYW5rQ2xpZW50Iiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl19.B-Ir1Heb9qvzFcStpA03iblJkTbTZKJPjucES2Ekdew' \
--header 'Content-Type: application/json' \
--data-raw '{
    "amount": 99.0
}'
```

Response:

```json
{
    "message": "Bank Account Successfully Returned!",
    "accounts": [
        {
            "id": "97b0529d-411d-44e3-986f-b7c9ed1fed01",
            "accountHolderId": "f599c03b-a9a3-4518-b191-d1541771ce2c",
            "creationDate": "2022-07-29T05:57:49.027+00:00",
            "accountType": "CURRENT",
            "balance": 200.0
        }
    ]
}
```

# Get Account Holder based On Equity Type

```sh
curl --location --request GET 'http://localhost:2000/api/v1/bankAccountLookup/withBalance/GREATER_THAN/200' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NTkwNzQ2NjIsInVzZXJfbmFtZSI6ImpvaG5kIiwiYXV0aG9yaXRpZXMiOlsiUkVBRF9QUklWSUxFREdFIiwiV1JJVEVfUFJJVklMRURHRSJdLCJqdGkiOiJicFpjN0RadkhuSUFLSktGQTNsLUZDRkdHN2ciLCJjbGllbnRfaWQiOiJzcHJpbmdiYW5rQ2xpZW50Iiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl19.B-Ir1Heb9qvzFcStpA03iblJkTbTZKJPjucES2Ekdew' \
--header 'Content-Type: application/json' \
--data-raw '{
    "amount": 99.0
}'
```

Response:

```json
{
    "message": "Successfully Returned 1 Bank Account(s)!",
    "accounts": [
        {
            "id": "a9e3ab4f-6d9f-45ae-9134-346c53bf3a98",
            "accountHolderId": "9bae0a74-4f13-4833-91e3-59fda3e59d06",
            "creationDate": "2022-07-29T05:58:17.544+00:00",
            "accountType": "CURRENT",
            "balance": 300.0
        }
    ]
}
```
<img width="1261" alt="Screenshot 2022-07-29 at 11 40 33 AM" src="https://user-images.githubusercontent.com/54174687/181694263-05076437-d723-4e28-ac39-15f6bf84e3ad.png">

<img width="781" alt="Screenshot 2022-07-29 at 11 40 43 AM" src="https://user-images.githubusercontent.com/54174687/181694312-71eac787-b598-434b-bb0c-5dfd6e440bfe.png">


