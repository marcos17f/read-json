# JSON File Reading and Navigation
## Objetivo
O objetivo deste projeto é demonstrar como ler um arquivo JSON em modo texto e navegar por seus objetos. A implementação é fornecida na seguintes linguagen de programação: Java.

### Java

#### Adicionar dependência do Jackson ao projeto

```xml
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.13.0</version>
</dependency>
```

####  Lidar com campo do tipo timestamp

A lib do ```Jackson``` não está configurado para lidar com tipos de data/hora do Java 8 (java.time.Instant) por padrão, para corrigir, seguir os passos abaixo:

- Adicionar o módulo **jackson-datatype-jsr310** ao seu projeto.

    ```xml
    <dependency>
        <groupId>com.fasterxml.jackson.datatype</groupId>
        <artifactId>jackson-datatype-jsr310</artifactId>
        <version>2.13.0</version>
    </dependency>
    ```
- Configurar o **ObjectMapper** para registrar o módulo. 

    ```java
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        
        objectMapper.registerModule(new JavaTimeModule());
        ...
    }
    ```

#### *Deserialize* um array JSON para um objeto 

Você pode fazer isso usando o método readValue com a classe TypeReference

Utilizar o método **readValue** com a classe **TypeReference**, conforme exemplo abaixo:

```java
List<Course> courses = objectMapper.readValue(jsonFile, new TypeReference<List<Course>>() {});
```

#### Passos para incluir arquivo JSON:

1. Adicione o arquivo JSON ao projeto:
    - Crie ou copie seu arquivo JSON para o diretório do seu projeto.
    - No Visual Studio, clique com o botão direito do mouse no diretório do projeto no Solution Explorer.
    - Escolha "Add" > "Existing Item" e selecione seu arquivo JSON.

2. Configure a cópia para o diretório de saída:
    - Selecione o arquivo JSON no Solution Explorer.
    - No painel de propriedades, defina a propriedade "Copy to Output Directory" para "Copy if newer" ou "Copy always".

- Dessa forma, o arquivo JSON será copiado para o diretório de saída (por exemplo, bin\Debug ou bin\Release) quando você compilar o projeto, e você pode usar o caminho relativo para acessá-lo durante a execução do aplicativo.


