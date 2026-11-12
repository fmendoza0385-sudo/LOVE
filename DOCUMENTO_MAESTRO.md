# DOCUMENTO MAESTRO DE DESARROLLO

## LUKKA Televisión — Aplicación IPTV libre, sin suscripciones ni activaciones

**Versión:** 2.0  
**Fecha:** 12 de noviembre de 2026  
**Estado:** Especificación funcional y técnica para preparar el proyecto ZIP y desarrollarlo posteriormente en GitHub  
**Organización:** GRM CONEXIÓN SAS  
**Plataformas objetivo:** Android TV y Android Smartphone

---

## 1. Propósito del documento

Este documento define los requisitos funcionales, visuales y técnicos de **LUKKA Televisión**, una aplicación IPTV de uso libre, sin planes de pago integrados, suscripciones, renovaciones, códigos de activación, licencias mensuales ni bloqueos por vencimiento.

En la configuración inicial, el usuario debe poder cargar o ingresar sus propias listas M3U y, una vez guardadas, comenzar a disfrutar de los canales disponibles en ellas.

La aplicación funcionará como reproductor y organizador de listas IPTV. No venderá, generará, distribuirá ni desbloqueará contenido. El usuario será responsable de proporcionar listas y fuentes de reproducción que tenga derecho a utilizar.

La especificación servirá como guía para preparar posteriormente el proyecto Android completo, empaquetarlo y desarrollarlo mediante GitHub. No implica que el código ya esté implementado ni que se haya modificado un APK.

## 2. Visión general y principios del producto

LUKKA Televisión debe ofrecer una experiencia sencilla, similar a la de un decodificador tradicional:

- Aplicación IPTV para Android TV y Smartphone.
- Configuración inicial sencilla, guiada y fácil de entender.
- Importación de listas M3U mediante archivo local o URL.
- Posibilidad de registrar más de una lista M3U.
- Organización automática de canales y grupos cuando la información esté presente en la lista.
- Reproducción directa del último canal visto, si está disponible.
- Navegación por canales con CH+ y CH− en Android TV.
- Guía de programación EPG cuando el usuario configure una fuente compatible.
- Identidad visual azul metalizado, blanco y negro.
- Sin cuentas obligatorias, suscripciones, pagos, códigos ni activación.
- Sin bloqueo de funciones por fechas, ciclos o vencimientos.

La aplicación no debe incorporar mecanismos ocultos de cobro, telemetría invasiva ni validaciones remotas que condicionen el acceso al reproductor.

## 3. Objetivos funcionales

1. Permitir que el usuario configure LUKKA por primera vez sin necesitar un código o cuenta.
2. Permitir importar una lista M3U desde el almacenamiento del dispositivo.
3. Permitir agregar una lista M3U mediante una URL.
4. Validar que el archivo o dirección ingresada tenga un formato utilizable y mostrar errores comprensibles.
5. Guardar de forma local las listas y preferencias del usuario.
6. Leer canales, nombres, grupos, logos y metadatos disponibles en cada lista.
7. Reproducir los canales compatibles con el dispositivo y el formato de origen.
8. Recordar el último canal reproducido y permitir iniciar desde él en el siguiente arranque.
9. Facilitar la búsqueda, filtrado y navegación por grupos y canales.
10. Permitir actualizar, reemplazar, eliminar o volver a cargar una lista desde Configuración.
11. Mantener una experiencia consistente en Android TV y Smartphone.
12. Manejar fallos de red, listas inválidas y formatos incompatibles sin cierres inesperados.

## 4. Alcance

### 4.1 Incluido

- Pantalla de bienvenida y configuración inicial.
- Importación de listas M3U desde archivo local.
- Registro de listas M3U mediante URL.
- Administración local de una o varias listas.
- Análisis y lectura de metadatos M3U.
- Catálogo de canales y grupos.
- Búsqueda de canales.
- Reproductor IPTV.
- OSD (información en pantalla) y zapping.
- EPG opcional mediante fuente XMLTV compatible.
- Favoritos y canales recientes.
- Persistencia de preferencias y último canal.
- Configuración para Android TV y Smartphone.
- Manejo de errores y diagnóstico de reproducción.
- Pruebas funcionales y compilación Android mediante GitHub Actions.

### 4.2 Fuera del alcance

