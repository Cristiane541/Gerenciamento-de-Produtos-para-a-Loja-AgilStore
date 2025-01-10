package model;

/**
 * Documentação Classe Produto
 */
public class Produto {
    private final int IDProduto; // ID único para cada produto
    private static int ID_ChaveUnicaProduto = 0; // Contador global para gerar IDs únicos
    private String nomeProduto;
    private String categoriaProduto;
    private int quantidadeEstoque;
    private double preco;
    
    /**
    Construtor que inicializa a variável IDProduto com um valor único,
    gerado automaticamente pela variável estática pré-incrementada ++ID_ChaveUnicaProduto = 0;  
     * @param IDProduto
     * @param nomeProduto
     * @param categoriaProduto
     * @param preco
     * @param quantidadeEstoque
     * @param Preco
    */
    
    
    //Sobrecar de construtores
    public Produto(int IDProduto, String nomeProduto, String categoriaProduto, int quantidadeEstoque, double Preco) {
        this.IDProduto = ++ID_ChaveUnicaProduto; // Atribui um ID único e incrementa o contador
        this.nomeProduto = nomeProduto;
        this.categoriaProduto = categoriaProduto;
        this.quantidadeEstoque = quantidadeEstoque;
        this.preco = Preco;
    }

    public Produto(String nomeProduto, String categoriaProduto, int quantidadeEstoque, double preco) {
        this.IDProduto = ++ID_ChaveUnicaProduto; // Atribui um ID único e incrementa o contador
        this.nomeProduto = nomeProduto;
        this.categoriaProduto = categoriaProduto;
        this.quantidadeEstoque = quantidadeEstoque;
        this.preco = preco;
    }
    
    //Getters and Setters
    public int getIDProduto() {
        return IDProduto;
    }
        
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(String categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double Preco) {
        this.preco = Preco;
    }

    // Método toString utilizado Para Exibir todos os produtos cadastrados no inventário.   
    @Override
    public String toString() {
        return "Produto ID: " + IDProduto + "\n" +
               "Nome: " + nomeProduto + "\n" +
               "Categoria: " + categoriaProduto + "\n" +
               "Quantidade em estoque: " + quantidadeEstoque + "\n" +
               "Preço: R$ " + String.format("%.2f", preco) + "\n\n\n";
    }
}
