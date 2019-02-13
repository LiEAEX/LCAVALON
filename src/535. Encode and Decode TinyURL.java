public class Codec {

    Map<Integer, String> m = new HashMap<>();
    int i = 0;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        m.put(i, longUrl);
        return "http://tinyurl.com/" + i++;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return m.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));