- Sistema de suscripciones o membresías.
- Códigos de activación, renovación o desbloqueo.
- Identificadores de usuario obligatorios o subcuentas.
- Vinculación obligatoria de listas a un dispositivo.
- Fechas de corte, vencimientos o períodos de gracia.
- Servidor central de licencias.
- Banco de códigos JSON o matrices de activación.
- Plataforma de pagos.
- Panel administrativo para gestionar licencias.
- Suministro, venta o distribución de canales o listas de terceros.
- Publicación en Google Play, salvo que se apruebe posteriormente.
- Implementación del código fuente en esta fase documental.

## 5. Experiencia de usuario y diseño visual

### 5.1 Identidad visual

La interfaz debe respetar la identidad definida para LUKKA Televisión:

- **Color principal:** azul metalizado.
- **Color secundario:** blanco.
- **Fondo y acentos:** negro.
- Contraste alto y tipografía legible.
- Botones grandes y fáciles de seleccionar.
- Iconografía sencilla y reconocible.
- Diseño moderno, limpio y profesional.
- Evitar textos técnicos, ventanas pequeñas y menús innecesarios.

No se debe inventar ni sustituir el logotipo oficial. Se utilizarán los recursos gráficos originales que se incluyan en el ZIP del proyecto.

### 5.2 Flujo de primera instalación

La primera ejecución debe seguir este flujo:

1. Mostrar el splash oficial de LUKKA Televisión.
2. Abrir una pantalla de bienvenida con el botón **CONFIGURAR MI TELEVISIÓN**.
3. Mostrar las opciones **AGREGAR LISTA M3U POR URL** e **IMPORTAR ARCHIVO M3U**.
4. Permitir que el usuario ingrese una URL M3U o seleccione un archivo compatible.
5. Validar y procesar la lista.
6. Mostrar un resumen de la importación: nombre de la lista, cantidad de canales detectados y grupos disponibles, cuando esos datos puedan determinarse.
7. Guardar la lista y mostrar el catálogo de canales.
8. Permitir seleccionar un canal y comenzar la reproducción.

Si el usuario todavía no tiene una lista, la aplicación debe mostrar instrucciones para agregarla posteriormente. No debe mostrar una pantalla de pago, suscripción o activación.

### 5.3 Configuración de listas

La sección **CONFIGURACIÓN > LISTAS IPTV** debe permitir:

- Agregar una lista por URL.
- Importar una lista desde archivo.
- Asignar un nombre local a cada lista.
- Activar o desactivar una lista sin borrarla.
- Actualizar una lista remota manualmente.
- Configurar actualización automática opcional.
- Reemplazar la URL o el archivo asociado.
- Eliminar una lista con confirmación.
- Consultar la fecha de última actualización.
- Mostrar el resultado de la última carga.
- Volver a intentar una importación fallida.

Las URL pueden contener credenciales proporcionadas por el usuario. Deben tratarse como información privada: no se deben mostrar completas en logs, reportes ni mensajes de error.

### 5.4 Android TV

- La pantalla debe ocupar el área completa cuando la plataforma lo permita.
- La navegación principal debe funcionar con las flechas del control remoto.
- OK/Enter debe seleccionar el elemento enfocado.
- CH+ y CH− deben cambiar de canal cuando el reproductor esté activo.
- Atrás debe permitir regresar entre reproductor, catálogo y configuración de manera predecible.
- Los botones y elementos tendrán áreas de selección amplias.
- La configuración de URL debe permitir utilizar el teclado en pantalla.
- No se exigirá ratón ni pantalla táctil.
- El foco inicial debe ser visible y consistente.

### 5.5 Smartphone

- Diseño adaptable a distintas resoluciones y densidades.
- Presentación vertical como orientación principal y adaptación horizontal cuando corresponda.
- Campos cómodos para escribir y botones amplios.
- Selector de archivos integrado con el sistema Android.
- Mensajes de error visibles y fáciles de entender.
- Controles táctiles apropiados.
- Gestos o botones de navegación que no interfieran con la reproducción.

## 6. Configuración inicial e importación M3U

### 6.1 Fuentes admitidas

La aplicación debe admitir:

1. **Archivo local:** selección de un archivo `.m3u` o `.m3u8` almacenado en el dispositivo.
2. **URL remota:** dirección HTTP o HTTPS que entregue una lista M3U válida.
3. **Varias listas:** permitir registrar varias fuentes y consultar sus canales desde la aplicación.

La aplicación no debe asumir que una URL es válida por su extensión. Debe comprobar la respuesta recibida y analizar el contenido.

### 6.2 Procesamiento de listas

El analizador M3U deberá:

