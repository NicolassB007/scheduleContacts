# Schedule Contacts API
---

## Tools used in this project
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)

---  

## API Goal
My goal for this project is improve more my development skills using  
Spring Boot with Kotlin.

### What feature does this project have? 
- Regex for validate email and phone number at Service Layer;
- DTOs for data transfer;
- Repository, Controller, Service and Model layers.  

---  

## Endpoints  
- GET
  - /api/contacts: This endpoint return all contacts.
- POST
  - /api/register: This endpoint save the contact in Database.

---  

## POST: Request JSON (Return STATUS 201 - CREATED)
- Request:
  ```
  {
    "name": "Nicolas",
    "email": "nicolasemail123@admin.com",
    "phone": "(14) 12345-6712"
  }
  ```

- Body:
  ```
  {
      "id": 1,
      "name": "Nicolas",
      "email": "nicolasemail123@admin.com",
      "phone": "(14) 12345-6712",
      "registeredDate": "2026-03-28"
  }
  ```

## GET: Response JSON (Return STATUS 200 - OK)
- ```
  [
      {
          "id": 1,
          "name": "Nicolas",
          "phone": "(14) 12345-6712",
          "email": "nicolasemail123@admin.com",
          "registerDate": "2026-03-28"
      }
  ]
  ```






