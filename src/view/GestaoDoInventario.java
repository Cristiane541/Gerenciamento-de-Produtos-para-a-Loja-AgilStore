package view;

import controller.Inventario;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Produto;

/**
 * @author Cristiane de Araujo Ferreira
 * @date 08/01/2024
 */

public class GestaoDoInventario {
    public static void main(String[] args) {
       
        while (true) {
            String opcao = JOptionPane.showInputDialog("Escolha uma opção:\n1. Adicionar Produto\n2. Listar Produtos\n3. Buscar Produto\n4. Atualizar Produto\n5. Excluir Produto\n6. Sair");
            switch (opcao) {
                case "1":
                    String nome = JOptionPane.showInputDialog("Nome do Produto:");
                    String categoria = JOptionPane.showInputDialog("Categoria:");
                    int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade em Estoque:"));
                    double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço:"));
                    Inventario.addProduto(nome, categoria, quantidade, preco);
                    break;
                case "2":
                    //Exibe todos os produtos cadastrados no inventário.
                    Inventario.exibirInventario();
                    
               
                    
                    
                    break;
                case "3":                    
                    // Pergunta ao usuário se ele quer buscar por ID ou Nome
                    int escolha = JOptionPane.showConfirmDialog(                       
                        null, 
                        "Deseja buscar o produto por ID?", 
                        "Escolha a busca", 
                        JOptionPane.YES_NO_OPTION
                    );

                    if (escolha == JOptionPane.YES_OPTION) {  // Se o usuário escolher "Sim" (ID)                        
                        String inputID = JOptionPane.showInputDialog("Digite o ID do produto:");
                        try {
                            int idProduto = Integer.parseInt(inputID);  // Converte a entrada para int
                            Inventario.buscarProduto(idProduto);  // Chama o método com o ID
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "ID inválido. Por favor, digite um número.");
                        }} else if (escolha == JOptionPane.NO_OPTION) {  // Se o usuário escolher "Não" (Nome)
                            String nomeProduto = JOptionPane.showInputDialog("Digite o nome do produto:");
                            Inventario.buscarProduto(nomeProduto);  // Chama o método com o nome
                    } else {
                        JOptionPane.showMessageDialog(null, "Seleção inválida.");
                    }
                    
                    break;
                case "4":
                    // Atualiza as informações de um produto existente identificado pelo seu id.
                    //Array que armazena quais das opções o usuário gostaria de Selecionar p fazer a devida atualização do campo
                    String[] opcoesAtualizacao = {"Nome", "Categoria", "Quantidade", "Preço", "Cancelar"};                    
                    int escolhaAtualizacao = JOptionPane.showOptionDialog(
                        null, 
                        "Escolha qual campo deseja atualizar:", 
                        "Atualizar Produto", 
                        JOptionPane.DEFAULT_OPTION, 
                        JOptionPane.QUESTION_MESSAGE, 
                        null, 
                        opcoesAtualizacao, 
                        opcoesAtualizacao[0]  // A primeira opção é selecionada por padrão
                    );
                    
                    // Solicita ID do produto do inventário a ser atualizado.
                    int numID = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o ID do produto a ser atualizado:"));
                    Inventario.atualizarProduto(escolhaAtualizacao,numID);
                    
                    break;
                case "5":
                    // Remove um produto do inventário pelo seu id.
                    String inputID = JOptionPane.showInputDialog(null, "Informe o ID do produto a ser excluído:");
                    if (inputID != null && !inputID.isEmpty()) {
                        try {
                            int idProd = Integer.parseInt(inputID);  // Converte a entrada para um inteiro
                            Inventario.excluirProduto(idProd);  // Chama o método para excluir o produto
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Por favor, insira um ID válido (um número inteiro).");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "ID não informado.");
                    }
                        break;
                case "6":
                    // Saindo do programa
                    JOptionPane.showMessageDialog(null, "Até logo...");                    
                    System.exit(0); // Para encerrar sistema
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        }
    }
}

