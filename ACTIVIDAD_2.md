
---

## 📌 **CHECKLIST FINAL – ENTREGA 2: ROLLER SPEED (Actualizado)**

💡 **Objetivo:** Finalizar la implementación completa del sistema, incluyendo la documentación, video y pruebas.

---

### 🔹 **1️⃣ CONFIGURACIÓN INICIAL**

| Estado | Descripción |
|--------|-------------|
✅ | MySQL correctamente configurado  
✅ | `application.properties` con datos de conexión correctos  
✅ | Conexión probada con `./mvnw spring-boot:run`  
✅ | Aplicación inicia sin errores  

---

### 🔹 **2️⃣ MENÚ PRINCIPAL CON THYMELEAF**

| Estado | Descripción |
|--------|-------------|
✅ | `navbar.html` funcional con rutas: Inicio, Misión, Visión, Valores, Servicios, Eventos  
✅ | Archivos HTML creados: `index.html`, `mision.html`, `vision.html`, `valores.html`, `servicios.html`, `eventos.html`  
✅ | `HomeController.java` implementado correctamente  
✅ | Navegador muestra todas las rutas sin errores  

---

### 🔹 **3️⃣ REGISTRO Y GESTIÓN DE USUARIOS**

| Estado | Descripción |
|--------|-------------|
✅ | Registro solo accesible por administradores desde `/admin/register`  
✅ | DTOs y validaciones implementadas  
✅ | Vista `register.html` funcional y protegida  
✅ | Endpoint `POST /admin/register` funcional con manejo de errores  
✅ | Flash attributes visibles en `admin_users.html` con mensajes de éxito/error  
✅ | Manejo de errores en Postman corregido (respuestas JSON, no HTML)  
✅ | Pruebas Postman completadas con éxito  

---

### 🔹 **4️⃣ GESTIÓN DE CLASES Y HORARIOS**

| Estado | Descripción |
|--------|-------------|
✅ | Entidad `ClassSchedule` creada con relaciones  
✅ | Asociación con `TrainingLocation` e `Instructor`  
✅ | Validación: combinación única `fecha + instructor + ubicación`  
✅ | CRUD completo (POST, GET, PUT, DELETE) funcionando  
🟡 | Vista `horario.html` implementada pero aún con contenido estático  
🔴 | Lógica de visualización por rol (estudiante/instructor) aún no implementada  

---

### 🔹 **5️⃣ REGISTRO DE ASISTENCIA**

| Estado | Descripción |
|--------|-------------|
✅ | Entidad `Attendance` implementada correctamente  
✅ | DTO y Mapper de asistencia funcionando  
✅ | Servicio y controlador desarrollados  
✅ | Endpoints disponibles:  
  ✔ `POST /attendance/{classId}/register`  
  ✔ `GET /students/{id}/attendance`  
  ✔ `GET /classes/{id}/attendance`  
✅ | Pruebas en Postman exitosas  
🟡 | Vista Thymeleaf `asistencia.html` creada con estructura informativa  
🔴 | Lógica funcional de visualización e interacción aún pendiente  

---

### 🔹 **6️⃣ GESTIÓN DE PAGOS**

| Estado | Descripción |
|--------|-------------|
✅ | Entidad `Payment` implementada  
✅ | DTO y Mapper funcionales  
✅ | `PaymentService` y `PaymentController` listos  
✅ | Endpoints funcionando:  
  ✔ `POST /payments`  
  ✔ `GET /payments`  
  ✔ `PUT /payments/{id}/confirm`  
  ✔ `GET /students/{id}/payments`  
✅ | Pruebas Postman exitosas  
🟡 | Vista `pagos.html` creada pero sin lógica aún  

---

### 🔹 **7️⃣ PUBLICACIÓN EN GITHUB**

| Estado | Descripción |
|--------|-------------|
✅ | Código actualizado en el repositorio  
✅ | Comandos ejecutados correctamente:  
```bash
git add .
git commit -m "Entrega 2 - Roller Speed"
git push origin main
```  
✅ | Revisión y sincronización completadas  

---

### 🔹 **8️⃣ GRABACIÓN DEL VIDEO**

| Estado | Descripción |
|--------|-------------|
🔴 | Video explicativo grabado (máximo 5 minutos)  
🔴 | Incluye: instalación, desarrollo, pruebas y GitHub  
🔴 | Subido a Drive o YouTube con enlace accesible  

---

### 🔹 **9️⃣ DOCUMENTO FINAL DE ENTREGA**

| Estado | Descripción |
|--------|-------------|
✅ | Documento con portada, introducción, desarrollo, experiencia  
✅ | Incluye enlace al video y repositorio GitHub  
✅ | Revisión ortográfica y formato aplicado  
🔴 | Subido a la plataforma del curso  

---

## 🔥 **RESUMEN FINAL**

| Elemento                     | Estado    |
|-----------------------------|-----------|
✅ Sistema completo y funcional  
✅ Clases, usuarios, pagos y asistencia operativos  
✅ Pruebas Postman exitosas  
🟡 Vistas funcionales básicas creadas (HTML), falta completar interacción  
🔴 Falta grabar video y subir el documento final  

---
