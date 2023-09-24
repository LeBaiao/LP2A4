package Repository;

import Model.Participante;
import java.util.ArrayList;
import java.util.List;

public class ParticipanteRepository {
    private static List<Participante> participantes = new ArrayList<>();

    public static void addParticipante (Participante participante){
        participantes.add(participante);
    }


}
