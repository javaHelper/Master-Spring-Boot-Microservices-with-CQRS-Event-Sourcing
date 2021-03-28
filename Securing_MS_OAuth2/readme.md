#

Request - 

```
curl --location --request POST 'http://localhost:8084/oauth/token' \
--header 'authorization: Basic c3ByaW5nYmFua0NsaWVudDpzcHJpbmdiYW5rU2VjcmV0' \
--header 'content-type: application/x-www-form-urlencoded' \
--data-urlencode 'grant_type=password' \
--data-urlencode 'username=johnd' \
--data-urlencode 'password=P@ssw0rd1'
```


```
{
    "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2MTY5Mzk5MzgsInVzZXJfbmFtZSI6ImpvaG5kIiwiYXV0aG9yaXRpZXMiOlsiUkVBRF9QUklWSUxFR0UiLCJXUklURV9QUklWSUxFR0UiXSwianRpIjoiNjk2NjRkYTAtNmQ3ZS00YWRmLTkzMjMtZjQyMzAwYzY1M2E1IiwiY2xpZW50X2lkIjoic3ByaW5nYmFua0NsaWVudCIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdfQ.zfNtY6NxW1Js9u7xVewreqP203Kcjbsv73Cz-bjk3MU",
    "token_type": "bearer",
    "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJqb2huZCIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJhdGkiOiI2OTY2NGRhMC02ZDdlLTRhZGYtOTMyMy1mNDIzMDBjNjUzYTUiLCJleHAiOjE2MTY5NDExMzgsImF1dGhvcml0aWVzIjpbIlJFQURfUFJJVklMRUdFIiwiV1JJVEVfUFJJVklMRUdFIl0sImp0aSI6IjA5ZGZmMzMwLTBlYjUtNDgwMy1hOTgxLTUxODNmZWU2NzA4ZSIsImNsaWVudF9pZCI6InNwcmluZ2JhbmtDbGllbnQifQ.F_1RN3jX-BZrDEpZKbplieq85PJHoufeYR-AEc3kRvk",
    "expires_in": 299,
    "scope": "read write",
    "jti": "69664da0-6d7e-4adf-9323-f42300c653a5"
}
```


Creare New User

```
curl --location --request POST 'http://localhost:8081/api/v1/registerUser' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2MTY5Mzc1ODcsInVzZXJfbmFtZSI6ImpvaG5kIiwiYXV0aG9yaXRpZXMiOlsiUkVBRF9QUklWSUxFR0UiLCJXUklURV9QUklWSUxFR0UiXSwianRpIjoiOTk2MTBiMDItMGQ1Ni00YzE1LWI2MjYtOWQ2NDcwNjM2MzJlIiwiY2xpZW50X2lkIjoic3ByaW5nYmFua0NsaWVudCIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdfQ.LCAKPw4cDFfOBfppf5IWm_QI7rX1IfLAUrZ_JSc0XiE' \
--header 'Content-Type: application/json' \
--data-raw '{
	"user" : {
		"firstname" : "James",
		"lastname" : "Doe",
		"emailAddress" : "james01@springbank.com",
		"account" : {
			"username": "jamesd01",
			"password" : "P@ssw0rd4",
			"roles" : [
				"WRITE_PRIVILEGE"	
			]
		}
	}
}'
```

Update new user

```
curl --location --request PUT 'http://localhost:8081/api/v1/updateUser/a2d1fd95-7a8d-4de8-9dee-8b6c3a715216' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2MTY5Mzk3NDYsInVzZXJfbmFtZSI6ImpvaG5kIiwiYXV0aG9yaXRpZXMiOlsiUkVBRF9QUklWSUxFR0UiLCJXUklURV9QUklWSUxFR0UiXSwianRpIjoiZWQ2NmVhMzYtNTFiNC00ZjUwLWE1YzItODc1MDBmOWU0MDc0IiwiY2xpZW50X2lkIjoic3ByaW5nYmFua0NsaWVudCIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdfQ.ul2mLym6DudcMTZKba3z_cboRfmfMSJU5-ECfRkLanc' \
--header 'Content-Type: application/json' \
--data-raw '{
	"user" : {
		"firstname" : "James",
		"lastname" : "Doe",
		"emailAddress" : "james_01@springbank.com",
		"account" : {
			"username": "jamesd01",
			"password" : "P@ssw0rd4",
			"roles" : [
				"WRITE_PRIVILEGE"	
			]
		}
	}
}'
```