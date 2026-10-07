import static java.lang.IO.*;

void main() {

    // ---------------- Integrantes no banco ---------------
    ArrayList<Pessoa> banco = new ArrayList<>();

    banco.add(new Pessoa(1, "Emerson", 17));
    banco.add(new Pessoa(2, "Alberto", 18));
    banco.add(new Pessoa(3, "Pedro", 17));
    banco.add(new Pessoa(4, "Emerson", 22));
    banco.add(new Pessoa(5, "Mika", 17));
    banco.add(new Pessoa(6, "Nicolas", 19));
    banco.add(new Pessoa(7, "Adriano", 18));
    banco.add(new Pessoa(8, "Carlinhos", 28));
    banco.add(new Pessoa(9, "Lucca", 16));
    banco.add(new Pessoa(10, "Igor", 17));
    banco.add(new Pessoa(11, "Adler", 16));

    ArrayList<Pessoa> cache = new ArrayList<>();

    //-------------------------------------------

    do {

        println("\n============================");
        println("===== Cashe de pessoas =====");
        println("============================");

        println("\n1 - Encerrar");
        println("2 - Pesquisar pessoa");
        println("3 - Mostrar cache");
        println("Digite a opção: ");

        int rep = Integer.parseInt(readln());

        // Finalizar
        if (rep == 1) {

            println("Programa encerrado!!!");
            break;

            // Buscar
        } else if (rep == 2) {

            println("Digite o ID da pessoa: ");
            int id = Integer.parseInt(readln());

            Pessoa encontrada = null;

            // Procurar no CACHE
            for (Pessoa pessoa : cache) {

                if (pessoa.getId() == id) {
                    encontrada = pessoa;
                    break;
                }
            }

            // Encontrou no cache
            if (encontrada != null) {

                println("Pessoa encontrada no cache: " + encontrada.getNome() + ", " + encontrada.getIdade() + " anos");

            } else {

                // Procurar no BANCO
                for (Pessoa pessoa : banco) {

                    if (pessoa.getId() == id) {

                        encontrada = pessoa;

                        // Se o cache estiver cheio
                        if (cache.size() == 10) {

                            Pessoa removida = cache.remove(0);

                            println("Cache cheio!");
                            println("Removida: " + removida.getNome());
                        }

                        // Adicionar ao cache
                        cache.add(pessoa);

                        println("Pessoa buscada no banco e adicionada ao cache: " + pessoa.getNome() + ", " + pessoa.getIdade() + " anos");

                        break;
                    }
                }

                if (encontrada == null) {
                    println("Pessoa não encontrada!");
                }
            }

            // MOSTRAR CACHE
        } else if (rep == 3) {

            println("\n===== CACHE ATUAL =====");

            if (cache.isEmpty()) {

                println("O cache está vazio.");

            } else {

                for (Pessoa pessoa : cache) {

                    println("ID: " + pessoa.getId() + " | Nome: " + pessoa.getNome() + " | Idade: " + pessoa.getIdade());
                }
            }

            println("=======================");

        } else {

            println("Opção inválida!");

        }

    } while (true);
}