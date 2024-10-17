![image](https://github.com/user-attachments/assets/bf19f912-dbb5-4732-852a-83d4aa944b41)

# Using JDK 21 & MySQL for project

# Our app feature version:
> _v1-scrum4: first version of the main features in SCRUM sprint 4_

# Our app deployment version: [https://community-support-project.onrender.com](#https://community-support-project.onrender.com)
> _version0-scrum4: deploy without FORM entity_
> 
> _version1-scrum4: deploy with USER, ORGANIZATION, FORM entity (the main features in SCRUM sprint 4)_

# Notes:

- _Input data validation is the responsibility of the front-end. If it have invalided, back-end will reponse with api error code (such as not null, min size, ...)_

## How to using endpoints:

**_1. Authentication endpoint:_**
- [/api/auth/login](#/api/auth/login) -> **_GET: login with 2 options (organization or user)_**
> **_Input data_**
>
> ![image](https://github.com/user-attachments/assets/86742b15-8989-45a3-9e9b-bb7c2fca0519)
>
> ![image](https://github.com/user-attachments/assets/7914c52b-7f6c-4aab-9234-f57ec5f13801)

> **_Output_**
>
> ![image](https://github.com/user-attachments/assets/dc669cf8-c5a5-4e02-b562-cfb18ede3454)
>
> ![image](https://github.com/user-attachments/assets/42654822-11fa-4823-b087-d901aa769d77)


**_2. User endpoints:_**

- [/api/users](#/api/users) -> **_GET: return all Users_**
> **_Output_**
> 
> ![image](https://github.com/user-attachments/assets/dabf64ea-67d0-41bb-bcb2-7881d229e8aa)

- [/api/users](#/api/users) -> **_POST: create new User - response same like get User's information. The phone number is unique_**
> **_Output_**
> 
> ![image](https://github.com/user-attachments/assets/e43d0102-2f60-44c4-9b13-a1155bb0c6dd)

- [/api/users/{userId}](#/api/users) -> **_GET: return User's information (need id)_**
> **_Output_**
> 
> ![Untitled](https://github.com/user-attachments/assets/c942128b-c4f7-405d-97c0-f44da646dd5d)

- [/api/users/{userId}](#/api/users) -> **_PUT: UPDATE user's information (need id) - repsonse same like get User's infomation_**

> **_Input data_** (we just only accept adjusting password, fullName and address):
> 
> ![image](https://github.com/user-attachments/assets/6aa9eae0-c763-45c7-a289-3a48f6dd54e7)

- [/api/users/{userId}](#/api/users) -> **_DELETE: delete user (need id)_**
> **_Output_**
> 
> ![image](https://github.com/user-attachments/assets/56154351-f327-40a9-b125-42516e545baf)

**_3. Form endpoints:_**

**_4. Organization endpoints:_**

## ...

## Constructor of API Response:

```java
public class ApiResponse<T> {
    private int code = 1000;
    String message;
    T result;
}
```

_(Updating ...)_

```java
    USER_EXISTED(1001, "User existed with this phone number or this identifier number", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(1002, "User not found!", HttpStatus.BAD_REQUEST),

    WRONG_PHONE_NUMBER(1003, "Wrong phone number",HttpStatus.BAD_REQUEST),
    WRONG_PASSWORD(1004, "Wrong password",HttpStatus.BAD_REQUEST),

    PHONE_NUMBER_INVALID(1005, "Phone number must be 10 character", HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID(1006, "Password must be at least 8 character", HttpStatus.BAD_REQUEST),
    CCCD_INVALID(1007, "CCCD must be at least 12 character", HttpStatus.BAD_REQUEST),


    INVALID_KEY(8888, "Invalid message key", HttpStatus.BAD_REQUEST),
//  UNAUTHENTICATED(9999, "", HttpStatus.BAD_REQUEST);
```
