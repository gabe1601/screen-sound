package com.example.alura.screensounds.main;

import com.example.alura.screensounds.model.Artist;
import com.example.alura.screensounds.model.Category;
import com.example.alura.screensounds.model.Music;
import com.example.alura.screensounds.repository.SoundRepository;

import java.util.Scanner;

public class Main {

    private Scanner sc = new Scanner(System.in);
    private SoundRepository repository;

    public Main(SoundRepository repository){
        this.repository = repository;
    }

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
            System.out.println(menu);
            System.out.print("Digite a sua escolha: ");
            userChoice = sc.nextInt();
            sc.nextLine();
            switch (userChoice) {
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
                    System.out.println();
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void registerArtist() {
        char userChoice = 0;
        while(userChoice != 'n') {
            System.out.print("Nome do artista: ");
            var artist = sc.nextLine();
            System.out.print("Qual o tipo do artista: ");
            var artistType = sc.nextLine();
            Category category = Category.stringConvert(artistType);
            System.out.print("Você deseja adicionar outro artista? (s/n)");
            userChoice = sc.next().toLowerCase().charAt(0);
            sc.nextLine();
            Artist artists = new Artist(artist, category);
            System.out.println(artists);
            repository.save(artists);
            System.out.println(artists);
        }
    }

    private void registerMusic() {
        char userChoice = 0;
        while (userChoice != 'n'){
            System.out.print("Nome da música: ");
            var music = sc.nextLine();
            System.out.print("Album: ");
            var album = sc.nextLine();
            System.out.print("Artista: ");
            var artist = sc.nextLine();

            Music musics = new Music(music, album, artist);
            System.out.println(musics);
        }
    }

    private void musicList() {
    }

    private void searchSongsToArtist() {
    }

    private void searchArtistInfos() {
    }
}
