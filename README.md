# Sistema de Gestión Multimedia — Unidad 4

* **Autora:** Angelina Mishell Maldonado Toral
* **Materia:** Programación Orientada a Objetos
* **Universidad:** Universidad Politécnica Salesiana

##  Cambios Realizados (Unidad 4)

En esta unidad se refactorizó integralmente el sistema base, aplicando principios de diseño de software, código limpio y el patrón arquitectónico MVC:

* **Refactorización y SRP:** Se eliminaron los métodos `mostrarDetalles()` y las salidas directas por consola (`System.out.println`) de las clases del modelo. Ahora la impresión y el formato visual se manejan exclusivamente en la capa de la Vista.
**Patrón Arquitectónico MVC:** El sistema se segmentó de forma estricta en tres capas independientes: Modelo (datos de negocio), Vista (interfaz de interacción en consola) y Controlador (lógica de orquestación y flujo).
**Manejo de Archivos (CSV):** Se implementó la persistencia de datos mediante la lectura y escritura desde/hacia el archivo físico `contenidos.csv` utilizando la clase auxiliar `GestorCSV`.
**Principios SOLID:** * *SRP (Single Responsibility Principle):* Separación clara de responsabilidades en componentes MVC.
**OCP (Open/Closed Principle):** Modelo de herencia extensible a partir de la clase abstracta `ContenidoAudiovisual`.
**DIP (Dependency Inversion Principle):** Inyección de dependencias en el constructor del controlador para desacoplarlo de la vista.
* **Pruebas Unitarias:** Se diseñó una suite de pruebas automatizadas con JUnit 5 para validar de forma aislada el comportamiento de las clases del modelo y la correcta carga del gestor de archivos.

##  Estructura del Código

El proyecto está organizado en paquetes dentro de Eclipse de la siguiente manera:

* **`src/modelo/`:** Clases de negocio puras (`ContenidoAudiovisual`, `Pelicula`, `SerieDeTV`, `Documental`, `Actor`, `Temporada`, `Investigador`).
* **`src/vista/`:** Clase `ConsolaVista`, encargada de desplegar los menús interactivos y dar formato a la salida de datos.
* **`src/controlador/`:** Clase `ContenidoController`, que actúa como mediadora coordinando las acciones de la vista y mutando el modelo o invocando al gestor de persistencia.
* **`src/util/`:** Clase `GestorCSV`, responsable del manejo técnico de archivos y control de excepciones en disco.
* **`src/poo/`:** Clase de inicio `PruebaAudioVisual`, que contiene el método ejecutor `main`.
* **`test/`:** Suite de pruebas unitarias en espejo con JUnit 5 (`PeliculaTest`, `SerieDeTVTest`, `DocumentalTest`, `GestorCSVTest`).
* **`contenidos.csv`:** Archivo de texto plano ubicado en la raíz que actúa como almacén de datos persistentes.

## Cómo ejecutar las pruebas unitarias

En Eclipse, despliega la carpeta fuente test en el Package Explorer.
Haz clic derecho sobre la carpeta test.
Selecciona Run As -> JUnit Test.
Se abrirá la pestaña de JUnit mostrando las pruebas ejecutadas. La barra se mostrará en verde, confirmando el correcto funcionamiento del modelo y la persistencia.

##  Cómo clonar y ejecutar el proyecto
Clonar el repositorio desde la terminal:
1. git clone https://github.com/Mishell-Maldonado/Gestion-Multimedia.git
2. Importar en Eclipse: Selecciona File -> Import -> General -> Existing Projects into Workspace y elige la carpeta del proyecto clonado.
3. Ejecutar el sistema: Ejecuta la clase PruebaAudioVisual.java (ubicada en el paquete poo) como una aplicación Java (Run As -> Java Application). Se desplegará el menú interactivo en la consola.

