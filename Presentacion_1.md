
---

# **📌 Presentación del Proyecto "Roller Speed"**  

## **1️⃣ Introducción**
### **🔹 Breve presentación del equipo y objetivo del proyecto 2.0**  
El proyecto **Roller Speed** surge como una solución tecnológica para mejorar la gestión de una escuela de patinaje. La idea principal es optimizar la administración de clases, usuarios, asistencia y pagos, ofreciendo una plataforma estructurada y eficiente. El equipo de desarrollo ha trabajado en la implementación de una **arquitectura MVC** con buenas prácticas en el backend para garantizar un código limpio, seguro y escalable.

### **🔹 Explicación de la finalidad del sistema**  
El sistema **automatiza procesos administrativos** dentro de una escuela de patinaje, permitiendo registrar estudiantes, instructores y clases, gestionar pagos y reportes, y ofrecer un acceso centralizado a la información institucional. Con esta solución, se busca **mejorar la experiencia tanto de los administradores como de los alumnos**, reduciendo la carga manual de gestión y brindando una plataforma digital moderna.

### **🔹 Características principales del proyecto**  
- **Autenticación segura con JWT.**
- **Gestión de usuarios con distintos roles.**
- **Registro y administración de clases y asistencia.**
- **Panel de control para la gestión de pagos y reportes.**
- **Interfaz web con Thymeleaf y Bootstrap.**
- **Conexión a una base de datos MySQL con JPA.**

---

## **2️⃣ Tecnologías Utilizadas**
### **🔹 Backend: Java con Spring Boot**  
El backend se implementó utilizando **Spring Boot**, un framework que permite desarrollar aplicaciones Java de manera rápida y eficiente. Se utilizó **Spring Data JPA** para la persistencia de datos, y **Spring Security** para la autenticación y control de acceso.

### **🔹 Base de datos: MySQL**  
Se eligió **MySQL** como sistema de base de datos relacional, permitiendo almacenar la información de manera estructurada y realizar consultas eficientes. Se utilizó **Hibernate con JPA** para mapear las entidades del backend a las tablas en la base de datos.

### **🔹 Frontend y herramientas adicionales**  
Si bien la interfaz principal se construyó con **Thymeleaf**, el sistema está preparado para integrarse con frameworks frontend modernos como **React o Angular**. Además, se usó **Postman** para probar la API y **Maven** para gestionar dependencias.

---

## **3️⃣ Estructura del Proyecto**
### **🔹 Capas del backend**  
El proyecto sigue una **arquitectura basada en capas**, dividiendo la aplicación en componentes modulares que facilitan la mantenibilidad y escalabilidad del código:
1. **Controllers:** Se encargan de recibir y procesar las peticiones HTTP.
2. **Services:** Contienen la lógica del negocio y validaciones.
3. **Repositories:** Administran la interacción con la base de datos mediante **JPA**.
4. **Entities:** Definen las estructuras de datos que se almacenan en la base de datos.
5. **Security:** Implementa la autenticación con JWT y gestión de roles.

### **🔹 Funcionalidades implementadas**  
- **Registro e inicio de sesión con autenticación segura.**
- **Gestión de usuarios con asignación de roles.**
- **Administración de clases y horarios.**
- **Control de asistencia y pagos.**
- **Manejo de información institucional (misión, visión, valores, servicios, eventos).**

---

## **4️⃣ Implementación y Configuración**
### **🔹 Creación del Proyecto en Spring Initializr**  
Para la creación del proyecto, se utilizó **Spring Initializr**, seleccionando las dependencias necesarias para el desarrollo. Entre ellas se incluyeron:
- **Spring Web:** Para la construcción de la API REST.
- **Spring Data JPA:** Para la gestión de la base de datos.
- **Spring Security:** Para la autenticación y autorización.
- **Thymeleaf:** Para la generación de vistas dinámicas.

### **🔹 Configuración de la Base de Datos**  
Se estableció la conexión con MySQL en el archivo `application.properties` y se creó la base de datos `rollerspeed_db` con la siguiente configuración:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/rollerspeed_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```

---

## **5️⃣ Implementación de Seguridad**
### **🔹 Spring Security con JWT**  
El sistema de autenticación se implementó con **JSON Web Tokens (JWT)**, lo que permite la validación de usuarios y la restricción de acceso a recursos sensibles. Se definieron tres roles:
- **ADMIN:** Acceso completo a la plataforma.
- **INSTRUCTOR:** Puede gestionar clases y asistencia.
- **STUDENT:** Acceso a información personal y clases inscritas.

Ejemplo de filtro de seguridad:
```java
if (tokenBlacklist.isTokenBlacklisted(token)) {
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    return;
}
```

---

## **6️⃣ Endpoints y API REST**
### **🔹 Principales Endpoints**  
Se diseñó una API RESTful con endpoints organizados en `/api/v1`. Algunos de los más relevantes son:

| Método | Endpoint               | Descripción |
|--------|------------------------|-------------|
| `POST` | `/auth/register`       | Registrar usuario |
| `POST` | `/auth/login`          | Iniciar sesión |
| `GET`  | `/users`               | Listar todos los usuarios |
| `POST` | `/classes`             | Crear una clase |
| `GET`  | `/classes/{id}`        | Obtener detalles de una clase |

Todos los endpoints protegidos requieren **autenticación con JWT**.

---

## **7️⃣ Despliegue y Pruebas**
### **🔹 Uso de DevTools para recarga automática**  
Para mejorar la experiencia de desarrollo, se usó **Spring Boot DevTools**, que permite la recarga automática de cambios sin necesidad de reiniciar manualmente el servidor.

### **🔹 Pruebas con Postman y JUnit**  
Se desarrollaron pruebas con **JUnit** para validar la correcta ejecución de los servicios, y se usó **Postman** para testear la API, verificando respuestas esperadas en cada endpoint.

### **🔹 Subida del código a GitHub**  
El código fue versionado con Git y alojado en **GitHub**, permitiendo mantener un control adecuado sobre las versiones del proyecto.

---

## **8️⃣ Conclusiones y Reflexión**
### **🔹 ¿Qué aprendimos con esta actividad?**  
El desarrollo de **Roller Speed** permitió afianzar conocimientos en **arquitectura MVC, seguridad con JWT y persistencia de datos con JPA**. Se trabajó en equipo para implementar una solución robusta y funcional.

### **🔹 ¿Cuáles fueron los principales retos?**  
- Configuración de seguridad con **Spring Security y JWT**.
- Integración de múltiples capas en la arquitectura.
- Definición de endpoints con buenas prácticas RESTful.

### **🔹 ¿Cómo este proyecto puede mejorar en el futuro?**  
Algunas mejoras futuras incluyen:
- Implementación de una **interfaz frontend con React**.
- Mejoras en la experiencia de usuario con **notificaciones y reportes dinámicos**.
- Optimización de la **gestión de pagos y asistencia**.

---

## **9️⃣ Demo en Vivo**
Para cerrar la presentación, se realizará una demostración en vivo mostrando:
1. **Inicio de sesión en la aplicación**.
2. **Creación y gestión de usuarios y clases**.
3. **Pruebas de API con Postman**.
4. **Consulta de información institucional en la interfaz web**.

---
