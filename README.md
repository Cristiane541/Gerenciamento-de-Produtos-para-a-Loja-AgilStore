## Gerenciamento de Inventário de Produtos para a Loja Agil Store
## Descrição
  Este é um sistema de gerenciamento de inventário de produtos para a loja AgilStore. O objetivo do sistema é automatizar o controle do 
  estoque de produtos, permitindo operações como:

## Funcionalidades e Como Usar
## 1. Adicionar Produto
   O sistema solicitará que o usuário insira as informações do produto, como nome, categoria, quantidade e preço. Um ID único será gerado    automaticamente para o produto.

## 2. Listar Produtos
   Exibe todos os produtos cadastrados. O usuário pode filtrar por categoria ou ordenar os produtos por nome, quantidade ou preço.

## 3. Atualizar Produto
   Através do ID do produto, o usuário pode atualizar os seguintes campos: nome, categoria, quantidade ou preço.

## 4. Excluir Produto
   O usuário pode excluir um produto do inventário após confirmar a ação.

## 5. Buscar Produto
   O sistema permite buscar um produto através do ID ou do nome. Caso não encontre, uma mensagem será exibida.

   A aplicação facilita a gestão de um inventário crescente e oferece opções para realizar as operações de forma eficiente.

## Ferramenta
   Apache Netbeans IDE 18
   JOptionPane - Interface gráfica para interação com o usuário
   Collections - Estruturas de dados para armazenamento do inventário
   Obs.: Os dados são persistidos apenas enquanto a aplicação estiver em execução (em memória), sem o uso de arquivos externos.

## Instalação
   Clone o repositório: git clone https://github.com/seu-usuario/agilstore.git

## Compile e execute o projeto:
   Caso você esteja utilizando um IDE como IntelliJ ou Eclipse, basta importar o projeto e executar a classe principal.
   Caso prefira rodar pela linha de comando, compile o código com: javac -d bin src/com/agilstore/*.java

## Execute a aplicação:
   java -cp bin com.agilstore.Inventario






