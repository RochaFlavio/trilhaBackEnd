<img width="1248" height="832" alt="Gemini_Generated_Image_81scik81scik81sc" src="https://github.com/user-attachments/assets/669a9026-9bba-487a-91de-385eed0ba14f" />

# Desafio 09

## Respostas:

**1.**  *O que é um padrão de projeto e por que nós os utilizamos?*

**Resp:** *O padrão de projeto é um jeito de deixar as coisas organizadas e utilizamos justamente para isso, organização, depois definimos qual tipo de padrão vamos usar e qual vai ser melhor encaixado no nosso projeto.* 

**2.** *Cite e explique com suas palavras:*

**A.Um dos padrões de criação:**

**Resp:** *Um dos padrões de criação é o "Factory Method". Ele serve para centralizar a lógica de criação de objetos, permitindo que o sistema decida, em tempo de execução, qual tipo específico de objeto instanciar. Por exemplo, em um sistema de concessionária, usamos uma "fábrica" que, com base no pedido do cliente ("SUV" ou "Sedan"), nos entrega o objeto correto, sem que o código principal precise saber a complexidade de criar cada tipo de carro.*

**B. Um dos padrões estruturais:**

**Resp:** *Dentro dos padrões estruturais, temos o "Adapter" (Adaptador). Ele é usado para fazer duas classes com interfaces incompatíveis trabalharem juntas. Ele atua como um "tradutor" que adapta a forma como uma classe existente funciona para o formato que seu sistema espera.*

**C. Um dos padrões comportamentais:**

**Resp:** *Um dos padrões comportamentais mais comum é o "Observer" (Observador). Ele é a solução prática para a relação 1:N (um para muitos). O padrão permite que um objeto principal (o "Sujeito") notifique automaticamente múltiplos objetos interessados (os "Observadores") sempre que seu estado mudar, garantindo a comunicação eficiente entre eles.*

**3. Explique o conceito de arquitetura de software e seu proposito:**

**Resp:** *A arquitetura de software ela é responsável pela organização do sistema e o seu propósito principal é garantir a qualidade e gerenciar a complexidade do projeto.*

**4. Qual arquitetura estamos seguindo até o momento? Justifique sua resposta.**

**Resp:** *No meu projeto estou usando a arquitetura por camadas, essa arquitetura é muito boa pois deixa cada coisa em seu devido lugar de uma forma organizada e que, se outra pessoa acessar o código, terá facilidade para achar a informação pelo fato de estar separado em pacotes de classes específicas. **Exemplo:** os **DTOs** estão em um pacote só de **DTOs**, **Controllers**, **Services**, **etc**., seguem da mesma forma. Isso deixa o código padrão e fácil de localizar a informação.*

**5. O que significa a sigla SOLID?**

**Resp:** *A sigla SOLID representa 5 princípios de design orientado a objetos que ajudam a criar código mais organizado, flexível e fácil de manter.*

**S:** *Single Responsibility Principle (Princípio da Responsabilidade Única)*

**O:** *Open/Closed Principle (Princípio Aberto/Fechado)*

**L:** *Liskov Substitution Principle (Princípio da Substituição de Liskov)*

**I:** *Interface Segregation Principle (Princípio da Segregação de Interface)*

**D:** *Dependency Inversion Principle (Inversão de Dependência)*

**6. Quais princípios foram utilizados no projeto até o momento? Explique.
(máx 10 linhas)**

**Resp:** *No meu projeto original utilizei a arquitetura em camadas **(Controller, Service, Repository e Entity)**, separando bem as responsabilidades em pacotes específicos, o que facilita leitura e manutenção.
Dentro dessa arquitetura, aplico o **Single Responsibility Principle**, pois cada classe possui uma única responsabilidade clara, como **controllers** cuidando apenas das requisições e services da lógica de negócio.
Também sigo o **Open/Closed Principle**, já que posso estender funcionalidades criando novos métodos e classes sem modificar o que já funciona.
Por fim, utilizo o **Dependency Inversion Principle**, porque os serviços dependem de interfaces de repositório e não diretamente da implementação concreta, permitindo futuras mudanças no banco sem alterar a lógica da aplicação.*

## Respostas do desafio 11

**1.** *O que são libs quando se trata de código? (máx 3 linhas)*

**Resp:** *Libs são as bibliotecas de código, libs é uma abreviação de libraries, que são conjuntos de códigos pré-escritos que fornecem funcionalidades específicas para serem reutilizadas em diferentes programas*

**2.** *Cite 2 libs populares no Java e seu objetivo; (máx 3 linhas)*

**Resp:** 

- **1 .** *Jackson (JSON Parsing Library):
Objetivo: É a biblioteca padrão para converter objetos Java em formato JSON (serialização) e vice-versa (desserialização).*


- **2 .**  *Lombok: Objetivo: Reduzir o código boilerplate em Java, como getters, setters, construtores e métodos toString, facilitando a escrita de código mais limpo e conciso.*


**3.** *Qual é o propósito do Maven, e qual é o seu relacionamento com o arquivo
pom.xml? (máx 5 linhas)*

**Resp:** *O **Maven** é o executor responsável por ler e processar as definições do **pom.xml**. Enquanto o **pom.xml** fornece as coordenadas e as regras (o plano), o **Maven** executa as ações (o trabalho pesado) para construir o projeto.*

**4.** *Qual é a diferença do Maven para o Grandle? (máx 3 linhas)*

**Resp:** *O **Maven** é focado em **padronização**, usando arquivos **XML** rígidos que facilitam a **organização** e o **aprendizado**. O **Gradle** é focado em **performance** e **flexibilidade**, usando scripts de código que tornam o **build** muito mais **rápido** e **customizável**. Enquanto o **Maven** segue regras fixas, o **Gradle** permite criar regras próprias para projetos complexos*

**5.** *Com os conhecimentos adquiridos até o agora, realize uma conexão com o
desafio 3 onde falamos sobre JDBC, os drivers de comunicação com os bancos de
dados.*
- **Qual a relação entre os termos lib, driver e JDBC?**

**Resp:** *A relação entre esses três termos é de **hierarquia** e **especialização**. Uma **lib** é o conceito geral, o **Driver** é um tipo específico de **lib**, e o **JDBC** é a regra que diz como eles devem conversar. Resumo da relação:
O **JDBC** é o manual de instruções, o **Driver** é o tradutor que segue esse manual, e a **Lib** é o pacote físico que traz esse tradutor para dentro do seu projeto.*


- **Como é adicionado uma lib no projeto?**

**Resp:** *Adicionamos uma dependência no nosso **pom.xml** para que o **Maven** baixe e interprete essa **lib** quando ela for chamada no nosso código.*

- **Escolha um banco de dados (menos o H2) e explique como utilizar o driver de
  comunicação.**

**Resp:** Para usar o **driver** no **MySQL**, precisamos adicionar a **dependência** do banco no nosso **pom.xml**. Após isso, no arquivo **application.properties**, realizamos a configuração de **login**, **senha** e a **URL** com o nome do nosso banco. Com isso configurado, basta preparar o código: mapear as classes e colunas para que o sistema consiga interagir com o banco de dados.*

