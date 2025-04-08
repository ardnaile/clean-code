# Exercício sobre Tratamento de Erros

Este projeto simula um torneio de futebol com registro de times, partidas e exibição do resultado final. Todos os erros são tratados e registrados em um arquivo de log.

## 🛠 Tecnologias

- Java
- Spring Boot (apenas para a estrutura do projeto, sem uso de API web)
- SLF4J + Logback (para logging)

## ⚙️ Como executar usando a IDE Intellij IDEA

- Abra o projeto na IDE
- Vá até a classe Main.java
- Clique com o botão direito > Run

## 🧾 Log de erro
Os erros são registrados em um arquivo localizado em:

```
logs/erros.log
```

### Configuração
A configuração para garantir que todas as exceções tratadas com `logger.error()` sejam salvas no arquivo de logs está em src/main/resources/logback.xml com este conteúdo:

```xml
<configuration>
    <appender name="FILE" class="ch.qos.logback.core.FileAppender">
        <file>logs/erros.log</file>
        <append>true</append>
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger - %msg%n</pattern>
        </encoder>
    </appender>

    <root level="error">
        <appender-ref ref="FILE"/>
    </root>
</configuration>

```


