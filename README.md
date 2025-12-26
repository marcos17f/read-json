Leitura e navegação de arquivos JSON

Objetivo
O objetivo deste projeto é demonstrar como ler um arquivo JSON em modo texto e navegar por seus objetos. A implementação é fornecida nas seguintes linguagens de programação: Java .

Passos

Java
Adicionar dependência de Jackson ao projeto
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.13.0</version>
</dependency>
Lidar com campo do tipo timestamp
A lib Jacksonnão está configurada para lidar com tipos de dados/hora do Java 8 (java.time.Instant) por padrão, para corrigir, siga os passos abaixo:

Adicione o módulo jackson-datatype-jsr310 ao seu projeto.

<dependency>
    <groupId>com.fasterxml.jackson.datatype</groupId>
    <artifactId>jackson-datatype-jsr310</artifactId>
    <version>2.13.0</version>
</dependency>
Configure o ObjectMapper para registrar o módulo.

public static void main(String[] args) {
    ObjectMapper objectMapper = new ObjectMapper();
    
    objectMapper.registerModule(new JavaTimeModule());
    ...
}
Desserializar um array JSON para um objeto
Você pode fazer isso usando o método readValue com a classe TypeReference

Utilização do método readValue com a classe TypeReference , conforme exemplo abaixo:

List<Course> courses = objectMapper.readValue(jsonFile, new TypeReference<List<Course>>() {});

Crie ou copie seu arquivo JSON para o diretório do seu projeto.
No Visual Studio, clique com o botão direito do mouse no diretório do projeto no Solution Explorer.
Escolha "Adicionar" > "Item Existente" e selecione seu arquivo JSON.
Configure a cópia para o diretório de saída:

Selecione o arquivo JSON no Solution Explorer.
No painel de propriedades, defina a propriedade "Copiar para diretório de saída" para "Copiar se for mais recente" ou "Copiar sempre".
Dessa forma, o arquivo JSON será copiado para o diretório de saída (por exemplo, bin\Debug ou bin\Release) quando você compilar o projeto, e você poderá usar o caminho relativo para acessá-lo durante a execução do aplicativo.
