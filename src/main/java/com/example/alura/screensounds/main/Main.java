package com.example.alura.screensounds.main;

public class Main {

    public void mainMenu(){
        var userChoice = -1;
        while(userChoice != 9) {
            var menu = """
                    *** Screen Sounds Aplication ***
                                    
                    1 - Cadastrar artista
                    2 - Cadastrar música
                    3 - Listar música
                    4 - Buscar música por artistas
                    5 - Pesquisar dados sobre artista
                                    
                    9 - Sair
                    """;
        }

        switch (userChoice){
            case 1:
                registerArtist();
                break;
            case 2:
                registerMusic();
                break;
            case 3:
                musicList();
                break;
            case 4:
                searchSongsToArtist();
                break;
            case 5:
                searchArtistInfos();
                break;
            case 9:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida");    
        }

    }

    private void searchArtistInfos() {
    }

    private void searchSongsToArtist() {
    }

    private void musicList() {
    }

    private void registerMusic() {
    }

    private void registerArtist() {
    }

}
