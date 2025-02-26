# 📝 Relatório do Processo de Desenvolvimento do Sistema de Estacionamento

## **1. Introdução**
Este relatório descreve o processo de desenvolvimento de um sistema de estacionamento, desde a concepção inicial até a implementação funcional. Durante o desenvolvimento, foram tomadas decisões de projeto, enfrentados desafios técnicos e implementadas soluções para garantir que o sistema atendesse aos requisitos funcionais e não funcionais. Este documento detalha essas decisões, os desafios encontrados e as soluções adotadas.

---

## **2. Decisões de Projeto**

### **2.1. Estrutura do Sistema**
- **Programação Orientada a Objetos (POO):**  
  O sistema foi desenvolvido utilizando os princípios da POO, como encapsulamento, herança e polimorfismo. Essa abordagem permitiu criar uma estrutura modular e reutilizável.
  - **Herança:** 
  - **Interfaces:** Implementada no `Relatorio` para geração de relatórios para cálculo de valores e quantidade de vagas ocupadas e livres. Isso promoveu maior modularidade e extensibilidade.

### **2.2. Persistência de Dados**
- **Arquivos de Texto:**  
  Foi decidido que os dados seriam salvos em arquivos para simplificar a persistência. Utilizamos arquivos `.txt`.

### **2.3. Relatórios**
- **Geração de Relatórios:**  
  Foi optado por criar classes específicas para gerar relatórios operacionais e financeiros. A escolha entre usar herança (`extends`) ou interfaces (`implements`) foi discutida, a decisão final foi por interfaces para maior flexibilidade e separação de responsabilidades.

### **2.4. Tratamento de Exceções**
- **Exceções Verificadas:**  
  Todas as exceções verificadas, como `IOException`, foram tratadas explicitamente para garantir que o sistema fosse robusto e pudesse lidar com erros de forma adequada.

---

## **3. Desafios Enfrentados**

### **3.1. Manipulação de Arquivos**
- **Escrita em Arquivos:**  
  Um dos primeiros desafios foi entender como escrever dados em arquivos de texto. O uso incorreto do `FileWriter` resultou em problemas, como arquivos não sendo criados ou dados não sendo gravados.  
  **Solução:** Utilizar blocos `try-with-resources` e garantir que o buffer fosse descarregado com `.flush()`.

### **3.2. Comparação de Strings**
- **Uso de `==` vs `.equals()`:**  
  Durante a implementação da remoção de veículos da lista, o uso do operador `==` para comparar placas resultou em falhas.  
  **Solução:** Substituir `==` pelo método `.equals()`, que compara o conteúdo das strings.

### **3.3. Interface Gráfica no Terminal**
- **Cores no Terminal:**  
    Pela falta de tempo não foi possível desenvolver uma interface gráfica mais completa, por isso usamos apenas o terminal. Sendo assim para melhorar a experiência do usuário, decidimos colorir mensagens no terminal.  
  **Solução:** Usar os códigos ANSI.

---

## **4. Soluções Implementadas**

### **4.1. Modularidade com Interfaces**
- Implementei interfaces como `Relatorio` para separar responsabilidades e permitir múltiplas implementações. Isso tornou o sistema mais flexível e extensível.

### **4.2. Tratamento de Erros**
- Adotei práticas robustas de tratamento de exceções, como capturar `IOException` durante a manipulação de arquivos e exibir mensagens de erro claras ao usuário.

### **4.3. Melhoria da Experiência do Usuário**
- Implementamos cores no terminal usando códigos ANSI para destacar mensagens importantes, como erros em vermelho e sucessos em verde.  
  **Exemplo de código para cores:**
  ```java
  System.out.println(ConsoleColors.RED + "Erro: Ocorreu um problema!" + ConsoleColors.RESET);