- Reconocer encabezados `#EXTM3U`.
- Leer entradas `#EXTINF`.
- Extraer el nombre del canal.
- Leer atributos disponibles, como `tvg-id`, `tvg-name`, `tvg-logo` y `group-title`.
- Asociar cada entrada con su URL de reproducción.
- Manejar espacios, caracteres UTF-8 y variaciones habituales de formato.
- Tolerar metadatos opcionales ausentes.
- Informar líneas o entradas inválidas sin cerrar la aplicación.
- Evitar duplicados cuando sea posible, sin eliminar canales distintos que compartan nombre.
- Mantener la relación entre cada canal y la lista de origen.

No se debe asumir que todas las listas incluyen logos, grupos, EPG o metadatos completos.

### 6.3 Actualización y almacenamiento

- Las listas locales se conservarán en el almacenamiento privado de la aplicación o mediante el mecanismo de acceso persistente de Android.
- Las listas remotas podrán volver a descargarse cuando el usuario lo solicite o cuando esté habilitada la actualización automática.
- La aplicación debe conservar la última copia válida de una lista remota si una actualización falla.
- Una actualización fallida no debe borrar el catálogo que ya funciona.
- La actualización automática debe ser configurable y respetar las restricciones de batería y segundo plano de Android.
- El usuario podrá eliminar todos los datos y listas desde una opción claramente identificada.

### 6.4 Seguridad y privacidad de las listas

- No enviar listas, URLs ni credenciales a servidores de GRM CONEXIÓN.
- No incluir URLs privadas ni credenciales en logs.
- No exponer datos de listas a otras aplicaciones.
- Utilizar almacenamiento privado y permisos mínimos.
- Solicitar acceso a archivos mediante el selector oficial de Android, evitando permisos amplios innecesarios.
- Las comunicaciones remotas deben utilizar HTTPS cuando el proveedor de la lista lo soporte.
- No modificar, retransmitir ni redistribuir listas de terceros.

## 7. Flujo de arranque y reproducción

Secuencia requerida:

1. Iniciar la aplicación y mostrar el splash oficial.
2. Cargar las preferencias locales y las listas guardadas.
3. Si no hay listas configuradas, abrir el asistente de configuración inicial.
4. Si existen listas, cargar el catálogo local disponible.
5. Si hay actualización automática habilitada, iniciar la actualización de forma controlada sin bloquear innecesariamente la interfaz.
6. Si existe un último canal guardado y sigue disponible, ofrecer o iniciar su reproducción conforme a la preferencia del usuario.
7. Si el último canal ya no existe o no está disponible, mostrar el catálogo y permitir seleccionar otro.
8. Cuando el usuario seleccione un canal, abrir el reproductor y mostrar el OSD.

La aplicación no debe depender de un servidor de activación para arrancar, cargar listas o reproducir contenido. La disponibilidad de cada canal dependerá de la lista, la conexión a Internet y la compatibilidad del dispositivo.

## 8. Arquitectura lógica propuesta

La implementación debe separar interfaz, reglas de negocio, almacenamiento y reproducción.

### 8.1 Componentes sugeridos

| Componente | Responsabilidad |
|---|---|
| `MainActivity` | Controlar navegación y flujo principal |
| `FirstRunSetup` | Guiar la configuración inicial |
| `PlaylistManager` | Administrar las listas registradas |
| `M3UImporter` | Importar archivos M3U |
| `M3UParser` | Analizar entradas y metadatos M3U |
| `PlaylistRepository` | Guardar y recuperar listas y catálogo |
| `PlaylistRefreshWorker` | Actualizar listas remotas cuando esté habilitado |
| `ChannelRepository` | Consultar, filtrar y organizar canales |
| `PlayerManager` | Controlar reproducción, pistas y errores |
| `EpgManager` | Cargar y relacionar datos XMLTV, si se configura |
| `FavoritesManager` | Administrar favoritos y recientes |
| `SettingsRepository` | Guardar preferencias de usuario |

Los nombres son una propuesta de organización. Antes de programar se deben adaptar a la arquitectura y lenguaje reales del proyecto Android.

### 8.2 Responsabilidades del asistente inicial

- Explicar brevemente qué necesita el usuario para comenzar.
- Presentar las dos formas de importar una lista.
- Validar los datos ingresados.
- Mostrar progreso durante la lectura.
- Informar cuántos canales y grupos fueron reconocidos, si es posible.
- Permitir corregir la URL o seleccionar otro archivo.
- Guardar la configuración únicamente después de una importación satisfactoria.
- Permitir omitir el proceso y configurarlo más tarde.

### 8.3 Responsabilidades del reproductor

