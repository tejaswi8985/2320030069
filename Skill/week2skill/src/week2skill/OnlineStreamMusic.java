package week2skill;

public class OnlineStreamMusic implements MusicSource {
	private String url;

    public OnlineStreamMusic(String url) {
        this.url = url;
    }

    public void play() {
        System.out.println("Streaming music from: " + url);
    }

}
