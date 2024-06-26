package com.example.alura.screensounds.main;

import com.example.alura.screensounds.model.Artist;
import com.example.alura.screensounds.model.Category;
import com.example.alura.screensounds.model.Music;
import com.example.alura.screensounds.repository.SoundRepository;
import com.example.alura.screensounds.services.ChatGptQuery;
import com.theokanning.openai.OpenAiHttpException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
                    6 - Pesquisar por album
                                    
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
                case 6:
                    findMusicsForAlbuns();
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
        var newRegister = "S";
        while(newRegister.equalsIgnoreCase("s")) {
            System.out.print("Nome do artista: ");
            var name = sc.nextLine();
            System.out.print("Qual o tipo do artista (solo, dupla ou banda): ");
            var artistType = sc.nextLine();
            Category category = Category.valueOf(artistType.toUpperCase());
            Artist artists = new Artist(name, category);
            repository.save(artists);
            System.out.println(artists);
            System.out.print("Você deseja adicionar outro artista? (s/n)");
            newRegister = sc.nextLine();
        }
    }

    private void registerMusic() {
        System.out.print("Cadastrar música de que artista?: ");
        var artist = sc.nextLine();
        Optional<Artist>artistMusic = repository.findByNameContainingIgnoreCase(artist);
        if(artistMusic.isPresent()){
            System.out.print("Nome da música: ");
            var musicName = sc.nextLine();
            System.out.print("Album: ");
            var album = sc.nextLine();
            Music music = new Music(musicName, album);
            music.setArtist(artistMusic.get());
            artistMusic.get().getMusics().add(music);
            repository.save(artistMusic.get());
        }else{
            System.out.println("Artista não encontrado!");
        }
    }

    private void musicList() {
        List<Music> musics = repository.findAllMusicsOrderedByArtistName();
        musics.forEach(System.out::println);
    }

    private void searchSongsToArtist() {
        System.out.print("Digite o artista para pesquisar as músicas: ");
        var name = sc.nextLine();
        List<Music> musics = repository.searchMusicByArtist(name);
        musics.forEach(System.out::println);
    }

    private void searchArtistInfos() {
        System.out.print("Pesquisar sobre qual artista?");
        var name = sc.nextLine();
        try {
            var answer = ChatGptQuery.getInformation(name);
            System.out.println(answer.trim());
        }catch (OpenAiHttpException e){
            System.out.println("Não foi possível realizar a pesquisa! Erro: " + e);
        }
    }

    private void findMusicsForAlbuns(){
        System.out.print("Digite o nome do album: ");
        var album = sc.nextLine();
        List<Music> albuns = repository.searchMusicsByAlbum(album);
        albuns.forEach(System.out::println);
    }
}