- Abrir el canal seleccionado.
- Mostrar nombre, logo y grupo cuando estén disponibles.
- Mostrar estados de carga, buffering y error.
- Permitir pausa cuando el tipo de fuente lo soporte.
- Permitir cambio de canal y recuperación ante fallos.
- Recordar el último canal.
- Manejar pistas de audio y subtítulos cuando el stream las proporcione y el motor lo permita.
- No dejar una pantalla negra indefinida sin información.

## 9. Persistencia y datos locales

La aplicación no requiere una base de usuarios, un banco de activaciones ni un servidor de licencias.

Se recomienda utilizar almacenamiento local estructurado, por ejemplo Room/SQLite para datos de listas y canales, y DataStore o preferencias equivalentes para ajustes sencillos.

Datos locales que pueden guardarse:

- Identificador interno local de cada lista.
- Nombre asignado por el usuario.
- Tipo de fuente: archivo o URL.
- Referencia privada al archivo o URL.
- Fecha de última importación o actualización.
- Estado de la última actualización.
- Canales y metadatos analizados.
- Canal favorito y último canal reproducido.
- Preferencias de reproducción, interfaz y EPG.

No se deben crear campos de plan, licencia, código, ciclo mensual, fecha de corte, vencimiento o dispositivo autorizado.

La aplicación debe manejar bases locales dañadas o incompletas mediante recuperación controlada y mensajes comprensibles. Si es necesario reconstruir el catálogo, debe poder volver a analizar las listas conservadas.

## 10. EPG y guía de programación

La guía electrónica de programación será opcional.

- Permitir ingresar o importar una fuente XMLTV (`.xml` o `.xml.gz`) cuando el proyecto soporte su procesamiento.
- Relacionar los programas con los canales mediante identificadores como `tvg-id`, cuando estén disponibles.
- Mostrar programación actual y siguiente si existe información válida.
- Manejar diferencias de zona horaria y horarios declarados en XMLTV.
- Permitir actualizar la guía manualmente y, opcionalmente, de forma programada.
- No impedir la reproducción si no existe EPG.
- Informar cuando una fuente EPG no pueda cargarse.
- No inventar programación cuando la fuente no la proporcione.

## 11. Estructura propuesta del ZIP del proyecto

El ZIP que se preparará para GitHub debe contener el proyecto Android completo y abrirse directamente en Android Studio.

Estructura orientativa:

```text
LUKKA_Television_Android/
├── README.md
├── DOCUMENTO_MAESTRO.md
├── LICENSE
├── .gitignore
├── gradlew
├── gradlew.bat
├── gradle/
│   └── wrapper/
├── settings.gradle
├── build.gradle
├── gradle.properties
├── app/
│   ├── build.gradle
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml
│           ├── java/
│           │   └── .../
│           │       ├── MainActivity
│           │       ├── playlist/
│           │       │   ├── PlaylistManager
│           │       │   ├── M3UImporter
│           │       │   ├── M3UParser
│           │       │   └── PlaylistRepository
│           │       ├── channels/
│           │       │   └── ChannelRepository
│           │       ├── player/
│           │       │   └── PlayerManager
│           │       ├── epg/
│           │       │   └── EpgManager
│           │       └── settings/
│           │           └── SettingsRepository
│           ├── res/
│           │   ├── drawable/
│           │   ├── mipmap/
│           │   ├── layout/
│           │   ├── values/
│           │   └── xml/
│           └── assets/
│               └── .../
├── .github/
│   └── workflows/
│       └── android-build.yml
└── docs/
    ├── ARQUITECTURA.md
    ├── FORMATO_M3U.md
    ├── CONFIGURACION_INICIAL.md
    └── PRUEBAS.md
```

Esta estructura es una guía. No se deben crear carpetas o clases vacías para aparentar que existe una implementación. Los archivos definitivos se ajustarán al proyecto Android real, sus paquetes, lenguaje y dependencias.

### 11.1 Contenido mínimo del ZIP

- Proyecto Android Studio completo.
- Gradle Wrapper y archivos de configuración.
- Código fuente del reproductor.
- Recursos oficiales de LUKKA Televisión.
- Archivos de ejemplo M3U sin credenciales ni URLs privadas, si se necesitan para pruebas.
- Configuración de Android TV y Smartphone.
- Pruebas disponibles.
- Este documento maestro.
- Workflow de GitHub Actions.
- Instrucciones de compilación.

### 11.2 Archivos que no deben incluirse

