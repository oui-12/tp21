# 🏗️ Architecture Microservices avec Spring Cloud et WebClient

## 📋 Description du Projet
🔹 Ce projet démontre une architecture microservices utilisant Spring Cloud et WebClient  
🔹 Il comprend un serveur Eureka pour la découverte de services et deux microservices : service-client et service-car

## 🚀 Services du Projet

### 1️⃣ Eureka Server (service-discovery)
📍 **Port**: 8761  
🔧 **Fonctionnalité**: Service de découverte pour gérer l'enregistrement et la localisation des microservices  
🌐 **Accès**: http://localhost:8761

### 2️⃣ Service Client
📍 **Port**: 8081  
👥 **Fonctionnalité**: Gestion des clients et de leurs interactions avec les voitures  
🔗 **Dépendances**: Se connecte à service-car via WebClient

### 3️⃣ Service Car
📍 **Port**: 8082  
🚗 **Fonctionnalité**: Gestion du catalogue de voitures  
🔌 **API**: Fournit des endpoints REST pour les opérations CRUD sur les voitures

## 🛠️ Technologies Utilisées

### Backend
- ☕ **Java 17** - Langage de programmation principal
- 🌿 **Spring Boot 3.2.0** - Framework d'application
- ☁️ **Spring Cloud** - Pour les fonctionnalités cloud
- 🔍 **Eureka Server** - Découverte de services
- 🔄 **WebClient** - Client HTTP réactif
- 🏗️ **Maven** - Gestion des dépendances

## 🚀 Démarrage Rapide

1. **Démarrer le serveur Eureka**
   ```bash
   cd eureka-server
   mvn spring-boot:run
