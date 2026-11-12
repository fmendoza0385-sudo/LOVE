# LUKKA Televisión — Android

Base inicial de repositorio para LUKKA Televisión: aplicación IPTV libre, sin suscripciones, códigos de activación, licencias ni bloqueos por vencimiento.

## Estado de esta entrega

Este ZIP contiene una **estructura Android Studio compilable como punto de partida**, configuración de Gradle, Kotlin, Android Manifest, workflow de GitHub Actions y una pantalla inicial mínima. No es todavía la aplicación IPTV terminada: el importador M3U, administrador de listas, catálogo, EPG y reproductor integrado deben implementarse en las siguientes fases.

## Versiones de herramientas

- JDK de CI: 21
- Compatibilidad de bytecode Java/Kotlin: 17
- Kotlin Gradle Plugin: 2.4.21 (estable)
- Android Gradle Plugin: 8.13.2
- Gradle Wrapper: 8.13
- compileSdk / targetSdk: 36
- AndroidX Media3: 1.11.1

Se elige JDK 21 para compilar y bytecode 17 para mantener una amplia compatibilidad de ejecución Android. Las versiones están fijadas para builds reproducibles; no se usan versiones `+`.

## Abrir y compilar

1. Sube el contenido de este ZIP a la raíz de un repositorio GitHub.
2. Abre el repositorio en Android Studio.
3. Usa JDK 21 para Gradle.
4. Espera la sincronización de Gradle.
5. Si tienes Gradle 8.13 instalado, ejecuta `gradle assembleDebug`. En GitHub Actions, el workflow instala Gradle 8.13 automáticamente.

El APK de depuración se genera en `app/build/outputs/apk/debug/app-debug.apk`.

## GitHub Actions

El workflow se encuentra en `.github/workflows/main.yml`. Se ejecuta al hacer push o pull request a `main` y también manualmente. Instala Gradle 8.13 y JDK 21, compila el APK y lo publica como artefacto. Este paquete no incluye el JAR oficial del Gradle Wrapper; el workflow no depende de él.

## Permisos Android

El manifest declara acceso a Internet y estado de red. El acceso a archivos debe realizarse mediante Storage Access Framework / selector de documentos, evitando permisos amplios de almacenamiento.

## Requisitos del producto

- Configuración inicial mediante archivo M3U o URL.
- Múltiples listas y almacenamiento local.
- Reproducción de canales compatibles.
- Android TV y Smartphone.
- EPG opcional.
- Sin cuentas, suscripciones, códigos, licencias ni servidores de activación.

## Seguridad

No subas listas M3U privadas, credenciales, tokens ni claves de firma al repositorio. Utiliza datos de prueba autorizados.
