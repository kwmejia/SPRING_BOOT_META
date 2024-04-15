# 1. Resumen de introduccion Spring Boot

## Comparación entre Spring Framework y Spring Boot

- **Spring Framework**:
  - Propósito: Framework completo para desarrollo en Java.
  - Configuración: Requiere configuración manual detallada.
  - Flexibilidad: Alta, con control sobre aspectos detallados de la aplicación.
  - Curva de aprendizaje: Empinada, requiere manejo de configuraciones complejas.

- **Spring Boot**:
  - Propósito: Simplificar el desarrollo de aplicaciones Spring.
  - Configuración: Usa autoconfiguración para simplificar el setup del proyecto.
  - Productividad: Alta, con herramientas como servidores embebidos.
  - Curva de aprendizaje: Más accesible, ideal para desarrollo rápido.

## Definición de "Starter" en Spring Boot

Un "starter" en Spring Boot es una dependencia preconfigurada que simplifica la adición de ciertas funcionalidades a las aplicaciones Spring, como `spring-boot-starter-web` para aplicaciones web o `spring-boot-starter-data-jpa` para la persistencia de datos.

## Anotaciones

- **Anotaciones (Java)**:
  - No modifican directamente el comportamiento del código.
  - Utilizadas para proporcionar información a herramientas y bibliotecas.

## Anotaciones Clave en Spring Boot

- **@SpringBootApplication**: Combina `@SpringBootConfiguration`, `@EnableAutoConfiguration`, y `@ComponentScan`.
- **@EnableAutoConfiguration**: Activa la autoconfiguración basada en las dependencias del classpath.
- **@ComponentScan**: Le dice a Spring dónde buscar otros componentes, servicios, y configuraciones.
- **@SpringBootConfiguration**: Indica que una clase proporciona configuración para Spring Boot.

## ¿Qué es un Bean en Spring?

Un Bean es un objeto que es gestionado por el contenedor Spring. Los beans son creados, gestionados y destruidos por Spring, facilitando características como la inyección de dependencias y la gestión del ciclo de vida.

## Spring Initializr

Una herramienta en línea que permite la generación rápida de proyectos Spring Boot, configurando automáticamente estructuras de proyecto y dependencias según las necesidades del desarrollador.



# Anotaciones de Controlador

## @Controller

- **Descripción**: `@Controller` es una anotación de Spring MVC que se utiliza para definir una clase como un controlador en el modelo MVC. Esta anotación indica al framework que la clase se encargará de procesar las solicitudes hechas por los clientes.
- **Uso**:
  - Utilizada en clases para definir que son controladores.
  - Puede ser combinada con anotaciones de mapeo de solicitudes para vincular métodos específicos a rutas HTTP.

## @RequestMapping

- **Descripción**: `@RequestMapping` es una de las anotaciones más utilizadas en Spring MVC y Spring Boot. Se utiliza para mapear solicitudes web a métodos de controlador específicos.
- **Uso**:
  - Puede ser utilizada a nivel de clase o método.
  - Soporta configuración de ruta, método HTTP, parámetros, encabezados y medios consumidos o producidos.
  - Ejemplo de uso en un método:
    ```java
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers() {
        return "users";
    }
    ```

## @GetMapping

- **Descripción**: `@GetMapping` es una anotación compuesta que actúa como un atajo para `@RequestMapping(method = RequestMethod.GET)`. Se utiliza para mapear solicitudes GET HTTP a métodos específicos en los controladores.
- **Uso**:
  - Simplifica la anotación `@RequestMapping` cuando se trata de solicitudes GET.
  - Ejemplo de uso:
    ```java
    @GetMapping("/users")
    public String listUsers() {
        return "users";
    }
    ```

Estas anotaciones son fundamentales en el desarrollo de aplicaciones web con Spring Boot, permitiendo la fácil asignación de comportamientos a las solicitudes HTTP y la organización clara del código del lado del servidor.


## @ResponseBody

- **Descripción**: `@ResponseBody` es una anotación que se puede utilizar en un método de controlador para indicar que el valor de retorno del método debe ser vinculado al cuerpo de la respuesta web. Esto significa que el tipo de retorno del método se serializa automáticamente en JSON o XML y se envía de vuelta al cliente.
- **Uso**:
  - Utilizada con métodos en controladores donde se desea enviar la respuesta directamente al cuerpo de la respuesta HTTP, sin pasar por vistas.
  - Ejemplo de uso:
    ```java
    @GetMapping("/users/details")
    @ResponseBody
    public User getUserDetails() {
        return new User("Alice", "alice@example.com");
    }
    ```

