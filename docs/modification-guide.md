# 📎 Guia de modificacion
## 🔧 Herramientas recomendadas
* Intellij idea
* Java 21
* Docker Desktop

## 📐 Estructura
### Domain
Dominio de la aplicación, encontramos principalmente, el modelo de dominio en el paquete domain

### Aplicación
Aquí coordinamos un tanto la funcionalidad, validamos ciertas reglas, y tenemos los casos de uso, aqui tenemos que entender algunos aspectos

* **application.dto:** utilizamos un dto para que el result pattern lo manejé
* **application.pattern:** Utilizamos un patron Result para evitar el uso excesivo e innecesario de excepciones
* **application.port:** tenemos los puertos, tanto de entrada como de salida, en este caso de salida unicamente los repositorios, y de entrada los casos de usp
* **application.usecase:** la implementacion de los casos de uso

### Infraestructura
Aquí conectaremos el dominio con el mundo real, haciendo uso de adaptadores, controladores, entre otros...
* **infrastructure.adapter.out:** al ser un ejemplo simple de momento solo tenemos los adaptadores de repositorios
* **infrastructure.controller:** controladores
* **infrastructure.dto:** DTO de salida, comunicación con el exterior
* **infrastructure.exception:** un globalexception simple
* **infrastructure.mapper:** utilizamos **mapstruct** para convertir los modelos de dominio en documentos para que lo entienda mongodb
* **infrastructure.persistence.document:** documentos que maneja mongodb
* **infrastructure.persistence.repository:** con ayuda de spring data utilizamos repositorios jpa para el manejo de operaciones con la base de datos


