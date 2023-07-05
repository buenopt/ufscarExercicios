package exerc15;

public class DecisionMaker {
    public boolean mostrarAnuncio(Usuario u, boolean anuncioRelevante) {
        if (u.isInativoPor2Semanas()) {
            return false; // Não mostra o anúncio se o usuário estiver inativo
        } else if (u.isViuAnuncioUltimaHora()) {
            return false; // Não mostra o anúncio se o usuário já tiver visto um anúncio na última hora
        } else if (u.getNumeroDeSeguidores() > 1000 && !anuncioRelevante) {
            return true; // Mostra o anúncio mesmo que não seja relevante para usuários influenciadores
        } else {
            return anuncioRelevante; // Mostra o anúncio se for relevante para usuários não influenciadores
        }
    }

}