- Contraseñas o credenciales de listas reales.
- Tokens privados.
- Claves de firma privadas.
- Archivos `.jks` o `.keystore` privados.
- Datos personales de usuarios.
- Listas privadas de clientes o proveedores.
- Archivos temporales, cachés y carpetas de compilación innecesarias.

Los secretos de firma, si se requieren para una versión de distribución, se configurarán separadamente en GitHub Secrets o en el entorno seguro correspondiente.

## 12. Requisitos de GitHub Actions

El repositorio deberá permitir compilar el proyecto desde GitHub Actions.

El workflow deberá:

1. Ejecutarse manualmente y, si se desea, ante cambios en la rama principal.
2. Configurar una versión de JDK compatible con Gradle.
3. Configurar Android SDK y las plataformas requeridas.
4. Dar permisos de ejecución a `gradlew` en Linux.
5. Ejecutar la compilación de depuración.
6. Detener el proceso si hay errores.
7. Publicar el APK generado como artefacto descargable.
8. Mostrar claramente la versión y el resultado de la compilación.

La versión de Gradle, Android Gradle Plugin, JDK y compile SDK debe elegirse después de inspeccionar el proyecto real. No se deben actualizar dependencias de manera indiscriminada.

**Entregable esperado:** APK instalable en Android TV y Smartphone compatibles. La firma de producción se gestionará separadamente y con secretos protegidos.

## 13. Compatibilidad y accesibilidad

- Mantener compatibilidad con los niveles de Android que soporte el proyecto original.
- Declarar correctamente el soporte de Android TV y pantallas táctiles.
- Usar navegación por foco en TV.
- Mantener contraste suficiente.
- Evitar tipografías pequeñas.
- Proporcionar etiquetas accesibles a campos y botones.
- Adaptar el diseño a distintas proporciones de pantalla.
- Solicitar permisos únicamente cuando sean necesarios.
- Evitar que operaciones de importación o actualización congelen la interfaz.
- Respetar las restricciones de ejecución en segundo plano de Android.

La compatibilidad final se verificará con dispositivos o emuladores representativos de ambas plataformas.

## 14. Casos de prueba obligatorios

| N.º | Escenario | Resultado esperado |
|---:|---|---|
| 1 | Primera instalación sin listas | Mostrar asistente de configuración |
| 2 | Importar archivo M3U válido | Leer y guardar canales |
| 3 | Ingresar URL M3U válida | Descargar, analizar y guardar la lista |
| 4 | Importar archivo con encabezado inválido | Mostrar error sin cerrar la aplicación |
| 5 | URL inaccesible | Informar el problema y permitir reintentar |
| 6 | Lista sin logos | Mostrar presentación alternativa sin fallar |
| 7 | Lista sin grupos | Mostrar canales en grupo general |
| 8 | Lista con caracteres UTF-8 | Mostrar nombres correctamente |
| 9 | Lista con entradas incompletas | Omitir o reportar entradas inválidas de forma controlada |
| 10 | Agregar varias listas | Permitir consultar sus canales |
| 11 | Actualización remota exitosa | Actualizar catálogo |
| 12 | Actualización remota fallida | Conservar la última copia válida |
| 13 | Eliminar una lista | Retirar sus canales sin afectar otras listas |
| 14 | Cerrar y abrir la aplicación | Conservar listas y preferencias |
| 15 | Último canal disponible | Recuperar o sugerir el último canal |
| 16 | Último canal eliminado | Volver al catálogo sin bloquear |
| 17 | Canal no disponible | Mostrar error y permitir cambiar de canal |
| 18 | CH+ y CH− en Android TV | Cambiar de canal correctamente |
| 19 | Navegación con control remoto | Mantener foco visible y funcional |
| 20 | Uso en Smartphone | Interfaz táctil funcional |
| 21 | Fuente EPG válida | Mostrar programación disponible |
| 22 | Sin EPG configurada | Mantener reproducción normal |
| 23 | URL con credenciales | No exponer credenciales en logs |
| 24 | Sin conexión a Internet | Mostrar estado de conexión y conservar datos locales |
| 25 | Base local dañada | Recuperación controlada o mensaje claro |

## 15. Criterios de aceptación

LUKKA Televisión se considerará lista cuando:

