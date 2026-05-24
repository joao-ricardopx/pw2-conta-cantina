package br.com.etechoracio.model;

import br.com.etechoracio.enums.TipoContaEnum;

public class ContaCantina {

    private TipoContaEnum tipoConta;
    private double saldo;
    private double limite;
    private double saldoMinimo;

    public ContaCantina(double saldo){

        tipoConta = TipoContaEnum.ALUNO;
        this.saldo = saldo;

        saldoMinimo = 10;
        limite = 0;

    }

    public ContaCantina(TipoContaEnum tipoConta, double saldo){

        this.tipoConta = tipoConta;
        this.saldo = saldo;

        saldoMinimo = 10;
        limite = 0;

        if(tipoConta == TipoContaEnum.PROFESSOR){

            limite = 100;

        }

    }

    public void emitirAlertaSaldoBaixo(){

        if(saldo <= saldoMinimo){

            System.out.println(
                    "ALERTA DE SALDO BAIXO: R$ " + saldo
            );

        }

        else{

            System.out.println(
                    "Saldo: R$ " + saldo
            );

        }

    }

    public void debitar(double valor){

        if(tipoConta == TipoContaEnum.DIRETOR){

            saldo -= valor;

            emitirAlertaSaldoBaixo();

        }

        else if(tipoConta == TipoContaEnum.PROFESSOR){

            if(saldo > valor &&
                    valor < saldo + limite){

                saldo -= valor;

                emitirAlertaSaldoBaixo();

            }

            else{

                System.out.println(
                        "Conta sem saldo suficiente"
                );

            }

        }

        else{

            if(saldo > valor){

                saldo -= valor;

                emitirAlertaSaldoBaixo();

            }

            else{

                System.out.println(
                        "Conta sem saldo suficiente"
                );

            }

        }

    }

    public void creditar(double valor){

        saldo += valor;

        if(tipoConta == TipoContaEnum.ALUNO){

            if(valor > 100){

                saldo += 5;

            }

        }

        emitirAlertaSaldoBaixo();

    }

    public void setSaldoMinimo(double saldoMinimo){

        this.saldoMinimo = saldoMinimo;

        emitirAlertaSaldoBaixo();

    }

    public double getSaldo(){

        return saldo;

    }

    public double getLimite(){

        return limite;

    }

    public TipoContaEnum getTipoConta(){

        return tipoConta;

    }

}