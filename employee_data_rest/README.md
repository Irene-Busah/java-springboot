# 1. API Design & Development for Employee Directory
Create a REST API for employee directory. The REST client should be able to

- Get a list of employees
- Get a single employee by ID
- Add a new employee
- Update an employee
- Delete an employee

| HTTP Method   | Endpoint   | CRUD Action   |
|:-------------:|:----------:|:-------------:|
| POST          | /api/employees | Creates a new employee |
| GET           | /api/employees | Read a list of employees |
| GET           | /api/employees/{employeeId} | Reads a single employee
| PUT           | /api/employees | Update an existing employee |
| DELETE        | /api/employees/{employeeId} | Delete an existing employee |
