package main;
import entity.Video;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("src\\main\\resources\\Tom&Jerry.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        int count = 0;
        ArrayList<Video> listVideo = new ArrayList<Video>();
        HashMap<String, Video> anhson = new HashMap<String, Video>();
        while ((line = br.readLine()) != null) {
            if (count == 0) {
                count++;
                continue;
            }
            String[] splitted = line.split("\\s{2,}");
            if (splitted.length == 4) {
                String day = splitted[0];
                String id = splitted[1];
                String title = splitted[2];
                String view = splitted[3];
                Video vd = new Video(day, id, title, view);
                listVideo.add(vd);
            }
        }
                for (Video a : listVideo) {
                    int oo = 0;
                    if (anhson.containsKey(a.getId())) {
                        oo = anhson.get(a.getId()).getView();
                    }
                    oo += a.getView();
                    Video video1 = new Video(a.getDay(), a.getId(), a.getTitle(), oo);
                    anhson.put(a.getId(), video1);
                }
                for (String idd : anhson.keySet()) {
                    System.out.println(idd);
                    System.out.println(anhson.get(idd).getTitle());
                    System.out.println(anhson.get(idd).getView());
                    System.out.println("------------------------");
                }
            }

    }

