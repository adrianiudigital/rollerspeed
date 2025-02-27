## 🌍 **Estructura General de la API**

El sistema está estructurado en los siguientes módulos principales:

✅ **1. Autenticación y Registro**  
✅ **2. Gestión de Usuarios (Estudiantes, Instructores, Administradores)**  
❌ 3. Gestión de Clases y Horarios  
❌ 4. Gestión de Asistencia  
❌ 5. Gestión de Pagos  
❌ 6. Información Institucional  
❌ 7. Administración y Reportes  

Todos los endpoints siguen una estructura **RESTful** con versionado (`/api/v1`).

---

### 1️⃣ **Autenticación y Registro**
Manejo de autenticación y registro de usuarios.

| Método | Endpoint                   | Descripción |
|--------|-----------------------------|-------------|
| `POST` | `/api/v1/auth/register`     | Registrar un nuevo usuario (Estudiante o Instructor) |
| `POST` | `/api/v1/auth/login`        | Iniciar sesión y obtener un token de acceso |
| `POST` | `/api/v1/auth/logout`       | Cerrar sesión e invalidar el token |
| `GET`  | `/api/v1/auth/me`           | Obtener información del usuario autenticado |

---

### 2️⃣ **Gestión de Usuarios (Estudiantes, Instructores, Administradores)**
Manejo de perfiles y roles dentro del sistema.

| Método | Endpoint                        | Descripción |
|--------|----------------------------------|-------------|
| `GET`  | `/api/v1/users`                 | Listar todos los usuarios (solo Administrador) |
| `GET`  | `/api/v1/users/{id}`            | Obtener información de un usuario |
| `PUT`  | `/api/v1/users/{id}`            | Actualizar datos de un usuario |
| `DELETE` | `/api/v1/users/{id}`          | Eliminar un usuario (solo Administrador) |
| `GET`  | `/api/v1/instructors`           | Listar todos los instructores |
| `GET`  | `/api/v1/students`              | Listar todos los estudiantes |
| `GET`  | `/api/v1/students/{id}`         | Obtener detalles de un estudiante |

---

### 3️⃣ **Gestión de Clases y Horarios**
Administración de clases, asignaciones y horarios.

| Método | Endpoint                            | Descripción |
|--------|--------------------------------------|-------------|
| `GET`  | `/api/v1/classes`                   | Listar todas las clases disponibles |
| `POST` | `/api/v1/classes`                   | Crear una nueva clase (solo Administrador) |
| `GET`  | `/api/v1/classes/{id}`              | Obtener detalles de una clase |
| `PUT`  | `/api/v1/classes/{id}`              | Modificar información de la clase |
| `DELETE` | `/api/v1/classes/{id}`           | Eliminar una clase (solo Administrador) |
| `POST` | `/api/v1/classes/{id}/assign`       | Asignar estudiantes a una clase |
| `GET`  | `/api/v1/instructors/{id}/classes`  | Listar las clases asignadas a un instructor |

---

### 4️⃣ **Gestión de Asistencia**
Control y reportes de asistencia por parte de los instructores.

| Método | Endpoint                                      | Descripción |
|--------|----------------------------------------------|-------------|
| `GET`  | `/api/v1/attendance`                        | Listar todos los registros de asistencia |
| `POST` | `/api/v1/attendance/{class_id}/register`    | Registrar asistencia de estudiantes en una clase |
| `GET`  | `/api/v1/students/{id}/attendance`         | Consultar asistencia de un estudiante |
| `GET`  | `/api/v1/classes/{id}/attendance`          | Ver registros de asistencia de una clase |

---

### 5️⃣ **Gestión de Pagos**
Administración de pagos de estudiantes y reportes financieros.

| Método | Endpoint                          | Descripción |
|--------|------------------------------------|-------------|
| `GET`  | `/api/v1/payments`                | Listar todas las transacciones de pago |
| `POST` | `/api/v1/payments`                | Registrar un nuevo pago |
| `GET`  | `/api/v1/payments/{id}`           | Consultar detalles de un pago |
| `GET`  | `/api/v1/students/{id}/payments`  | Ver historial de pagos de un estudiante |
| `GET`  | `/api/v1/payments/pending`        | Listar pagos pendientes |
| `PUT`  | `/api/v1/payments/{id}/confirm`   | Confirmar un pago realizado |

---

### 6️⃣ **Información Institucional**
Contenido público sobre la escuela.

| Método | Endpoint                              | Descripción |
|--------|--------------------------------------|-------------|
| `GET`  | `/api/v1/institution/mission`       | Obtener la misión de la escuela |
| `GET`  | `/api/v1/institution/vision`        | Obtener la visión de la escuela |
| `GET`  | `/api/v1/institution/values`        | Obtener los valores de la escuela |
| `GET`  | `/api/v1/services`                  | Listar los servicios disponibles |
| `GET`  | `/api/v1/events`                    | Listar eventos próximos |
| `POST` | `/api/v1/events`                    | Crear un nuevo evento (solo Administrador) |
| `DELETE` | `/api/v1/events/{id}`            | Eliminar un evento (solo Administrador) |

---

### 7️⃣ **Administración y Reportes**
Herramientas administrativas y generación de informes.

| Método | Endpoint                           | Descripción |
|--------|-------------------------------------|-------------|
| `GET`  | `/api/v1/reports/enrollments`      | Estadísticas de inscripciones por mes |
| `GET`  | `/api/v1/reports/attendance`       | Reporte general de asistencia |
| `GET`  | `/api/v1/reports/financials`       | Reporte financiero de la escuela |

---

### 📌 **Consideraciones Generales**
✅ **Versionado** → Todos los endpoints están prefijados con `/api/v1/` para futuras actualizaciones sin afectar versiones anteriores.  
✅ **Manejo de errores** → Respuestas JSON estandarizadas con códigos de estado HTTP.  
✅ **Seguridad** → Autenticación JWT, permisos basados en roles y cifrado de datos sensibles.  
✅ **Paginación y Filtros** → Aplicados en listados (`?page=1&size=10`).  
✅ **CORS habilitado** → Para permitir accesos desde el frontend.  

---

