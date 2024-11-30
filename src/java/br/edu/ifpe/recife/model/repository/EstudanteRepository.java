/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.repository;

import java.util.ArrayList;
import java.util.List;
import br.edu.ifpe.recife.model.entities.Estudante;

/**
 *
 * @author Rafael
 */
public class EstudanteRepository {
    private static List<Estudante> estudantes;

    static {
        estudantes = new ArrayList<>();

Estudante e1 = new Estudante();
        e1.setAnoEntradaEstudante(2023);
        e1.setCodigoEstudante(1);
        e1.setEmailEstudante("a@a");
        e1.setNomeEstudante("Ayrton Senna");
        e1.setSenhaEstudante("1");
        estudantes.add(e1);

        Estudante e2 = new Estudante();
        e2.setAnoEntradaEstudante(2022);
        e2.setCodigoEstudante(2);
        e2.setEmailEstudante("b@b");
        e2.setNomeEstudante("Betina Youtube");
        e2.setSenhaEstudante("1");
        estudantes.add(e2);

        Estudante e3 = new Estudante();
        e3.setAnoEntradaEstudante(2024);
        e3.setCodigoEstudante(3);
        e3.setEmailEstudante("c@c");
        e3.setNomeEstudante("Carlão Trezoitão");
        e3.setSenhaEstudante("1");
        estudantes.add(e3);

        Estudante e4 = new Estudante();
        e4.setAnoEntradaEstudante(2021);
        e4.setCodigoEstudante(4);
        e4.setEmailEstudante("d@d");
        e4.setNomeEstudante("Didi Trapalhão");
        e4.setSenhaEstudante("1");
        estudantes.add(e4);

        Estudante e5 = new Estudante();
        e5.setAnoEntradaEstudante(2023);
        e5.setCodigoEstudante(5);
        e5.setEmailEstudante("e@e");
        e5.setNomeEstudante("Elba Ramalho");
        e5.setSenhaEstudante("1");
        estudantes.add(e5);

        Estudante e6 = new Estudante();
        e6.setAnoEntradaEstudante(2020);
        e6.setCodigoEstudante(6);
        e6.setEmailEstudante("f@f");
        e6.setNomeEstudante("Felipe Massa");
        e6.setSenhaEstudante("1");
        estudantes.add(e6);

        Estudante e7 = new Estudante();
        e7.setAnoEntradaEstudante(2024);
        e7.setCodigoEstudante(7);
        e7.setEmailEstudante("g@g");
        e7.setNomeEstudante("Gabriel Jesus");
        e7.setSenhaEstudante("1");
        estudantes.add(e7);

        Estudante e8 = new Estudante();
        e8.setAnoEntradaEstudante(2019);
        e8.setCodigoEstudante(8);
        e8.setEmailEstudante("h@h");
        e8.setNomeEstudante("Harry Potter");
        e8.setSenhaEstudante("1");
        estudantes.add(e8);

        Estudante e9 = new Estudante();
        e9.setAnoEntradaEstudante(2022);
        e9.setCodigoEstudante(9);
        e9.setEmailEstudante("i@i");
        e9.setNomeEstudante("Indio Curandeiro");
        e9.setSenhaEstudante("1");
        estudantes.add(e9);

        Estudante e10 = new Estudante();
        e10.setAnoEntradaEstudante(2023);
        e10.setCodigoEstudante(10);
        e10.setEmailEstudante("j@j");
        e10.setNomeEstudante("Jojo Todynho");
        e10.setSenhaEstudante("1");
        estudantes.add(e10);
        
        Estudante e11 = new Estudante();
        e10.setAnoEntradaEstudante(2023);
        e10.setCodigoEstudante(11);
        e10.setEmailEstudante("rafael@r");
        e10.setNomeEstudante("Rafael Moraes");
        e10.setSenhaEstudante("1");
        estudantes.add(e11);
    }

    public static void create(Estudante estudante) {
        estudantes.add(estudante);
    }

    public static void update(Estudante updatedEstudante) {
        for (Estudante estudante : estudantes) {
            if (estudante.getCodigoEstudante() == updatedEstudante.getCodigoEstudante()) {
                estudante.setNomeEstudante(updatedEstudante.getNomeEstudante());
                estudante.setEmailEstudante(updatedEstudante.getEmailEstudante());
                estudante.setSenhaEstudante(updatedEstudante.getSenhaEstudante());
                estudante.setAnoEntradaEstudante(updatedEstudante.getAnoEntradaEstudante());
                return;
            }
        }
    }

    public static Estudante read(int codigoEstudante) {
        for (Estudante estudante : estudantes) {
            if (estudante.getCodigoEstudante() == codigoEstudante) {
                return estudante;
            }
        }
        return null;
    }

    public static void delete(int codigoEstudante) {
        for (int i = 0; i < estudantes.size(); i++) {
            if (estudantes.get(i).getCodigoEstudante() == codigoEstudante) {
                estudantes.remove(i);
                return;
            }
        }
    }

    public static List<Estudante> readAll() {
        return estudantes;
    }
    
    public static Estudante fazerLogin(String emailEstudante, String senhaEstudante) {
        for (Estudante e : estudantes) {
            if (e.getEmailEstudante().equals(emailEstudante) && e.getSenhaEstudante().equals(senhaEstudante)) {
                return e;
            }
        }
        return null;
    }
}
   