Estas anotaciones son fundamentales en el desarrollo de aplicaciones web con Spring Boot, permitiendo la fácil asignación de comportamientos a las solicitudes HTTP y la organización clara del código del lado del servidor.


# Introducción a Spring MVC

Spring MVC es un subproyecto de Spring Framework, diseñado específicamente para el desarrollo de aplicaciones web. Utiliza el patrón Modelo-Vista-Controlador (MVC) para diseñar aplicaciones web de manera clara y flexible.

## Características Principales de Spring MVC

- **Modelo-Vista-Controlador**: Spring MVC sigue el patrón de diseño MVC, que separa la lógica de negocio (modelo), la interfaz de usuario (vista) y la lógica de control (controlador) en componentes distintos. Esto facilita la gestión y mantenimiento de aplicaciones complejas.

- **Configuración Flexible**: Se puede configurar a través de XML o más comúnmente mediante anotaciones en Java, lo que permite a los desarrolladores un alto grado de flexibilidad y control sobre la configuración de sus aplicaciones.

- **Integración con el Ecosistema Spring**: Se integra de manera fluida con otros aspectos de Spring, como seguridad, gestión de transacciones y más, proporcionando un marco cohesivo para el desarrollo de aplicaciones empresariales.

- **Soporte para Diversas Tecnologías de Vista**: Admite una variedad de tecnologías de vistas, incluyendo Thymeleaf, JSP y FreeMarker, permitiendo a los desarrolladores elegir la más adecuada para sus necesidades.

- **Despacho de Solicitudes Robusto**: Utiliza un `DispatcherServlet` para manejar las solicitudes entrantes y despacharlas a los controladores apropiados, basado en las anotaciones o configuraciones.

## Componentes Clave de Spring MVC

- **DispatcherServlet**: Es el corazón de Spring MVC, que maneja todas las solicitudes HTTP y las dirige a los controladores adecuados.

- **Controladores**: Son componentes anotados con `@Controller`, que manejan las solicitudes entrantes, realizan operaciones de negocio y retornan una respuesta, generalmente en forma de nombre de vista o datos (a través de `@ResponseBody`).

- **Vistas**: Son representaciones visuales de datos, comúnmente implementadas usando tecnologías como JSP, Thymeleaf, etc.

- **Resolvers**: Componentes como `ViewResolver` o `MessageResolver` ayudan a determinar qué vista debería ser mostrada al usuario en respuesta a una solicitud o cómo se deben resolver los mensajes.

## Ejemplo Básico de Spring MVC

```java
@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }
}
```

# Estereotipos en Spring Framework

Spring define varios estereotipos que son esenciales para el correcto funcionamiento y organización de una aplicación. Estos estereotipos ayudan a Spring a detectar automáticamente y configurar beans dentro del contenedor Spring.

## @Controller

- **Descripción**: `@Controller` es un estereotipo utilizado en Spring MVC para marcar una clase como controlador en el patrón MVC. Esta anotación indica que la clase manejará las solicitudes web.
- **Uso**:
  - Utilizado en la capa de presentación.
  - Maneja y responde a las solicitudes de usuario, delegando las operaciones de negocio necesarias a los servicios.

## @Repository

- **Descripción**: `@Repository` es un estereotipo que se utiliza para marcar la clase que accede a la base de datos en la capa de persistencia. Spring proporciona una capa de abstracción para manejar el acceso a datos reduciendo la cantidad de código de plomería necesario.
- **Uso**:
  - Utilizado en la capa de persistencia.
  - Encapsula el código necesario para acceder a los datos, separándolo de la lógica de negocio.
  - Spring convierte automáticamente las excepciones relacionadas con la persistencia en excepciones de tipo `DataAccessException`.

## @Service

- **Descripción**: `@Service` es un estereotipo en Spring que se utiliza para anotar clases en la capa de servicio. Estas clases contienen la lógica de negocio y llaman a métodos en la capa de repositorio.
- **Uso**:
  - Utilizado en la capa de servicio.
  - Contiene y orquesta la lógica de negocio, operaciones o transacciones.
  - Es el intermediario entre los controladores y los repositorios, gestionando el flujo de información y las reglas de negocio.

