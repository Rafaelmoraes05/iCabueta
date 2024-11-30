/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.repository;

import java.util.ArrayList;
import java.util.List;
import br.edu.ifpe.recife.model.entities.Professor;


/**
 *
 * @author Rafael
 */
public class ProfessorRepository {
    
    private static List<Professor> professores;
    
    static {
        professores = new ArrayList<>();

        Professor p1 = new Professor();
        p1.setCodigoProfessor(1);
        p1.setEmailProfessor("a@a");
        p1.setNomeProfessor("Eduardo Vasconcelos");
        p1.setSenhaProfessor("1");
        professores.add(p1);

        Professor p2 = new Professor();
        p2.setCodigoProfessor(2);
        p2.setEmailProfessor("b@b");
        p2.setNomeProfessor("Mestre Yoda");
        p2.setSenhaProfessor("1");
        professores.add(p2);
    }

    public static void create(Professor professor) {
        professores.add(professor);
    }

    public static void update(Professor updatedProfessor) {
        for (Professor professor : professores) {
            if (professor.getCodigoProfessor() == updatedProfessor.getCodigoProfessor()) {
                professor.setNomeProfessor(updatedProfessor.getNomeProfessor());
                professor.setEmailProfessor(updatedProfessor.getEmailProfessor());
                professor.setSenhaProfessor(updatedProfessor.getSenhaProfessor());
                return;
            }
        }
    }

    public static Professor read(int codigo) {
        for (Professor professor : professores) {
            if (professor.getCodigoProfessor() == codigo) {
                return professor;
            }
        }
        return null;
    }

    public static void delete(int codigo) {
        for (int i = 0; i < professores.size(); i++) {
            if (professores.get(i).getCodigoProfessor() == codigo) {
                professores.remove(i);
                return;
            }
        }
    }

    public static List<Professor> readAll() {
        return professores;
    }
    
    public static Professor fazerLogin(String email, String senha) {
        for (Professor p : professores) {
            if (p.getEmailProfessor().equals(email) && p.getSenhaProfessor().equals(senha)) {
                return p;
            }
        }
        return null;
    }
    
}
