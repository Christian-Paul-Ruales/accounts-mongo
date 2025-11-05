# 🏦 ACCOUNTS
[![Version](https://img.shields.io/badge/Version-git-red?logo=git)](https://git-scm.com/)
[![Java](https://img.shields.io/badge/Java-21-white?logo=openjdk)](https://www.oracle.com/java/technologies/downloads/)
[![Build](https://img.shields.io/badge/Build-SpringBoot-green?logo=spring-boot)](https://start.spring.io/)
[![Build](https://img.shields.io/badge/Build-Docker-green?logo=docker)](https://docs.docker.com/desktop/)
[![Version](https://img.shields.io/badge/BBDD-Mongodb-3F851E?logo=mongodb)](https://www.mongodb.com/)
## 📋 Descripción
Proyecto basico de ejemplo con una arquitectura hexagonal basica con spring boot y mongo db

## ⚠️ Importante
La documentacion se encuentra en la carpeta ***/docs***

## 🔧 Herramientas recomendadas
* Intellij idea
* Git
* Java 21
* Docker Desktop

## 🚀 Instalación y Ejecución
1. Clonar el repositorio
2. Ejecución del contenedor
```shell
docker compose -f docker-compose-dev.yml up -d --build
```
3.1. Ejecucion desde el IDE, configurado java 21 ***Current File***
3.2. con maven

```shell
mvn clean install
```
