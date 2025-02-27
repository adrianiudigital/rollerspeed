
---

## **✅ PASO 1: INSTALACIÓN DE HERRAMIENTAS**  
✅ **Instalar Java JDK 17**  
✅ **Instalar VS Code + Extensiones**  
   - **Extension Pack for Java**  
   - **Spring Boot Tools**  
✅ **Instalar MySQL**  
✅ **Crear la base de datos `rollerspeed_db` en MySQL**  

---

## **✅ PASO 2: CREACIÓN DEL PROYECTO EN SPRING BOOT**  
✅ **Acceder a [Spring Initializr](https://start.spring.io/) y configurar el proyecto:**  
   - **Project:** Maven  
   - **Language:** Java  
   - **Spring Boot Version:** 3.3.8  
   - **Group:** `com.rollerspeed`  
   - **Artifact:** `rollerspeed`  
   - **Name:** `rollerspeed`  
   - **Packaging:** Jar  
   - **Java Version:** 17  

✅ **Seleccionar dependencias necesarias:**  
   - **Spring Web** (para manejar peticiones HTTP).  
   - **Thymeleaf** (para las vistas HTML).  
   - **Spring Data JPA** (para interactuar con la base de datos).  
   - **MySQL Driver**.  
   - **Spring Boot DevTools** (para recarga automática).  

✅ **Descargar el proyecto y abrirlo en VS Code.**  

---

## **✅ PASO 3: CONFIGURACIÓN DEL PROYECTO**  
✅ **Modificar `application.properties` para configurar MySQL:**  

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/rollerspeed_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

✅ **Crear la base de datos en MySQL:**  
```sql
CREATE DATABASE rollerspeed_db;
```

✅ **Ejecutar el proyecto y validar que Spring Boot inicia correctamente.**  

```sh
./mvnw spring-boot:run
```

📌 **Si la consola muestra `Started RollerspeedApplication`, el proyecto está funcionando.**  

---

## **✅ PASO 4: CREACIÓN DEL PRODUCTO MÍNIMO VIABLE (PMV)**  
✅ **Crear un navbar funcional con las siguientes opciones:**  
   - **Misión**  
   - **Visión**  
   - **Valores**  
   - **Servicios**  
   - **Eventos**  

📍 **Ubicación:** `src/main/resources/templates/navbar.html`  

✅ **Crear Controlador en `HomeController.java`**  
✅ **Crear las páginas HTML correspondientes en `src/main/resources/templates/`**  
✅ **El navbar y las secciones funcionan correctamente en Spring Boot.**  

---

## **❌ PASO 5: SUBIR EL CÓDIGO A GITHUB**  
📍 **Ejecutar los siguientes comandos:**  
```sh
git init
git add .
git commit -m "Subiendo PMV de Roller Speed"
git branch -M main
git remote add origin https://github.com/TU_USUARIO/rollerspeed.git
git push -u origin main
```

📌 **El código aún no está en GitHub.**  

---

## **❌ PASO 6: GRABACIÓN DEL VIDEO DE INSTALACIÓN Y CONFIGURACIÓN**  
📍 **El video debe incluir:**  
❌ Instalación de **Java JDK 17**, **VS Code**, **MySQL**.  
❌ Creación del **proyecto en Spring Boot**.  
❌ Configuración del **`application.properties`**.  
❌ Implementación del **navbar con Thymeleaf**.  
❌ Subida del código a **GitHub**.  

📌 **El video aún no ha sido grabado.**  

---

## **❌ PASO 7: DOCUMENTO DE ENTREGA**  
📍 **El documento debe incluir:**  
❌ **Portada** con los integrantes del grupo.  
❌ **Introducción** explicando la actividad.  
❌ **Conclusión** sobre la experiencia y su impacto en el mundo laboral.  
❌ **Enlace al video de configuración**.  

📌 **El documento aún no ha sido preparado.**  

---
