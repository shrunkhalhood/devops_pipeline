# 🐳 Mini Full Stack Demo — Dockerized Local Setup

> **Branch:** `dockerized-local-setup`  
> **Base Project:** AI-Powered-CI-CD-Failure-Analyzer  
> **Docker Hub:** [shrunkhood/mini-full-stack-demo](https://hub.docker.com/repository/docker/shrunkhood/mini-full-stack-demo)

---

## 🧠 Why This Branch Exists

The original version of this app was tightly coupled with **Amazon RDS** (AWS managed database).  
This meant:
- ❌ The app only worked if AWS RDS was running
- ❌ High cost — RDS charges even when idle
- ❌ Not portable — others couldn't run it locally
- ❌ No local testing possible without AWS credentials

### ✅ Solution
 I created this branch to make the app **fully portable and Docker-based**:
- No AWS dependency
- Runs entirely on your local machine
- Anyone can clone and run it in minutes
- MySQL runs inside Docker — no manual DB setup needed


---

---


## ✅ Prerequisites

Make sure you have these installed on your machine:

- [Docker](https://www.docker.com/products/docker-desktop)
- [Git](https://git-scm.com/)

---

## 🚀 How To Run The App

### Step 1 — Clone the Repository
```bash
git clone https://github.com/shrunkhalhood/AI-Powered-CI-CD-Failure-Analyzer.git
```

### Step 2 — Switch to This Branch
```bash
cd AI-Powered-CI-CD-Failure-Analyzer
git checkout dockerized-local-setup
```

### Step 3 — Pull the Latest Docker Image
```bash
docker pull shrunkhood/mini-full-stack-demo:latest
```

### Step 4 — Start the App
```bash
docker-compose up -d
```
👉 This will start both **MySQL** and the **Spring Boot app** automatically.
You have to just wait for **3-5 minutes**

### Step 5 — Open in Browser
```
http://localhost:8080
```
🎉 Your app is live!

---

## 🛑 How To Stop The App
```bash
docker-compose down
```

---

## 🔍 How To View Registered Data
```bash
docker exec -it mysql-db mysql -u root -proot
```
Then inside MySQL:
```sql
use playerdb;
select * from users;
```

---

## ⚙️ How It Works Internally
```
[ Browser ] → [ Spring Boot App :8080 ] → [ MySQL DB :3306 ]
                    (spring-app)               (mysql-db)
                 Docker Container          Docker Container
                       |___________________________|
                          Docker Network
```

---

## 🙌 Author

**Shrunkhal** — [@shrunkhalhood](https://github.com/shrunkhalhood)
