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

