/**
 * EXEMPLOS PRÁTICOS PARA AULA DE QUALIDADE DE CÓDIGO
 *
 * 1. CODE SMELLS
 * 2. BUGS
 * 3. VULNERABILIDADES
 */

import java.util.*;
import java.util.stream.*;

public class QualidadeCodigo {

    // ============================================================================
    // SEÇÃO 1: CODE SMELLS
    // ============================================================================

    public static void main(String[] args) {
        System.out.println("=== CODE SMELLS ===\n");
    }

    // CODE SMELL 1: Função muito longa
    public double processarPedido(Pedido pedido) {
        // Validação
        if (pedido.cliente == null) return 0;
        if (pedido.itens == null || pedido.itens.isEmpty()) return 0;
        if (pedido.endereco == null) return 0;

        // Cálculo do total
        double total = 0;
        for (Item item : pedido.itens) {
            total += item.preco * item.quantidade;
        }

        // Aplicar desconto
        if ("DESC10".equals(pedido.cupom)) {
            total = total * 0.9;
        } else if ("DESC20".equals(pedido.cupom)) {
            total = total * 0.8;
        }

        // Calcular frete
        double frete = 0;
        if ("SP".equals(pedido.endereco.estado)) {
            frete = 15;
        } else if ("RJ".equals(pedido.endereco.estado)) {
            frete = 20;
        } else {
            frete = 30;
        }

        // Simular envio
        System.out.println("Enviando email para " + pedido.cliente.email);
        System.out.println("Salvando pedido no banco de dados...");

        return total + frete;
    }

    // CODE SMELL 2: Código duplicado
    public double calcularDescontoCliente1(double valor) {
        if (valor > 1000) return valor * 0.9;
        else if (valor > 500) return valor * 0.95;
        return valor;
    }

    public double calcularDescontoCliente2(double valor) {
        if (valor > 1000) return valor * 0.9;
        else if (valor > 500) return valor * 0.95;
        return valor;
    }

    // CODE SMELL 3: Números mágicos
    public int calcularTaxaEntrega(int distancia) {
        if (distancia < 5) return 10;
        else if (distancia < 15) return 25;
        else return 50;
    }

    // CODE SMELL 4: Nomes ruins
    public int calcular(int x, int y, int z) {
        int a = x * y;
        int b = a * z;
        int c = b + 50;
        return c;
    }

    // CODE SMELL 5: Classe Deus
    class SistemaCompleto {
        void validarUsuario() {}
        void salvarUsuario() {}
        void enviarEmail() {}
        void calcularFrete() {}
        void processarPagamento() {}
        void gerarRelatorio() {}
        void enviarSMS() {}
        void calcularImposto() {}
    }

    // CODE SMELL 6: Comentários excessivos
    public int proc(List<Integer> d) {
        int x = d.get(0);
        x = x * 2;
        x = x - 10;
        return x;
    }

    // CODE SMELL 7: Train Wreck
    public String obterNomeCidadeUsuario(Usuario usuario) {
        return usuario.getEndereco().getCidade().getNome().toUpperCase();
    }

    // ============================================================================
    // SEÇÃO 2: BUGS
    // ============================================================================

    public boolean verificarIdade(String idade) {
        if (idade == "18") { // BUG
            System.out.println("Você tem exatamente 18 anos");
            return true;
        }
        return false;
    }

    public void contarAte10() {
        int i = 0;
        while (i < 10) {
            System.out.println(i);
            // BUG: faltou i++
        }
    }

    public List<Integer> removerNegativos(List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) < 0) {
                nums.remove(i); // BUG
            }
        }
        return nums;
    }

    public int somarPrimeirosN(List<Integer> array, int n) {
        int soma = 0;
        for (int i = 0; i <= n; i++) { // BUG
            soma += array.get(i);
        }
        return soma;
    }

    public Produto atualizarPreco(Produto p, double novoPreco) {
        Produto atualizado = p; // BUG
        atualizado.preco = novoPreco;
