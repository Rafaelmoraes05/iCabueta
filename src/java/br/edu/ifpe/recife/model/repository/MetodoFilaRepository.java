/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.repository;

import br.edu.ifpe.recife.model.entities.MetodoFila;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class MetodoFilaRepository {
    private static List<MetodoFila> metodosFila;

    static {
        metodosFila = new ArrayList<>();

        MetodoFila mf1 = new MetodoFila();
        mf1.setCodigoFila(1);
        mf1.setDescricaoCurta("Cola Tech");
        mf1.setDescricaoLonga("Utilização de dispositivos eletrônicos escondido.");
        metodosFila.add(mf1);

        MetodoFila mf2 = new MetodoFila();
        mf2.setCodigoFila(2);
        mf2.setDescricaoCurta("Resposta na Borracha");
        mf2.setDescricaoLonga("Escreveu as alternativas na borracha e passou ao lado.");
        metodosFila.add(mf2);

        MetodoFila mf3 = new MetodoFila();
        mf3.setCodigoFila(3);
        mf3.setDescricaoCurta("Olhou a prova");
        mf3.setDescricaoLonga("Tentar visualizar a prova de outro colega para copiar as respostas.");
        metodosFila.add(mf3);

        MetodoFila mf4 = new MetodoFila();
        mf4.setCodigoFila(4);
        mf4.setDescricaoCurta("Aviãozinho");
        mf4.setDescricaoLonga("Uso de papéis pequenos com o conteúdo da prova.");
        metodosFila.add(mf4);

        MetodoFila mf5 = new MetodoFila();
        mf5.setCodigoFila(5);
        mf5.setDescricaoCurta("Navegador");
        mf5.setDescricaoLonga("Busca de respostas na internet.");
        metodosFila.add(mf5);

    }

    public static void create(MetodoFila metodoFila) {
        metodosFila.add(metodoFila);
    }

    public static void update(MetodoFila updatedMetodoFila) {
        for (MetodoFila metodoFila : metodosFila) {
            if (metodoFila.getCodigoFila() == updatedMetodoFila.getCodigoFila()) {
                metodoFila.setDescricaoCurta(updatedMetodoFila.getDescricaoCurta());
                metodoFila.setDescricaoLonga(updatedMetodoFila.getDescricaoLonga());
                return;
            }
        }
    }

    public static MetodoFila read(int codigoFila) {
        for (MetodoFila metodoFila : metodosFila) {
            if (metodoFila.getCodigoFila() == codigoFila) {
                return metodoFila;
            }
        }
        return null;
    }

    public static void delete(int codigoFila) {
        for (int i = 0; i < metodosFila.size(); i++) {
            if (metodosFila.get(i).getCodigoFila() == codigoFila) {
                metodosFila.remove(i);
                return;
            }
        }
    }

    public static List<MetodoFila> readAll() {
        return metodosFila;
    }
    
}
