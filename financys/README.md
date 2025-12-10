<img width="1248" height="832" alt="Gemini_Generated_Image_qpisaeqpisaeqpis" src="https://github.com/user-attachments/assets/5670ff14-5a99-440f-905f-615013f98ca3" />

# Desafio 10

## Respostas:

**1.**  *O que você entende por **Spring Framework**?*

**Resp:** *O que eu entendo por Spring Framework é que ele é uma **estrutura** (ou framework) de código aberto para a plataforma Java.
Sua principal função é simplificar o desenvolvimento de aplicações complexas, oferecendo um conjunto robusto de **módulos** e **ferramentas** que evitam que o desenvolvedor tenha que criar funcionalidades comuns — como gerenciamento de segurança, acesso a dados e injeção de dependência — **do zero**.
Isso proporciona **agilidade** no desenvolvimento e ajuda a manter o código organizado e de fácil manutenção.* 

**2.** *Cite 3 exemplos de ferramentas Spring e suas respectivas finalidades;*

**Resp:**

**1. Spring Core / Containers:** *O coração do framework. Gerencia a **Injeção de Dependência (DI)** e o ciclo de vida dos objetos (Beans). É a base para que todas as outras ferramentas Spring funcionem.*

**2. Spring MVC (Model-View-Controller):** *Facilita a criação de **aplicações web** e APIs REST. Define a arquitetura que lida com requisições HTTP, mapeamento de URLs e retorno de páginas web ou dados JSON.*

**3. Spring Boot:** *Simplifica a **configuração e o setup** de projetos Spring. Ele automatiza a configuração de dependências e servidores embutidos (como Tomcat ou Jetty), permitindo que você crie aplicações Spring "prontas para rodar" com o mínimo de esforço.*


**3.** *Quais ferramentas do Spring foram utilizadas na trilha até o momento?*

**Resp:** *Spring Boot, Spring Web (Spring MVC), Spring Data JPA, Spring Validation (Bean Validation com Jakarta), Spring Transactional, Spring Exception e ResponseEntity, Injeção de Dependência (Spring IoC Container)*

**4.** *Cite 5 vantagens em utilizar Spring;*

**Resp:** **Os 5 principais motivos para utilizar o Spring Framework são:**

*1. Facilidade e agilidade na criação de aplicações web e APIs REST.*

*2. Uso de ferramentas e módulos mapeados (como Injeção de Dependência e Spring Data) que evitam a escrita de código do zero.*

*3. Abstração de configurações complexas.*

*4. Benefício da segurança robusta herdada da plataforma Java.*

*5. Oferta de módulos especializados, como o Spring Security, para proteção avançada das aplicações.*


**5.** *Descreva os passos de criação de uma Web API Spring boot, com conexão com
SQL Server;*

**Resp:** 

**Passo 1: Criar o Projeto Base com Spring Initializr**
*Use a ferramenta online Spring Initializr para gerar a estrutura inicial do seu projeto Maven*

**Passo 2: Configurar a Conexão com o SQL Server**
*No arquivo src/main/resources/application.properties, adicione as propriedades de conexão com o seu banco de dados SQL Server.*

**Passo 3: Criar a Camada de Modelo (Entidade JPA)**
*Crie uma classe Java que represente uma tabela no seu banco de dados. Use anotações JPA para mapeamento*

**Passo 4: Criar a Camada de Repositório (Data Access)**
*Crie uma interface que estenda JpaRepository. O Spring Data JPA criará automaticamente a implementação necessária para operações CRUD (Create, Read, Update, Delete).*

**Passo 5: Criar a Camada de Controle (Web API Endpoints)**
*Crie um controlador REST para expor os endpoints da API que serão acessados via HTTP (GET, POST, PUT, DELETE)*

**Passo 6: Executar e Testar a Aplicação**
*Inicie sua aplicação Spring Boot através da sua IDE ou usando o comando Maven no terminal na raiz do projeto.*

**6.** *Qual a funcionalidade do **pom.xml**?*

