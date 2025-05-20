package br.fiap.controle;

import br.fiap.assento.Assento;
import br.fiap.cliente.Cliente;
import br.fiap.cliente.PessoaFisica;
import br.fiap.cliente.PessoaJuridica;
import br.fiap.reserva.Reserva;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.*;

public class Controle {

    private static List<Cliente> listaCliente = new ArrayList<>();
    private static List<Assento> listaAssento = new ArrayList<>();
    private List<Reserva> listaReserva = new ArrayList<>();

    static {
        //lista de clientes
        listaCliente.add(new PessoaFisica("ClienteA", "clienteA@fiap.com","123"));
        listaCliente.add(new PessoaJuridica("ClienteB", "clienteB@gmail.com","123/1000"));
        listaCliente.add(new PessoaFisica("ClienteC", "clienteC@fiap.com","456"));
        listaCliente.add(new PessoaJuridica("ClienteD", "clienteD@gmail.com","456/1000"));

        for (int i = 0; i < 10; i++) {
            listaAssento.add(new Assento(i+1));
        }
    }

    public void menu() {
        int opcao;

        while(true) {
            try {
                opcao = parseInt(showInputDialog(gerarMenu()));
                switch(opcao) {
                    case 1:
                        reservar();
                        break;
                    case 2:
                        pesquisar();
                        break;
                    case 3:
                        cancelar();
                        break;
                    case 4:
                        return;
                    default:
                        showMessageDialog(null, "Opção inválida");
                }
            }
            catch(NumberFormatException e) {
                showMessageDialog(null, "Você deve digitar um número");
            }
        }
    }

    private void cancelar() { }

    private void pesquisar() {
        String identificador = showInputDialog("CPF/CNPJ para pesquisa");
        listaReserva.forEach(reserva ->{
            if(reserva.getCliente().getIdentificador().equalsIgnoreCase(identificador)){
                showMessageDialog(null, reserva);
            }
            else {
                showMessageDialog(null, "Cliente não encontrado!");
            }
        });
    }

    private void reservar() { }

    private String gerarMenu() {
        String aux = "SISTEMA DE RESERVA DE PASSAGEM AÉREA\n";
        aux += "1. Reservar\n";
        aux += "2. Pesquisar reserva\n";
        aux += "3. Cancelar reserva\n";
        aux += "4. Finalizar";
        return aux;
    }
}
