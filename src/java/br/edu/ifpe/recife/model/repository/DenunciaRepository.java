/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.repository;

import br.edu.ifpe.recife.model.entities.Cadeira;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import br.edu.ifpe.recife.model.entities.Denuncia;
import br.edu.ifpe.recife.model.entities.Estudante;
import br.edu.ifpe.recife.model.entities.MetodoFila;
import br.edu.ifpe.recife.model.entities.Professor;
import java.util.Random;


/**
 *
 * @author Rafael
 */
public class DenunciaRepository {

    private static List<Denuncia> denuncias = new ArrayList<>();

    static {   

        Random random = new Random();

        long  maxDate = System.currentTimeMillis();
        long minDate = maxDate - (365L * 24 * 60 * 60 * 1000); 

        String[] turnos = {"manha", "tarde", "noite"};
        List<Estudante> estudantes = EstudanteRepository.readAll();
        int totalEstudantes = estudantes.size();

        for (int i = 0; i < 30; i++) {
            long randomTimestamp = minDate + (long) (random.nextDouble() * (maxDate - minDate));
            String turno = turnos[random.nextInt(turnos.length)];

            Professor professor = ProfessorRepository.read(random.nextInt(2) + 1);
            Cadeira cadeira = CadeiraRepository.read(random.nextInt(5) + 1);
            MetodoFila metodoFila = MetodoFilaRepository.read(random.nextInt(5) + 1);

            Estudante denunciante = estudantes.get(random.nextInt(totalEstudantes));

            List<Estudante> denunciados = new ArrayList<>();
            while (denunciados.size() < 3) {
                Estudante candidato = estudantes.get(random.nextInt(totalEstudantes));
                if (!candidato.equals(denunciante) && !denunciados.contains(candidato)) {
                    denunciados.add(candidato);
                }
            }

            Denuncia denuncia = new Denuncia(
                i + 1, 
                randomTimestamp, 
                turno, 
                "Alguma coisa que aconteceu", 
                denunciados, 
                denunciante, 
                professor, 
                cadeira, 
                metodoFila
            );

            denuncias.add(denuncia);
        }

    }

    public static void create(Denuncia denuncia) {
        denuncias.add(denuncia);
    }

    public static Denuncia read(int codigo) {
        for (Denuncia denuncia : denuncias) {
            if (denuncia.getCodigo() == codigo) {
                return denuncia;
            }
        }
        return null;
    }

    public static List<Denuncia> readAll() {
        return denuncias;
    }

    public static List<Denuncia> filterByDenunciante(Estudante denunciante) {

        List<Denuncia> filtered = new ArrayList();

        for (Denuncia d : denuncias) {
            if (d.getDenunciante().getCodigoEstudante() == denunciante.getCodigoEstudante()) {
                filtered.add(d);
            }
        }
        filtered.sort((d1, d2) -> Long.compare(d2.getData(), d1.getData()));
        return filtered;

    }

    public static List<Denuncia> filterByProfessor(Professor p) {

        List<Denuncia> filtered = new ArrayList();

        for (Denuncia d : denuncias) {
            if (d.getProfessor().getCodigoProfessor() == p.getCodigoProfessor()) {
                filtered.add(d);
            }
        }
        filtered.sort((d1, d2) -> Long.compare(d2.getData(), d1.getData()));
        return filtered;

    }

    public static List<Denuncia> filterByDenunciado(Estudante denunciado) {

        List<Denuncia> filtered = new ArrayList();

        for (Denuncia d : denuncias) {
            for (Estudante e : d.getDenunciados()) {
                if (e.getCodigoEstudante() == denunciado.getCodigoEstudante()) {
                    filtered.add(d);
                }

            }
        }
        filtered.sort((d1, d2) -> Long.compare(d2.getData(), d1.getData()));
        return filtered;

    }
}