**Resp:** *Em resumo, o pom.xml é o manual de instruções que o Maven segue para construir, gerenciar e executar seu projeto Spring Boot.*

**7.** *Qual a funcionalidades do **applications.properties**?*

**Resp:** *Ele serve para fazermos as nossas configurações. Nele conseguimos fazer a configuração do Banco de Dados, configurações do Servidor Web e configurações específicas do Spring.*

**8.** *Qual o propósito das **Annotations**?*

**Resp:** *As anotações funcionam como marcadores ou etiquetas que "informam" ao framework sobre o propósito ou o papel de um determinado trecho de código. Exemplo quando definimos que uma classe é de serviço com  o @Service, ou quando queremos injetar uma dependência em uma classe com @Autowired*

**9.** *Cite 10 annotations, com suas respectivas finalidades e descreva ou desenhe um
cenário exemplificando a sua utilização;*

**Resp:** *Imagine que estamos construindo um sistema simples de gerenciamento de pedidos (e-commerce) usando Java, Spring Boot, JPA/Hibernate e Lombok.*

**10 Anotações Comuns e Suas Finalidades**

**Anotação	Finalidade**

**1. @Service:**	*Indica que uma classe contém a lógica de negócios (camada de serviço), permitindo que o Spring a gerencie como um componente.*

**2. @Controller:**	*Define uma classe como um controlador para aplicações MVC tradicionais (retorna views/HTML).*

**3. @Autowired:**	*Realiza a Injeção Automática de Dependências (DI), conectando componentes gerenciados pelo Spring.*

**4. @Getter:**	*(Lombok) Gera automaticamente os métodos getter para os campos da classe em tempo de compilação.*

**5. @Setter:**	*(Lombok) Gera automaticamente os métodos setter para os campos da classe em tempo de compilação.*

**6. @RequestMapping:**	*Mapeia requisições web para métodos específicos em classes controladoras.*

**7. @RestController:**	*Uma anotação de conveniência para APIs RESTful, combinando @Controller e @ResponseBody (retorna JSON/XML).*

**8. @Entity:**	*(JPA) Marca a classe como uma entidade persistente, mapeando-a para uma tabela no banco de dados.*

**9. @Table:**	*(JPA) Especifica detalhes da tabela no banco de dados, como o nome exato.*

**10. @NotNull:**	*(Bean Validation) Garante que um campo específico não seja nulo durante a validação dos dados de entrada.*

**10.** *O que é um **advice** em Spring? Quais os tipos de advice para o Spring?*

**Resp:** *Advice é o comportamento que o Spring executa automaticamente em determinados pontos do código. Os tipos de advice em Spring AOP são: **@Before**, **@AfterReturning**, **@AfterThrowing**, **@After**, e **@Around***

**11.** *O que é Spring **IoC Container**?*

**Resp:** *O Spring IoC Container é responsável por criar, gerenciar e aplicar os efeitos das anotações do Spring, como **@Service**, **@Controller**, **@Repository**, **@Component**, **@Autowired** e **@Transactional***

**12.** *Como adicionamos segurança à nossa aplicação Spring?*

**Resp:** *Colocar o @Valid para ele não passar dados que não pode, criar um DTO de response para não trazer informações sensíveis, tipo CPF, etc., adicionar a dependência Spring Security, entre outros...*

**13.** *Qual é o pacote Spring responsável pelas conexões com os bancos de dados?*

**Resp:** *O pacote responsável é a dependência Spring Data JPA (spring-boot-starter-data-jpa).*

**14.** *Explique e exemplifique como criar um agendamento de execução de métodos
Spring; Cite exemplos de usabilidade;*

**Resp:** *Usamos o agendamento no Spring através da anotação **@Scheduled**, que permite programar a execução automática de um método em um horário específico ou em intervalos de tempo, funcionando como um **“alarme”** que dispara a função sem precisar ser chamada manualmente. Para habilitar isso, utilizamos também a anotação **@EnableScheduling***