## Ejemplos de Uso

```java
@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }
}

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
```

# Métodos HTTP en Spring MVC

Spring MVC permite manejar diferentes tipos de métodos HTTP para facilitar la creación de interfaces RESTful en aplicaciones web. Cada método HTTP en Spring MVC puede ser manejado específicamente usando anotaciones que simplifican el mapeo de las solicitudes a los métodos del controlador.

## Métodos HTTP Comunes

# Métodos HTTP Básicos

| Método  | Descripción                                           | Idempotente | Seguro |
|---------|-------------------------------------------------------|-------------|--------|
| GET     | Solicita la representación de un recurso específico.  | Sí          | Sí     |
| POST    | Envía datos para crear un nuevo recurso.              | No          | No     |
| PUT     | Reemplaza todas las representaciones actuales del recurso de destino con la carga útil de la solicitud. | Sí | No     |
| DELETE  | Borra un recurso específico.                          | Sí          | No     |
| HEAD    | Solicita la misma respuesta que el método GET, pero sin el cuerpo de la respuesta. | Sí | Sí     |
| OPTIONS | Describe las opciones de comunicación para el recurso de destino. | Sí | Sí     |
| PATCH   | Aplica modificaciones parciales a un recurso.         | No          | No     |

## Descripciones Detalladas

- **GET**: Usado para recuperar datos. Es seguro porque no modifica recursos en el servidor; idempotente porque realizar la misma solicitud repetidas veces no tiene efectos adicionales.
- **POST**: Usado para enviar datos al servidor, como crear o actualizar recursos. No es idempotente, lo que significa que enviar una solicitud POST repetidamente puede resultar en diferentes estados o efectos secundarios.
- **PUT**: Usado para actualizar completamente un recurso existente o crear uno nuevo en una URI específica. Es idempotente ya que realizar la misma solicitud varias veces produce el mismo resultado.
- **DELETE**: Elimina recursos especificados. Es idempotente porque realizar la misma solicitud varias veces no tiene efectos adicionales, después de que el recurso se elimina la primera vez.
- **HEAD**: Similar al método GET, pero sin el cuerpo de la respuesta. Es útil para recuperar encabezados.
- **OPTIONS**: Utilizado para describir las opciones de comunicación disponibles en el servidor, permitiendo al cliente saber qué métodos HTTP y otros parámetros están soportados.
- **PATCH**: Utilizado para hacer modificaciones parciales a un recurso. No es idempotente, ya que pequeñas modificaciones pueden acumular un estado diferente.

Cada uno de estos métodos juega un papel crucial en el desarrollo de aplicaciones web y APIs, facilitando la implementación de operaciones específicas en recursos del servidor.

# Inyección de Dependencias (DI)

La inyección de dependencias es un patrón de diseño utilizado en la ingeniería de software para facilitar la gestión de dependencias entre componentes. Este patrón es esencial en frameworks como Spring para construir aplicaciones más modulares y fáciles de mantener.

## ¿Qué es la Inyección de Dependencias?

La inyección de dependencias permite a una clase recibir sus dependencias de una fuente externa en lugar de crearlas internamente. Esto ayuda a reducir el acoplamiento entre componentes, facilitando así la escalabilidad y mantenibilidad del software.

## Ventajas de la Inyección de Dependencias

1. **Desacoplamiento:** Reduce la dependencia directa entre componentes.
2. **Facilidad de Pruebas:** Facilita las pruebas unitarias al permitir la simulación fácil de las dependencias.
3. **Gestión de Configuración Simplificada:** Centraliza la configuración de las dependencias.
4. **Reutilización de Código:** Promueve la reutilización al separar las preocupaciones.
5. **Flexibilidad y Escalabilidad:** Facilita la expansión y modificación del software.

## Implementación en Spring Framework

Spring utiliza varias anotaciones para gestionar la inyección de dependencias, facilitando la configuración y automatización de este proceso.

### Anotaciones Comunes

- **@Autowired:** Utilizada para inyectar dependencias automáticamente en Spring.
- **@Bean:** Define un bean en el contexto de Spring.
- **@Component:** Marca una clase como un componente de Spring, haciendo que Spring gestione su ciclo de vida.

### Ejemplo de Uso de @Autowired

```java
@Component
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Métodos de negocio aquí
}
```
