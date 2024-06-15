# TCI-Digital-Labs
# Thomas Cook Employee Bonus Assignment

## Introduction

Its a small springboot application which has two apis 1. post to add employees and 2. get to get the eligible employees for bonus.

## Implementation Details

The project consists of the following components:

- **Controllers:**
-  EmployeeBonusController
- **dto:**
- EmployeeBonusResponse
- **models:**
- Employee
- **exceptions:**
- customeceptionhandler
- **repositories:**
- BonusRepo
- EmployeeRepo
- **services:**
- BonusService
- EmployeeBonusservice


## Testing

The project includes comprehensive unit tests to ensure correctness and robustness. 

## APIs

### POST API Signature and Payload

#### POST /tci/employee-bonus

**Request Payload sample:**

```json
{
	"employees": [
		{
			"empName": "raj singh",
			"department": "accounts",
			"amount": 5000,
			"currency": "INR",
			"joiningDate": "may-20-2022",
			"exitDate": "may-20-2023"
		},
		{
			"empName": "pratap m",
			"department": "accounts",
			"amount": 3000,
			"currency": "INR",
			"joiningDate": "jan-01-2021",
			"exitDate": "may-20-2023"
		},
		...
	]
}
```

### GET API Signature and Payload

#### GET /tci/employee-bonus?date=”may-27-2022”

**Request Payload sample:**

```json
{
	"errorMessage": "",
	"data": [
		{
			"currency": "INR",
			"employees": [
				{
					"empName": "pratap m",
					"amount": 3000
				},
				{
					"name": "raj singh",
					"amount": 5000
				}
			]
		},
		{
			"currency": "USD",
			"employees": [
				{
					"empName": "sam",
					"amount": 2500
				},
				{
					"empName": "susan",
					"amount": 700
				}
			]
		}
	]
}
```



