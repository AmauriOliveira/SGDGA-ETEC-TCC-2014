package br.com.etec.sgdga.control;

import javax.swing.JOptionPane;

public class CnpjValido {

    int[] numero = new int[15];
    int ver = 0, mult = 0;

    public boolean CNPJ(String valor) {
        String cnpj = valor;

        if (valor.trim().length() == 18) {
            try {
                numero[0] = Integer.parseInt(cnpj.charAt(0) + "");
                numero[1] = Integer.parseInt(cnpj.charAt(1) + "");
                //.2
                numero[2] = Integer.parseInt(cnpj.charAt(3) + "");
                numero[3] = Integer.parseInt(cnpj.charAt(4) + "");
                numero[4] = Integer.parseInt(cnpj.charAt(5) + "");
                //.6
                numero[5] = Integer.parseInt(cnpj.charAt(7) + "");
                numero[6] = Integer.parseInt(cnpj.charAt(8) + "");
                numero[7] = Integer.parseInt(cnpj.charAt(9) + "");
                //.10
                numero[8] = Integer.parseInt(cnpj.charAt(11) + "");
                numero[9] = Integer.parseInt(cnpj.charAt(12) + "");
                numero[10] = Integer.parseInt(cnpj.charAt(13) + "");
                numero[11] = Integer.parseInt(cnpj.charAt(14) + "");
                //15
                numero[14] = Integer.parseInt(cnpj.charAt(16) + "" + cnpj.charAt(17));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor errado\n" + e, "Falha", 0, null);
            }
            mult = 5;
//primeiro digito
            for (int i = 0; i < 12; i++) {
                if (mult == 1) {
                    mult = 9;
                }
                ver = ver + (numero[i] * mult);
                mult--;

            }
            ver = ver % 11;

            if (ver > 1) {
                numero[12] = 11 - ver;
            } else {
                numero[12] = 0;
            }
            //segundo digito
            //reiniciar contador
            mult = 6;
            ver = 0;
            for (int i = 0; i < 13; i++) {
                if (mult == 1) {
                    mult = 9;
                }
                int f = (numero[i] * mult);
                ver = ver + (numero[i] * mult);
                mult--;

            }

            ver = ver % 11;

            if (ver > 1) {
                numero[13] = 11 - ver;
            } else {
                numero[13] = 0;
            }

            int cor, dig;

            ///verificar
            cor = Integer.parseInt(numero[12] + "" + numero[13]);
            dig = numero[14];
            //
            ver = 0;
            numero[14] = 0;
            ///reset
            ///
            return dig == cor;

        } else {
            return false;
        }

    }

}
