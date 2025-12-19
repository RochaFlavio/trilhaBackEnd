<img width="1264" height="848" alt="Gemini_Generated_Image_7x4hli7x4hli7x4h" src="https://github.com/user-attachments/assets/5ef0377b-e956-4836-87f1-8c99de85d4d5" />

# Desafio 11
## Respostas :

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
