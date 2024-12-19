# Índice
- [Qué es Angular](#qué-es-angular)
- [Alternativas a Angular](#alternativas-a-angular)
- [Instalación de Angular](#instalación-de-angular)
- [Creación y Ejecución de un Proyecto](#creación-y-ejecución-de-un-proyecto)
- [Live reload](#live-reload)
- [Scaffolding en Angular](#scaffolding-en-angular)
    - [Raiz de un Proyecto](#raiz-de-un-proyecto)
    - [Carpetas .angular](#carpetas-angular)
    - [Carpetas .vscode](#carpetas-vscode)
    - [Carpetas node_modules](#carpetas-node_modules)
    - [Carpetas src](#carpetas-src)
        - [Carpeta app](#carpeta-app)
        - [Carpeta assets](#carpeta-assets)
- [Modo producción](#modo-producción)


# Qué es Angular 
[up](#índice)
Angular es un framework JavaScript, construido sobre TypeScript para crear aplicaciones web SPA (Single Page Application).

***Principales ventajas de Angular:***

- `Modularidad`: Facilita la organización y el mantenimiento del código.

- `Enrutamiento`: Permite la navegación entre las diferentes vistas de la aplicación.

- `Data Binding`: Conecta la interfaz de usuario con los datos de la aplicación de manera eficiente.

- `Directivas`: Permite modificar el comportamiento de los elementos del HTML/DOM.

- `Inyección de dependencias`: Simplifica la gestión de dependencias en componentes y servicios.

- `Testing`: Incluye herramientas integradas para pruebas.

***Angular incluye:***

- Un marco basado en componentes para construir aplicaciones escalables.

- Bibliotecas integradas para funciones clave como enrutamiento, formularios y comunicación cliente-servidor.

- Herramientas de desarrollo para crear, probar y actualizar proyecto.

Angular se adapta desde pequeños proyectos hasta aplicaciones empresariales, respaldado por una comunidad activa de más de 1,7 millones de desarrolladores y creadores de contenido.

# Alternativas a Angular 
[up](#índice)

 - **React**

 - **Vue**

# Instalación de Angular 
[up](#índice)

Para instalar Angular, es necesario tener primero instalado Node.js y npm. Luego instalamos Angular CLI, es necesario instalarlo de forma global en el sistema. 

```bash
<!-- Instalar Angular CLI -->
npm install -g @angular/cli

<!-- Verificar la versión de Angular CLI -->
ng --version
```

El CLI de Angular es una herramienta clave que automatiza tareas comunes del desarrollo, permitiendo interactuar con Angular desde la terminal.

***Funciones principales de Angular CLI:***

- Crear un nuevo proyecto.

- Generar componentes, servicios, directivas, etc.

- Dessarrollar localmente.

- Compila y optimiza la aplicación.

- Ejecutar pruebas unitarias y de extremo a extremo.

# Creación y Ejecución de un Proyecto 
[up](#índice)

- Con comando `ng`

```bash
<!-- Crear un nuevo proyecto -->
ng new nombre_proyecto

<!-- Iniciar el servidor de desarrollo -->
ng serve --open
```

- Con comando `npm`

```bash
"scripts": {
    "ng": "ng",
    "start": "ng serve",
    "build": "ng build",
    "watch": "ng build --watch --configuration development",
    "test": "ng test",
    "serve:ssr:my-app": "node dist/my-app/server/server.mjs"
}
```

# Live reload 
[up](#índice)
Al ejecutar el proyecto podemos ver los cambios en tiempo real.

# Scaffolding en Angular 
[up](#índice)

El scaffolding en Angular genera automáticamente la estructura básica de un proyecto al usar ng new

## Raiz de un Proyecto 
[up](#índice)

- `angular.json`: Configuración del proyecto.

- `package.json`: Dependencias utlizadas.

- `pakage-lock.json`: Dependencias instaladas.

- `README.md`: Documentación del proyecto.

- `server.ts`: Renderizado del lado del servidor (SSR). Aparece si se habilita la opción de SSR.

- `tsconfig.json`: Configuración de TypeScript.

- `tsconfig.app.json`: Configuración de TypeScript para la aplicación.

- `tsconfig.spec.json`: Configuración de TypeScript para las pruebas.

## Carpetas .angular 
[up](#índice)

- `my-app`: Contiene el fichero tsbuildinfo, generado por el compilador TypeScript durante la compilación incremental. 

- `vite`: una herramienta de construcción frontend conocida por su rápido desarrollo.

## Carpetas .vscode 
[up](#índice)

Contiene la configuración de Visual Studio Code .

## Carpetas node_modules 
[up](#índice)

Contiene la dependencias node que utiliza el proyecto.

## Carpetas src 
[up](#índice)

Es donde se encuentra la mayor parte del código fuente de la aplicación.

- `fav.ico`: Icono de la aplicación.

- `index.html`: Página principal de la aplicación.

- `main.server.ts`: Fichero ts para SSR.

- `main.ts`: Fichero ts principal de la aplicación.

- `style.css`: Hoja de estilos global.

### Carpeta app 
[up](#índice)

Es donde se define la estructura, la lógica y el comportamiento de la aplicación. Y donde se trabaja el dessarrollo de la aplicación, inicialmente contiene un componente llamado app.component.ts. 

*Archivos componentes:*

- `.css`: Estilos del componente.

- `.html`: Plantilla del componente.

- `.ts`: Lógica del componente.

- `.spec.ts`: Pruebas del componente.

**Tambien contiene:**

- `app.config.server.ts`: Usado para SSR.

- `app.config.ts`: Usado para el BootStraping.

- `app.routes.ts`: Para enrutado de los componentes.

Tambien crea cada elemento de Angular como Componentes, Directivas, Servicios, Pipes, etc.

### Carpeta assets 
[up](#índice)

En esta carpeta se almacenan los recursos estáticos de la aplicación que no se puede procesar por Angular durante la compilación, como imágenes, fuentes, etc.

# Modo producción 
[up](#índice)

Angular nos deja trabajar en modo de dessarrollo cuando estamos construyendo la aplicación, pero cuando la aplicación está lista para producción, debemos compilar los datos justos para la ejecución del proyecto/aplicacion en un Servidor Web.

***Para compilar en modo producción:***

```bash
ng build
```