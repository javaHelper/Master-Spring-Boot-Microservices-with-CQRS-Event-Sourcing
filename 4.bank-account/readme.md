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


