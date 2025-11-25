<img width="1248" height="832" alt="Gemini_Generated_Image_te0eq3te0eq3te0e" src="https://github.com/user-attachments/assets/db49410c-fdf0-4d9a-a81d-13140ff2730f" />

# Desafio 08

## Respostas:

**1.**  *O que são exceptions? (máx 5 linhas)*

**Resp:** *Exceptions **(exceções)** são eventos inesperados que ocorrem durante a execução de um programa, interrompendo seu fluxo normal. Elas servem como um mecanismo para tratar erros de forma controlada, prevenindo que a aplicação **"quebre" (interrompa abruptamente)** e permitindo que o desenvolvedor exiba mensagens informativas ou execute ações corretivas, garantindo a continuidade do funcionamento do sistema.* 

**2.** *Qual é o funcionamento do try, catch e finally? (máx 10 linhas)*

**Resp:**
*O funcionamento do try, catch e finally é um mecanismo para gerenciar erros em tempo de execução (exceções):*
* **Try:** *É o mecanismo onde digitamos a parte do código que possa dar algum erro.*


* **Catch:** *É o responsável por guardar nosso tratamento caso a linha do código informado no try venha a ocorrer.*


* **Finally:** *Vem em seguida, garantindo a execução de um bloco de código **(geralmente de limpeza de recursos)** independentemente de ocorrer um erro ou não. É ideal para garantir a liberação de recursos, como fechar arquivos ou conexões de rede, prevenindo vazamentos e garantindo que o programa continue de forma segura.*

**3.** *Qual a relação entre “try, catch e finally” e “throws”? (máx 5 linhas)*

**Resp:** *A relação do **throws** com o **try, catch e finally** é que essa assinatura no método serve para informar que o método pode lançar uma exceção **(dar algum erro)** e obriga o código que o chama a ter o **try/catch** para tratar essa exceção, caso contrário, o compilador apontará um erro.*

**4.** *Para que serve a annotation @ExceptionHandler? (máx 5 linhas)*

**Resp:** *A anotação **@ExceptionHandler** serve para ser utilizada em métodos de classes controladoras **(@Controller ou @ControllerAdvice)** para interceptar e tratar exceções específicas que ocorrem durante o processamento de requisições HTTP. Ela permite personalizar a resposta enviada ao cliente **(como códigos de status HTTP e mensagens de erro amigáveis)**, em vez de retornar um erro genérico do sistema.*

**5.** *Para que serve o comando throw? (máx 5 linhas)*

**Resp:** *O **throw** é usado para forçar a interrupção do programa quando uma condição que você considera um erro acontece.*

**6.** *Para que serve a annotation @ControllerAdvice? (máx 10 linhas)*

**Resp:** **@ControllerAdvice** *é a anotação que você coloca no topo da sua classe dedicada a gerenciar erros de forma centralizada.
Essa classe funciona como um controlador global de exceções, onde cada método dentro dela, anotado com **@ExceptionHandler**, lida com um tipo específico de erro para toda a sua API.*



