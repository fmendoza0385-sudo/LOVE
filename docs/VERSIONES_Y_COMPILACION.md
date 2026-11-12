# Versiones y compilación

Versiones fijadas en esta base inicial:
- JDK para CI: Eclipse Temurin 21.
- Compatibilidad de bytecode: Java 17 / Kotlin JVM target 17.
- Android Gradle Plugin: 8.13.2.
- Gradle: 8.13.
- Kotlin Gradle Plugin: 2.4.21.
- Android SDK: compileSdk 36 / targetSdk 36.
- AndroidX Media3: 1.11.1.

La versión estable Kotlin 2.4.21 se seleccionó en lugar de Kotlin 2.5.0-RC, que es una versión preliminar (no estable). AGP 8.13.2 se utiliza como base conservadora compatible con Gradle 8.13 y JDK 21, evitando adoptar una línea AGP 9.x sin validar primero la migración de plugins del proyecto.

## Nota sobre Gradle Wrapper

El ZIP se genera en un entorno sin acceso de red, por lo que no fue posible incorporar el JAR oficial `gradle-wrapper.jar`. El workflow de GitHub instala Gradle 8.13 directamente y compila con el comando `gradle`; no requiere el wrapper. Para desarrollo local, instala Gradle 8.13 o genera el wrapper oficial desde una instalación Gradle 8.13 con `gradle wrapper --gradle-version 8.13`.

Antes de publicar una versión de producción, ejecutar compilación limpia y pruebas en Android Studio con JDK 21.
