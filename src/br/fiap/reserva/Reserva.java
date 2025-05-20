package br.fiap.reserva;

import br.fiap.assento.Assento;
import br.fiap.cliente.Cliente;
import br.fiap.desconto.Desconto;

public class Reserva {
    private Cliente cliente;
    private Assento assento;
    private double valorOriginal;
    private double valorFinal;


    public Reserva(Cliente cliente, Assento assento, double valorOriginal) {
        this.cliente = cliente;
        this.assento = assento;
        this.valorOriginal = valorOriginal;
        aplicarDesconto();
    }

    private void aplicarDesconto() {
        if (cliente instanceof Desconto) {
            valorFinal = (((Desconto) cliente).aplicarDesconto(valorOriginal));
        } else {
            valorFinal = valorOriginal;
        }
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "cliente=" + cliente +
                ", valorOriginal=" + valorOriginal +
                ", valorFinal=" + valorFinal +
                ", assento=" + assento +
                '}';
    }

    public Cliente getCliente() {
        return cliente;
    }
}