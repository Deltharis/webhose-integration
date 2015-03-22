import com.buzzilla.webhose.client.WebhoseClient;
import com.buzzilla.webhose.client.WebhosePost;
import com.buzzilla.webhose.client.WebhoseQuery;
import com.buzzilla.webhose.client.WebhoseResponse;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Delth on 2015-03-22.
 */
public class Main {

    private static String api_key = "ce34060a-34a9-4981-8622-73dcd8168a06";

    public static void main(String[] args) {
        WebhoseClient client = new WebhoseClient(api_key);

        WebhoseQuery query = new WebhoseQuery();
        query.someTerms.addAll(Arrays.asList("horoskop"));
        System.out.println(query.sites);
        int counter = 0;
        try {
            WebhoseResponse r;
            do {
                counter++;
                r = client.search(query);
                for (WebhosePost post : r.posts) {
                    System.out.println("COOL");
                    System.out.println(post.url);
                    System.out.println(post.title);
                    System.out.println(post.text.substring(0, post.text.length() > 50 ? 50 : post.text.length()));
                    System.out.println("YEEEAH");
                    System.out.println(post.crawled);
                }
            } while (r.moreResultsAvailable > 0 && counter < 10);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
