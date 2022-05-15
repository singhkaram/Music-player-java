package Music_player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Punjabi101","Spotify");

        album.addSong("Toxic",3.5);
        album.addSong("Gangsta",3.5);
        album.addSong("Excuses",5.0);
        albums.add(album);

        album = new Album("Hot Hits India","Spotify");

        album.addSong("Heat Waves",4.5);
        album.addSong("Peaches",3.5);
        album.addSong("Cooped Up",3.5);

        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("Toxic",playList_1);
        albums.get(0).addToPlayList("Gangsta",playList_1);
        albums.get(1).addToPlayList("Heat Waves",playList_1);
        albums.get(1).addToPlayList("Cooped Up",playList_1);

        play(playList_1);

    }

    private static void play(LinkedList<Song> playList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if(playList.size() == 0){
            System.out.println("This Playlist Have No Song");
        }else {
            System.out.println("Now Playing " + listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){

                case 0:
                    System.out.println("Playlist Complete");
                    quit = true;
                    break;

                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now Playing "+listIterator.next().toString());
                    }else {
                        System.out.println("No Song Available, Reached To The End Of The List");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now Playing "+listIterator.previous().toString());
                    }else {
                        System.out.println("We Are The First Song");
                        forward = false;
                    }
                    break;

                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now Playing "+listIterator.previous().toString());
                            forward = false;
                        }else {
                            System.out.println("We Are At The Start Of The List");
                        }
                    }else {
                        if(listIterator.hasNext()){
                            System.out.println("Now Playing "+listIterator.next().toString());
                            forward = true;
                        }else {
                            System.out.println("We Are At The End Of List");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() >0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now Playing "+listIterator.next().toString());
                        }
                        else {
                            if(listIterator.hasPrevious())
                            System.out.println("Now Playing "+listIterator.previous().toString());
                        }
                    }

            }
        }
    }

    private static void printMenu(){
        System.out.println("Available Option's\n PRESS");
        System.out.println("0 - To Quit\n"+
                "1 - To Play Next Song\n"+
                "2 - To Play Previous Song\n"+
                "3 - To Replay The Current Song\n"+
                "4 - List Of All Songs \n"+
                "5 - Print All Available Options\n"+
                "6 - Delete Current Song");
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("-----------------");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("-----------------");
    }

}