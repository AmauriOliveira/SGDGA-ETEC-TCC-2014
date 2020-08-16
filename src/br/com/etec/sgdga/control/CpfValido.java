package br.com.etec.sgdga.control;

import javax.swing.JOptionPane;

public class CpfValido {

    int[] numero = new int[11];
    int ver = 0, mult = 0, dig = 0, cor = 0;

    public boolean CPF(String valor) {
        String cpf = valor;
      

        if (valor.trim().length() == 14) {
            try {
                numero[0] = Integer.parseInt(cpf.charAt(0) + "");
                numero[1] = Integer.parseInt(cpf.charAt(1) + "");
                numero[2] = Integer.parseInt(cpf.charAt(2) + "");
//.
                numero[3] = Integer.parseInt(cpf.charAt(4) + "");
                numero[4] = Integer.parseInt(cpf.charAt(5) + "");
                numero[5] = Integer.parseInt(cpf.charAt(6) + "");
//.
                numero[6] = Integer.parseInt(cpf.charAt(8) + "");
                numero[7] = Integer.parseInt(cpf.charAt(9) + "");
                numero[8] = Integer.parseInt(cpf.charAt(10) + "");
                dig = Integer.parseInt(cpf.charAt(12) + "" + cpf.charAt(13));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Valor errado\n" + ex, "Falha", 0, null);
                dig = 999;
            }
            mult = 10;
//primeiro digito
            for (int i = 0; i < 9; i++) {
                ver = ver + (numero[i] * mult);
                mult--;

            }
            ver = ver % 11;

            if (ver > 1) {
                numero[9] = 11 - ver;
            } else {
                numero[9] = 0;
            }
            //segundo digito
            //reiniciar contador
            mult = 11;
            ver = 0;
            for (int i = 0; i < 10; i++) {
                ver = ver + (numero[i] * mult);
                mult--;

            }

            ver = ver % 11;

            if (ver > 1) {
                numero[10] = 11 - ver;
            } else {
                numero[10] = 0;
            }

            ///verificar
            cor = Integer.parseInt(numero[9] + "" + numero[10]);

            ////
            numero[10] = 177;
            ver = 0;////reset
            ///
            return dig == cor;
        } else {
            return false;
        }
    }

}
