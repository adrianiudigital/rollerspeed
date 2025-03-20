
---

## **📌 PASOS DETALLADOS PARA COMPLETAR LA ENTREGA 2**

💡 **Objetivo:** Terminar **toda la implementación y documentación** para la entrega final.

---

### **🔹 1️⃣ Configuración Inicial**

✅ **1.1.** Verificar que **MySQL está correctamente configurado**.  
✅ **1.2.** Asegurar que el **archivo `application.properties`** tiene los datos correctos de conexión.  
✅ **1.3.** Probar la conexión a la base de datos ejecutando:  
```sh
./mvnw spring-boot:run
```
✅ **1.4.** Confirmar que la aplicación inicia sin errores.  

---

### **🔹 2️⃣ Implementación del Menú Principal con Thymeleaf**

✅ **2.1.** Crear el **navbar funcional en `navbar.html`** con las siguientes opciones:

- 🏠 **Inicio**
- 🎯 **Misión**
- 👀 **Visión**
- ⭐ **Valores**
- 🏆 **Servicios**
- 📅 **Eventos**  
✅ **2.2.** Crear los archivos **HTML en `src/main/resources/templates/`**:
- `index.html`
- `mision.html`
- `vision.html`
- `valores.html`
- `servicios.html`
- `eventos.html`  
✅ **2.3.** Implementar el **HomeController** en `HomeController.java` para manejar las rutas.  
✅ **2.4.** Probar en el navegador que todas las rutas funcionan (`http://localhost:8080/`).  

---

### **🔹 3️⃣ Registro y Gestión de Usuarios**

✅ **3.1.** Implementar el **registro de estudiantes e instructores** con un formulario.  
✅ **3.2.** Crear las entidades `Student` e `Instructor` en **Java con JPA**.  
✅ **3.3.** Crear los `Controllers` correspondientes para manejar las rutas de registro.  
✅ **3.4.** Probar que los usuarios se registran correctamente en la base de datos.  
✅ **3.5.** Implementar la **vista de listado de estudiantes**.  
✅ **3.6.** Agregar un **endpoint en `UserController`** para obtener la lista de estudiantes.  
✅ **3.7.** Probar en el navegador y en Postman que todo funciona bien.  

---

### **🔹 4️⃣ Gestión de Clases y Horarios**

🔴 **4.1.** Crear la entidad **ClassSchedule** con los siguientes atributos:

- 📅 **Fecha y hora de la clase.**
- 🏆 **Nivel de la clase (básico, intermedio, avanzado).**
- 👨‍🏫 **Instructor asignado.**
- 📍 **Ubicación de la clase.**  
🔴 **4.2.** Crear el `ClassScheduleController` para manejar las peticiones.  
🔴 **4.3.** Implementar la **vista del calendario de clases** en `horario.html`.  
🔴 **4.4.** Mostrar el calendario para:
- 🏃 **Estudiantes** (solo pueden ver sus clases).
- 👨‍🏫 **Instructores** (pueden ver y modificar sus clases).  
🔴 **4.5.** Probar en el navegador que se listan correctamente las clases.  

---

### **🔹 5️⃣ Registro de Asistencia**

🔴 **5.1.** Implementar un **sistema para que los instructores registren asistencia.**  
🔴 **5.2.** Crear un modelo `Attendance` con:

- 📅 **Fecha.**
- 🏆 **Clase asignada.**
- 📝 **Lista de estudiantes presentes.**  
🔴 **5.3.** Crear un `AttendanceController` con endpoints:
- `POST /attendance/{classId}/register` → Registrar asistencia.
- `GET /students/{id}/attendance` → Consultar asistencia por estudiante.  
🔴 **5.4.** Implementar la **vista de asistencia en Thymeleaf**.  
🔴 **5.5.** Probar en Postman que la API responde correctamente.  

---

### **🔹 6️⃣ Gestión de Pagos**

🔴 **6.1.** Implementar la **entidad `Payment`** con:

- 🏆 **Estudiante.**
- 💰 **Monto.**
- 📅 **Fecha de pago.**
- 💳 **Método de pago.**
- ❌ **Estado (pendiente, pagado).**  
🔴 **6.2.** Crear el **PaymentController** con endpoints:
- `GET /payments` → Ver pagos registrados.
- `POST /payments` → Registrar un nuevo pago.
- `PUT /payments/{id}/confirm` → Confirmar un pago.  
🔴 **6.3.** Implementar la **vista para listar pagos y ver estados.**  
🔴 **6.4.** Probar en Postman y en el navegador.  

---

### **🔹 7️⃣ Publicación en GitHub**

✅ **7.1.** Asegurar que **todos los archivos están actualizados.**  
✅ **7.2.** Subir los cambios con los siguientes comandos:  
```sh
git add .
git commit -m "Entrega 2 - Roller Speed"
git push origin main
```
✅ **7.3.** Confirmar que el código está en GitHub correctamente.  

---

### **🔹 8️⃣ Grabación del Video**

🔴 **8.1.** Preparar el video con **explicación clara** del proceso:

- 📌 Instalación y configuración.
- 📌 Creación del proyecto en Spring Boot.
- 📌 Implementación de vistas y funcionalidades.
- 📌 Pruebas en Postman y navegador.
- 📌 Subida del código a GitHub.  
🔴 **8.2.** Grabar un video **de máximo 5 minutos**.  
🔴 **8.3.** Subir el video a una plataforma con enlace visible (Google Drive, YouTube).  

---

### **🔹 9️⃣ Preparación del Documento Final**

✅ **9.1.** Incluir los siguientes apartados en el documento de entrega:

- 📌 **Portada con los integrantes.**
- 📌 **Introducción al caso de estudio.**
- 📌 **Desarrollo del proyecto y funcionalidades.**
- 📌 **Conclusión sobre la experiencia y el aprendizaje.**
- 📌 **Enlace al video y repositorio de GitHub.**  
✅ **9.2.** Revisar ortografía y formato del documento.  
🔴 **9.3.** Subir el documento final en la plataforma de entrega.  

---

## **🔥 RESUMEN FINAL**

✅ **Sistema funcionando al 65%.**  
✅ **Código actualizado en GitHub.**  
🔴 **Falta completar las funcionalidades de Clases, Asistencia y Pagos.**  
🔴 **Falta grabar el video de entrega.**  
🔴 **Falta subir el documento final a la plataforma.**  

---
