![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-00758F?style=for-the-badge&logo=mysql&logoColor=white)
# 🪪 License Verification System (Java + JDBC + MySQL)

## 📌 Project Description
This is a console-based Java application that verifies a driving license application using PAN Card and Aadhaar Card details.

The system validates:
- PAN ID
- Aadhaar Number
- Name Match
- Date of Birth Match
- Address Match
- Age Eligibility (18–60 years)

If verification is successful, the application is stored in the database.

---

## 🛠 Technologies Used
- Core Java
- JDBC
- MySQL
- Eclipse IDE
- Layered Architecture (Model – DAO – Service)

---

## 🏗 Project Structure
License-Verification-System
│
├── src
│ ├── model
│ │ ├── PanCard.java
│ │ ├── AadhaarCard.java
│ │ └── LicenceApplication.java
│ │
│ ├── dao
│ │ ├── PanDAO.java
│ │ ├── AadhaarDAO.java
│ │ └── LicenceDAO.java
│ │
│ ├── service
│ │ └── LicenceService.java
│ │
│ ├── exception
│ │ └── DatabaseException.java
│ │
│ └── util
│ └── DB.java
│
├── .gitignore
└── README.md

---

## 🔄 Application Flow

1. User enters PAN ID and Aadhaar Number
2. DAO fetches data from database
3. Service layer verifies:
   - Age eligibility
   - Name match
   - DOB match
   - Address match
4. If verified → Insert into `application` table
5. Duplicate applications are prevented

---

## 🗄 Database Tables

### pancard
- pan_id (Primary Key)
- pan_name
- pan_address
- dob

### aadhaarcard
- aadhaar_num (Primary Key)
- aadhaar_name
- aadhaar_address
- dob

### application
- applicant_id (AUTO_INCREMENT Primary Key)
- applicant_name
- applicant_dob
- applicant_address
- pan_id
- aadhaar_num

---

## 🚀 How to Run

1. Clone repository:
2. Import into Eclipse
3. Configure database in `DB.java`
4. Run `Main.java`

---

## ✅ Features

✔ Clean Layered Architecture  
✔ JDBC PreparedStatement (SQL Injection Safe)  
✔ Custom Exception Handling  
✔ Age Validation Logic  
✔ Duplicate Application Prevention  

---

## 👨‍💻 Author

**Dhelip Kumar**  
Aspiring Java Backend Developer  


