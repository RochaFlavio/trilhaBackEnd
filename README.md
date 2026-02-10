<img width="1264" height="848" alt="Gemini_Generated_Image_yej4yjyej4yjyej4" src="https://github.com/user-attachments/assets/79b60395-a3d0-4f35-bb3c-57cd4dc77c6d" />

# Desafio 12    
## Respostas :

**1.** *Explique o conceito de teste unitário?*

**Resp:** *O **teste unitário** serve para testar uma função ou parte do código de forma **exclusiva**. Por exemplo: se quero testar uma função expecifica, seleciono apenas ela para não precisar testar todas as outras funções do código inteiro.*

**2.** *Descreva como fazer um código de teste.*

**Resp:** *Para criar um código de teste você segue uma lógica simples: primeiro você chama a função passando um valor para ela e depois confere se o resultado é o que você queria. O processo funciona criando um arquivo de teste que geralmente tem o mesmo nome da sua função original mas com o final .test, e dentro dele você dá um nome para esse teste escrevendo uma frase curta sobre o que aquela função específica deve fazer. Por fim, você faz a comparação usando uma palavra mágica como o expect ou o assert para confirmar se o resultado que a função devolveu é igual ao valor que você já sabe que é o correto.*

**3.** *Qual o intuito do teste unitário?*

**Resp:** *O intuito é testar uma função específica do código, isolando apenas ela sem rodar o sistema inteiro e sem acessar o banco de dados*

**4.** *Quais são as ferramentas que utilizamos para realizar testes unitários(2 pelo
menos).*

**Resp:** 
* **Jest:** *O mais usado para quem programa em JavaScript ou TypeScript. Jest Official*
* **JUnit:** *O padrão absoluto para quem usa Java. JUnit.org*

<h1 align= "center"> Texto Stack Tracer e Explicações </h1>

| Texto Stack Tracer | Explicação (1 Frase) |
|--------------------|----------------------|
| org.mockito.exceptions.misusing.UnnecessaryStubbingException<br>Unnecessary stubbings detected<br>Following stubbings are unnecessary<br>-> TrilhaBackTestes.java:80 | Mock criado no teste mas não utilizado |
| java.lang.NullPointerException: Cannot invoke "java.util.List.stream()" because "todos" is null | Tentativa de executar stream() em lista nula |
| org.opentest4j.AssertionFailedError<br>Expected: 5<br>Actual: 1 | O teste esperava 5 registros mas retornou apenas 1 |
| java.lang.ArithmeticException: Divisão por zero | Divisão realizada com divisor zero |
| org.opentest4j.AssertionFailedError<br>expected: false<br>but was: true | O teste esperava lista vazia mas recebeu lista com dados |