- La primera ejecución permita configurar una lista M3U sin registro ni activación.
- Se pueda importar una lista desde archivo local.
- Se pueda agregar una lista mediante URL.
- Se puedan guardar y administrar varias listas.
- El catálogo muestre los canales y metadatos disponibles.
- El reproductor abra canales compatibles.
- Se recuerde el último canal conforme a las preferencias.
- El zapping funcione en Android TV.
- La EPG sea opcional y no bloquee la reproducción.
- Las listas se conserven ante una actualización fallida.
- Los errores de red, datos y decodificación se manejen sin cierres inesperados.
- No existan pantallas, servicios, clases, tablas o llamadas de red de suscripción, activación o licenciamiento.
- No haya bloqueos por fecha, vencimiento, renovación, código o estado de cuenta.
- GitHub Actions genere el APK de prueba.
- Se completen los casos de prueba y se documenten los resultados.

## 16. Plan de desarrollo por fases

### Fase 0 — Preparación del proyecto

- Recibir y revisar el ZIP Android original.
- Identificar lenguaje, paquetes, Activities, reproductor y dependencias.
- Verificar que el proyecto compile antes de modificarlo.
- Identificar y retirar los componentes heredados de suscripción, activación, licencias y bloqueo.
- Preparar la estructura del repositorio y documentación.

**Salida:** diagnóstico técnico y proyecto base reproducible, sin dependencias de licenciamiento.

### Fase 1 — Configuración inicial e importación

- Crear el asistente de primera ejecución.
- Implementar importación desde archivo.
- Implementar ingreso de URL.
- Crear el analizador M3U.
- Guardar listas y resultados localmente.
- Mostrar errores y resumen de importación.

**Salida:** usuario puede agregar su lista y acceder al catálogo.

### Fase 2 — Catálogo y administración de listas

- Mostrar canales y grupos.
- Implementar búsqueda y filtros.
- Permitir varias listas.
- Implementar favoritos y recientes.
- Implementar actualización, reemplazo y eliminación.
- Conservar última copia válida ante fallos.

**Salida:** catálogo funcional y administrable.

### Fase 3 — Integración del reproductor

- Integrar el catálogo con el motor de reproducción.
- Implementar OSD y zapping.
- Guardar el último canal.
- Manejar buffering, errores y recuperación.
- Preservar las funciones existentes que sean compatibles.

**Salida:** aplicación IPTV integrada.

### Fase 4 — EPG, compatibilidad y pruebas

- Implementar carga opcional XMLTV.
- Probar listas y streams representativos.
- Verificar Android TV y Smartphone.
- Revisar privacidad de URLs y credenciales.
- Corregir errores de interfaz y reproducción.

**Salida:** informe de pruebas y correcciones.

### Fase 5 — GitHub y APK

- Configurar GitHub Actions.
- Compilar APK de depuración.
- Probar instalación en Android TV y Smartphone.
- Documentar versión, resultado y limitaciones.

**Salida:** repositorio compilable y APK de prueba.

## 17. Decisiones y datos pendientes antes de programar

1. **Proyecto base:** entregar el ZIP Android completo para auditar y modificar.
2. **Identidad visual:** incluir logotipo oficial y recursos gráficos originales.
3. **Dispositivos de prueba:** indicar modelos o versiones Android disponibles, si se conocen.
4. **Fuentes M3U de prueba:** proporcionar listas de prueba que el usuario tenga autorización para utilizar, preferiblemente sin credenciales privadas.
5. **EPG:** confirmar si se desea configurar una URL XMLTV desde el inicio o dejarla como opción posterior.
6. **Reproducción inicial:** confirmar si se debe iniciar automáticamente el último canal o mostrar primero el catálogo.

No se debe introducir nuevamente un sistema de suscripciones, códigos, activaciones, vencimientos o bloqueos bajo otro nombre.

## 18. Entregables finales del desarrollo

Al finalizar las fases de desarrollo se espera recibir:

- Proyecto Android Studio completo y organizado.
- Código fuente de importación y análisis M3U.
- Asistente de configuración inicial.
- Administrador de listas.
- Catálogo de canales y grupos.
- Reproductor integrado.
- Funciones de favoritos, recientes y último canal.
- EPG opcional, si se aprueba e implementa.
- Compatibilidad con Android TV y Smartphone.
- Configuración de GitHub Actions.
- APK de prueba.
- Documentación de instalación y compilación.
- Informe de pruebas.

## 19. Instrucción principal para el desarrollador

Desarrollar **LUKKA Televisión como una aplicación IPTV libre de suscripciones y activaciones**. En la primera ejecución, el usuario debe poder ingresar una URL M3U o importar un archivo M3U, guardar la configuración y comenzar a disfrutar de los canales disponibles en su lista.

Eliminar por completo cualquier lógica heredada de:

