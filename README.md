# Sistema de Gerenciamento de Restaurante

Este projeto é um sistema de gerenciamento de restaurante desenvolvido em Java. Ele utiliza classes que representam os principais elementos do funcionamento de um restaurante, como clientes, funcionários, mesas, pedidos e cardápio. O sistema foi modelado com base em um diagrama de classes e implementado com boas práticas de programação orientada a objetos.

---

## 📋 Estrutura do Projeto

O projeto é organizado em classes, cada uma representando um componente do sistema:

### **Classes principais**
- **Pessoa**: Classe abstrata que serve como base para `Funcionario` e `Cliente`.
- **Funcionario**: Representa um funcionário do restaurante, com métodos para atender mesas e registrar pedidos.
- **Cliente**: Representa um cliente, com histórico de pedidos e métodos para realizar pedidos e solicitar a conta.
- **Mesa**: Representa uma mesa no restaurante, com status, pedidos ativos e métodos para reserva, ocupação e liberação.
- **Pedido**: Contém informações sobre os pedidos, como itens, status e mesa associada.
- **ItemPedido**: Representa os itens dentro de um pedido, incluindo quantidade e observações.
- **ItemCardapio**: Representa os itens do cardápio, incluindo nome, descrição, preço, categoria e disponibilidade.
- **Cardapio**: Gerencia os itens disponíveis no cardápio, com funcionalidades para adicionar, remover e editar itens.
- **Conta**: Representa a conta de um pedido, com cálculo de valores e registro de pagamento.
- **Restaurante**: Classe principal que gerencia mesas, funcionários, clientes, cardápio e pedidos.

---

## 🛠️ Tecnologias Utilizadas

- **Java SE**: Linguagem principal 
- **Maven (opcional)**: Para gerenciar dependências e organizar o projeto.
- **IDE**: Visual Studio Code e InteliJ

---

## 🚀 Funcionalidades Implementadas

- Cadastro de funcionários e clientes.
- Gerenciamento de mesas: reserva, ocupação e liberação.
- Gerenciamento de pedidos: criação, adição e remoção de itens, cálculo do total, finalização e cancelamento.
- Gerenciamento do cardápio: adição, remoção e edição de itens.
- Geração de contas para os pedidos e registro de pagamento.
- Busca por mesas disponíveis no restaurante.

---

## 💡 Como Usar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/FoodDin---Software-Project.git
2. Importe o projeto na sua IDE
3. Agora Compile e Teste

---

## 📝 O Que Falta Ser Feito

Embora o projeto esteja funcional, algumas melhorias e funcionalidades adicionais podem ser implementadas para torná-lo perfeito:

1. **Interface gráfica (GUI)**: Desenvolver uma interface gráfica para facilitar o uso do sistema.
2. **Persistência de dados**: Adicionar integração com banco de dados para salvar informações de clientes, pedidos, mesas e cardápio.
3. **Relatórios de vendas**: Implementar a geração de relatórios detalhados, como vendas por período e desempenho dos funcionários.
4. **Validações de dados**: Garantir que entradas de dados inválidas sejam tratadas adequadamente.
5. **Testes unitários**: Criar testes para verificar o correto funcionamento das classes e métodos.
6. **Controle de autenticação**: Adicionar níveis de acesso (administradores, garçons, cozinheiros) para melhorar a segurança do sistema.

---

## 📂 Estrutura de Arquivos

```plaintext
src/
├── Pessoa.java
├── Funcionario.java
├── Cliente.java
├── Mesa.java
├── Pedido.java
├── ItemPedido.java
├── ItemCardapio.java
├── Cardapio.java
├── Conta.java
└── Restaurante.java

---
