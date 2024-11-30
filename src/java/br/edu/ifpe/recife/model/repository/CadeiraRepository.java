/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.repository;

import java.util.ArrayList;
import java.util.List;
import br.edu.ifpe.recife.model.entities.Cadeira;

/**
 *
 * @author Rafael
 */
public class CadeiraRepository {
    private static List<Cadeira> cadeiras;

static {
        cadeiras = new ArrayList<>();
        Cadeira c1 = new Cadeira();
        c1.setCodigo(1);
        c1.setNome("Algoritmos e Estruturas de Dados");
        c1.setAno(2022);
        c1.setDescricao("Estudo de algoritmos e estruturas de dados fundamentais para o desenvolvimento de software.");
        c1.setSemestre(1);
        cadeiras.add(c1);

        Cadeira c2 = new Cadeira();
        c2.setCodigo(2);
        c2.setNome("Programação Orientada a Objetos");
        c2.setAno(2023);
        c2.setDescricao("Introdução aos conceitos e práticas de programação orientada a objetos utilizando Java.");
        c2.setSemestre(2);
        cadeiras.add(c2);

        Cadeira c3 = new Cadeira();
        c3.setCodigo(3);
        c3.setNome("Banco de Dados");
        c3.setAno(2022);
        c3.setDescricao("Fundamentos de sistemas de banco de dados, modelagem de dados e SQL.");
        c3.setSemestre(2);
        cadeiras.add(c3);

        Cadeira c4 = new Cadeira();
        c4.setCodigo(4);
        c4.setNome("Engenharia de Software");
        c4.setAno(2024);
        c4.setDescricao("Princípios e práticas de engenharia de software, incluindo o ciclo de vida do desenvolvimento de sistemas.");
        c4.setSemestre(1);
        cadeiras.add(c4);

        Cadeira c5 = new Cadeira();
        c5.setCodigo(5);
        c5.setNome("Redes de Computadores");
        c5.setAno(2023);
        c5.setDescricao("Conceitos e práticas de redes de computadores, protocolos e arquitetura de rede.");
        c5.setSemestre(1);
        cadeiras.add(c5);
        
        Cadeira c6 = new Cadeira();
        c5.setCodigo(6);
        c5.setNome("WEB 1");
        c5.setAno(2023);
        c5.setDescricao("Conceitos de programação web, http, css e javascript.");
        c5.setSemestre(1);
        cadeiras.add(c6);
        
        Cadeira c7 = new Cadeira();
        c5.setCodigo(7);
        c5.setNome("WEB 2");
        c5.setAno(2023);
        c5.setDescricao("Essa cadeira aí mesmo...");
        c5.setSemestre(5);
        cadeiras.add(c7);

    }

    public static void create(Cadeira cadeira) {
        cadeiras.add(cadeira);
    }

    public static void update(Cadeira updatedCadeira) {
        for (Cadeira cadeira : cadeiras) {
            if (cadeira.getCodigo() == updatedCadeira.getCodigo()) {
                cadeira.setNome(updatedCadeira.getNome());
                cadeira.setAno(updatedCadeira.getAno());
                cadeira.setSemestre(updatedCadeira.getSemestre());
                cadeira.setDescricao(updatedCadeira.getDescricao());
                return;
            }
        }
    }

    public static Cadeira read(int codigo) {
        for (Cadeira cadeira : cadeiras) {
            if (cadeira.getCodigo() == codigo) {
                return cadeira;
            }
        }
        return null;
    }

    public static void delete(int codigo) {
        for (int i = 0; i < cadeiras.size(); i++) {
            if (cadeiras.get(i).getCodigo() == codigo) {
                cadeiras.remove(i);
                return;
            }
        }
    }

    public static List<Cadeira> readAll() {
        return cadeiras;
    }
}