- Suscripciones, membresías o planes.
- Códigos de activación o renovación.
- ID de usuario obligatorio.
- Matrices o bancos de códigos.
- Fechas de corte y vencimientos.
- Validación de licencias.
- Vinculación obligatoria a dispositivos.
- Pantallas de servicio suspendido.
- Bloqueos del reproductor por razones comerciales.
- Servidores o API de activación.

La aplicación no debe consultar un servidor externo para decidir si el usuario tiene permiso de abrirla. La disponibilidad de los canales dependerá exclusivamente de las listas configuradas, de la conectividad con sus fuentes y de la compatibilidad técnica del dispositivo.

No sustituir el reproductor ni alterar funciones existentes que no formen parte del alcance. Antes de retirar código heredado, identificar sus dependencias y comprobar que no se eliminen por accidente funciones necesarias de reproducción, navegación, EPG u OSD.

La programación comenzará después de preparar y revisar el ZIP del proyecto Android.

---

## 20. Compatibilidad de reproducción: canales con audio y pantalla negra

### 20.1 Problema que se debe corregir

Se ha reportado que algunos canales reproducen el audio, pero muestran la imagen completamente negra. Una causa posible es que el dispositivo Android o el reproductor no pueda decodificar el formato de video, el perfil, el nivel o alguna característica del flujo recibido.

**Aclaración técnica:** MPEG-TS (`.ts`) es un contenedor de transporte, no un códec de video. Un flujo MPEG-TS puede transportar video MPEG-2, H.264/AVC, H.265/HEVC u otros formatos, además de audio. Por eso, no se debe asumir que todos los casos de pantalla negra se solucionan únicamente por “activar MPEG-TS”.

También pueden causar este síntoma una pista de video ausente o incorrecta, un PID de video no reconocido, parámetros de codificación no compatibles, señal dañada, segmentos HLS defectuosos, problemas de decodificación por hardware o una incompatibilidad específica del dispositivo.

### 20.2 Objetivo

El reproductor de LUKKA Televisión deberá identificar y manejar correctamente los formatos de transporte y códecs que estén presentes en las listas y streams configurados por el usuario, tanto en Android TV como en Smartphone.

La meta es maximizar la compatibilidad y evitar que un canal quede en negro cuando exista una alternativa técnica compatible. No se debe prometer reproducción universal: ningún reproductor puede garantizar todos los formatos, perfiles, niveles, DRM y flujos defectuosos en todos los modelos Android. Los casos no compatibles deberán diagnosticarse y reportarse claramente.

### 20.3 Requisitos obligatorios del reproductor

1. Inspeccionar el formato real de los streams utilizados por los canales de prueba, sin deducir el códec únicamente por la extensión `.ts` o `.m3u8`.
2. Soportar correctamente listas M3U y reproducción HLS cuando el origen las entregue en esos formatos.
3. Soportar MPEG-TS como formato de transporte cuando el reproductor y el dispositivo puedan decodificar los códecs contenidos en él.
4. Usar una versión estable y compatible de AndroidX Media3 / ExoPlayer, o mantener el motor actual si la auditoría demuestra que es adecuado.
5. Verificar las capacidades de decodificación del dispositivo antes de seleccionar una ruta de reproducción, cuando la API lo permita.
6. Manejar correctamente selección de pistas, pistas de video y audio, cambios de resolución y cambios de variante HLS.
7. Implementar estados visibles de carga, buffering, error de manifiesto, error de red y error de decodificación. No dejar indefinidamente una pantalla negra sin diagnóstico.
8. Ante un fallo recuperable, reintentar la preparación del stream de forma limitada y controlada, evitando ciclos infinitos.
9. Permitir cambiar de canal y recuperar el reproductor sin reiniciar toda la aplicación.
10. Mantener la integración con el OSD y el zapping estilo decodificador.

### 20.4 Diagnóstico de pantalla negra con audio

Cuando haya audio y no haya imagen, el reproductor deberá registrar información técnica suficiente para identificar la causa:

- Identificador interno del canal, ocultando tokens y credenciales.
- Tipo de fuente: HLS, MPEG-TS directo u otro transporte.
- Contenedor detectado, si está disponible.
- Códec de video y audio detectados.
- Resolución, frecuencia de cuadros, perfil y nivel, cuando estén disponibles.
- Pistas disponibles y pista seleccionada.
- Decodificador utilizado: hardware o software, si la plataforma informa ese dato.
- Modelo del dispositivo y versión de Android.
- Error detallado del reproductor y etapa en que ocurrió.
- Si el audio continúa funcionando mientras falla el video.

Los logs no deben guardar contraseñas, tokens de acceso ni URLs privadas completas. Para diagnóstico se usarán identificadores de canal y URLs redactadas.

