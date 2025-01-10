package controller;
import java.util.Comparator;
import java.util.Iterator;
import model.Produto;
import java.util.List;
import java.util.LinkedList;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class Inventario {
    protected static List<Produto> listaProduto = new LinkedList<>();
    
    /** 
     * Permitir que o usuário adicione um novo produto ao inventário,
     * além disso é feita uma verificação das informações inseridas. 
     */
    public static void addProduto(String nomeProduto, String categoriaProduto, int quantidadeEstoque, double preco) {

        // Verifica se os campos nomeProduto e categoriaProduto não são nulos ou vazios.
        if (nomeProduto == null || nomeProduto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O nome do produto é obrigatório.");
            return;
        }

        if (categoriaProduto == null || categoriaProduto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A categoria do produto é obrigatória.");
            return;
        }

        // Verifica se a quantidade de estoque é válida
        if (quantidadeEstoque < 0) {
            JOptionPane.showMessageDialog(null, "A quantidade em estoque não pode ser negativa.");
            return;
        }

        // Verifica se o preço é válido
        if (preco < 0) {
            JOptionPane.showMessageDialog(null, "O preço não pode ser negativo.");
            return;
        }

        // Se todas as validações passarem, adiciona o produto à lista        
        listaProduto.add(new Produto(quantidadeEstoque, nomeProduto, categoriaProduto, quantidadeEstoque, preco));
        JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!");
    }

    public static void exibirInventario() {
    if (listaProduto.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Não há produtos cadastrados.", "Lista de Produtos", JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    // Pergunta ao usuário se ele quer filtrar por categoria ou ordenar os produtos
    String[] opcoesFiltro = {"Filtrar por Categoria", "Ordenar por Nome", "Ordenar por Quantidade", "Ordenar por Preço", "Nenhum filtro"};
    int escolhaFiltro = JOptionPane.showOptionDialog(
            null,
            "Escolha uma opção de filtro ou ordenação:",
            "Filtrar ou Ordenar Produtos",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            opcoesFiltro,
            opcoesFiltro[0] // Padrão para a primeira opção
    );

    // Filtragem ou ordenação com base na escolha do usuário
    switch (escolhaFiltro) {
        case 0: // Filtrar por Categoria
            String categoriaFiltro = JOptionPane.showInputDialog("Digite a categoria para filtrar:");
            if (categoriaFiltro != null && !categoriaFiltro.trim().isEmpty()) {
                listaProduto = listaProduto.stream()
                        .filter(produto -> produto.getCategoriaProduto().equalsIgnoreCase(categoriaFiltro))
                        .collect(Collectors.toList());
            }
            break;

        case 1: // Ordenar por Nome
            listaProduto.sort(Comparator.comparing(Produto::getNomeProduto));
            break;

        case 2: // Ordenar por Quantidade
            listaProduto.sort(Comparator.comparingInt(Produto::getQuantidadeEstoque));
            break;

        case 3: // Ordenar por Preço
            listaProduto.sort(Comparator.comparingDouble(Produto::getPreco));
            break;

        default:
            // Nenhum filtro ou ordenação aplicada
            break;
    }

    // Cria uma string para armazenar todos os produtos com formato simples
    StringBuilder produtosLista = new StringBuilder();

    // Adiciona os produtos à lista no formato do toString()
    for (Produto prodLista : listaProduto) {
        produtosLista.append(prodLista.toString());  // Chama o toString de cada produto
    }

    // Exibe todos os produtos em uma única janela
    JOptionPane.showMessageDialog(null, produtosLista.toString(), "Lista de Produtos", JOptionPane.INFORMATION_MESSAGE);
}

    
    
    // Remover um produto do inventário pelo seu id
    public static void excluirProduto(int idProd) {
        if (idProd <= 0) {
            JOptionPane.showMessageDialog(null, "ID inválido! Por favor, insira um ID maior que 0.");
            return; // Sai do método caso o ID não seja válido
        }

        boolean produtoEncontrado = false;
        Iterator<Produto> iterator = listaProduto.iterator();

        while (iterator.hasNext()) {
            Produto produto = iterator.next();
            if (produto.getIDProduto() == idProd) {
                int respostaUser = JOptionPane.showConfirmDialog(
                    null,
                    "Deseja realmente excluir este produto?",
                    "Excluir Produto",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );

                if (respostaUser == JOptionPane.YES_OPTION) {
                    iterator.remove(); // Remove o produto da lista
                    JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
                    produtoEncontrado = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Operação de exclusão cancelada.");
                }
                break; // Interrompe o loop após encontrar o produto
            }
        }

        // Verifica se o produto foi encontrado após o loop
        if (!produtoEncontrado) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado.");
        }
    }
    
    // Buscar e exibir detalhes de um produto específico pelo id ou pelo nome.
    public static void buscarProduto(Object tipodeParametro){        
        tipoParametro(tipodeParametro);        
    }

    public static void tipoParametro(Object pID_Nome){
        boolean produtoEncontrado = false;
        Iterator<Produto> iterator = listaProduto.iterator();
        
        // Verifica se o parametro passado é um int IDProduto
        if (pID_Nome instanceof Integer) {
            int idProduto = (Integer) pID_Nome;
            
            while(iterator.hasNext()) {
                Produto produto = iterator.next();
                
                if(produto.getIDProduto() == idProduto){
                    JOptionPane.showMessageDialog(null, produto.toString());
                    produtoEncontrado = true;
                    break;
                }            
            }
        }  
        
        else if (pID_Nome instanceof String) {
            String nomeProduto = (String) pID_Nome;
            iterator = listaProduto.iterator(); // Reinicia o iterator
            
            while(iterator.hasNext()){
                Produto produto = iterator.next();
                if (produto.getNomeProduto().equalsIgnoreCase(nomeProduto)) {
                    JOptionPane.showMessageDialog(null, produto.toString());
                    produtoEncontrado = true;
                    break;
                }                    
            } 
        } 
        else {
            JOptionPane.showMessageDialog(null, "Parâmetro inválido. Informe um ID ou Nome do produto corretamente.");
        }
        
        if (!produtoEncontrado) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado.");
        }
    }
    
    // Solicita ao usuário qual campo deseja atualizar e verifica a escolha do usuário
    // Atualizar as informações de um produto existente identificado pelo seu id.
    public static void atualizarProduto(int escolhaAtualizacao, int idProd) {
        // Verifica se o ID é válido
        if (idProd <= 0) {
            JOptionPane.showMessageDialog(null, "ID inválido! Por favor, insira um ID válido!");
            return; // Sai do método caso o ID não seja válido
        }

        // Encontra o produto pelo ID
        Produto updateProduto = null;
        for (Produto produto : listaProduto) {
            if (produto.getIDProduto() == idProd) {
                updateProduto = produto;
                break; // Encontra o produto e sai do loop
            }
        }
        
        // Se o produto não for encontrado, exibe uma mensagem
        if (updateProduto == null) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado.");
            return;
        }

        // Solicita ao usuário qual campo deseja atualizar
        switch (escolhaAtualizacao) {
            case 0 -> {
                // Atualizar Nome
                String novoNome = JOptionPane.showInputDialog("Digite o novo nome do produto:");
                if (novoNome != null && !novoNome.trim().isEmpty()) {
                    updateProduto.setNomeProduto(novoNome); // Atualiza o nome
                    JOptionPane.showMessageDialog(null, "Nome atualizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Nome inválido.");
                }
            }

            case 1 -> {
                // Atualizar Categoria
                String novaCategoria = JOptionPane.showInputDialog("Digite a nova categoria do produto:");
                if (novaCategoria != null && !novaCategoria.trim().isEmpty()) {
                    updateProduto.setCategoriaProduto(novaCategoria); // Atualiza a categoria
                    JOptionPane.showMessageDialog(null, "Categoria atualizada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Categoria inválida.");
                }
            }

            case 2 -> {
                // Atualizar Quantidade
                String novaQuantidadeStr = JOptionPane.showInputDialog("Digite a nova quantidade do produto:");
                try {
                    int novaQuantidade = Integer.parseInt(novaQuantidadeStr); // Converte para inteiro
                    if (novaQuantidade >= 0) {
                        updateProduto.setQuantidadeEstoque(novaQuantidade); // Atualiza a quantidade
                        JOptionPane.showMessageDialog(null, "Quantidade atualizada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Quantidade inválida. Não pode ser negativa.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Quantidade inválida. Digite um número.");
                }
            }

            case 3 -> {
                // Atualizar Preço
                String novoPrecoStr = JOptionPane.showInputDialog("Digite o novo preço do produto (ex: 99.99):");
                try {
                    double novoPreco = Double.parseDouble(novoPrecoStr); // Converte para double
                    if (novoPreco >= 0) {
                        updateProduto.setPreco(novoPreco); // Atualiza o preço
                        JOptionPane.showMessageDialog(null, "Preço atualizado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Preço inválido. Não pode ser negativo.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Preço inválido. Digite um número válido.");
                }
            }

            case 4 -> JOptionPane.showMessageDialog(null, "Operação de atualização cancelada.");

            default -> JOptionPane.showMessageDialog(null, "Opção inválida.");
        }
    }
}