### 20.5 Estrategia de compatibilidad y recuperación

El desarrollo deberá seguir esta secuencia:

1. Confirmar que el manifiesto o flujo contiene una pista de video válida.
2. Confirmar que el códec, perfil, nivel, resolución y formato de píxel son compatibles con el dispositivo.
3. Verificar que la pista de video correcta esté seleccionada y que no esté deshabilitada.
4. Revisar errores de decodificación por hardware y probar una ruta alternativa únicamente si el motor y el dispositivo la soportan.
5. Si se incorpora decodificación por software, hacerlo como capacidad opcional, evaluando rendimiento, consumo, temperatura, licencias y compatibilidad de arquitectura. No incluir bibliotecas FFmpeg ni extensiones de códecs sin revisar sus licencias y condiciones de distribución.
6. Si el origen entrega un formato que el dispositivo no puede decodificar, evaluar una conversión o transcodificación en servidor, únicamente para streams cuyo uso y transformación estén autorizados. La conversión debe producir un formato compatible con los dispositivos objetivo y dimensionarse para la capacidad real del servidor y la red.
7. Si no existe una ruta compatible, mostrar un mensaje breve y entendible, registrar el diagnóstico y permitir volver a intentar o cambiar de canal.

No se debe forzar indiscriminadamente el modo de decodificación por software: puede producir bajo rendimiento, calentamiento, consumo excesivo de batería o pérdida de fluidez, especialmente en TV Box de baja capacidad.

### 20.6 Requisitos para HLS y MPEG-TS

- Comprobar que los archivos M3U8 y sus segmentos sean accesibles y estén bien formados.
- Comprobar que las variantes de calidad declaradas en el manifiesto correspondan a streams reales.
- Verificar que los segmentos MPEG-TS contengan pistas de audio y video coherentes.
- Manejar correctamente discontinuidades, cambios de resolución y cambios de variante cuando estén presentes.
- No asumir que una lista M3U es un formato de video: es un índice de canales y direcciones de reproducción.
- No asumir que MPEG-TS determina por sí solo el códec.
- No modificar ni transcodificar listas o canales de terceros sin autorización.

### 20.7 Pruebas obligatorias de reproducción

Crear una matriz de pruebas con canales representativos de los formatos realmente presentes en las listas configuradas por el usuario. Como mínimo, cuando estén presentes en las fuentes:

| Caso | Característica a probar | Resultado esperado |
|---|---|---|
| 1 | HLS con video H.264/AVC y audio compatible | Imagen y audio correctos |
| 2 | HLS con segmentos MPEG-TS y H.264/AVC | Imagen y audio correctos |
| 3 | MPEG-TS directo con códec compatible | Imagen y audio correctos |
| 4 | Video HEVC/H.265 en un dispositivo compatible | Reproducción correcta |
| 5 | Video HEVC/H.265 en un dispositivo no compatible | Error controlado; nunca bloqueo indefinido |
| 6 | Flujo con audio pero sin pista de video | Mensaje de fuente sin video |
| 7 | Pista de video presente pero no decodificable | Diagnóstico de códec/decodificador |
| 8 | Cambio entre variantes HLS | Reproducción estable |
| 9 | Segmento ausente o manifiesto defectuoso | Recuperación o error comprensible |
| 10 | Canal con resolución o perfil no soportado | Ruta alternativa compatible o aviso |
| 11 | Zapping repetido entre canales de formatos distintos | Sin bloqueo ni pantalla negra persistente |
| 12 | Reproducción en Android TV y Smartphone | Resultado documentado por dispositivo |

La matriz final debe reflejar los códecs que realmente aparezcan en los streams suministrados. No se deben declarar compatibles formatos que no hayan sido probados.

### 20.8 Criterios de aceptación adicionales

El módulo de reproducción se considerará aceptado cuando:

- Se haya identificado la causa de los canales reportados con audio y pantalla negra, o se haya documentado qué información falta para identificarla.
- Los streams de prueba que el usuario tenga autorización para utilizar se reproduzcan correctamente en los dispositivos objetivo compatibles.
- Los casos de códec no compatible presenten un error controlado y no una pantalla negra indefinida.
- Existan logs técnicos útiles y redactados para investigar fallos.
- El cambio de canal y la recuperación del reproductor funcionen después de un error.
- La corrección no rompa el arranque directo, el último canal visto, el OSD ni el zapping.

---

**FIN DEL DOCUMENTO MAESTRO — LUKKA TELEVISIÓN**
